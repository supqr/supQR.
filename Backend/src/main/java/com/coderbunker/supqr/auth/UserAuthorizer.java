package com.coderbunker.supqr.auth;

import io.dropwizard.auth.Authorizer;

public class UserAuthorizer implements Authorizer<User> {

	@Override
	public boolean authorize (User user, String role) {
		return user.getUserType().toString().equals(role);
	}
}

