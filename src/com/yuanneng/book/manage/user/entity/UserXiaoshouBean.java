/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.user.entity;


public class UserXiaoshouBean extends UserBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    
    //推荐会员会员ID
    private String achUserId = null;
    
    private String pay_status = null;
    
    private String pay_status_name = null;
    
    private String pay = null;
    
    private String flg = null;
    
    
    /**
     * @return the achUserId
     */
    public String getAchUserId() {
        return achUserId;
    }

    
    /**
     * @param achUserId the achUserId to set
     */
    public void setAchUserId(String achUserId) {
        this.achUserId = achUserId;
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
     * @return the pay
     */
    public String getPay() {
        return pay;
    }


    
    /**
     * @param pay the pay to set
     */
    public void setPay(String pay) {
        this.pay = pay;
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
     * @return the pay_status_name
     */
    public String getPay_status_name() {
        return pay_status_name;
    }


    
    /**
     * @param pay_status_name the pay_status_name to set
     */
    public void setPay_status_name(String pay_status_name) {
        this.pay_status_name = pay_status_name;
    }
    
    
}
