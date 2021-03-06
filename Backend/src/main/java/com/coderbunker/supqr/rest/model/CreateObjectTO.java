/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

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
public class CreateObjectTO {

	@NotEmpty
	private String title;
}
