package com.example.demotest.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xx
 * @date 2024/4/1 10:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("note")
public class Note extends BaseBean {
    @TableId(value = "note_id", type = IdType.AUTO)
    private Long noteId;

    @TableField(value = "title")
    @NotNull(message = "标题必填")
    private String title;

    @TableField(value = "book_name")
    @NotNull(message = "书名必选")
    private String bookName;

    @TableField(value = "book_id")
    @NotNull(message = "书籍必选")
    private Long bookId;

    @TableField(value = "content")
    @NotNull(message = "内容必填")
    private String content;


}