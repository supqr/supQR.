package com.coderbunker.supqr.service.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Registration {

	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String hashedPassword;

}

