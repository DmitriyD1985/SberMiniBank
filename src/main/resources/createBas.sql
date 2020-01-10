CREATE TABLE `users` (
`userId` int(11) NOT NULL AUTO_INCREMENT,
`userFIO` varchar(200) CHARACTER SET utf8 NOT NULL,
`userPassword` varchar(45) CHARACTER SET utf8 NOT NULL,
`userLogin` varchar(45) CHARACTER SET utf8 NOT NULL,
`userAccount` varchar(200) CHARACTER SET utf8 NOT NULL DEFAULT '0',
PRIMARY KEY (`userId`),
UNIQUE KEY `idusers_UNIQUE` (`userId`),
UNIQUE KEY `userLogin_UNIQUE` (`userLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



CREATE TABLE `useroperationhistory` (
`operationName` varchar(45) NOT NULL,
`operationSum` varchar(200) NOT NULL,
`operationContrAgentLogin` varchar(45) NOT NULL,
`userLogin` varchar(45) NOT NULL,
`operationID` int(11) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (`operationID`),
UNIQUE KEY `operationID_UNIQUE` (`operationID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
