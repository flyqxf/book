/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.sale.entity;

import com.yuanneng.book.common.entity.CommonBean;


public class ConditionBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String userId = null;
    private String userName = null;
    private String register_time = null;
    
    private String flg = null;
    
    private String personSumFrom= null;
    private String personSumTo= null;

    
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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return the register_time
     */
    public String getRegister_time() {
        return register_time;
    }
    
    /**
     * @param register_time the register_time to set
     */
    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }
    
    /**
     * @return the flg
     */
    public String getFlg() {
        return flg;
    }
    
    /**
     * @param flg the flg to set
     */
    public void setFlg(String flg) {
        this.flg = flg;
    }
    
    /**
     * @return the personSumFrom
     */
    public String getPersonSumFrom() {
        return personSumFrom;
    }
    
    /**
     * @param personSumFrom the personSumFrom to set
     */
    public void setPersonSumFrom(String personSumFrom) {
        this.personSumFrom = personSumFrom;
    }
    
    /**
     * @return the personSumTo
     */
    public String getPersonSumTo() {
        return personSumTo;
    }
    
    /**
     * @param personSumTo the personSumTo to set
     */
    public void setPersonSumTo(String personSumTo) {
        this.personSumTo = personSumTo;
    }
    
    
}
