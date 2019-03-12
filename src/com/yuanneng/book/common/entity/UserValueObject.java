package com.yuanneng.book.common.entity;

import java.io.Serializable;

import com.yuanneng.book.sysmanage.entity.UserBean;

public class UserValueObject implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户信息
     */
    private UserBean user = null;

    /**
     * 用户登录IP
     */
    private String loginIp = null;

    /**
     * 用户上次登录时间
     */
    private String loginDate = null;

    /**
     * @return 用户信息
     */
    public UserBean getUser() {
        return user;
    }

    /**
     * @param user 用户信息
     */
    public void setUser(UserBean user) {
        this.user = user;
    }

    /**
     * @return 用户登录IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * @param loginIp 用户登录IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

}
