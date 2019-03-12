/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.sysmanage.entity;

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
public class UserBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    private String no=null;
    private String userId=null;
    private String userName=null;
    private String userPassword=null;
    private String mail=null;
    private String mobile=null;
    private String code=null;
    private String register_code=null;
    private String id_zhifubao=null;
    private String id_weixin=null;
    private String bank=null;
    private String bank_card_number=null;
    private String bank_card_name=null;
    private String money=null;
    private String receivables_flg = null;
    private String user_flg=null;
    private String status=null;
    private String tuijianRenshu=null;
    private String del_flg="0";
    private String orderId=null;
    private Date register_time=null;
    private Date updateTime=null;
    /** 更新用户状态的结果 (0:正常,1:更新DB变成锁定状态,2:更新DB变成锁定状态未成功) */
    private String flag = null;
    
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
     * @return the code
     */
    public String getCode() {
        return code;
    }
    
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * @return the register_code
     */
    public String getRegister_code() {
        return register_code;
    }
    
    /**
     * @param register_code the register_code to set
     */
    public void setRegister_code(String register_code) {
        this.register_code = register_code;
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
     * @return the money
     */
    public String getMoney() {
        return money;
    }
    
    /**
     * @param money the money to set
     */
    public void setMoney(String money) {
        this.money = money;
    }

    
    /**
     * @return the receivables_flg
     */
    public String getReceivables_flg() {
        return receivables_flg;
    }

    
    /**
     * @param receivables_flg the receivables_flg to set
     */
    public void setReceivables_flg(String receivables_flg) {
        this.receivables_flg = receivables_flg;
    }

    /**
     * @return the user_flg
     */
    public String getUser_flg() {
        return user_flg;
    }
    
    /**
     * @param user_flg the user_flg to set
     */
    public void setUser_flg(String user_flg) {
        this.user_flg = user_flg;
    }
    
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * @return the del_flg
     */
    public String getDel_flg() {
        return del_flg;
    }
    
    /**
     * @param del_flg the del_flg to set
     */
    public void setDel_flg(String del_flg) {
        this.del_flg = del_flg;
    }
    
    /**
     * @return the register_time
     */
    public Date getRegister_time() {
        return register_time;
    }
    
    /**
     * @param register_time the register_time to set
     */
    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
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

    
    /**
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    
    /**
     * @param flag the flag to set
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    
    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    
    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    
    /**
     * @return the no
     */
    public String getNo() {
        return no;
    }

    
    /**
     * @param no the no to set
     */
    public void setNo(String no) {
        this.no = no;
    }

    
    /**
     * @return the tuijianRenshu
     */
    public String getTuijianRenshu() {
        return tuijianRenshu;
    }

    
    /**
     * @param tuijianRenshu the tuijianRenshu to set
     */
    public void setTuijianRenshu(String tuijianRenshu) {
        this.tuijianRenshu = tuijianRenshu;
    }
    
    


}
