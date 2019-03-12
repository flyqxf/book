package com.yuanneng.book.common.entity;

/**
 * CodeBaseBean.java
 * 
 * 功 能： 页面项目管理基础Entity
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.31         肖健            新规做成
 * </pre>
 */
public class CodeBaseBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 项目区分
     */
    private String key;

    /**
     * 项目名称
     */
    private String name;

    public CodeBaseBean() {
    }

    public CodeBaseBean(String key, String name) {
        super();
        this.key = key;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
