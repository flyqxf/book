/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.login.entity;

import com.yuanneng.book.common.entity.CommonBean;


public class AdminUserBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String userId=null;
    private String userPassword=null;
    
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }
    
    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    
    
}
