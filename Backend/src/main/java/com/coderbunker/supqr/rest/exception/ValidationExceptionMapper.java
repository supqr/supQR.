package com.coderbunker.supqr.rest.exception;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.rest.model.ErrorsTO;
import io.dropwizard.jersey.validation.ConstraintMessage;
import io.dropwizard.jersey.validation.JerseyViolationException;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Slf4j
@Registered
public class ValidationExceptionMapper implements ExceptionMapper<JerseyViolationException> {
	@Override
	public Response toResponse (JerseyViolationException exception) {
		log.warn("A {} appeared", exception.getClass().getSimpleName());
		return Response
			.status(BAD_REQUEST)
			.entity(new ErrorsTO(
				exception.getConstraintViolations()
					.stream()
					.map(constraintViolation -> ConstraintMessage.getMessage(constraintViolation, exception.getInvocable()))
					.collect(Collectors.toList())
			))
			.build();

	}
}

