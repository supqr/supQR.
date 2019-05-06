/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import io.dropwizard.Configuration;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SupQrConfiguration extends Configuration {

	private int sessionDuration;
	@NotNull
	private DatabaseConfiguration database;

}
