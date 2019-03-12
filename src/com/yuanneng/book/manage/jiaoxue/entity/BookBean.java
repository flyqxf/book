/*
 * @(#)UserBean.java
 */
package com.yuanneng.book.manage.jiaoxue.entity;

import com.yuanneng.book.common.entity.CommonBean;


public class BookBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id = null;
    private String chapter = null;
    private String part = null;
    private String link = null;
    private String chk = "0";
    private String sort = null;
    
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
     * @return the chapter
     */
    public String getChapter() {
        return chapter;
    }
    
    /**
     * @param chapter the chapter to set
     */
    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
    
    /**
     * @return the part
     */
    public String getPart() {
        return part;
    }
    
    /**
     * @param part the part to set
     */
    public void setPart(String part) {
        this.part = part;
    }
    
    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }
    
    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    
    /**
     * @return the chk
     */
    public String getChk() {
        return chk;
    }

    
    /**
     * @param chk the chk to set
     */
    public void setChk(String chk) {
        this.chk = chk;
    }

    
    /**
     * @return the sort
     */
    public String getSort() {
        return sort;
    }

    
    /**
     * @param sort the sort to set
     */
    public void setSort(String sort) {
        this.sort = sort;
    }
    
}
