package com.coderbunker.supqr.rest.resource;

import com.coderbunker.supqr.annotation.Registered;
import com.coderbunker.supqr.rest.model.AuthTO;
import com.coderbunker.supqr.rest.model.JwtTO;
import com.coderbunker.supqr.rest.model.RegistrationTO;
import com.coderbunker.supqr.service.AuthService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Path("/auth")
@Registered
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

	private final AuthService authService;

	@POST
	public JwtTO authenticate (@Valid AuthTO authTO) {
		return authService.authenticate(authTO);
	}

	@POST
	@Path("register")
	public JwtTO register (@Valid RegistrationTO registrationTO) {
		return authService.register(registrationTO);
	}

}
