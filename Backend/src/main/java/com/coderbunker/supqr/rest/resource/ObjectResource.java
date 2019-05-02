package com.coderbunker.supqr.rest.resource;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.service.ObjectService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Registered
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Path("/object")
public class ObjectResource {

	private final ObjectService objectService;

	@GET
	@Path("me")
	public List<Object> getMyObjects () {
		return objectService.getObjects();
	}


}
