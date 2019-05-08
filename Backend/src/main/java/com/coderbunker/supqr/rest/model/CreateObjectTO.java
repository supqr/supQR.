/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateObjectTO {

	private String title;
}
