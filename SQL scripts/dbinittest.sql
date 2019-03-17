CREATE DATABASE  IF NOT EXISTS `useradmintest`;

USE `useradmintest`;

DROP TABLE IF EXISTS `orderstest`;
DROP TABLE IF EXISTS `userstest`;

CREATE TABLE `userstest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `useradmintest`.`orderstest` (
  `idorders` INT NOT NULL,
  `sent` BOOLEAN NOT NULL DEFAULT FALSE,
  `length` INT NOT NULL DEFAULT 0,
  `width` INT NOT NULL DEFAULT 0,
  `height` INT NOT NULL DEFAULT 0,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `idorders`
    FOREIGN KEY (`idorders`)
    REFERENCES `useradmin`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
    
LOCK TABLES `userstest` WRITE;
INSERT INTO `userstest` VALUES 
(1,'jens@somewhere.com','jensen','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','employee');
UNLOCK TABLES;