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
                       `date` DATE NOT NULL,
                       `user_id` INTEGER NOT NULL,
                       PRIMARY KEY (`id`),
                       KEY `USER_SIZE_idx` (`user_id`),
                       CONSTRAINT `USER_SIZE` FOREIGN KEY (`user_id`)
                           REFERENCES `user` (`id`)
                           ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `body_size` VALUES
(1, 65, 38, 31, 98, 75, 88, 45, 36, '2018-05-23', 1),
(2, 70, 40, 32, 100, 78, 90, 48, 38, '2018-02-23', 1),
(3, 66, 37, 35, 96, 74, 87, 47, 37, '2018-06-23', 2),
(4, 60, 36, 30, 91, 70, 83, 43, 35, '2018-05-25', 2);



DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `first_name` varchar(45) Not NULL,
                       `nick` varchar(45) NOT NULL,
                       `email` varchar(45) DEFAULT NULL,
                       `phone_number` INTEGER DEFAULT NULL,
                       `login_name` varchar(45) NOT NULL,
                       `password` varchar(45) NOT NULL,
                       `sex` INTEGER NOT NULL,
                       `daily_limits_id` INTEGER NOT NULL,
                       PRIMARY KEY (`id`),
                       UNIQUE KEY `NICK_UNIQUE` (`nick`),
                       UNIQUE KEY `LOGIN_UNIQUE` (`login_name`),
                       UNIQUE KEY `EMAIL_UNIQUE` (`email`),
                           KEY `DL_SIZE_idx` (`daily_limits_id`),
                       CONSTRAINT `DL_SIZE` FOREIGN KEY (`daily_limits_id`)
                           REFERENCES `daily_limits` (`id`)
                           ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `user` VALUES
(1,'Anna','Ann','anna@gmail.com',569842365, 'Ann123', 'test1', 0, 1),
(2,'Fiona','Shrek','fiona@gmail.com', 846152365,'shrek123', 'test2', 1, 2);



DROP TABLE IF EXISTS `daily_limits`;

CREATE TABLE `daily_limits`(
                        `id` INTEGER NOT NULL AUTO_INCREMENT,
                        `limit_kcal` INTEGER DEFAULT NULL,
                        `limit_dink` INTEGER DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `daily_limits` VALUES
(1, 2500, 2000),
(2, 4000, 3000);



DROP TABLE IF EXISTS `note`;


CREATE TABLE `note`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `header` varchar(128) NOT NULL,
                       `details_note_id` INTEGER DEFAULT NULL,
                       PRIMARY KEY (`id`),
                       KEY `DN_SIZE_idx` (`details_note_id`),
                       CONSTRAINT `DN_SIZE` FOREIGN KEY (`details_note_id`)
                           REFERENCES `details_note` (`id`)
                           ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `note` VALUES
(1, 'wyjazd', 1),
(2, 'wakacje', 2);


DROP TABLE IF EXISTS `details_note`;

CREATE TABLE `details_note`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `details` varchar(45) DEFAULT NULL,
                       PRIMARY KEY (`id`)

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `details_note` VALUES
(1, 'dieta nie utrzymana'),
(2, 'zjedzone znacznie wiecej');



DROP TABLE IF EXISTS `training`;

CREATE TABLE `training`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `date` DATE NOT NULL,
                       `training_text` varchar(128) DEFAULT NULL,
                       `training_time` INTEGER DEFAULT NULL,
                       `training_kcal` INTEGER DEFAULT NULL,
                       `day_id` INTEGER DEFAULT NULL,
                       PRIMARY KEY (`id`)
                           KEY `T_SIZE_idx` (`day_id`),
                       CONSTRAINT `T_SIZE` FOREIGN KEY (`day_id`)
                           REFERENCES `day` (`id`)
                           ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `training` VALUES
(1, '2018-09-23', 'silka', 90, 1000),
(2, '2018-09-24', 'spacer', 30, 300);




DROP TABLE IF EXISTS `diet`;

CREATE TABLE `diet`(
                           `id` INTEGER NOT NULL AUTO_INCREMENT,
                           `date` DATE NOT NULL,
                           `breakfast_kcal` INTEGER DEFAULT NULL,
                           `breakfast_text` varchar(128) DEFAULT NULL,
                           `breakfastII_kcal` INTEGER DEFAULT NULL,
                           `breakfastII_text` varchar(128) DEFAULT NULL,
                           `dinner_kcal` INTEGER DEFAULT NULL,
                           `dinner_text` varchar(128) DEFAULT NULL,
                           `afternoon_meal_kcal` INTEGER DEFAULT NULL,
                           `afternoon_meal_text` varchar(128) DEFAULT NULL,
                           `supper_kcal` INTEGER DEFAULT NULL,
                           `supper_text` varchar(128) DEFAULT NULL,
                           PRIMARY KEY (`id`)

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `diet` VALUES
(1, '2018-09-23',  450, 'kanapki', 100, 'jablko', 800, 'zeberka', 250, 'jogurt', 150, 'salatke'),
(2, '2018-09-24',  350, 'jajowa', 120, 'owsianka', 950, 'schabowy', 150, 'banany', 350, 'kanpki');





DROP TABLE IF EXISTS `day`;

CREATE TABLE `day`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `date` DATE NOT NULL,
                       `user_id` INTEGER NOT NULL,
                       `body_size_id` INTEGER DEFAULT NULL,
                       `last_date_measure_body` DATE DEFAULT NULL,
                       `amount_portions_dink` INTEGER DEFAULT NULL,
                       `min_amount_portions_dink` INTEGER DEFAULT NULL,
                       `amount_portions_alcohol` INTEGER DEFAULT NULL,
                       `diet_id` INTEGER DEFAULT NULL,
                       `amount_portions_snack` INTEGER DEFAULT NULL,
                       `note_id` INTEGER DEFAULT NULL,
                       PRIMARY KEY (`id`),
                       KEY `U_SIZE_idx` (`user_id`),
                       CONSTRAINT `U_SIZE` FOREIGN KEY (`user_id`)
                           REFERENCES `user` (`id`),
                       KEY `N_SIZE_idx` (`note_id`),
                       CONSTRAINT `N_SIZE` FOREIGN KEY (`note_id`)
                           REFERENCES `note` (`id`),
                       KEY `D_SIZE_idx` (`diet_id`),
                       CONSTRAINT `D_SIZE` FOREIGN KEY (`diet_id`)
                           REFERENCES `diet` (`id`)
                           ON DELETE NO ACTION ON UPDATE NO ACTION


) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `day` VALUES
(1, '2018-05-23', 1, 2, '2018-04-03', 5, 6, 2, 1, 2, 1, 2),
(2, '2018-05-23', 2, 1, '2018-04-14', 8, 9, 0, 2, 0, 2, 1);



DROP TABLE IF EXISTS `short_day`;

CREATE TABLE `short_day`(
                               `id` INTEGER NOT NULL AUTO_INCREMENT,
                               `user_id` INTEGER NOT NULL,
                               `date` DATE NOT NULL,
                               `is_limit_kcal` BOOLEAN DEFAULT NULL,
                               `is_limit_dink` BOOLEAN DEFAULT NULL,
                               `is_alcohol` BOOLEAN DEFAULT NULL,
                               `is_snacks` BOOLEAN DEFAULT NULL,

                               PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `short_day` VALUES
(1, 2, '2018-09-23', TRUE, TRUE, FALSE, FALSE),
(2, 1, '2018-09-24', TRUE, FALSE, TRUE, FALSE);



SET FOREIGN_KEY_CHECKS = 1;

