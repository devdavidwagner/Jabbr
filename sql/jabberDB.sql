DROP DATABASE IF EXISTS jabber;
CREATE DATABASE jabber;


USE jabber;

CREATE TABLE User
(
userID int NOT NULL AUTO_INCREMENT,
username varchar(255) NOT NULL,
password varchar(255) NOT NULL,
salt varchar(255)  NOT NULL,
PRIMARY KEY (userID)


);