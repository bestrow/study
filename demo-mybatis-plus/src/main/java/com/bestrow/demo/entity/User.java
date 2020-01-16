package com.bestrow.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "User")
@Data
@TableName(value = "user")
public class User {
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_AGE = "age";
    public static final String COL_EMAIL = "email";
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "主键ID")
    private String id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;
}