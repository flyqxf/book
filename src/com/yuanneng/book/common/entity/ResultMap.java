/*
 * @(#)ResultMap.java
 */
package com.yuanneng.book.common.entity;

import java.util.Date;

/**
 * ResultMap.java
 * 
 * 功 能： 承载Sql语句返回的结果
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.05.05         shanjixiang        新规做成
 * </pre>
 */
public class ResultMap extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 返回的Key
     */
    private String resKey;

    /**
     * 返回的值Value
     */
    private String resValue;

    /**
     * 时间
     */
    private Date timeDate;

    /**
     * 时间字符串类型
     */
    private String timeDateStr;

    public String getTimeDateStr() {
        return timeDateStr;
    }

    public void setTimeDateStr(String timeDateStr) {
        this.timeDateStr = timeDateStr;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public String getResValue() {
        return resValue;
    }

    public void setResValue(String resValue) {
        this.resValue = resValue;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

}
