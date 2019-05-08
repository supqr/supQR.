package com.coderbunker.supqr.service;

import static java.util.stream.Collectors.toList;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.inject.Inject;

import org.jooq.generated.tables.pojos.Feedback;

import com.coderbunker.supqr.annotation.Injectable;
import com.coderbunker.supqr.database.FeedbackRepository;
import com.coderbunker.supqr.database.ObjectRepository;
import com.coderbunker.supqr.rest.model.CreateObjectTO;
import com.coderbunker.supqr.rest.model.ObjectSummaryTO;
import com.coderbunker.supqr.rest.model.ObjectTO;
import com.coderbunker.supqr.rest.model.RatingTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Injectable
public class ObjectService {

	private final ObjectRepository objectRepository;
	private final FeedbackRepository feedbackRepository;

	public List<ObjectSummaryTO> getObjectsForUser (int userId) {
		return objectRepository.getArticlesByUserId(userId)
			.stream()
			.map(article -> {
				RatingTO ratingForArticle = getRatingForArticle(article.getArticleId(), article.getViews());
				return ObjectSummaryTO
					.builder()
					.objectId(article.getArticleId())
					.title(article.getTitle())
					.ratingTO(ratingForArticle)
					.build();
			})
			.collect(toList());
	}

	private RatingTO getRatingForArticle (Integer articleId, Integer views) {
		List<Feedback> ratingOfArticle = feedbackRepository.getRatingOfArticle(articleId);

		int upvotes = (int) ratingOfArticle
			.stream()
			.filter(Feedback::getUpvote)
			.count();
		int downvotes = (int) ratingOfArticle
			.stream()
			.filter(feedback -> !feedback.getUpvote())
			.count();
		boolean pendingFeedback = ratingOfArticle
			.stream()
			.anyMatch(feedback -> !feedback.getUpvote() && !feedback.getTextValue().isEmpty() && !feedback.getResolved());

		return RatingTO.builder()
			.pendingFeedback(pendingFeedback)
			.downvotes(downvotes)
			.upvotes(upvotes)
			.views(views)
			.build();
	}

	public ObjectTO getObject (Integer objectId) {
		return objectRepository.getArticle(objectId);
	}

	public ByteArrayInputStream getMedia (Integer mediaId) {
		byte[] media = objectRepository.getMedia(mediaId);
		return new ByteArrayInputStream(media);
	}

	public ObjectSummaryTO createObject (Integer userId, CreateObjectTO createObjectTO) {
		int articleId = objectRepository.createObject(userId, createObjectTO.getTitle());

		return ObjectSummaryTO
			.builder()
			.title(createObjectTO.getTitle())
			.objectId(articleId)
			.ratingTO(getEmptyRating())
			.build();
	}

	private RatingTO getEmptyRating () {
		return RatingTO
			.builder()
			.downvotes(0)
			.pendingFeedback(false)
			.upvotes(0)
			.upvotes(0)
			.build();
	}

	public void deleteObject (Integer objectId) {
		// TODO: Check if user is allowed to delete

		objectRepository.deleteObject(objectId);
	}
}
