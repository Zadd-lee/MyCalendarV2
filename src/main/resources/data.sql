insert into user (NAME, EMAIL, PASSWORD, CREATED_AT, UPDATED_AT)
values ('user1', 'user1@gmail.com', '$2a$04$OyOlOiwVhM.8xh.YL3U1l.5yQO.8QDURZYttUHQFUp9U77UwItfju', now(), now());
insert into user (NAME, EMAIL, PASSWORD, CREATED_AT, UPDATED_AT)
values ('user2', 'user@gmail.com', '$2a$04$OyOlOiwVhM.8xh.YL3U1l.5yQO.8QDURZYttUHQFUp9U77UwItfju', now(), now());


insert into event (USER_ID, TITLE, CONTEXTS, CREATED_AT, UPDATED_AT)
values (1,'test1','test1',now(),now());
insert into event (USER_ID, TITLE, CONTEXTS, CREATED_AT, UPDATED_AT)
values (1,'test2','test2',now(),now());
insert into event (USER_ID, TITLE, CONTEXTS, CREATED_AT, UPDATED_AT)
values (2,'test22',null,now(),now());

insert into comment (EVENT_ID, USER_ID, COMMENT, CREATED_AT, UPDATED_AT)
values (1,1,'TEST1',NOW(),NOW());
insert into comment (EVENT_ID, USER_ID, COMMENT, CREATED_AT, UPDATED_AT)
values (2,2,'TEST1',NOW(),NOW());

commit;
