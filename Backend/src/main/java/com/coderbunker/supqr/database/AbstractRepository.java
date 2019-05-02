package com.coderbunker.supqr.database;

import com.bendb.dropwizard.jooq.jersey.DSLContextFactory;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;

@RequiredArgsConstructor
public abstract class AbstractRepository {

	private final DSLContextFactory factory;

	protected DSLContext getContext () {
		return factory.provide();
	}
	
}
