CREATE DATABASE  IF NOT EXISTS `health_calendar`;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
                           `id` INTEGER NOT NULL AUTO_INCREMENT,
                           `first_name` varchar(45) DEFAULT NULL,
                           `nick` varchar(45) DEFAULT NULL,
                           `email` varchar(45) DEFAULT NULL,
                           `phone_number` INTEGER DEFAULT NULL,
                           `login_name` varchar(45) DEFAULT NULL,
                           `password` varchar(45) DEFAULT NULL,
                           `sex` INTEGER DEFAULT NULL,
                           `body_size_id` INTEGER DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `NICK_UNIQUE` (`nick`),
                           KEY `FK_SIZE_idx` (`body_size_id`),
                           CONSTRAINT `FK_SIZE` FOREIGN KEY (`body_size_id`)
                           REFERENCES `body_size` (`id`)
                           ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `user` VALUES
(1,'Anna','Ann','anna@gmail.com','569842365', 'Ann123', 'test1', 0, 1),
(2,'Fiona','Shrek','fiona@gmail.com','846152365','shrek123', 'test2', 0, 2);


CREATE TABLE `body_size`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `body_weight` INTEGER DEFAULT NULL,
                       `neck_size` INTEGER DEFAULT NULL,
                       `arm_size` INTEGER DEFAULT NULL,
                       `bust_size` INTEGER DEFAULT NULL,
                       `waist` INTEGER DEFAULT NULL,
                       `hip_size` INTEGER DEFAULT NULL,
                       `femoral_size` INTEGER DEFAULT NULL,
                       `sural` INTEGER DEFAULT NULL,
                       PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `body_size` VALUES
(1, 65, 38, 31, 98, 75, 88, 45, 36),
(2, 60, 36, 30, 91, 70, 83, 43, 35);

SET FOREIGN_KEY_CHECKS = 1;



-- CREATE TABLE `diet`(
--                     `id` int(11) NOT NULL AUTO_INCREMENT,
--                     `first_name` varchar(45) DEFAULT NULL,
--                     `user_name` varchar(45) DEFAULT NULL,
--                     `email` varchar(45) DEFAULT NULL,
--                     `phone_number` int(10) DEFAULT NULL,
--                     `login_name` varchar(45) DEFAULT NULL,
--                     `password` varchar(45) DEFAULT NULL,
--                     `login_name` varchar(45) DEFAULT NULL,
--                     PRIMARY KEY (`id`)
--
--
--
--
-- CREATE TABLE `training`(
--                        `id` int(11) NOT NULL AUTO_INCREMENT,
--                        `first_name` varchar(45) DEFAULT NULL,
--                        `user_name` varchar(45) DEFAULT NULL,
--                        `email` varchar(45) DEFAULT NULL,
--                        `phone_number` int(10) DEFAULT NULL,
--                        `login_name` varchar(45) DEFAULT NULL,
--                        `password` varchar(45) DEFAULT NULL,
--                        `login_name` varchar(45) DEFAULT NULL,
--                        PRIMARY KEY (`id`)