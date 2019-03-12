/*
 * @(#)BookBean.java
 */
package com.yuanneng.book.article.entity;
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
public class ArticleBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id = null;
    private String title = null;
    private String province = null;
    private String province_val = null;
    private String city_val = null;
    private String city = null;
    private String content = null;
    private String status = null;
    private String delFlg = null;
    private Date createTime = null;
    private String createUser = null;
    private Date confirmTIme = null;
    private String confirmUser = null;
    
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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
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
        String time = "";
        if(createTime!=null) {
            time = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(createTime);
        }
        return  time;
        
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
        String time = "";
        if(confirmTIme!=null) {
            time = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(confirmTIme);
        }
        return  time;
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
     * @return the province_val
     */
    public String getProvince_val() {
        return province_val;
    }

    
    /**
     * @param province_val the province_val to set
     */
    public void setProvince_val(String province_val) {
        this.province_val = province_val;
    }

    
    /**
     * @return the city_val
     */
    public String getCity_val() {
        return city_val;
    }

    
    /**
     * @param city_val the city_val to set
     */
    public void setCity_val(String city_val) {
        this.city_val = city_val;
    }

    
  
}
