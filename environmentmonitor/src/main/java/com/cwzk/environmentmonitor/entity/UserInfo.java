package com.cwzk.environmentmonitor.entity;

public class UserInfo {

    /**
     * 账号
     */
    public String account;

    /**
     * 密码
     */
    public String password;

    /**
     * 1是学生家长，2是管理员
     */
    public int role;

    /**
     * 寝室号
     * 用来查询
     */
    public String dormNumber;
}
