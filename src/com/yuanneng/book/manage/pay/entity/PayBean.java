package com.yuanneng.book.manage.pay.entity;

import java.util.Date;

import com.yuanneng.book.common.entity.CommonBean;


public class PayBean extends CommonBean {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String id=null;
    private String userId=null;
    private String userName=null;
    private String personSum="0";
    private String pay="0";
    private String paid="0";
    private String unpaid="0";
    private String qishu=null;
    private String beginTime=null;
    private String endTime=null;
    private String payName=null;
    private Date paydate=null;
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
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
     * @return the paid
     */
    public String getPaid() {
        return paid;
    }
    
    /**
     * @param paid the paid to set
     */
    public void setPaid(String paid) {
        this.paid = paid;
    }
    
    /**
     * @return the unpaid
     */
    public String getUnpaid() {
        return unpaid;
    }
    
    /**
     * @param unpaid the unpaid to set
     */
    public void setUnpaid(String unpaid) {
        this.unpaid = unpaid;
    }
    
    /**
     * @return the qishu
     */
    public String getQishu() {
        return qishu;
    }
    
    /**
     * @param qishu the qishu to set
     */
    public void setQishu(String qishu) {
        this.qishu = qishu;
    }
    
    /**
     * @return the beginTime
     */
    public String getBeginTime() {
        return beginTime;
    }
    
    /**
     * @param beginTime the beginTime to set
     */
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
    
    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }
    
    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    /**
     * @return the payName
     */
    public String getPayName() {
        return payName;
    }
    
    /**
     * @param payName the payName to set
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }
    
    /**
     * @return the paydate
     */
    public Date getPaydate() {
        return paydate;
    }
    
    /**
     * @param paydate the paydate to set
     */
    public void setPaydate(Date paydate) {
        this.paydate = paydate;
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

    
}
