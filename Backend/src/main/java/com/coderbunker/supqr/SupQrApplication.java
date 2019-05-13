/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.auth.JwtAuthenticator;
import com.coderbunker.supqr.auth.User;
import com.coderbunker.supqr.auth.UserAuthorizer;
import com.coderbunker.supqr.database.DatabaseBundle;
import com.coderbunker.supqr.database.DatabaseMigrationBundle;
import com.coderbunker.supqr.util.ReflectionUtil;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.EnumSet;
import java.util.Optional;

import static io.dropwizard.jersey.filter.AllowedMethodsFilter.ALLOWED_METHODS_PARAM;
import static org.eclipse.jetty.servlets.CrossOriginFilter.ALLOWED_HEADERS_PARAM;

@Slf4j
public class SupQrApplication extends Application<SupQrConfiguration> {

	public static void main (String[] args) throws Exception {
		File config = loadConfig();
		new SupQrApplication().run("server", config.getPath());
	}

	private static File loadConfig () {
		new File("SupQR").mkdir();
		File file = new File("SupQR/config.yml");
		if (!file.exists()) {
			try (InputStream is = SupQrApplication.class.getResourceAsStream("/config.yml");
				 OutputStream os = new FileOutputStream(file)) {
				IOUtils.copy(is, os);
			} catch (IOException e) {
				log.error("Could not load config.", e);
				throw new RuntimeException("Could not load config.");
			}
		}
		return file;
	}

	@Override
	public void initialize (Bootstrap<SupQrConfiguration> bootstrap) {
		DatabaseBundle database = new DatabaseBundle();
		bootstrap.addBundle(database);
		bootstrap.addBundle(new DatabaseMigrationBundle(database));
	}

	@Override
	public void run (SupQrConfiguration configuration, Environment environment) {
		FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORSFilter", CrossOriginFilter.class);

		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, environment.getApplicationContext().getContextPath() + "*");
		filter.setInitParameter(ALLOWED_METHODS_PARAM, "GET,PUT,POST,OPTIONS");
		filter.setInitParameter(ALLOWED_HEADERS_PARAM, "Origin, Content-Type, Accept");


		environment.jersey().setUrlPattern("/api/*");

		initializeAuthentication(environment);
		environment.jersey().register(
			ServiceBinder
				.builder()
				.config(configuration)
				.build()
		);

		ReflectionUtil
			.findClasses(Registered.class)
			.forEach(clazz -> environment.jersey().register(clazz));
	}

	public <T> T getService (Class<T> clazz, Environment environment) {
		return Optional.ofNullable(((ServletContainer) environment
			.getJerseyServletContainer()))
			.orElseThrow(() -> new RuntimeException("Cannot find servlet container"))
			.getApplicationHandler()
			.getServiceLocator()
			.getService(clazz);
	}

	private void initializeAuthentication (Environment environment) {
		environment.jersey().register(
			new AuthDynamicFeature(
				new OAuthCredentialAuthFilter.Builder<User>()
					.setAuthenticator(new JwtAuthenticator())
					.setAuthorizer(new UserAuthorizer())
					.setPrefix("Bearer")
					.buildAuthFilter()));
		environment.jersey().register(RolesAllowedDynamicFeature.class);
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
	}


}
