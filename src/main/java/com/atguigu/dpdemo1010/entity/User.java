package com.atguigu.dpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
   ///实现自动填充；@tablefield
    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    ////乐观锁
    @Version
    @TableField(fill=FieldFill.INSERT)
    private  Integer version;

    @TableLogic//逻辑删除的注解
 @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
