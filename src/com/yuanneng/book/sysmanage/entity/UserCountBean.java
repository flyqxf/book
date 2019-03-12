/*
 * @(#)UserCountBean.java
 */
package com.yuanneng.book.sysmanage.entity;

import com.yuanneng.book.common.entity.CommonBean;

/**
 * UserCountBean.java
 * 
 * 功 能： 用户的角色统计数据
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.05.23         meioqiong         新规做成
 * </pre>
 */
public class UserCountBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 页面参数：超级管理员
     */
    private int supperCount = 0;

    /**
     * 页面参数：审计管理员
     */
    private int auditCount = 0;

    /**
     * 页面参数：普通管理员
     */
    private int generalCount = 0;

    /**
     * 页面参数：其他管理员
     */
    private int otherCount = 0;

    /**
     * 超级管理员数取得
     * 
     * @return
     */
    public int getSupperCount() {
        return supperCount;
    }

    /**
     * 超级管理员数设置
     * 
     * @param supperCount 设置参数
     */
    public void setSupperCount(int supperCount) {
        this.supperCount = supperCount;
    }

    /**
     * 审计管理员数取得
     * 
     * @return 返回结果
     */
    public int getAuditCount() {
        return auditCount;
    }

    /**
     * 审计管理员数设置
     * 
     * @param auditCount 设置参数
     */
    public void setAuditCount(int auditCount) {
        this.auditCount = auditCount;
    }

    /**
     * 普通管理员数取得
     * 
     * @return 返回结果
     */
    public int getGeneralCount() {
        return generalCount;
    }

    /**
     * 普通管理员数设置
     * 
     * @param generalCount 设置参数
     */
    public void setGeneralCount(int generalCount) {
        this.generalCount = generalCount;
    }

    /**
     * 其他管理员数取得
     * 
     * @return 返回结果
     */
    public int getOtherCount() {
        return otherCount;
    }

    /**
     * 其他管理员数设置
     * 
     * @param otherCount 设置参数
     */
    public void setOtherCount(int otherCount) {
        this.otherCount = otherCount;
    }
}
