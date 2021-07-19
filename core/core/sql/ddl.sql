CREATE TABLE USER (
user_id bigint AUTO_INCREMENT,
name varchar(50),
password varchar(50),
email varchar(50),
avatarUrl varchar(50),
primary key(user_id),
unique key(name)
);

CREATE TABLE COMMENT (
comment_id bigint AUTO_INCREMENT,
createdAt date,
primary key(comment_id)
);

CREATE TABLE VIDEO (
video_id bigint AUTO_INCREMENT,
fileUrl varchar(50),
title varchar(50),
description varchar(500),
views bigint,
createdAt date,
primary key(video_id),
unique key(fileUrl)
);