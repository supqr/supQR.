/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr.rest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjectSummaryTO {
	private int objectId;
	private String title;
	private String pictureURL;
	private RatingTO ratingTO;
}
