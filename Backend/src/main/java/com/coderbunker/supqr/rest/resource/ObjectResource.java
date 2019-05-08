package com.coderbunker.supqr.rest.resource;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.auth.User;
import com.coderbunker.supqr.rest.model.CreateObjectTO;
import com.coderbunker.supqr.rest.model.ObjectEditTO;
import com.coderbunker.supqr.rest.model.ObjectSummaryTO;
import com.coderbunker.supqr.rest.model.ObjectTO;
import com.coderbunker.supqr.service.ObjectService;
import io.dropwizard.auth.Auth;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	public List<ObjectSummaryTO> getMyObjects (@Auth User user) {
		return objectService.getObjectsForUser(user.getUserId());
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
	public void deleteObject (@Auth User user, @PathParam("objectId") Integer objectId) {
		objectService.deleteObject(objectId, user);
	}

	@POST
	@Path("/")
	public ObjectSummaryTO createObject (@Auth User user, CreateObjectTO createObjectTO) {
		return objectService.createObject(user.getUserId(), createObjectTO);
	}

	@PUT
	@Path("{objectId}")
	public void editObject (@Auth User user, ObjectEditTO objectEditTO, @PathParam("objectId") Integer objectId) {
		objectService.editObject(objectId, user, objectEditTO);
	}
}
