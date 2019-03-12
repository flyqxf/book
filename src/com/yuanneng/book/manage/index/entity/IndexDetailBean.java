/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.index.entity;

import com.yuanneng.book.common.entity.CommonBean;


public class IndexDetailBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String registeTime=null;
    private String cnt=null;
    
    /**
     * @return the registeTime
     */
    public String getRegisteTime() {
        return registeTime;
    }
    
    /**
     * @param registeTime the registeTime to set
     */
    public void setRegisteTime(String registeTime) {
        this.registeTime = registeTime;
    }
    
    /**
     * @return the cnt
     */
    public String getCnt() {
        return cnt;
    }
    
    /**
     * @param cnt the cnt to set
     */
    public void setCnt(String cnt) {
        this.cnt = cnt;
    }
    
    
    
}
