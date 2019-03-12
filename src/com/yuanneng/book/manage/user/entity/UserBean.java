/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.user.entity;

import com.yuanneng.book.common.entity.CommonBean;


public class UserBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String userId=null;
    private String userName=null;
    private String mobile=null;
    private String province=null;
    private String city=null;
    private String province_val=null;
    private String city_val=null;
    private String id_zhifubao=null;
    private String id_weixin=null;
    private String bank=null;
    private String bank_card_number=null;
    private String receivables_flg = null;
    private String receivables_flg_name = null;
    private String register_time = null;
    private String user_flg = null;
    private String user_flg_name = null;
    private String status = null;
    private String status_name = null;
    private String register_time_from = null;
    private String register_time_to = null;
    private String zhanghao = null;
    private String tuijianRenshu = "0";
    private String mail = null;
    private String code = null;
    private String register_code = null;
    private String bank_card_name = null;
    
    private String userPassword = null;

    
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
     * @return the province
     */
    public String getProvince() {
        return province;
    }
    
    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }
    
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
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
     * @return the register_time_from
     */
    public String getRegister_time_from() {
        return register_time_from;
    }

    
    /**
     * @param register_time_from the register_time_from to set
     */
    public void setRegister_time_from(String register_time_from) {
        this.register_time_from = register_time_from;
    }

    
    /**
     * @return the register_time_to
     */
    public String getRegister_time_to() {
        return register_time_to;
    }

    
    /**
     * @param register_time_to the register_time_to to set
     */
    public void setRegister_time_to(String register_time_to) {
        this.register_time_to = register_time_to;
    }

    
    /**
     * @return the zhanghao
     */
    public String getZhanghao() {
        return zhanghao;
    }

    
    /**
     * @param zhanghao the zhanghao to set
     */
    public void setZhanghao(String zhanghao) {
        this.zhanghao = zhanghao;
    }

    
    /**
     * @return the user_flg_name
     */
    public String getUser_flg_name() {
        return user_flg_name;
    }

    
    /**
     * @param user_flg_name the user_flg_name to set
     */
    public void setUser_flg_name(String user_flg_name) {
        this.user_flg_name = user_flg_name;
    }

    
    /**
     * @return the receivables_flg_name
     */
    public String getReceivables_flg_name() {
        return receivables_flg_name;
    }

    
    /**
     * @param receivables_flg_name the receivables_flg_name to set
     */
    public void setReceivables_flg_name(String receivables_flg_name) {
        this.receivables_flg_name = receivables_flg_name;
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
     * @return the status_name
     */
    public String getStatus_name() {
        return status_name;
    }

    
    /**
     * @param status_name the status_name to set
     */
    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    
    /**
     * @return the province_val
     */
    public String getProvince_val() {
        return province_val;
    }

    
    /**
     * @param province_val the province_val to set
     */
    public void setProvince_val(String province_val) {
        this.province_val = province_val;
    }

    
    /**
     * @return the city_val
     */
    public String getCity_val() {
        return city_val;
    }

    
    /**
     * @param city_val the city_val to set
     */
    public void setCity_val(String city_val) {
        this.city_val = city_val;
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
