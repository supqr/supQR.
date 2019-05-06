CREATE TABLE user
(
    user_id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username      varchar(255) NOT NULL UNIQUE,
    firstName     varchar(255) NOT NULL,
    lastName      varchar(255) NOT NULL,
    email         varchar(255) NOT NULL,
    password      varchar(255) NOT NULL,
    locked        boolean,
    admin         boolean,
    lockingReason varchar(255)
);

CREATE TABLE rating
(
    rating_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    views     INT,
    upvotes   INT,
    downvotes INT
);

CREATE TABLE article
(
    article_id INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL UNIQUE,
    author_id  INT          NOT NULL,
    rating_id  INT          NOT NULL UNIQUE,

    FOREIGN KEY (author_id) REFERENCES user (user_id),
    FOREIGN KEY (rating_id) REFERENCES rating (rating_id)
);

CREATE TABLE feedback
(
    feedback_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    feedback_author_id     INT NOT NULL,
    article_id  INT NOT NULL,
    text_value        TEXT,

    FOREIGN KEY (feedback_author_id) REFERENCES user (user_id),
    FOREIGN KEY (article_id) REFERENCES article (article_id)
);

CREATE TABLE content
(
    content_id INT                    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    article_id INT                    NOT NULL,
    order_id   INT                    NOT NULL,
    type       ENUM ('MEDIA', 'TEXT') NOT NULL,

    FOREIGN KEY (article_id) REFERENCES article (article_id)
);

CREATE TABLE media_content
(
    media_content_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content_id       INT,

    FOREIGN KEY (content_id) REFERENCES content (content_id)
);

CREATE TABLE text_content
(
    text_content_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    text_value            TEXT,
    content_id      INT,

    FOREIGN KEY (content_id) REFERENCES content (content_id)
);