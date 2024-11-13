insert into user (NAME, EMAIL, PASSWORD, CREATEDAT, UPDATEDAT)
values ('user1', 'user1@gmail.com', '1111', now(), now());
insert into user (NAME, EMAIL, PASSWORD, CREATEDAT, UPDATEDAT)
values ('user1', 'user@gmail.com', '1111', now(), now());


insert into event (USERID, TITLE, CONTEXTS, CREATEDAT, UPDATEDAT)
values (1,'test1','test1',now(),now());
insert into event (USERID, TITLE, CONTEXTS, CREATEDAT, UPDATEDAT)
values (1,'test2','test2',now(),now());
insert into event (USERID, TITLE, CONTEXTS, CREATEDAT, UPDATEDAT)
values (2,'test22',null,now(),now());


commit;