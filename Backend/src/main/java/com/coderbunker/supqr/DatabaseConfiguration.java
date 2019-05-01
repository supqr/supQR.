/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class DatabaseConfiguration {

	private String username;
	private String password;
	private String url;

	@NonNull
	private ConnectionConfiguration connections;

	@Data
	public static class ConnectionConfiguration {
		private final int maxPoolSize;
		private final int minPoolSize;
	}
}
