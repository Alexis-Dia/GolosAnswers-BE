DROP TABLE IF EXISTS `alarm`;
CREATE TABLE `alarm` (
  `id` int(11) NOT NULL,
  `unit_id` int(11) DEFAULT NULL,
  `date_entree` datetime NOT NULL,
  `alarm_type_id` int(11) NOT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `solve_date` datetime DEFAULT NULL,
  `call` bit(1) DEFAULT NULL,
  `email_id` int(11) DEFAULT NULL,
  `resolution_msg` varchar(500) DEFAULT NULL,
  `email_to_respondent` bit(1) DEFAULT NULL,
  `resolved` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `alarm`(id, unit_id, date_entree, alarm_type_id, comment, solve_date, email_id, resolution_msg, email_to_respondent, resolved) VALUES
 (1,1,STR_TO_DATE('14/02/2017 23:38:12', '%d/%m/%Y %T'),1,'message',STR_TO_DATE('14/02/2017 23:38:12', '%d/%m/%Y %T'),1,'true',true,true),
 (2,2,STR_TO_DATE('14/02/2017 23:38:12', '%d/%m/%Y %T'),2,'message',STR_TO_DATE('14/02/2017 23:38:12', '%d/%m/%Y %T'),1,'true',true,false),
 (3,3,STR_TO_DATE('14/02/2017 23:38:12', '%d/%m/%Y %T'),3,'message',STR_TO_DATE('14/02/2017 23:38:12', '%d/%m/%Y %T'),1,'true',true,false),
 (4,4,STR_TO_DATE('14/02/2017 23:38:12', '%d/%m/%Y %T'),4,'message',STR_TO_DATE('14/02/2017 23:38:12', '%d/%m/%Y %T'),1,'true',true,true);

CREATE TABLE `language`(
	`id` int AUTO_INCREMENT NOT NULL,
	`name` varchar(100) NULL,
 CONSTRAINT `language_pk` PRIMARY KEY(`id` ASC));
INSERT INTO `language`(name) VALUES
 ('en');

CREATE TABLE `security_level`(
	`id` int AUTO_INCREMENT NOT NULL,
	`name` varchar(40) NOT NULL,
	`level` int NOT NULL,
 CONSTRAINT `PK_security_level_id` PRIMARY KEY(`id` ASC));
INSERT INTO `security_level`(name,level) VALUES
 ('Administrator',1);

CREATE TABLE `consumer`(
	`id` int AUTO_INCREMENT NOT NULL,
	`first_name` varchar(100) NOT NULL,
	`last_name` varchar(100) NOT NULL,
	`security_level_id` int NOT NULL,
	`language_id` int NOT NULL,
	`password` varchar(15) NOT NULL,
	`user_id` varchar(20) NULL,
 CONSTRAINT `PK_consumer_id` PRIMARY KEY(`id` ASC));
INSERT INTO `consumer`(first_name, last_name, security_level_id, language_id, password, user_id) VALUES
 ('Zack','Brown',1,1,'admin', 'admin');
