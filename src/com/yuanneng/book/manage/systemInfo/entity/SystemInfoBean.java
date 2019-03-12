/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.systemInfo.entity;

import com.yuanneng.book.common.entity.CommonBean;


public class SystemInfoBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id=null;
    private String name=null;
    private String value=null;
    private String key = null;
    private String keyword = null;
    
    
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
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
    
    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    
    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    
    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    
    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    
    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    
    
}
