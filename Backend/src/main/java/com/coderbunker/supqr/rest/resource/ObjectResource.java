package com.coderbunker.supqr.rest.resource;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.auth.User;
import com.coderbunker.supqr.rest.model.ObjectSummaryTO;
import com.coderbunker.supqr.service.ObjectService;

import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import io.dropwizard.auth.Auth;

@Registered
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Path("/object/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ObjectResource {

	private final ObjectService objectService;

	@GET
	@Path("me")
	public List<ObjectSummaryTO> getMyObjects (@Auth User user) {
		return objectService.getObjectsForUser(user.getUserId());
	}

}
