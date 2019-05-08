package com.coderbunker.supqr.service;

import com.coderbunker.supqr.annotation.Injectable;
import com.coderbunker.supqr.auth.User;
import com.coderbunker.supqr.auth.User.UserType;
import com.coderbunker.supqr.database.FeedbackRepository;
import com.coderbunker.supqr.database.ObjectRepository;
import com.coderbunker.supqr.rest.model.ContentUploadTO;
import com.coderbunker.supqr.rest.model.ContentUploadTO.Type;
import com.coderbunker.supqr.rest.model.CreateObjectTO;
import com.coderbunker.supqr.rest.model.ObjectEditTO;
import com.coderbunker.supqr.rest.model.ObjectSummaryTO;
import com.coderbunker.supqr.rest.model.ObjectTO;
import com.coderbunker.supqr.rest.model.RatingTO;
import lombok.RequiredArgsConstructor;
import org.jooq.generated.tables.pojos.Feedback;

import javax.inject.Inject;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response.Status;
import java.io.ByteArrayInputStream;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

	public void deleteObject (Integer objectId, User user) {
		if (!objectRepository.isUserAuthorOfArticle(objectId, user.getUserId()) && user.getUserType() != UserType.ADMIN) {
			throw new ServerErrorException(Status.UNAUTHORIZED);
		}
		objectRepository.deleteObject(objectId);
	}

	public void editObject (Integer objectId, User user, ObjectEditTO objectEditTO) {
		if (!objectRepository.isUserAuthorOfArticle(objectId, user.getUserId()) && user.getUserType() != UserType.ADMIN) {
			throw new ServerErrorException(Status.UNAUTHORIZED);
		}
		objectRepository.deleteContent(objectId);
		objectRepository.updateTitle(objectId, objectEditTO.getTitle());
		for (int i = 0; i < objectEditTO.getContent().size(); i++) {
			insertContent(objectId, i, objectEditTO.getContent().get(i));
		}
	}

	private void insertContent (Integer articleId, Integer orderId, ContentUploadTO contentUploadTO) {
		if (contentUploadTO.getType() == Type.TEXT) {
			Integer contentId = objectRepository.createContent(articleId, orderId, false);
			objectRepository.insertTextContent(contentId, contentUploadTO.getText());
		} else {
			Integer contentId = objectRepository.createContent(articleId, orderId, true);
			objectRepository.insertMediaContent(contentId, contentUploadTO.getData(), contentUploadTO.getType() == Type.VIDEO);
		}
	}
}
