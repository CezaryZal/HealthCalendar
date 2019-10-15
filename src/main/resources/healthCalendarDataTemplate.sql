
INSERT INTO `user` VALUES
(1, 2500, 3000, 'anna@gmail.com', 'Anna','Ann', 'Ann123', 'test1', 569842365, 0),
(2, 2800, 3200, 'fiona@gmail.com', 'Fiona','Shrek', 'shrek123', 'test2', 846152365, 1);

INSERT INTO `body_size` VALUES
(1, 65, 38, 31, 98, '2018-05-23', 75, 88, 45, 1, 36),
(2, 70, 40, 32, 100, '2018-02-23', 78, 90, 48, 1, 38),
(3, 66, 37, 35, 96, '2018-06-23', 74, 87, 47, 2, 37),
(4, 60, 36, 30, 91, '2018-05-25', 70, 83, 43, 2, 35);



DROP TABLE IF EXISTS `daily_limits`;

CREATE TABLE `daily_limits`(
                        `id` INTEGER NOT NULL AUTO_INCREMENT,
                        `limit_kcal` INTEGER DEFAULT NULL,
                        `limit_dink` INTEGER DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;

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

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


INSERT INTO `note` VALUES
(1, 'wyjazd do świdnika', 1),
(2, 'wakacje', 2);


DROP TABLE IF EXISTS `details_note`;

CREATE TABLE `details_note`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `details` varchar(45) DEFAULT NULL,
                       PRIMARY KEY (`id`)

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


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
                       PRIMARY KEY (`id`),
                           KEY `FK_DAY_idx` (`day_id`),
                       CONSTRAINT `FK_DAY` FOREIGN KEY (`day_id`)
                           REFERENCES `day` (`id`)
                           ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


INSERT INTO `training` VALUES
(1, '2018-09-23', 'silka', 90, 1000, 1),
(2, '2018-09-24', 'spacer', 30, 300, 2);




DROP TABLE IF EXISTS `diet`;

CREATE TABLE `diet`(
                           `id` INTEGER NOT NULL AUTO_INCREMENT,
                           `date` DATE NOT NULL,
                           `type_meal` varchar(128) DEFAULT NULL,
                           `meal_kcal` INTEGER DEFAULT NULL,
                           `meal_text` varchar(128) DEFAULT NULL,
                           PRIMARY KEY (`id`)

) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


INSERT INTO `diet` VALUES
(1, '2018-09-23', 'sniadanie', 260, 'jajecznica z 2jaj'),
(2, '2018-09-24', 'obiad', 420, 'schabowy');





DROP TABLE IF EXISTS `day`;

CREATE TABLE `day`(
                       `id` INTEGER NOT NULL AUTO_INCREMENT,
                       `dateRecord` DATE NOT NULL,
                       `user_id` INTEGER NOT NULL,
                       `body_size_id` INTEGER DEFAULT NULL,
                       `last_date_measure_body` DATE DEFAULT NULL,
                       `amount_portions_drink` INTEGER DEFAULT NULL,
                       `min_amount_portions_drink` INTEGER DEFAULT NULL,
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


) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


INSERT INTO `day` VALUES
(1, '2018-05-24', 1, 1, '2018-04-03', 5, 6, 2, 1, 2, 1),
(2, '2018-05-23', 2, 2, '2018-04-14', 8, 9, 0, 2, 0, 2);



DROP TABLE IF EXISTS `short_day`;

CREATE TABLE `short_day`(
                               `id` INTEGER NOT NULL AUTO_INCREMENT,
                               `user_id` INTEGER NOT NULL,
                               `date` DATE NOT NULL,
                               `is_limit_kcal` BOOLEAN DEFAULT NULL,
                               `is_limit_drink` BOOLEAN DEFAULT NULL,
                               `is_alcohol` BOOLEAN DEFAULT NULL,
                               `is_snacks` BOOLEAN DEFAULT NULL,

                               PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;

INSERT INTO `short_day` VALUES
(1, 2, '2018-09-23', TRUE, TRUE, FALSE, FALSE),
(2, 1, '2018-09-24', TRUE, FALSE, TRUE, FALSE);



SET FOREIGN_KEY_CHECKS = 1;

