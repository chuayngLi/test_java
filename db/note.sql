CREATE TABLE `note`
(
    `note_id`    int(11) NOT NULL,
    `title`      varchar(255) NOT NULL COMMENT '笔记标题',
    `book_name`  varchar(255) NOT NULL COMMENT '阅读书籍名称',
    `book_id`    int(11) NOT NULL COMMENT '阅读书籍id',
    `content`    varchar(255) NOT NULL COMMENT '笔记内容',
    `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='笔记表';