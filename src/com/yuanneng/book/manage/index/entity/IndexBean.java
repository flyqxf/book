/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.index.entity;

import com.yuanneng.book.common.entity.CommonBean;


public class IndexBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String personSummary=null;
    private String saleSum=null;
    private String personSum=null;
    //收入
    private String income=null;
    //已分配金额
    private String distribution=null;
    //未分配金额
    private String notDistribution=null;
    
    /**
     * @return the personSummary
     */
    public String getPersonSummary() {
        return personSummary;
    }
    
    /**
     * @param personSummary the personSummary to set
     */
    public void setPersonSummary(String personSummary) {
        this.personSummary = personSummary;
    }
    
    /**
     * @return the saleSum
     */
    public String getSaleSum() {
        return saleSum;
    }
    
    /**
     * @param saleSum the saleSum to set
     */
    public void setSaleSum(String saleSum) {
        this.saleSum = saleSum;
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
     * @return the income
     */
    public String getIncome() {
        return income;
    }
    
    /**
     * @param income the income to set
     */
    public void setIncome(String income) {
        this.income = income;
    }
    
    /**
     * @return the distribution
     */
    public String getDistribution() {
        return distribution;
    }
    
    /**
     * @param distribution the distribution to set
     */
    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }
    
    /**
     * @return the notDistribution
     */
    public String getNotDistribution() {
        return notDistribution;
    }
    
    /**
     * @param notDistribution the notDistribution to set
     */
    public void setNotDistribution(String notDistribution) {
        this.notDistribution = notDistribution;
    }
    
    
}
