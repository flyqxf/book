/*
 * @(#)BookBean.java
 */
package com.yuanneng.book.prerson.entity;
import java.util.Date;

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
public class HistoryBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id = null;
    private String userId=null;
    private String userName=null;
    private String userPassword=null;
    private String mail=null;
    private String mobile=null;
    private String id_zhifubao=null;
    private String id_weixin=null;
    private String bank=null;
    private String bank_card_number=null;
    private String bank_card_name=null;
    private Date updateTime = null;
    
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
    
    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }
    
    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }
    
    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    /**
     * @return the id_zhifubao
     */
    public String getId_zhifubao() {
        return id_zhifubao;
    }
    
    /**
     * @param id_zhifubao the id_zhifubao to set
     */
    public void setId_zhifubao(String id_zhifubao) {
        this.id_zhifubao = id_zhifubao;
    }
    
    /**
     * @return the id_weixin
     */
    public String getId_weixin() {
        return id_weixin;
    }
    
    /**
     * @param id_weixin the id_weixin to set
     */
    public void setId_weixin(String id_weixin) {
        this.id_weixin = id_weixin;
    }
    
    /**
     * @return the bank
     */
    public String getBank() {
        return bank;
    }
    
    /**
     * @param bank the bank to set
     */
    public void setBank(String bank) {
        this.bank = bank;
    }
    
    /**
     * @return the bank_card_number
     */
    public String getBank_card_number() {
        return bank_card_number;
    }
    
    /**
     * @param bank_card_number the bank_card_number to set
     */
    public void setBank_card_number(String bank_card_number) {
        this.bank_card_number = bank_card_number;
    }
    
    /**
     * @return the bank_card_name
     */
    public String getBank_card_name() {
        return bank_card_name;
    }
    
    /**
     * @param bank_card_name the bank_card_name to set
     */
    public void setBank_card_name(String bank_card_name) {
        this.bank_card_name = bank_card_name;
    }
    
    /**
     * @return the updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    
    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    
    

}
