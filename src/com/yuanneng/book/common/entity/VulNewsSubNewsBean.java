package com.yuanneng.book.common.entity;

import java.util.Date;

import com.yuanneng.book.common.utils.Constant;

public class VulNewsSubNewsBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private int number = Constant.NUM_0;

    /**
     * ID
     */
    private String id = null;

    /**
     * 标题
     */
    private String vulTitle = null;

    /**
     * 来源
     */
    private String vulSubSource = null;

    /**
     * URL
     */
    private String vulSubUrl = null;

    /**
     * 时间
     */
    private Date time = null;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return 标题
     */
    public String getVulTitle() {
        return vulTitle;
    }

    /**
     * @param vulTitle 标题
     */
    public void setVulTitle(String vulTitle) {
        this.vulTitle = vulTitle;
    }

    /**
     * @return 来源
     */
    public String getVulSubSource() {
        return vulSubSource;
    }

    /**
     * @param vulSubSource 来源
     */
    public void setVulSubSource(String vulSubSource) {
        this.vulSubSource = vulSubSource;
    }

    /**
     * @return URL
     */
    public String getVulSubUrl() {
        return vulSubUrl;
    }

    /**
     * @param vulSubUrl URL
     */
    public void setVulSubUrl(String vulSubUrl) {
        this.vulSubUrl = vulSubUrl;
    }

    /**
     * @return 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
