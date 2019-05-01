package com.coderbunker.supqr.database;

import com.coderbunker.supqr.SupQrConfiguration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.db.DatabaseConfiguration;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;

@RequiredArgsConstructor
public class DatabaseMigrationBundle implements ConfiguredBundle<SupQrConfiguration> {

    private final DatabaseConfiguration<SupQrConfiguration> databaseConfiguration;

    @Override
    public void run(SupQrConfiguration configuration, Environment environment) {
        PooledDataSourceFactory factory = databaseConfiguration.getDataSourceFactory(configuration);
        Flyway
                .configure()
                .dataSource(factory.build(environment.metrics(), "Flyway"))
                .locations("db/migration")
                .load()
                .migrate();
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {

    }

}

