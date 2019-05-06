INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('hanspeter', 'Hans', 'Peter', 'hanspeter@gmail.com', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('teowidmer', 'Teo', 'Widmer', 'teo.widmer@gmx.ch', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('johnwick3000', 'John', 'Wick', 'jw@gmail.com', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('maxmuster', 'Max', 'Muster', 'maxiboi200@gmx.ch', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('jsins', 'Johnathan', 'Sins', 'jsins@gmail.com', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('guenthermint', 'Guenther', 'Mint', 'mint@yahoo.com', 'pw', TRUE);

INSERT INTO article(title, author_id, views) VALUES('Coffee Machine', 2, 69);
INSERT INTO article(title, author_id, views) VALUES('Pasta', 2, 69);
INSERT INTO article(title, author_id, views) VALUES('Specki', 2, 23);
INSERT INTO article(title, author_id, views) VALUES('Towels', 2, 466);
INSERT INTO article(title, author_id, views) VALUES('Toilet', 6, 23);
INSERT INTO article(title, author_id, views) VALUES('Dish Washer', 4, 56);
INSERT INTO article(title, author_id, views) VALUES('Printer', 3, 56);
INSERT INTO article(title, author_id, views) VALUES('Water Dispenser', 5, 32);

INSERT INTO feedback(feedback_author_id, article_id, text_value, upvote, resolved) VALUES(6, 1, 'wow very mint', 1, 0);
INSERT INTO feedback(feedback_author_id, article_id, text_value, upvote, resolved) VALUES(2, 1, 'wow very mint', 1, 0);
INSERT INTO feedback(feedback_author_id, article_id, text_value, upvote, resolved) VALUES(1, 1, 'wow very mint', 1, 0);
INSERT INTO feedback(feedback_author_id, article_id, text_value, upvote, resolved) VALUES(1, 1, 'wow very mint', 1, 0);
INSERT INTO feedback(feedback_author_id, article_id, text_value, upvote, resolved) VALUES(1, 2, 'my name is teo and i approve', 1, 0);
INSERT INTO feedback(feedback_author_id, article_id, text_value, upvote, resolved) VALUES(3, 3, 'season 3 was the best', 0, 0);
INSERT INTO feedback(feedback_author_id, article_id, text_value, upvote, resolved) VALUES(5, 4, 'As a teacher I think of this as insufficient.', 0, 1);
INSERT INTO feedback(feedback_author_id, article_id, text_value, upvote, resolved) VALUES(4, 5, '5/7 perfect score', 0, 1);

INSERT INTO content(article_id, order_id, type) VALUES(1, 1, 'MEDIA');
INSERT INTO content(article_id, order_id, type) VALUES(1, 2, 'TEXT');
INSERT INTO content(article_id, order_id, type) VALUES(2, 1, 'TEXT');
INSERT INTO content(article_id, order_id, type) VALUES(2, 2, 'MEDIA');
INSERT INTO content(article_id, order_id, type) VALUES(2, 3, 'TEXT');
INSERT INTO content(article_id, order_id, type) VALUES(3, 1, 'TEXT');
INSERT INTO content(article_id, order_id, type) VALUES(3, 2, 'TEXT');
INSERT INTO content(article_id, order_id, type) VALUES(3, 3, 'MEDIA');
INSERT INTO content(article_id, order_id, type) VALUES(3, 4, 'TEXT');
INSERT INTO content(article_id, order_id, type) VALUES(4, 1, 'TEXT');
INSERT INTO content(article_id, order_id, type) VALUES(5, 1, 'TEXT');
INSERT INTO content(article_id, order_id, type) VALUES(5, 2, 'MEDIA');

INSERT INTO media_content(content_id) VALUES(1);
INSERT INTO media_content(content_id) VALUES(4);
INSERT INTO media_content(content_id) VALUES(8);
INSERT INTO media_content(content_id) VALUES(12);

INSERT INTO text_content(text_value, content_id) VALUES('you press coffee button', 2);
INSERT INTO text_content(text_value, content_id) VALUES('flush by using thing', 3);
INSERT INTO text_content(text_value, content_id) VALUES('and then use other thing for stuff', 5);
INSERT INTO text_content(text_value, content_id) VALUES('put dishes into tray thing', 6);
INSERT INTO text_content(text_value, content_id) VALUES('put in dish soap', 7);
INSERT INTO text_content(text_value, content_id) VALUES('dont forget to empty dish washer', 9);
INSERT INTO text_content(text_value, content_id) VALUES('turn printer on and do stuff', 10);
INSERT INTO text_content(text_value, content_id) VALUES('press button for water but dont forget to put glass under it', 11);