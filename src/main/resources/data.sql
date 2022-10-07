/* UserAccount Test Data INSERT */
INSERT INTO user_account(user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by)
VALUES ('cheesecup', 'qwer1234', 'Chiz', 'cheesecup@gmail.com', 'Hello, I am chiz', now(), 'cheesecup', now(), 'cheesecup');

/* Article Test Data INSERT */
INSERT INTO article(title, content, created_by, modified_by, created_at, modified_at)
VALUES ('first title', 'first content by cheesecup', 'cheesecup', 'cheesecup', '2021-05-30 23:53:46', '2021-07-10 08:48:50');

INSERT INTO article(title, content, created_by, modified_by, created_at, modified_at)
VALUES ('second title', 'second content by chiz', 'chiz', 'chiz', '2022-09-04 00:32:25', '2022-10-05 00:33:01');

/* ArticleComment Test Data INSERT */
INSERT INTO article_comment(article_id, content, created_by, modified_by, created_at, modified_at)
VALUES (1, 'first article first comment', 'baekwon', 'baekwon', '2021-08-04 00:32:25', '2021-10-05 11:33:01');

INSERT INTO article_comment(article_id, content, created_by, modified_by, created_at, modified_at)
VALUES (1, 'first article second comment', 'shampoo', 'shampoo', '2021-10-04 00:32:25', '2021-10-05 08:33:01');

INSERT INTO article_comment(article_id, content, created_by, modified_by, created_at, modified_at)
VALUES (2, 'second article first comment', 'shampoo', 'shampoo', '2022-10-01 11:21:25', '2022-10-01 11:32:25');

INSERT INTO article_comment(article_id, content, created_by, modified_by, created_at, modified_at)
VALUES (2, 'second article second comment', 'water', 'water', '2022-10-02 08:55:25', '2022-10-02 11:32:25');

INSERT INTO article_comment(article_id, content, created_by, modified_by, created_at, modified_at)
VALUES (2, 'second article third comment', 'choco', 'choco', '2022-10-03 07:32:25', '2021-10-04 08:33:01');
