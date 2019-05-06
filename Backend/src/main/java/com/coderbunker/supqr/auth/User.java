package com.coderbunker.supqr.auth;

import lombok.Value;

import java.security.Principal;

@Value
public class User implements Principal {

	private Integer userId;
	private String name;
	private UserType userType;

	public enum UserType {

		USER,
		ADMIN

	}
}
