/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import lombok.Builder;

@Builder
public class ServiceBinder extends AbstractBinder {

	private final SupQrConfiguration config;

	@Override
	protected void configure () {
		bind(this.config).to(SupQrConfiguration.class);
	}
}
