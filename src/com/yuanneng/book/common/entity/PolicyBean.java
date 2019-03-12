/*
 * @(#)PolicyBean.java
 */
package com.yuanneng.book.common.entity;

import com.yuanneng.book.common.entity.CommonBean;

/**
 * PolicyBean.java
 * 
 * 功 能： 策略信息entity
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.08.16           秦霄飞          新规做成
 * </pre>
 */
public class PolicyBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /** 策略ID */
    private String policyId = null;

    /** 策略名称 */
    private String policyName = null;

    /**
     * @return the policyId
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     * @param policyId the policyId to set
     */
    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    /**
     * @return the policyName
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * @param policyName the policyName to set
     */
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

}
