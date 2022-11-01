package com.xuegao.springmybatisplus.doo.demo;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

    private Integer id;

    private String username;

    private String password;

    @TableLogic
    @TableField(select = false, fill = FieldFill.INSERT)
    private Integer delFlag;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String traceId;

    public UserInfo() {
    }
}