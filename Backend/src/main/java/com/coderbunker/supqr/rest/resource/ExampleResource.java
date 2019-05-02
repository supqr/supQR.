/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr.rest.resource;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.service.ExampleService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Path("/test")
@Registered
public class ExampleResource {

	private final ExampleService exampleService;

	@GET
	@Path("/mint")
	public String test () {
		return exampleService.getExample();
	}
}
