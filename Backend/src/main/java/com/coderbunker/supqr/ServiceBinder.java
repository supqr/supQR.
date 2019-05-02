/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr;

import com.coderbunker.supqr.annotation.Injectable;
import com.coderbunker.supqr.util.ReflectionUtil;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

@Builder
@Slf4j
public class ServiceBinder extends AbstractBinder {

	private final SupQrConfiguration config;

	@Override
	protected void configure () {
		bind(this.config).to(SupQrConfiguration.class);
		ReflectionUtil
			.findClasses(Injectable.class)
			.forEach(this::bindSingleton);
	}

	private void bindSingleton (Class<?> clazz) {
		log.info("Registering {} as Service", clazz.getSimpleName());
		bindAsContract(clazz).in(Singleton.class);
	}
}
