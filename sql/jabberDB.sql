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

CREATE TABLE Reply
(
replyID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
username varchar(255) NOT NULL,
userID int NOT NULL ,
replyContent varchar(1000) NOT NULL,
postedTime varchar(255) NOT NULL,
threadID int NOT NULL,
FOREIGN KEY(userID) references User(userID),
FOREIGN KEY(threadID) references Thread(threadID)




);


