package com.coderbunker.supqr.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentUploadTO {

	@NotNull
	private Type type;
	private String text;
	private byte[] data;

	public enum Type {
		TEXT, IMAGE, VIDEO
	}


}
