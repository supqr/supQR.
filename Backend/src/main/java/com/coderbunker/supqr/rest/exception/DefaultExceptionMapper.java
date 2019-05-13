package com.coderbunker.supqr.rest.exception;


import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.rest.model.MessageTO;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Slf4j
@Registered
public class DefaultExceptionMapper implements ExceptionMapper<Throwable> {
	@Override
	public Response toResponse (Throwable exception) {
		log.error("An Unexpected error appeared", exception);
		log.error("Exception class is {}", exception.getClass().getSimpleName());
		return Response
			.status(INTERNAL_SERVER_ERROR)
			.entity(new MessageTO(exception.getMessage()))
			.build();
	}
}

