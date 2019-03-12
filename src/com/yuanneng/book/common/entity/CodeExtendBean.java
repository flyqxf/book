package com.yuanneng.book.common.entity;

/**
 * CodeExtendBean.java
 * 
 * 功 能： 页面项目管理Entity
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.31         肖健            新规做成
 * </pre>
 */
public class CodeExtendBean extends CodeBaseBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 管理ID
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
