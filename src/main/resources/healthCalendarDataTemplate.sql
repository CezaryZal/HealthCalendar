CREATE DATABASE  IF NOT EXISTS `health_calendar`;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `body_size`;

CREATE TABLE `body_size`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `body_weight` INTEGER DEFAULT NULL,
                       `neck_size` INTEGER DEFAULT NULL,
                       `arm_size` INTEGER DEFAULT NULL,
                       `bust_size` INTEGER DEFAULT NULL,
                       `waist` INTEGER DEFAULT NULL,
                       `hip_size` INTEGER DEFAULT NULL,
                       `femoral_size` INTEGER DEFAULT NULL,
                       `calf` INTEGER DEFAULT NULL,
                       `date` DATE DEFAULT NULL,
                       PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `body_size` VALUES
(1, 65, 38, 31, 98, 75, 88, 45, 36, '2018-05-23'),
(2, 60, 36, 30, 91, 70, 83, 43, 35, '2018-05-23');



DROP TABLE IF EXISTS `drink_liquids`;

CREATE TABLE `drink_liquids`(
                            `id` INTEGER NOT NULL AUTO_INCREMENT,
                            `portions` INTEGER DEFAULT NULL,
                            `amount` INTEGER DEFAULT NULL,
                            `min_portions` INTEGER DEFAULT NULL,
                            `alcohol` BOOLEAN DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `drink_liquids` VALUES
(1, 2, 500, 2000, false),
(2, 3, 750, 2500, true);


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
                           KEY `BodyS_SIZE_idx` (`body_size_id`),
                       CONSTRAINT `BodyS_SIZE` FOREIGN KEY (`body_size_id`)
                           REFERENCES `body_size` (`id`)
                           ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `user` VALUES
(1,'Anna','Ann','anna@gmail.com','569842365', 'Ann123', 'test1', 0, 1),
(2,'Fiona','Shrek','fiona@gmail.com','846152365','shrek123', 'test2', 0, 2);


DROP TABLE IF EXISTS `diet`;


CREATE TABLE `diet`(
                      `id` INTEGER NOT NULL AUTO_INCREMENT,
                      `date` DATE DEFAULT NULL,
                      `kcal` INTEGER DEFAULT NULL,
                      `min_kcal` INTEGER DEFAULT NULL,
                      `max_kcal` INTEGER DEFAULT NULL,
                      PRIMARY KEY (`id`)

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `diet` VALUES
(1, '2018-05-23', 1500, 1300, 1800),
(2, '2018-05-23', 1800, 1500, 2300);


DROP TABLE IF EXISTS `day`;

CREATE TABLE `day`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `date` DATE DEFAULT NULL,
                       `diet_id` INTEGER DEFAULT NULL,
                       `drink_liquids_id` INTEGER DEFAULT NULL,
                       `user_id` INTEGER DEFAULT NULL,
                       PRIMARY KEY (`id`),
                       KEY `D_SIZE_idx` (`diet_id`),
                       CONSTRAINT `D_SIZE` FOREIGN KEY (`diet_id`)
                           REFERENCES `diet` (`id`),
                       KEY `DL_SIZE_idx` (`drink_liquids_id`),
                       CONSTRAINT `FK_SIZE` FOREIGN KEY (`drink_liquids_id`)
                           REFERENCES `drink_liquids` (`id`),
                       KEY `U_SIZE_idx` (`user_id`),
                       CONSTRAINT `U_SIZE` FOREIGN KEY (`user_id`)
                           REFERENCES `user` (`id`)
                           ON DELETE NO ACTION ON UPDATE NO ACTION


) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `day` VALUES
(1, '2018-05-23', 1, 1, 1),
(2, '2018-05-23', 2, 2, 2);




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

-- sugar in drinks
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