/*
 * Copyright (c) Ergon Informatik AG, Switzerland
 */

package com.coderbunker.supqr.database;

import static com.coderbunker.supqr.rest.model.ContentTO.Type.IMAGE;
import static com.coderbunker.supqr.rest.model.ContentTO.Type.TEXT;
import static com.coderbunker.supqr.rest.model.ContentTO.Type.VIDEO;
import static org.jooq.generated.tables.Article.ARTICLE;
import static org.jooq.generated.tables.Content.CONTENT;
import static org.jooq.generated.tables.MediaContent.MEDIA_CONTENT;
import static org.jooq.generated.tables.TextContent.TEXT_CONTENT;
import static org.jooq.generated.tables.User.USER;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;

import org.jooq.Record;
import org.jooq.generated.tables.pojos.Article;
import org.jooq.generated.tables.records.ArticleRecord;

import com.bendb.dropwizard.jooq.jersey.DSLContextFactory;
import com.coderbunker.supqr.annotation.Injectable;
import com.coderbunker.supqr.rest.model.ContentTO;
import com.coderbunker.supqr.rest.model.ObjectTO;

@Injectable
public class ObjectRepository extends AbstractRepository {

	@Inject
	public ObjectRepository (DSLContextFactory factory) {
		super(factory);
	}

	public List<Article> getArticlesByUserId (int userId) {
		return getContext()
			.selectFrom(ARTICLE)
			.where(ARTICLE.AUTHOR_ID.eq(userId))
			.fetchInto(Article.class);
	}

	public ObjectTO getArticle (int articleId) {
		Record articleRecord = getContext()
			.select()
			.from(ARTICLE)
			.join(USER).onKey()
			.where(ARTICLE.ARTICLE_ID.eq(articleId))
			.fetchOne();
		List<ContentTO> content = getContext()
			.select()
			.from(CONTENT)
			.leftJoin(TEXT_CONTENT).on(TEXT_CONTENT.CONTENT_ID.eq(CONTENT.CONTENT_ID))
			.leftJoin(MEDIA_CONTENT).on(MEDIA_CONTENT.CONTENT_ID.eq(CONTENT.CONTENT_ID))
			.fetch(this::toContentTO);
		return ObjectTO
			.builder()
			.objectId(articleId)
			.title(articleRecord.get(ARTICLE.TITLE))
			.author(articleRecord.get(USER.USERNAME))
			.content(content)
			.build();
	}

	private ContentTO toContentTO (Record record) {
		if (record.get(MEDIA_CONTENT.MEDIA_CONTENT_ID) != null) {
			return ContentTO
				.builder()
				.type(record.get(MEDIA_CONTENT.VIDEO) ? VIDEO : IMAGE)
				.value(record.get(MEDIA_CONTENT.MEDIA_CONTENT_ID).toString())
				.build();
		} else if (record.get(TEXT_CONTENT.TEXT_CONTENT_ID) != null) {
			return ContentTO
				.builder()
				.type(TEXT)
				.value(record.get(TEXT_CONTENT.TEXT_VALUE))
				.build();
		} else {
			throw new InternalServerErrorException("Cannot fetch content");
		}
	}

	public byte[] getMedia (Integer mediaId) {
		return getContext()
			.select(MEDIA_CONTENT.MEDIA)
			.from(MEDIA_CONTENT)
			.where(MEDIA_CONTENT.MEDIA_CONTENT_ID.eq(mediaId))
			.fetchOne(record -> record.get(MEDIA_CONTENT.MEDIA));
	}

	public void deleteObject (Integer objectId) {
		getContext()
			.delete(ARTICLE)
			.where(ARTICLE.ARTICLE_ID.eq(objectId))
			.execute();
	}

	public boolean isUserAuthorOfArticle (Integer objectId, Integer userId) {
		return getContext()
			.selectOne()
			.from(ARTICLE)
			.where(ARTICLE.ARTICLE_ID.eq(objectId))
			.and(ARTICLE.AUTHOR_ID.eq(userId))
			.fetch()
			.isNotEmpty();
	}

	public int createObject (Integer userId, String title) {
		ArticleRecord articleRecord = getContext().newRecord(ARTICLE);

		articleRecord.setAuthorId(userId);
		articleRecord.setTitle(title);
		articleRecord.setViews(0);

		articleRecord.store();

		return articleRecord.getArticleId();
	}
}
