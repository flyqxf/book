/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.sale.entity;

import com.yuanneng.book.common.entity.CommonBean;


public class SaleBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String userId = null;
    private String userName = null;
    private String register_time = null;
    
    
    private int personSum_zhijie = 0;
    private int personSum_jianjie = 0;
    private String paySummary = "0";
    
    private int personThisMonth_zhijie = 0;
    private int personThisMonth_jianjie = 0;
    private String paySummary_thisMonth = "0";
    
    private String pay = "0";
    private String flg = null;
    
    private String yearMonth = null;
    
    
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
     * @return the yearMonth
     */
    public String getYearMonth() {
        return yearMonth;
    }

    
    /**
     * @param yearMonth the yearMonth to set
     */
    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    
    /**
     * @return the personSum_zhijie
     */
    public int getPersonSum_zhijie() {
        return personSum_zhijie;
    }

    
    /**
     * @param personSum_zhijie the personSum_zhijie to set
     */
    public void setPersonSum_zhijie(int personSum_zhijie) {
        this.personSum_zhijie = personSum_zhijie;
    }

    
    /**
     * @return the personSum_jianjie
     */
    public int getPersonSum_jianjie() {
        return personSum_jianjie;
    }

    
    /**
     * @param personSum_jianjie the personSum_jianjie to set
     */
    public void setPersonSum_jianjie(int personSum_jianjie) {
        this.personSum_jianjie = personSum_jianjie;
    }

    
    /**
     * @return the paySummary
     */
    public String getPaySummary() {
        return paySummary;
    }

    
    /**
     * @param paySummary the paySummary to set
     */
    public void setPaySummary(String paySummary) {
        this.paySummary = paySummary;
    }

    
    /**
     * @return the personThisMonth_zhijie
     */
    public int getPersonThisMonth_zhijie() {
        return personThisMonth_zhijie;
    }

    
    /**
     * @param personThisMonth_zhijie the personThisMonth_zhijie to set
     */
    public void setPersonThisMonth_zhijie(int personThisMonth_zhijie) {
        this.personThisMonth_zhijie = personThisMonth_zhijie;
    }

    
    /**
     * @return the personThisMonth_jianjie
     */
    public int getPersonThisMonth_jianjie() {
        return personThisMonth_jianjie;
    }

    
    /**
     * @param personThisMonth_jianjie the personThisMonth_jianjie to set
     */
    public void setPersonThisMonth_jianjie(int personThisMonth_jianjie) {
        this.personThisMonth_jianjie = personThisMonth_jianjie;
    }

    
    /**
     * @return the paySummary_thisMonth
     */
    public String getPaySummary_thisMonth() {
        return paySummary_thisMonth;
    }

    
    /**
     * @param paySummary_thisMonth the paySummary_thisMonth to set
     */
    public void setPaySummary_thisMonth(String paySummary_thisMonth) {
        this.paySummary_thisMonth = paySummary_thisMonth;
    }

}
