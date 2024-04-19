package com.example.demotest.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xx
 * @date 2024/4/1 10:02
 */
@Data
public class BaseBean {
    @TableField("created_at")
    private String createdAt;

    @TableField("updated_at")
    private String updatedAt;
}