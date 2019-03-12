/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.user.entity;


public class UserJianjieXiaoshouBean extends UserXiaoshouBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    
    private String xiaoshouPersonSum = null;
    
    private String paySum = null;

    
    /**
     * @return the xiaoshouPersonSum
     */
    public String getXiaoshouPersonSum() {
        return xiaoshouPersonSum;
    }

    
    /**
     * @param xiaoshouPersonSum the xiaoshouPersonSum to set
     */
    public void setXiaoshouPersonSum(String xiaoshouPersonSum) {
        this.xiaoshouPersonSum = xiaoshouPersonSum;
    }

    
    /**
     * @return the paySum
     */
    public String getPaySum() {
        return paySum;
    }

    
    /**
     * @param paySum the paySum to set
     */
    public void setPaySum(String paySum) {
        this.paySum = paySum;
    }
    
    
 
}
