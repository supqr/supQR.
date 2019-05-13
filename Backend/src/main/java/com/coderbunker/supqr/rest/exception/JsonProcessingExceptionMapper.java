package com.coderbunker.supqr.rest.exception;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.rest.model.MessageTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Slf4j
@Registered
public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException> {
	@Override
	public Response toResponse (JsonProcessingException exception) {
		log.warn("Unprocessable Entity received");
		return Response
			.status(BAD_REQUEST)
			.entity(new MessageTO("Unprocessable Entity"))
			.build();
	}
}

