/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr.database;

import static org.jooq.generated.tables.Article.ARTICLE;

import java.util.List;

import javax.inject.Inject;

import org.jooq.generated.tables.pojos.Article;

import com.bendb.dropwizard.jooq.jersey.DSLContextFactory;
import com.coderbunker.supqr.annotation.Injectable;

@Injectable
public class ObjectRepository extends AbstractRepository {

	@Inject
	public ObjectRepository (DSLContextFactory factory) {
		super(factory);
	}

	public List<Article> getArticlesByUserId (int userId) {

		return getContext()
			.select()
			.from(ARTICLE)
			.where(ARTICLE.AUTHOR_ID.eq(userId))
			.fetchInto(Article.class);
	}

}
