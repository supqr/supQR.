/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr.database;

import static org.jooq.generated.tables.Feedback.FEEDBACK;

import java.util.List;

import javax.inject.Inject;

import org.jooq.generated.tables.pojos.Feedback;

import com.bendb.dropwizard.jooq.jersey.DSLContextFactory;
import com.coderbunker.supqr.annotation.Injectable;

@Injectable
public class FeedbackRepository extends AbstractRepository {

	@Inject
	public FeedbackRepository (DSLContextFactory factory) {
		super(factory);
	}

	public List<Feedback> getRatingOfArticle (Integer articleId) {
		return getContext()
			.select()
			.from(FEEDBACK)
			.where(FEEDBACK.ARTICLE_ID.eq(articleId))
			.fetchInto(Feedback.class);
	}
}
