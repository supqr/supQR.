package com.coderbunker.supqr.rest.exception;


import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.rest.model.MessageTO;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Slf4j
@Registered
public class ClientErrorMapper implements ExceptionMapper<ClientErrorException> {
	@Override
	public Response toResponse (ClientErrorException exception) {
		log.warn("An http exception ({}) has been thrown with cause: {} ", exception.getClass().getSimpleName(), exception.getMessage());
		return Response
			.status(exception.getResponse().getStatus())
			.entity(new MessageTO(exception.getMessage()))
			.build();
	}
}
