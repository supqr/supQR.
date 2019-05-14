package com.coderbunker.supqr.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthTO {

	@NotEmpty
	private String identification;
	@NotEmpty
	private char[] password;

}
