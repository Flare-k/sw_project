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
video_id varchar(50),
file_url varchar(1000),
thumbnail_url varchar(1000),
title varchar(1000),
description varchar(1000),
platform varchar(200),
primary key(video_id),
unique key(file_url)
);

CREATE TABLE refresh_token(
keyr varchar(200),
valuer varchar(200),
primary key(keyr)
);
