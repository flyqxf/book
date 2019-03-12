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
public class AchievementBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id = null;
    private String userId = null;
    private String registerUserId = null;
    private String registerUserIdJianjie = null;
    private String pay_status = null;
    private String pay_status_name = null;
    private String pay = null;
    private String flg = null;
    private String flg_name = null;
    private String userName = null;
    private String province = null;
    private String city = null;
    private String register_time = null;
    private String startDate = null;
    private String endDate = null;
    private String qishu = null;
    
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
     * @return the registerUserId
     */
    public String getRegisterUserId() {
        return registerUserId;
    }
    
    /**
     * @param registerUserId the registerUserId to set
     */
    public void setRegisterUserId(String registerUserId) {
        this.registerUserId = registerUserId;
    }
    
    
    
    /**
     * @return the registerUserIdJianjie
     */
    public String getRegisterUserIdJianjie() {
        return registerUserIdJianjie;
    }

    
    /**
     * @param registerUserIdJianjie the registerUserIdJianjie to set
     */
    public void setRegisterUserIdJianjie(String registerUserIdJianjie) {
        this.registerUserIdJianjie = registerUserIdJianjie;
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
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    
    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
     * @return the flg_name
     */
    public String getFlg_name() {
        return flg_name;
    }

    
    /**
     * @param flg_name the flg_name to set
     */
    public void setFlg_name(String flg_name) {
        this.flg_name = flg_name;
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

   
    
}
