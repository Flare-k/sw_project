CREATE TABLE USER (
user_id bigint AUTO_INCREMENT,
username varchar(50),
password varchar(50),
email varchar(50),
avatarUrl varchar(50),
enabled tinyint(1),
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

CREATE TABLE ROLE(
 user_id BIGINT NOT NULL AUTO_INCREMENT,
 username VARCHAR(20),
 PRIMARY KEY (user_id)
);

CREATE TABLE USER_ROLE(
 user_id BIGINT NOT NULL AUTO_INCREMENT,
 role_id BIGINT NOT NULL,
 PRIMARY KEY (user_id, role_id),
 FOREIGN KEY (user_id) REFERENCES USER(user_id),
 FOREIGN KEY (role_id) REFERENCES ROLE(user_id)
);

INSERT INTO ROLE(user_id, username) VALUES (1, "ROLE_USER");