package com.example.demotest.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@TableName("issue")
public class Issue extends BaseBean {
    @TableId(value = "issue_id", type = IdType.AUTO)
    private Long issueId;

    @TableField("title")
    @NotNull(message = "标题必填")
    private String title;

    @TableField("key_word")
    @NotNull(message = "关键字必填")
    private String keyWord;

    @TableField("description")
    @NotNull(message = "描述必填")
    private String description;

    @TableField("resolve")
    private String resolve;


}
