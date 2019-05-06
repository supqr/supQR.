package com.coderbunker.supqr.auth;

import io.dropwizard.auth.Authenticator;

import java.util.Optional;

public class JwtAuthenticator implements Authenticator<String, User> {

	@Override
	public Optional<User> authenticate (String token) {
		try {
			return Optional.of(JwtService.validateToken(token));
		} catch (Exception ex) {
			return Optional.empty();
		}
	}
}

