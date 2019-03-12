/*
 * @(#)BookBean.java
 */
package com.yuanneng.book.advice.entity;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class AdviceBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id = null;
    private String adviceTitle = null;
    private String link = null;
    private String adviceType = null;
    private Date createTime = null;
    private String createUser = null;
    private Date updateTIme = null;
    private String updateUser = null;
    
    private String path=null;
    
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
     * @return the adviceTitle
     */
    public String getAdviceTitle() {
        return adviceTitle;
    }
    
    /**
     * @param adviceTitle the adviceTitle to set
     */
    public void setAdviceTitle(String adviceTitle) {
        this.adviceTitle = adviceTitle;
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
     * @return the adviceType
     */
    public String getAdviceType() {
        return adviceType;
    }
    
    /**
     * @param adviceType the adviceType to set
     */
    public void setAdviceType(String adviceType) {
        this.adviceType = adviceType;
    }
    
    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return  new SimpleDateFormat("yyyyMMdd").format(createTime);
    }
    
    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    /**
     * @return the createUser
     */
    public String getCreateUser() {
        return createUser;
    }
    
    /**
     * @param createUser the createUser to set
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    /**
     * @return the updateTIme
     */
    public Date getUpdateTIme() {
        return updateTIme;
    }
    
    /**
     * @param updateTIme the updateTIme to set
     */
    public void setUpdateTIme(Date updateTIme) {
        this.updateTIme = updateTIme;
    }
    
    /**
     * @return the updateUser
     */
    public String getUpdateUser() {
        return  new SimpleDateFormat("yyyyMMdd").format(updateUser);
    }
    
    /**
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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
