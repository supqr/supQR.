package com.coderbunker.supqr.rest.resource;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.auth.User;
import com.coderbunker.supqr.rest.model.ObjectSummaryTO;
import com.coderbunker.supqr.rest.model.ObjectTO;
import com.coderbunker.supqr.service.ObjectService;
import io.dropwizard.auth.Auth;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;
import java.util.List;

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
	public ByteArrayInputStream getMedia (@PathParam("mediaId") Integer mediaId) {
		return objectService.getMedia(mediaId);
	}

	@POST
	@Path("add/{title}")
	public ObjectSummaryTO createObject(@Auth User user, @PathParam("title") String title) {
		return objectService.createObject(user.getUserId(), title);
	}
}
