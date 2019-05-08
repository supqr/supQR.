ALTER TABLE content
    DROP FOREIGN KEY content_ibfk_1;
ALTER TABLE content
    ADD CONSTRAINT FOREIGN KEY (article_id) REFERENCES article (article_id) ON DELETE CASCADE;

ALTER TABLE media_content
    DROP FOREIGN KEY media_content_ibfk_1;
ALTER TABLE media_content
    ADD CONSTRAINT FOREIGN KEY (content_id) REFERENCES content (content_id) ON DELETE CASCADE;

ALTER TABLE text_content
    DROP FOREIGN KEY text_content_ibfk_1;
ALTER TABLE text_content
    ADD CONSTRAINT FOREIGN KEY (content_id) REFERENCES content (content_id) ON DELETE CASCADE;

ALTER TABLE feedback
    DROP FOREIGN KEY feedback_ibfk_2;
ALTER TABLE feedback
    ADD CONSTRAINT FOREIGN KEY (article_id) REFERENCES article (article_id) ON DELETE CASCADE;