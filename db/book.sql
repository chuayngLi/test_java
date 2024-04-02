CREATE TABLE `book`
(
    `book_id`    int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(255) NOT NULL COMMENT '书名',
    `type`       varchar(255) NOT NULL COMMENT '类别',
    `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍表';