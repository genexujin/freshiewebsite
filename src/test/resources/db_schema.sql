-- create the database
DROP DATABASE IF EXISTS freshie;
CREATE DATABASE freshie;

GRANT ALL PRIVILEGES ON freshie.* TO freshie@* IDENTIFIED BY "phoebefreshie1234";

-- select the database
USE freshie;

CREATE  TABLE IF NOT EXISTS `freshie`.`blog_post` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `url` VARCHAR(500) NOT NULL ,
  `title` VARCHAR(500) NULL ,
  `image` VARCHAR(1000) NULL ,
  `description` VARCHAR(2000) NULL ,
  `postDate` DATETIME NULL ,
  `commentCount` INT NULL ,
  `forwardCount` INT NULL ,
  `sourceName` VARCHAR(2000) NULL ,
  `sourceURL` VARCHAR(2000) NULL ,
  `content` VARCHAR() NULL ,
    PRIMARY KEY (`id`) );