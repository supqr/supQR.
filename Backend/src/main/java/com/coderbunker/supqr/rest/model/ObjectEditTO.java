package com.coderbunker.supqr.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ObjectEditTO {

	private String title;
	private List<ContentUploadTO> content;

}
