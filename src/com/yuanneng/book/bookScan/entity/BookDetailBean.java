/*
 * @(#)BookBean.java
 */
package com.yuanneng.book.bookScan.entity;
import com.yuanneng.book.common.entity.CommonBean;

/**
 * UserBean.java
 * 
 * 功 能： 用户信息bean
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.08.21         guot        新规做成
 * </pre>
 */
public class BookDetailBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id = null;
    //private String bookId = null;
    private String chapter = null;
    private String part = null;
    //private String content = null;
    private String link = null;
    private String youkeFlg = "0";
    
    private String path = "";
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
     * @return the youkeFlg
     */
    public String getYoukeFlg() {
        return youkeFlg;
    }

    
    /**
     * @param youkeFlg the youkeFlg to set
     */
    public void setYoukeFlg(String youkeFlg) {
        this.youkeFlg = youkeFlg;
    }

    
    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    
    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }
    
   
}
