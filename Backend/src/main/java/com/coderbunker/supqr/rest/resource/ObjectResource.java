package com.coderbunker.supqr.rest.resource;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.auth.User;
import com.coderbunker.supqr.rest.model.ObjectSummaryTO;
import com.coderbunker.supqr.rest.model.ObjectTO;
import com.coderbunker.supqr.service.ObjectService;

import lombok.RequiredArgsConstructor;

import io.dropwizard.auth.Auth;

@Registered
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Path("/object")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ObjectResource {

	private final ObjectService objectService;

	@GET
	@Path("me")
	public List<ObjectSummaryTO> getMyObjects () {
		int id = 2; // temporary

		return objectService.getObjectsForUser(id);
	}

	@GET
	@Path("{objectId}")
	public ObjectTO getObject (@PathParam("objectId") Integer objectId) {
		return objectService.getObject(objectId);
	}

	@GET
	@Path("media/{mediaId}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public ByteArrayInputStream getMedia (@PathParam("mediaId") Integer mediaId) {
		return objectService.getMedia(mediaId);
	}

	@DELETE
	@Path("{objectId}")
	public Response deleteObject (@Auth User user,
		@PathParam("objectId") Integer objectId) {
		objectService.deleteObject(objectId);

		return Response.accepted().build();
	}

	@POST
	@Path("add/{title}")
	public ObjectSummaryTO createObject(@Auth User user, @PathParam("title") String title) {
		return objectService.createObject(user.getUserId(), title);
	}
}
