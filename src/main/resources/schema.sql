DROP TABLE IF EXISTS `COMMENT`;
DROP TABLE IF EXISTS `EVENT`;
DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER`
(
    `USER_ID`    BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `NAME`       VARCHAR(10)  NOT NULL,
    `EMAIL`      VARCHAR(40)  NOT NULL,
    `PASSWORD`   VARCHAR(255) NOT NULL,
    `CREATED_AT` DATETIME     NOT NULL,
    `UPDATED_AT` DATETIME     NOT NULL
);

CREATE TABLE `EVENT`
(
    `EVENT_ID`   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `USER_ID`    BIGINT       NOT NULL,
    `TITLE`      VARCHAR(255) NULL,
    `CONTEXTS`   TEXT         NULL,
    `CREATED_AT` DATETIME     NOT NULL,
    `UPDATED_AT` DATETIME     NOT NULL,
    FOREIGN KEY (`USER_ID`) REFERENCES USER (USER_ID) on DELETE CASCADE
);


CREATE TABLE `COMMENT`
(
    `COMMENT_ID` BIGINT   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `EVENT_ID`   BIGINT   NOT NULL,
    `USER_ID`    BIGINT   NOT NULL,
    `COMMENT`    TEXT     NULL,
    `CREATED_AT` DATETIME NOT NULL,
    `UPDATED_AT` DATETIME NOT NULL,
    FOREIGN KEY (`EVENT_ID`) REFERENCES EVENT (EVENT_ID) on DELETE CASCADE,
    FOREIGN KEY (`USER_ID`) REFERENCES USER (USER_ID) on DELETE CASCADE
);
