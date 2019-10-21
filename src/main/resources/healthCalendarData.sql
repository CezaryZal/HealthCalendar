
INSERT INTO `user` VALUES
(1, 'anna@gmail.com', 'Anna','Ann', 'Ann123', 'test1', 569842365, 0, 1),
(2, 'fiona@gmail.com', 'Fiona','Shrek', 'shrek123', 'test2', 846152365, 1, 2);

INSERT INTO `body_size` VALUES
(1, 65, 38, 31, 98, '2018-05-23', 75, 88, 45, 1, 36),
(2, 70, 40, 32, 100, '2018-02-23', 78, 90, 48, 1, 38),
(3, 66, 37, 35, 96, '2018-06-23', 74, 87, 47, 2, 37),
(4, 60, 36, 30, 91, '2018-05-25', 70, 83, 43, 2, 35);

INSERT INTO `daily_limits` VALUES
(1, 2500, 2000, 1),
(2, 4000, 3000, 2);

INSERT INTO `meal` VALUES
(1, '2018-05-23 11:21', 1, 'jajecznica z 2jaj', 260, 'sniadanie'),
(2, '2018-05-23 12:22', 1, 'schabowy', 420, 'obiad'),
(3, '2018-05-24 03:33', 2, 'kanapki', 300, 'II sniadanie'),
(4, '2018-05-24 04:44', 2, 'gulasz', 510, 'obiad'),
(5, '2018-05-24 05:55', 2, 'żeberka', 510, 'obiad'),
(6, '2018-05-24 06:06', 2, 'gulasz', 510, 'obiad');

INSERT INTO `training` VALUES
(1, 260, '2018-05-23 11:21', 1, 'silka', '1:40'),
(2, 220, '2018-05-23 12:22', 1, 'sex', '0:40'),
(3, 300, '2018-05-24 03:33', 2, 'plywalnia', '0:55'),
(4, 210, '2018-05-24 04:44', 2, 'rower', '0:45'),
(5, 430, '2018-05-24 05:55', 2, 'bieganie', '1:00'),
(6, 300, '2018-05-24 06:06', 2, 'silka', '1:10');

INSERT INTO `note` VALUES
(1, 1, 'dieta nie utrzymana', 'wyjazd do świdnika'),
(2, 1, 'pite duzo alkoholu', 'wakacje'),
(3, 2, 'duzo tlustego jedzenia i alkoholu', 'wyjazd do tesciow'),
(4, 2, 'nieregularne jedzenie i pyty alkohol', 'wakacje');

INSERT INTO `short_day` VALUES
(1, '2018-05-24', TRUE, FALSE, TRUE, TRUE, 1),
(2, '2018-05-23', TRUE, FALSE, TRUE, TRUE, 1),
(3, '2018-05-24', TRUE, FALSE, TRUE, TRUE, 2),
(4, '2018-05-23', TRUE, FALSE, TRUE, TRUE, 2),
(5, '2018-06-20', TRUE, FALSE, TRUE, TRUE, 1),
(6, '2018-04-29', TRUE, FALSE, TRUE, TRUE, 1),
(7, '2018-08-20', TRUE, FALSE, TRUE, TRUE, 1),
(8, '2018-03-29', TRUE, FALSE, TRUE, TRUE, 1);

INSERT INTO `day` VALUES
(1, '2018-05-24', 11, 12, 4, 1, 1),
(2, '2018-05-23', 21, 22, 1, 1, 2),
(3, '2018-05-24', 31, 32, 4, 2, 3),
(4, '2018-05-23', 41, 42, 1, 2, 4);



-- ALTER TABLE `meal` CONVERT TO CHARACTER SET utf8 COLLATE utf8_polish_ci;

SET FOREIGN_KEY_CHECKS = 1;
