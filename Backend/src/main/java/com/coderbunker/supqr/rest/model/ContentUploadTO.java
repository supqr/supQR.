package com.coderbunker.supqr.rest.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentUploadTO {

	@NotNull
	private Type type;
	private String value;

	public enum Type {
		TEXT, IMAGE, VIDEO
	}


}
