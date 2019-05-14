package com.coderbunker.supqr.rest.exception;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.rest.model.MessageTO;
import lombok.extern.slf4j.Slf4j;
import org.jooq.exception.DataAccessException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static javax.ws.rs.core.Response.Status.CONFLICT;

@Slf4j
@Registered
public class DatabaseExceptionMapper implements ExceptionMapper<DataAccessException> {
	@Override
	public Response toResponse (DataAccessException exception) {
		log.warn("Database Exception appeared ({})", exception.getMessage());
		return Response
			.status(CONFLICT)
			.entity(new MessageTO("Conflict appeared"))
			.build();
	}
}

