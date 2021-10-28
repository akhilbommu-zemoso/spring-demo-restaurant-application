CREATE DATABASE  IF NOT EXISTS `restaurant_db`;
USE `restaurant_db`;

--
-- Table structure for table `restaurant`
--
DROP TABLE IF EXISTS `booking`;
DROP TABLE IF EXISTS `restaurant`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_name` varchar(45) DEFAULT NULL,
  `rating` varchar(3) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_no` varchar(45) DEFAULT NULL,
  `available_passes` int,
  `total_passes` int,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `booking`(
    `booking_id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `restaurant_id` int(11) NOT NULL,
    `number_of_passes` int NOT NULL,
    PRIMARY KEY(`booking_id`),
    CONSTRAINT FK_userId FOREIGN KEY (`user_id`) REFERENCES user(`id`),
    CONSTRAINT FK_restaurantId FOREIGN KEY(`restaurant_id`) REFERENCES restaurant(`id`)
);
