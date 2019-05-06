package com.coderbunker.supqr.database;

import com.bendb.dropwizard.jooq.jersey.DSLContextFactory;
import com.coderbunker.supqr.annotation.Injectable;

import javax.inject.Inject;

import static org.jooq.generated.tables.User.USER;

@Injectable
public class ExampleRepository extends AbstractRepository {

	@Inject
	public ExampleRepository (DSLContextFactory factory) {
		super(factory);
	}


	public String getExample () {
		return getContext()
			.select(USER.FIRSTNAME)
			.from(USER)
			.fetchAnyInto(String.class);
	}
}
