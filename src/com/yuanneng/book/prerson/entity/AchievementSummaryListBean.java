/*
 * @(#)BookBean.java
 */
package com.yuanneng.book.prerson.entity;


import com.yuanneng.book.common.entity.CommonBean;

/**
 * UserBean.java
 * 
 * 功 能： 用户信息bean
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.08.21         guot        新规做成
 * </pre>
 */
public class AchievementSummaryListBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;


    private String userId = null;
    private String personSum = null;
    private String moneySum = null;
    private String pay_status = null;
    private String flg =null;
    
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
     * @return the personSum
     */
    public String getPersonSum() {
        return personSum;
    }
    
    /**
     * @param personSum the personSum to set
     */
    public void setPersonSum(String personSum) {
        this.personSum = personSum;
    }
    
    /**
     * @return the moneySum
     */
    public String getMoneySum() {
        return moneySum;
    }
    
    /**
     * @param moneySum the moneySum to set
     */
    public void setMoneySum(String moneySum) {
        this.moneySum = moneySum;
    }
    
    /**
     * @return the pay_status
     */
    public String getPay_status() {
        return pay_status;
    }
    
    /**
     * @param pay_status the pay_status to set
     */
    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
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
    
    
    
}
