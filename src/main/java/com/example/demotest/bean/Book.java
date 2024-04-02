package com.example.demotest.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("book")
public class Book extends BaseBean {
    @TableId(value = "book_id", type = IdType.AUTO)
    private Long bookId;

    @TableField("name")
    @NotNull(message = "书名必填")
    private String name;

    @TableField("type")
    @NotNull(message = "类型必填")
    private String type;

}
