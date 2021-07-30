CREATE TABLE USER (
user_id bigint AUTO_INCREMENT,
username varchar(50),
password varchar(200),
email varchar(50),
avatar_url varchar(50),
enabled tinyint(1),
authority varchar(64),
primary key(user_id),
unique key(username)
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

CREATE TABLE refresh_token(
keyr varchar(200),
valuer varchar(200),
primary key(keyr)
);
