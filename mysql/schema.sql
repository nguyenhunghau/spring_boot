
CREATE DATABASE IF NOT EXISTS `FABER_EXTRACT`;
USE `FABER_EXTRACT`;

CREATE TABLE `a_staff` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) DEFAULT NULL,
  `EMAIL` varchar(250) DEFAULT NULL,
  `CREATED` datetime DEFAULT NULL,
  `CREATED_BY` varchar(250) DEFAULT NULL,
  `IS_CS_MEMBER` bit(1) DEFAULT b'0',
  `IS_LOGIN_MANAGEMENT` bit(1) DEFAULT b'0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
