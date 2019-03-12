/*
 * @(#)BookBean.java
 */
package com.yuanneng.book.diary.entity;
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
public class DiaryBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String id = null;
    private String userId = null;
    private String title = null;
    private String diary = null;
    private String diaryTime = null;
    private String createTime = null;
    private String updateTIme = null;
    private String conditionDiaryTimeFrom = null;
    private String conditionDiaryTimeTo = null;
    
    
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
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * @return the diary
     */
    public String getDiary() {
        return diary;
    }
    
    /**
     * @param diary the diary to set
     */
    public void setDiary(String diary) {
        this.diary = diary;
    }
    
    /**
     * @return the diaryTime
     */
    public String getDiaryTime() {
        return diaryTime;
    }
    
    /**
     * @param diaryTime the diaryTime to set
     */
    public void setDiaryTime(String diaryTime) {
        this.diaryTime = diaryTime;
    }
    
    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return createTime;
    }
    
    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    /**
     * @return the updateTIme
     */
    public String getUpdateTIme() {
        return updateTIme;
    }
    
    /**
     * @param updateTIme the updateTIme to set
     */
    public void setUpdateTIme(String updateTIme) {
        this.updateTIme = updateTIme;
    }

    
    /**
     * @return the conditionDiaryTimeFrom
     */
    public String getConditionDiaryTimeFrom() {
        return conditionDiaryTimeFrom;
    }

    
    /**
     * @param conditionDiaryTimeFrom the conditionDiaryTimeFrom to set
     */
    public void setConditionDiaryTimeFrom(String conditionDiaryTimeFrom) {
        this.conditionDiaryTimeFrom = conditionDiaryTimeFrom;
    }

    
    /**
     * @return the conditionDiaryTimeTo
     */
    public String getConditionDiaryTimeTo() {
        return conditionDiaryTimeTo;
    }

    
    /**
     * @param conditionDiaryTimeTo the conditionDiaryTimeTo to set
     */
    public void setConditionDiaryTimeTo(String conditionDiaryTimeTo) {
        this.conditionDiaryTimeTo = conditionDiaryTimeTo;
    }
    
    
  
}
