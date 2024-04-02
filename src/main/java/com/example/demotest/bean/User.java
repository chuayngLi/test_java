package com.example.demotest.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "account")
    @NotNull(message = "账号必填")
    private String account;

    @TableField(value = "password")
    @NotNull(message = "密码必填")
    private String password;

}
