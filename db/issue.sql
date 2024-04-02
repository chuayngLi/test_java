CREATE TABLE `issue`
(
    `issue_id`    int(10) NOT NULL AUTO_INCREMENT,
    `key_word`    varchar(255) NOT NULL COMMENT '关键字',
    `description` text         NOT NULL COMMENT '问题描述',
    `title`       varchar(255) NOT NULL COMMENT '问题标题',
    `resolve`     text COMMENT '解决方案',
    `created_at`  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`issue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;