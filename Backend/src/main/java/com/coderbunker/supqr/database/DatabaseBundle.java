/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr.database;

import com.bendb.dropwizard.jooq.JooqBundle;
import com.bendb.dropwizard.jooq.JooqFactory;
import com.coderbunker.supqr.DatabaseConfiguration;
import com.coderbunker.supqr.SupQrConfiguration;

import lombok.extern.slf4j.Slf4j;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;

@Slf4j
public class DatabaseBundle extends JooqBundle<SupQrConfiguration> {

	@Override
	public PooledDataSourceFactory getDataSourceFactory(SupQrConfiguration configuration) {
		DatabaseConfiguration dbConfig = configuration.getDatabase();
		DataSourceFactory dataSourceFactory = new DataSourceFactory();
		dataSourceFactory.setUrl("jdbc:mariadb://" + dbConfig.getHost() + ":" + dbConfig.getPort());
		dataSourceFactory.setUser(dbConfig.getUsername());
		log.info("Connection to jdbc:mariadb://{}:{}. Authenticating as User {}.", dbConfig.getHost(), dbConfig.getPort(), dbConfig.getUsername());
		dataSourceFactory.setPassword(dbConfig.getPassword());
		dataSourceFactory.setDriverClass("org.mariadb.jdbc.Driver");
		log.info("Driver is {}", dataSourceFactory.getDriverClass());
		dataSourceFactory.setMaxSize(dbConfig.getConnections().getMaxPoolSize());
		dataSourceFactory.setMinSize(dbConfig.getConnections().getMinPoolSize());
		dataSourceFactory.setInitialSize(dbConfig.getConnections().getMinPoolSize());
		log.info("Initial pool size is {}. Min size is {} and max size is {}.", dataSourceFactory.getInitialSize(), dataSourceFactory.getMinSize(), dataSourceFactory.getMaxSize());
		// It is important to set this property to true. Otherwise, when someone forgets to run an insert/update/delete
		// in a transaction and the connection is put back into the pool the next request getting the same connection
		// will see the not committed insert/update/delete and might even commit it without being aware of it!
		dataSourceFactory.setRollbackOnReturn(true);
		return dataSourceFactory;
	}

	@Override
	public String primaryDataSourceName() {
		return "Certification DB";
	}

	@Override
	public JooqFactory getJooqFactory(SupQrConfiguration configuration) {
		JooqFactory factory = super.getJooqFactory(configuration);
		factory.setExecuteLogging(true);
		return factory;
	}
}
