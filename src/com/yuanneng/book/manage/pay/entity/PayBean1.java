/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.pay.entity;

import java.util.Date;

import com.yuanneng.book.common.entity.CommonBean;


public class PayBean1 extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id = null;
    private String userId = null;
    private String userName = null;
    
    private String personSum_zhijie = null;
    private String personSum_jianjie = null;
    private String personSum_Summary = null;
    
    private String pay_zhijie = "0";
    private String paid_zhijie = "0";
    private String unpaid_zhijie = "0";
    
    private String pay_jianjie = "0";
    private String paid_jianjie = "0";
    private String unpaid_jianjie = "0";
    
    private String id_qqq=null;
    private String pay_qqq = "0";
    private String paid_qqq = "0";
    private String unpaid_qqq = "0";
    
    private String id_qq=null;
    private String pay_qq = "0";
    private String paid_qq = "0";
    private String unpaid_qq = "0";
    
    private String id_dq=null;
    private String pay_dq = "0";
    private String paid_dq = "0";
    private String unpaid_dq = "0";
    
    private String unpaid_summary="0";
    private String pay_summary="0";
    
    private String personSum_Summary_qqq = "0";
    private String personSum_Summary_qq = "0";
    private String personSum_Summary_dq = "0";
    
    private String flg = null;
    private String date = null;
    private Date paydate = null;
    private String payName = null;
    private String pay = null;
    
    private String payId = null;
    
    
    private String pay_qqq_zhijie = "0";
    private String paid_qqq_zhijie = "0";
    private String unpaid_qqq_zhijie = "0";
    
    private String pay_qqq_jianjie = "0";
    private String paid_qqq_jianjie = "0";
    private String unpaid_qqq_jianjie = "0";
    
    private String pay_qq_zhijie = "0";
    private String paid_qq_zhijie = "0";
    private String unpaid_qq_zhijie = "0";
    
    private String pay_qq_jianjie = "0";
    private String paid_qq_jianjie = "0";
    private String unpaid_qq_jianjie = "0";

    private String pay_dq_zhijie = "0";
    private String paid_dq_zhijie = "0";
    private String unpaid_dq_zhijie = "0";
    
    private String pay_dq_jianjie = "0";
    private String paid_dq_jianjie = "0";
    private String unpaid_dq_jianjie = "0";

    
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
     * @return the pay_zhijie
     */
    public String getPay_zhijie() {
        return pay_zhijie;
    }

    
    /**
     * @param pay_zhijie the pay_zhijie to set
     */
    public void setPay_zhijie(String pay_zhijie) {
        this.pay_zhijie = pay_zhijie;
    }

    
    /**
     * @return the paid_zhijie
     */
    public String getPaid_zhijie() {
        return paid_zhijie;
    }

    
    /**
     * @param paid_zhijie the paid_zhijie to set
     */
    public void setPaid_zhijie(String paid_zhijie) {
        this.paid_zhijie = paid_zhijie;
    }

    
    /**
     * @return the unpaid_zhijie
     */
    public String getUnpaid_zhijie() {
        return unpaid_zhijie;
    }

    
    /**
     * @param unpaid_zhijie the unpaid_zhijie to set
     */
    public void setUnpaid_zhijie(String unpaid_zhijie) {
        this.unpaid_zhijie = unpaid_zhijie;
    }

    
    /**
     * @return the pay_jianjie
     */
    public String getPay_jianjie() {
        return pay_jianjie;
    }

    
    /**
     * @param pay_jianjie the pay_jianjie to set
     */
    public void setPay_jianjie(String pay_jianjie) {
        this.pay_jianjie = pay_jianjie;
    }

    
    /**
     * @return the paid_jianjie
     */
    public String getPaid_jianjie() {
        return paid_jianjie;
    }

    
    /**
     * @param paid_jianjie the paid_jianjie to set
     */
    public void setPaid_jianjie(String paid_jianjie) {
        this.paid_jianjie = paid_jianjie;
    }

    
    /**
     * @return the unpaid_jianjie
     */
    public String getUnpaid_jianjie() {
        return unpaid_jianjie;
    }

    
    /**
     * @param unpaid_jianjie the unpaid_jianjie to set
     */
    public void setUnpaid_jianjie(String unpaid_jianjie) {
        this.unpaid_jianjie = unpaid_jianjie;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }
    
    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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
     * @return the pay_qqq
     */
    public String getPay_qqq() {
        return pay_qqq;
    }

    
    /**
     * @param pay_qqq the pay_qqq to set
     */
    public void setPay_qqq(String pay_qqq) {
        this.pay_qqq = pay_qqq;
    }

    
    /**
     * @return the paid_qqq
     */
    public String getPaid_qqq() {
        return paid_qqq;
    }

    
    /**
     * @param paid_qqq the paid_qqq to set
     */
    public void setPaid_qqq(String paid_qqq) {
        this.paid_qqq = paid_qqq;
    }

    
    /**
     * @return the unpaid_qqq
     */
    public String getUnpaid_qqq() {
        return unpaid_qqq;
    }

    
    /**
     * @param unpaid_qqq the unpaid_qqq to set
     */
    public void setUnpaid_qqq(String unpaid_qqq) {
        this.unpaid_qqq = unpaid_qqq;
    }

    
    /**
     * @return the pay_qq
     */
    public String getPay_qq() {
        return pay_qq;
    }

    
    /**
     * @param pay_qq the pay_qq to set
     */
    public void setPay_qq(String pay_qq) {
        this.pay_qq = pay_qq;
    }

    
    /**
     * @return the paid_qq
     */
    public String getPaid_qq() {
        return paid_qq;
    }

    
    /**
     * @param paid_qq the paid_qq to set
     */
    public void setPaid_qq(String paid_qq) {
        this.paid_qq = paid_qq;
    }

    
    /**
     * @return the unpaid_qq
     */
    public String getUnpaid_qq() {
        return unpaid_qq;
    }

    
    /**
     * @param unpaid_qq the unpaid_qq to set
     */
    public void setUnpaid_qq(String unpaid_qq) {
        this.unpaid_qq = unpaid_qq;
    }

    
    /**
     * @return the pay_dq
     */
    public String getPay_dq() {
        return pay_dq;
    }

    
    /**
     * @param pay_dq the pay_dq to set
     */
    public void setPay_dq(String pay_dq) {
        this.pay_dq = pay_dq;
    }

    
    /**
     * @return the paid_dq
     */
    public String getPaid_dq() {
        return paid_dq;
    }

    
    /**
     * @param paid_dq the paid_dq to set
     */
    public void setPaid_dq(String paid_dq) {
        this.paid_dq = paid_dq;
    }

    
    /**
     * @return the unpaid_dq
     */
    public String getUnpaid_dq() {
        return unpaid_dq;
    }

    
    /**
     * @param unpaid_dq the unpaid_dq to set
     */
    public void setUnpaid_dq(String unpaid_dq) {
        this.unpaid_dq = unpaid_dq;
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
     * @return the unpaid_summary
     */
    public String getUnpaid_summary() {
        return unpaid_summary;
    }

    
    /**
     * @param unpaid_summary the unpaid_summary to set
     */
    public void setUnpaid_summary(String unpaid_summary) {
        this.unpaid_summary = unpaid_summary;
    }

    
    /**
     * @return the personSum_zhijie
     */
    public String getPersonSum_zhijie() {
        return personSum_zhijie;
    }

    
    /**
     * @param personSum_zhijie the personSum_zhijie to set
     */
    public void setPersonSum_zhijie(String personSum_zhijie) {
        this.personSum_zhijie = personSum_zhijie;
    }

    
    /**
     * @return the personSum_jianjie
     */
    public String getPersonSum_jianjie() {
        return personSum_jianjie;
    }

    
    /**
     * @param personSum_jianjie the personSum_jianjie to set
     */
    public void setPersonSum_jianjie(String personSum_jianjie) {
        this.personSum_jianjie = personSum_jianjie;
    }

    
    /**
     * @return the personSum_Summary
     */
    public String getPersonSum_Summary() {
        return personSum_Summary;
    }

    
    /**
     * @param personSum_Summary the personSum_Summary to set
     */
    public void setPersonSum_Summary(String personSum_Summary) {
        this.personSum_Summary = personSum_Summary;
    }

    
    /**
     * @return the personSum_Summary_qqq
     */
    public String getPersonSum_Summary_qqq() {
        return personSum_Summary_qqq;
    }

    
    /**
     * @param personSum_Summary_qqq the personSum_Summary_qqq to set
     */
    public void setPersonSum_Summary_qqq(String personSum_Summary_qqq) {
        this.personSum_Summary_qqq = personSum_Summary_qqq;
    }

    
    /**
     * @return the personSum_Summary_qq
     */
    public String getPersonSum_Summary_qq() {
        return personSum_Summary_qq;
    }

    
    /**
     * @param personSum_Summary_qq the personSum_Summary_qq to set
     */
    public void setPersonSum_Summary_qq(String personSum_Summary_qq) {
        this.personSum_Summary_qq = personSum_Summary_qq;
    }

    
    /**
     * @return the personSum_Summary_dq
     */
    public String getPersonSum_Summary_dq() {
        return personSum_Summary_dq;
    }

    
    /**
     * @param personSum_Summary_dq the personSum_Summary_dq to set
     */
    public void setPersonSum_Summary_dq(String personSum_Summary_dq) {
        this.personSum_Summary_dq = personSum_Summary_dq;
    }

    
    /**
     * @return the pay_summary
     */
    public String getPay_summary() {
        return pay_summary;
    }

    
    /**
     * @param pay_summary the pay_summary to set
     */
    public void setPay_summary(String pay_summary) {
        this.pay_summary = pay_summary;
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
     * @return the id_qqq
     */
    public String getId_qqq() {
        return id_qqq;
    }

    
    /**
     * @param id_qqq the id_qqq to set
     */
    public void setId_qqq(String id_qqq) {
        this.id_qqq = id_qqq;
    }

    
    /**
     * @return the id_qq
     */
    public String getId_qq() {
        return id_qq;
    }

    
    /**
     * @param id_qq the id_qq to set
     */
    public void setId_qq(String id_qq) {
        this.id_qq = id_qq;
    }

    
    /**
     * @return the id_dq
     */
    public String getId_dq() {
        return id_dq;
    }

    
    /**
     * @param id_dq the id_dq to set
     */
    public void setId_dq(String id_dq) {
        this.id_dq = id_dq;
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
     * @return the payId
     */
    public String getPayId() {
        return payId;
    }

    
    /**
     * @param payId the payId to set
     */
    public void setPayId(String payId) {
        this.payId = payId;
    }

    
    /**
     * @return the pay_qqq_zhijie
     */
    public String getPay_qqq_zhijie() {
        return pay_qqq_zhijie;
    }

    
    /**
     * @param pay_qqq_zhijie the pay_qqq_zhijie to set
     */
    public void setPay_qqq_zhijie(String pay_qqq_zhijie) {
        this.pay_qqq_zhijie = pay_qqq_zhijie;
    }

    
    /**
     * @return the paid_qqq_zhijie
     */
    public String getPaid_qqq_zhijie() {
        return paid_qqq_zhijie;
    }

    
    /**
     * @param paid_qqq_zhijie the paid_qqq_zhijie to set
     */
    public void setPaid_qqq_zhijie(String paid_qqq_zhijie) {
        this.paid_qqq_zhijie = paid_qqq_zhijie;
    }

    
    /**
     * @return the unpaid_qqq_zhijie
     */
    public String getUnpaid_qqq_zhijie() {
        return unpaid_qqq_zhijie;
    }

    
    /**
     * @param unpaid_qqq_zhijie the unpaid_qqq_zhijie to set
     */
    public void setUnpaid_qqq_zhijie(String unpaid_qqq_zhijie) {
        this.unpaid_qqq_zhijie = unpaid_qqq_zhijie;
    }

    
    /**
     * @return the pay_qqq_jianjie
     */
    public String getPay_qqq_jianjie() {
        return pay_qqq_jianjie;
    }

    
    /**
     * @param pay_qqq_jianjie the pay_qqq_jianjie to set
     */
    public void setPay_qqq_jianjie(String pay_qqq_jianjie) {
        this.pay_qqq_jianjie = pay_qqq_jianjie;
    }

    
    /**
     * @return the paid_qqq_jianjie
     */
    public String getPaid_qqq_jianjie() {
        return paid_qqq_jianjie;
    }

    
    /**
     * @param paid_qqq_jianjie the paid_qqq_jianjie to set
     */
    public void setPaid_qqq_jianjie(String paid_qqq_jianjie) {
        this.paid_qqq_jianjie = paid_qqq_jianjie;
    }

    
    /**
     * @return the unpaid_qqq_jianjie
     */
    public String getUnpaid_qqq_jianjie() {
        return unpaid_qqq_jianjie;
    }

    
    /**
     * @param unpaid_qqq_jianjie the unpaid_qqq_jianjie to set
     */
    public void setUnpaid_qqq_jianjie(String unpaid_qqq_jianjie) {
        this.unpaid_qqq_jianjie = unpaid_qqq_jianjie;
    }

    
    /**
     * @return the pay_qq_zhijie
     */
    public String getPay_qq_zhijie() {
        return pay_qq_zhijie;
    }

    
    /**
     * @param pay_qq_zhijie the pay_qq_zhijie to set
     */
    public void setPay_qq_zhijie(String pay_qq_zhijie) {
        this.pay_qq_zhijie = pay_qq_zhijie;
    }

    
    /**
     * @return the paid_qq_zhijie
     */
    public String getPaid_qq_zhijie() {
        return paid_qq_zhijie;
    }

    
    /**
     * @param paid_qq_zhijie the paid_qq_zhijie to set
     */
    public void setPaid_qq_zhijie(String paid_qq_zhijie) {
        this.paid_qq_zhijie = paid_qq_zhijie;
    }

    
    /**
     * @return the unpaid_qq_zhijie
     */
    public String getUnpaid_qq_zhijie() {
        return unpaid_qq_zhijie;
    }

    
    /**
     * @param unpaid_qq_zhijie the unpaid_qq_zhijie to set
     */
    public void setUnpaid_qq_zhijie(String unpaid_qq_zhijie) {
        this.unpaid_qq_zhijie = unpaid_qq_zhijie;
    }

    
    /**
     * @return the pay_qq_jianjie
     */
    public String getPay_qq_jianjie() {
        return pay_qq_jianjie;
    }

    
    /**
     * @param pay_qq_jianjie the pay_qq_jianjie to set
     */
    public void setPay_qq_jianjie(String pay_qq_jianjie) {
        this.pay_qq_jianjie = pay_qq_jianjie;
    }

    
    /**
     * @return the paid_qq_jianjie
     */
    public String getPaid_qq_jianjie() {
        return paid_qq_jianjie;
    }

    
    /**
     * @param paid_qq_jianjie the paid_qq_jianjie to set
     */
    public void setPaid_qq_jianjie(String paid_qq_jianjie) {
        this.paid_qq_jianjie = paid_qq_jianjie;
    }

    
    /**
     * @return the unpaid_qq_jianjie
     */
    public String getUnpaid_qq_jianjie() {
        return unpaid_qq_jianjie;
    }

    
    /**
     * @param unpaid_qq_jianjie the unpaid_qq_jianjie to set
     */
    public void setUnpaid_qq_jianjie(String unpaid_qq_jianjie) {
        this.unpaid_qq_jianjie = unpaid_qq_jianjie;
    }

    
    /**
     * @return the pay_dq_zhijie
     */
    public String getPay_dq_zhijie() {
        return pay_dq_zhijie;
    }

    
    /**
     * @param pay_dq_zhijie the pay_dq_zhijie to set
     */
    public void setPay_dq_zhijie(String pay_dq_zhijie) {
        this.pay_dq_zhijie = pay_dq_zhijie;
    }

    
    /**
     * @return the paid_dq_zhijie
     */
    public String getPaid_dq_zhijie() {
        return paid_dq_zhijie;
    }

    
    /**
     * @param paid_dq_zhijie the paid_dq_zhijie to set
     */
    public void setPaid_dq_zhijie(String paid_dq_zhijie) {
        this.paid_dq_zhijie = paid_dq_zhijie;
    }

    
    /**
     * @return the unpaid_dq_zhijie
     */
    public String getUnpaid_dq_zhijie() {
        return unpaid_dq_zhijie;
    }

    
    /**
     * @param unpaid_dq_zhijie the unpaid_dq_zhijie to set
     */
    public void setUnpaid_dq_zhijie(String unpaid_dq_zhijie) {
        this.unpaid_dq_zhijie = unpaid_dq_zhijie;
    }

    
    /**
     * @return the pay_dq_jianjie
     */
    public String getPay_dq_jianjie() {
        return pay_dq_jianjie;
    }

    
    /**
     * @param pay_dq_jianjie the pay_dq_jianjie to set
     */
    public void setPay_dq_jianjie(String pay_dq_jianjie) {
        this.pay_dq_jianjie = pay_dq_jianjie;
    }

    
    /**
     * @return the paid_dq_jianjie
     */
    public String getPaid_dq_jianjie() {
        return paid_dq_jianjie;
    }

    
    /**
     * @param paid_dq_jianjie the paid_dq_jianjie to set
     */
    public void setPaid_dq_jianjie(String paid_dq_jianjie) {
        this.paid_dq_jianjie = paid_dq_jianjie;
    }

    
    /**
     * @return the unpaid_dq_jianjie
     */
    public String getUnpaid_dq_jianjie() {
        return unpaid_dq_jianjie;
    }

    
    /**
     * @param unpaid_dq_jianjie the unpaid_dq_jianjie to set
     */
    public void setUnpaid_dq_jianjie(String unpaid_dq_jianjie) {
        this.unpaid_dq_jianjie = unpaid_dq_jianjie;
    }
    
    
}
