-- 테스트 계정
-- TODO : 테스트용이지만 비밀번호가 노출된 데이터 세팅.
INSERT INTO user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by)
VALUES ('cheesecup', '123456789', 'Chiz', 'couplejwsa@gmailcom', 'I am Chiz', now(), 'cheesecup', now(), 'cheesecup');

INSERT INTO user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by)
VALUES ('kdy8252', '123456789', 'baekwon', 'kdy8252@naver.com', 'I am Baekwon', now(), 'kdy8252', now(), 'kdy8252');

INSERT INTO user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by)
VALUES ('ediya', '123456789', 'Ediya', 'ediya@coffee.com', 'I am sweet EDIYA', now(), 'ediya', now(), 'ediya');

-- 10개의 게시글
insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (1, 'Integer tincidunt ante vel ipsum.', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.', 'Aquamarine', 'Trude', 'Astrid', '2022-09-28 11:40:24', '2022-04-11 11:03:43');

insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (2, 'Suspendisse potenti.', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 'Pink', 'Filberte', 'Annelise', '2022-04-03 05:52:22', '2022-09-25 15:29:06');

insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (1, 'Vivamus tortor.', 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', 'Pink', 'Ruthe', 'Maressa', '2022-05-07 11:48:44', '2022-05-30 04:38:58');

insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (1, 'Nulla justo.', 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', 'Pink', 'Stevy', 'Tabb', '2022-01-03 09:07:18', '2022-06-17 19:47:53');

insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (2, 'Suspendisse potenti.', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 'Orange', 'Elianora', 'Leandra', '2022-02-19 18:39:27', '2022-02-22 15:10:12');

insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (2, 'Mauris lacinia sapien quis libero.', 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', null, 'Valerie', 'Katrine', '2022-04-05 07:22:42', '2022-04-10 20:19:24');

insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (3, 'In hac habitasse platea dictumst.', 'Fusce consequat. Nulla nisl. Nunc nisl.', 'Fuscia', 'Olympia', 'Ingar', '2022-03-01 05:34:05', '2022-07-01 08:30:51');

insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (1, 'Vestibulum ac est lacinia nisi venenatis tristique.', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 'Khaki', 'Loydie', 'Hailee', '2022-05-29 20:58:19', '2022-08-08 22:22:11');

insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (3, 'Mauris lacinia sapien quis libero.', 'Fusce consequat. Nulla nisl. Nunc nisl.', null, 'Maressa', 'Quinlan', '2022-05-30 03:08:08', '2022-09-09 06:01:38');

insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at)
values (1, 'Morbi non lectus.', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.', 'Blue', 'Ainslie', 'Cally', '2022-06-01 23:13:50', '2022-01-27 03:03:35');

-- 5개의 댓글
insert into article_comment (content, created_by, modified_by, created_at, modified_at, article_id, user_account_id)
values ('Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 'Victor', 'Myriam', '2022-04-18 04:28:37', '2022-09-14 21:33:58', 1, 2);

insert into article_comment (content, created_by, modified_by, created_at, modified_at, article_id, user_account_id)
values ('In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 'Ephrayim', 'Raychel', '2022-02-16 13:49:29', '2022-03-03 09:44:33', 2, 3);

insert into article_comment (content, created_by, modified_by, created_at, modified_at, article_id, user_account_id)
values ('Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', 'Arabelle', 'Doralynne', '2022-02-26 18:58:15', '2022-10-09 07:42:46', 2, 1);

insert into article_comment (content, created_by, modified_by, created_at, modified_at, article_id, user_account_id)
values ('Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 'Cleve', 'Cullie', '2022-10-12 09:23:03', '2022-07-26 10:23:19', 3, 2);

insert into article_comment (content, created_by, modified_by, created_at, modified_at, article_id, user_account_id)
values ('Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 'Rivi', 'Chicky', '2022-05-12 07:19:01', '2022-01-21 11:30:49', 5, 3);
