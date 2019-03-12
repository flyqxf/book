/*
 * @(#)TemplateBean.java
 */
package com.yuanneng.book.common.entity;

import com.yuanneng.book.common.entity.CommonBean;

/**
 * TemplateBean.java
 * 
 * 功 能：模板信息entity
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.08.16         guot        新规做成
 * </pre>
 */
public class TemplateBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /** 模板ID */
    private String templateId = null;

    /** 模板名称 */
    private String templateName = null;

    /**
     * @return the templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId the templateId to set
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * @return the templateName
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * @param templateName the templateName to set
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

}
