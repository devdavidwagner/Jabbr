DROP DATABASE IF EXISTS jabber;
CREATE DATABASE jabber;


USE jabber;

CREATE TABLE User
(
userID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
username varchar(255) NOT NULL,
password varchar(255) NOT NULL,
salt varchar(255)  NOT NULL

);

CREATE TABLE Thread
(
threadID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
username varchar(255) NOT NULL,
userID int NOT NULL ,
threadTitle varchar(255) NOT NULL,
postedTime varchar(255) NOT NULL,
threadContent varchar(8000) NOT NULL,
 FOREIGN KEY(userID) references User(userID)

);




