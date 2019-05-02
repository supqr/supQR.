/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr;

import com.coderbunker.supqr.database.ExampleRepository;
import com.coderbunker.supqr.service.ExampleService;
import lombok.Builder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

@Builder
public class ServiceBinder extends AbstractBinder {

	private final SupQrConfiguration config;

	@Override
	protected void configure () {
		bind(this.config).to(SupQrConfiguration.class);

		bindAsContract(ExampleService.class).in(Singleton.class);
		bindAsContract(ExampleRepository.class).in(Singleton.class);
	}
}
