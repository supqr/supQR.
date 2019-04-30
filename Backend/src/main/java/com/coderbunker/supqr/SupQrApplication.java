/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import com.coderbunker.supqr.database.DatabaseBundle;
import com.coderbunker.supqr.rest.resource.TestResource;

import lombok.extern.slf4j.Slf4j;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
		bootstrap.addBundle(new DatabaseBundle());
	}

	@Override
	public void run (SupQrConfiguration configuration, Environment environment) {
		environment.jersey().setUrlPattern("/api/*");

		environment.jersey().register(
			ServiceBinder
				.builder()
				.config(configuration)
				.build()
		);

		environment.jersey().register(TestResource.class);
	}

}
