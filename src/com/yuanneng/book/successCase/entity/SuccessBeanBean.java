/*
 * @(#)BookBean.java
 */
package com.yuanneng.book.successCase.entity;
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
public class SuccessBeanBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id = null;
    private String title = null;
    private String link = null;
    private String province = null;
    private String city = null;
    private String status = null;
    private String delFlg = null;
    private Date createTime = null;
    private String createUser = null;
    private Date confirmTIme = null;
    private String confirmUser = null;
    
    private String path = null;
    
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return the province
     */
    public String getProvince() {
        return province;
    }
    
    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }
    
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * @return the delFlg
     */
    public String getDelFlg() {
        return delFlg;
    }
    
    /**
     * @param delFlg the delFlg to set
     */
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
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
     * @return the confirmTIme
     */
    public String getConfirmTIme() {
        return  new SimpleDateFormat("yyyyMMdd").format(confirmTIme);
    }
    
    /**
     * @param confirmTIme the confirmTIme to set
     */
    public void setConfirmTIme(Date confirmTIme) {
        this.confirmTIme = confirmTIme;
    }
    
    /**
     * @return the confirmUser
     */
    public String getConfirmUser() {
        return confirmUser;
    }
    
    /**
     * @param confirmUser the confirmUser to set
     */
    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser;
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
