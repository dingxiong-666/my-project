package com.dx.project.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * @Author: dx
 * @CreateTime: 2021-09-14 10:36
 * @Description: ${Description}
 */
@TableName("user")
@Data
public class User {
    @TableId(value = "id",
            type = IdType.AUTO
    )
    private Integer id;
    private String username;
    private String password;
    //@TableField("nick_name")
    private String nickName;
    private Integer age;
    private String sex;
    private String address;
}
