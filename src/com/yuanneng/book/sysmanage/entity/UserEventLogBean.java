/*
 * @(#)UserEventLogBean.java
 */
package com.yuanneng.book.sysmanage.entity;

import java.util.Date;

import com.yuanneng.book.common.entity.CommonBean;

/**
 * UserBean.java
 * 
 * 功 能： 用户事件日志数据保存
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.04.01         shanjixiang        新规做成
 * </pre>
 */
public class UserEventLogBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /** 日志ID */
    private String logId = null;

    /** 用户ID */
    private String userId = null;

    /** 用户名 */
    private String userName = null;

    /** 登陆者IP地址 */
    private String loginIP = null;

    /** 登录来源 */
    private String loginSource = null;

    /** 点击次数 */
    private Integer count = null;

    /** 事件 */
    private String fashion = null;

    /** 事件描述 */
    private String description = null;

    /** 登录时间 */
    private Date start_Date = null;

    /** 退出时间 */
    private Date end_Date = null;

    /**
     * 日志ID取得
     * 
     * @return 日志ID
     */
    public String getLogId() {
        return logId;
    }

    /**
     * 日志ID设置
     * 
     * @param logId 日志ID
     */
    public void setLogId(String logId) {
        this.logId = logId;
    }

    /**
     * 用户ID取得
     * 
     * @return 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID设置
     * 
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 用户名取得
     * 
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名设置
     * 
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 登录者IP地址取得
     * 
     * @return 登录者IP地址
     */
    public String getLoginIP() {
        return loginIP;
    }

    /**
     * 登录者IP地址设置
     * 
     * @param loginIP 登录者IP地址
     */
    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    /**
     * 登录来源取得
     * 
     * @return 登录来源
     */
    public String getLoginSource() {
        return loginSource;
    }

    /**
     * 登录来源设置
     * 
     * @param loginSource 登录来源
     */
    public void setLoginSource(String loginSource) {
        this.loginSource = loginSource;
    }

    /**
     * 点击次数取得
     * 
     * @return 点击次数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 点击次数设置
     * 
     * @param count 点击次数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 事件取得
     * 
     * @return 事件
     */
    public String getFashion() {
        return fashion;
    }

    /**
     * 事件设置
     * 
     * @param fashion 事件
     */
    public void setFashion(String fashion) {
        this.fashion = fashion;
    }

    /**
     * 事件描述取得
     * 
     * @return 事件描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 事件描述设置
     * 
     * @param description 事件描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 登录时间取得
     * 
     * @return 登录时间
     */
    public Date getStart_Date() {
        return start_Date;
    }

    /**
     * 登录时间设置
     * 
     * @param start_Date 登录时间
     */
    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    /**
     * 退出时间取得
     * 
     * @return 退出时间
     */
    public Date getEnd_Date() {
        return end_Date;
    }

    /**
     * 退出时间设置
     * 
     * @param end_Date 退出时间
     */
    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    /**
     * 序列化取得
     * 
     * @return 序列化
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
