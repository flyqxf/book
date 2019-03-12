package com.yuanneng.book.common.entity;

import java.io.Serializable;

public class AssetLoopholeTotal implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 严重漏洞个数
     */
    private String seriousCount = null;

    /**
     * 高危漏洞个数
     */
    private String highCount = null;

    /**
     * 中危漏洞个数
     */
    private String middleCount = null;

    /**
     * 资产总数
     */
    private String assetTotalCount = null;

    /**
     * 已经审核资产总数
     */
    private String auditAssetCount = null;

    /**
     * 未经审核资产总数
     */
    private String unAuditAssetCount = null;

    /**
     * @return 严重漏洞个数
     */
    public String getSeriousCount() {
        return seriousCount;
    }

    /**
     * @param seriousCount 严重漏洞个数
     */
    public void setSeriousCount(String seriousCount) {
        this.seriousCount = seriousCount;
    }

    /**
     * @return 高危漏洞个数
     */
    public String getHighCount() {
        return highCount;
    }

    /**
     * @param highCount 高危漏洞个数
     */
    public void setHighCount(String highCount) {
        this.highCount = highCount;
    }

    /**
     * @return 中危漏洞个数
     */
    public String getMiddleCount() {
        return middleCount;
    }

    /**
     * @param middleCount 中危漏洞个数
     */
    public void setMiddleCount(String middleCount) {
        this.middleCount = middleCount;
    }

    /**
     * @return 资产总数
     */
    public String getAssetTotalCount() {
        return assetTotalCount;
    }

    /**
     * @param assetTotalCount 资产总数
     */
    public void setAssetTotalCount(String assetTotalCount) {
        this.assetTotalCount = assetTotalCount;
    }

    /**
     * @return 已经审核资产总数
     */
    public String getAuditAssetCount() {
        return auditAssetCount;
    }

    /**
     * @param auditAssetCount 已经审核资产总数
     */
    public void setAuditAssetCount(String auditAssetCount) {
        this.auditAssetCount = auditAssetCount;
    }

    /**
     * @return 未经审核资产总数
     */
    public String getUnAuditAssetCount() {
        return unAuditAssetCount;
    }

    /**
     * @param unAuditAssetCount 未经审核资产总数
     */
    public void setUnAuditAssetCount(String unAuditAssetCount) {
        this.unAuditAssetCount = unAuditAssetCount;
    }

}
