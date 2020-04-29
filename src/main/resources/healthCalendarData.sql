CREATE DATABASE IF NOT EXISTS `health_calendar`;

USE `health_calendar`;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `users_auth`;
CREATE TABLE `users_auth` (
                      `id` BIGINT NOT NULL AUTO_INCREMENT,
                      `active` BIT(1) DEFAULT NULL,
                      `password` CHAR (64) DEFAULT NULL,
                      `permissions` VARCHAR(20) DEFAULT NULL,
                      `roles` CHAR(10) DEFAULT NULL,
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

INSERT INTO `users_auth` VALUES
(1, true, '$2a$14$qvPKR4sT9jI1svoxv/IbaOC0hQJ9sHDUkW5W9lsBCXKF84oWglyDa', 'ADD', 'VIEWER'),
(2, true, '$2a$14$YMpWNeW5XrzvJnI/TuosWenErLQght/C56DhIE5BNkUs296PvPFLC', 'ADD', 'USER'),
(3, true, '$2a$10$aAIl0ih538I2tHl93BTUzuiQMZZbnzNIUyeM3/dkXc6MzQorLALe.', 'ADD', 'ADMIN');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                    `id` BIGINT NOT NULL AUTO_INCREMENT,
                    `birth_date` DATE DEFAULT NULL,
                    `email` VARCHAR(255) DEFAULT NULL,
                    `login_name` VARCHAR(55) DEFAULT NULL,
                    `nick` VARCHAR(24) DEFAULT NULL,
                    `phone_number` VARCHAR(20) DEFAULT NULL,
                    `man` BIT(1) DEFAULT NULL,
                    `drink_demand` SMALLINT UNSIGNED DEFAULT NULL,
                    `kcal_demand` SMALLINT UNSIGNED DEFAULT NULL,
                    `users_auth_id` BIGINT DEFAULT NULL,
                    PRIMARY KEY (`id`),
                    KEY `users_auth` (`users_auth_id`),
                    CONSTRAINT `users_auth` FOREIGN KEY (`users_auth_id`) REFERENCES `users_auth` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

INSERT INTO `user` VALUES
(1, '1966-05-23', 'anna@gmail.com', 'janek14','jan', '569 842 365', true, 2500, 2000, 1),
(2, '1996-05-23', 'fiona@gmail.com', 'tomek92','tomy', '846 152 365', true, 4000, 3000, 2),
(3, '1999-05-23', 'kris@gmail.com', 'czar9001','czarek', '849 642 365', true, 3000, 2500, 3);

DROP TABLE IF EXISTS `body_size`;
CREATE TABLE `body_size` (
                     `id` BIGINT NOT NULL AUTO_INCREMENT,
                     `arm_size` SMALLINT UNSIGNED DEFAULT NULL,
                     `body_weight` SMALLINT UNSIGNED DEFAULT NULL,
                     `bust_size` SMALLINT UNSIGNED DEFAULT NULL,
                     `calf` SMALLINT UNSIGNED DEFAULT NULL,
                     `date` DATE DEFAULT NULL,
                     `femoral_size` SMALLINT UNSIGNED DEFAULT NULL,
                     `hips_size` SMALLINT UNSIGNED DEFAULT NULL,
                     `neck_size` SMALLINT UNSIGNED DEFAULT NULL,
                     `waist` SMALLINT UNSIGNED DEFAULT NULL,
                     `user_id` BIGINT DEFAULT NULL,
                     PRIMARY KEY (`id`),
                     KEY `body_user` (`user_id`),
                     CONSTRAINT `body_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

INSERT INTO `body_size` VALUES
(1, 65, 38, 31, 98, '2018-05-23', 75, 88, 45, 36, 1),
(2, 70, 40, 32, 100, '2018-02-23', 78, 90, 48, 38, 1),
(3, 66, 37, 35, 96, '2018-06-23', 74, 87, 47, 37, 2),
(4, 60, 36, 30, 91, '2018-05-25', 70, 83, 43, 35, 2);

DROP TABLE IF EXISTS `short_report`;
CREATE TABLE `short_report` (
                    `id` BIGINT NOT NULL AUTO_INCREMENT,
                    `date` DATE DEFAULT NULL,
                    `is_achieved_drink` BIT(1) DEFAULT NULL,
                    `is_achieved_kcal` BIT(1) DEFAULT NULL,
                    `is_alcohol` BIT(1) DEFAULT NULL,
                    `is_snacks` BIT(1) DEFAULT NULL,
                    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

INSERT INTO `short_report` VALUES
(1, '2018-05-23', TRUE, FALSE, TRUE, TRUE),
(2, '2018-05-24', TRUE, FALSE, TRUE, TRUE),
(3, '2018-05-24', TRUE, FALSE, TRUE, TRUE),
(4, '2018-05-23', TRUE, FALSE, TRUE, TRUE),
(5, '2018-06-20', TRUE, FALSE, TRUE, TRUE),
(6, '2018-05-23', TRUE, FALSE, TRUE, TRUE);

DROP TABLE IF EXISTS `day`;
CREATE TABLE `day` (
                       `id` BIGINT NOT NULL AUTO_INCREMENT,
                       `date` DATE DEFAULT NULL,
                       `portions_alcohol` TINYINT UNSIGNED DEFAULT NULL,
                       `portions_drink` TINYINT UNSIGNED DEFAULT NULL,
                       `portions_snack` TINYINT UNSIGNED DEFAULT NULL,
                       `user_id` BIGINT DEFAULT NULL,
                       `short_day_id` BIGINT DEFAULT NULL,
                       PRIMARY KEY (`id`),
                       KEY `day_short_day` (`short_day_id`),
                       KEY `day_user` (`user_id`),
                       CONSTRAINT `day_short_day` FOREIGN KEY (`short_day_id`) REFERENCES `short_report` (`id`),
                       CONSTRAINT `day_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

INSERT INTO `day` VALUES
(1, '2018-05-23', 11, 12, 4, 1, 1),
(2, '2018-05-24', 21, 22, 1, 1, 2),
(3, '2018-05-24', 31, 32, 4, 2, 3),
(4, '2018-05-23', 41, 42, 1, 2, 4),
(5, '2018-05-24', 31, 32, 4, 3, 5),
(6, '2018-05-23', 5, 3, 4, 3, 6);

DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal` (
                    `id` BIGINT NOT NULL AUTO_INCREMENT,
                    `date_time` DATETIME NOT NULL ,
                    `description` VARCHAR(255) NOT NULL,
                    `kcal` SMALLINT UNSIGNED NOT NULL,
                    `type` VARCHAR(55) NOT NULL,
                    `day_id` BIGINT NOT NULL,
                    PRIMARY KEY (`id`),
                    KEY `meal_day` (`day_id`),
                    CONSTRAINT `meal_day` FOREIGN KEY (`day_id`) REFERENCES `day` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

INSERT INTO `meal` VALUES
(1, '2018-05-23 11:21', 'jajecznica z 2jaj', 260, 'sniadanie', 1),
(2, '2018-05-23 12:22', 'schabowy', 420, 'obiad', 1),
(3, '2018-05-24 03:33', 'kanapki', 300, 'II sniadanie', 2),
(4, '2018-05-24 04:44', 'gulasz', 510, 'obiad', 2),
(5, '2018-05-24 05:55', 'żeberka', 510, 'obiad', 2),
(6, '2018-05-24 06:06', 'gulasz', 510, 'obiad', 2);

DROP TABLE IF EXISTS `training`;
CREATE TABLE `training` (
                    `id` BIGINT NOT NULL AUTO_INCREMENT,
                    `burn_kcal` SMALLINT UNSIGNED DEFAULT NULL,
                    `date_time` DATETIME DEFAULT NULL,
                    `description` VARCHAR(255) DEFAULT NULL,
                    `time` TIME DEFAULT NULL,
                    `day_id` BIGINT DEFAULT NULL,
                    PRIMARY KEY (`id`),
                    KEY `training_day` (`day_id`),
                    CONSTRAINT `training_day` FOREIGN KEY (`day_id`) REFERENCES `day` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

INSERT INTO `training` VALUES
(1, 260, '2018-05-23 11:21', 'silka', '1:40', 1),
(2, 220, '2018-05-23 12:22', 'sex', '0:40', 1),
(3, 300, '2018-05-24 03:33', 'plywalnia', '0:55', 2),
(4, 210, '2018-05-24 04:44', 'rower', '0:45', 2),
(5, 430, '2018-05-24 05:55', 'bieganie', '1:00', 2),
(6, 300, '2018-05-24 06:06', 'silka', '1:10', 2);

DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
                    `id` BIGINT NOT NULL AUTO_INCREMENT,
                    `details_note` VARCHAR(255) DEFAULT NULL,
                    `header` VARCHAR(55) DEFAULT NULL,
                    `day_id` BIGINT DEFAULT NULL,
                    PRIMARY KEY (`id`),
                    KEY `note_day` (`day_id`),
                    CONSTRAINT `note_day` FOREIGN KEY (`day_id`) REFERENCES `day` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

INSERT INTO `note` VALUES
(1, 'dieta nie utrzymana', 'wyjazd do świdnika', 1),
(2, 'pite duzo alkoholu', 'wakacje', 1),
(3, 'duzo tlustego jedzenia i alkoholu', 'wyjazd do tesciow', 2),
(4, 'duzo tlustego alkoholu', 'wyjazd do szefa', 3),
(5, 'nieregularne jedzenie i pyty alkohol', 'wakacje', 2);


-- ALTER TABLE `meal` CONVERT TO CHARACTER SET utf8 COLLATE utf8_polish_ci;

SET FOREIGN_KEY_CHECKS = 1;

