package com.yuanneng.book.common.entity;

import java.util.Date;

import com.yuanneng.book.common.utils.Constant;

public class VulNewsSubKeywordBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private int number = Constant.NUM_0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * ID
     */
    private String id = null;

    /**
     * 名称
     */
    private String name = null;

    /**
     * 一级关键字
     */
    private String primaryKeyword = null;

    /**
     * 二级关键字
     */
    private String secondaryKeyword = null;

    /**
     * 域名
     */
    private String domain = null;

    /**
     * 创建时间
     */
    private Date createDate = null;

    /**
     * 更新时间
     */
    private Date updateDate = null;

    /**
     * 更新时间(字符串)
     */
    private String updateDateStr = null;

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
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 一级关键字
     */
    public String getPrimaryKeyword() {
        return primaryKeyword;
    }

    /**
     * @param primaryKeyword 一级关键字
     */
    public void setPrimaryKeyword(String primaryKeyword) {
        this.primaryKeyword = primaryKeyword;
    }

    /**
     * @return 二级关键字
     */
    public String getSecondaryKeyword() {
        return secondaryKeyword;
    }

    /**
     * @param secondaryKeyword 二级关键字
     */
    public void setSecondaryKeyword(String secondaryKeyword) {
        this.secondaryKeyword = secondaryKeyword;
    }

    /**
     * @return 域名
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain 域名
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * @return 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return 更新时间(字符串)
     */
    public String getUpdateDateStr() {
        return updateDateStr;
    }

    /**
     * @param updateDateStr 更新时间(字符串)
     */
    public void setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
    }

}
