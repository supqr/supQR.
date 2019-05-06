INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('hanspeter', 'Hans', 'Peter', 'hanspeter@gmail.com', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('teowidmer', 'Teo', 'Widmer', 'teo.widmer@gmx.ch', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('johnwick3000', 'John', 'Wick', 'jw@gmail.com', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('maxmuster', 'Max', 'Muster', 'maxiboi200@gmx.ch', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('jsins', 'Johnathan', 'Sins', 'jsins@gmail.com', 'pw', FALSE);
INSERT INTO user(username, firstName, lastName, email, password, admin) VALUES('guenthermint', 'Guenther', 'Mint', 'mint@yahoo.com', 'pw', TRUE);

INSERT INTO rating(views, upvotes, downvotes) VALUES(298, 193, 27);
INSERT INTO rating(views, upvotes, downvotes) VALUES(481, 398, 72);
INSERT INTO rating(views, upvotes, downvotes) VALUES(748, 592, 194);
INSERT INTO rating(views, upvotes, downvotes) VALUES(71, 2, 32);
INSERT INTO rating(views, upvotes, downvotes) VALUES(184, 89, 12);

INSERT INTO article(title, author_id, rating_id) VALUES('Coffee Machine', 2, 1);
INSERT INTO article(title, author_id, rating_id) VALUES('Toilet', 6, 2);
INSERT INTO article(title, author_id, rating_id) VALUES('Dish Washer', 4, 3);
INSERT INTO article(title, author_id, rating_id) VALUES('Printer', 3, 4);
INSERT INTO article(title, author_id, rating_id) VALUES('Water Dispenser', 5, 5);

INSERT INTO feedback(feedback_author_id, article_id, text_value) VALUES(6, 1, 'wow very mint');
INSERT INTO feedback(feedback_author_id, article_id, text_value) VALUES(2, 2, 'my name is teo and i approve');
INSERT INTO feedback(feedback_author_id, article_id, text_value) VALUES(3, 3, 'season 3 was the best');
INSERT INTO feedback(feedback_author_id, article_id, text_value) VALUES(5, 4, 'As a teacher I think of this as insufficient.');
INSERT INTO feedback(feedback_author_id, article_id, text_value) VALUES(4, 5, '5/7 perfect score');

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