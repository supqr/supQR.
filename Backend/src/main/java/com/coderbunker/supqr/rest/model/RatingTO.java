/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr.rest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingTO {
	private int views;
	private int upvotes;
	private int downvotes;
	private boolean pendingFeedback;
}
