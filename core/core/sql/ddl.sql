create table user (
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
file_url varchar(512),
thumbnail_url varchar(512),
title varchar(512),
description varchar(1024),
platform varchar(200),
user_id bigint,
primary key(video_id),
unique key(file_url)
);

ALTER TABLE video ADD CONSTRAINT FK_user_TO_video_1 FOREIGN KEY (user_id) REFERENCES user (user_id);


CREATE TABLE refresh_token(
keyr varchar(200),
valuer varchar(200),
primary key(keyr)
);
