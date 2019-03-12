package com.yuanneng.book.common.entity;

import java.util.Date;

/**
 * OrganizationBean.java
 * 
 * 功 能： 组织机构Entity
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.31         肖健            新规做成
 * </pre>
 */
public class OrganizationBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 组织机构ID
     */
    private String orgId;

    /**
     * 组织机构名称
     */
    private String orgName;

    /**
     * 管辖IP段范围
     */
    private String target;

    /**
     * ip起点
     */
    private String ipFrom = null;

    /**
     * ip结束
     */
    private String ipTo = null;

    /** 创建者 */
    private String createUser = null;

    /** 创建时间 */
    private Date creat_Date = null;

    /** 更新者 */
    private String updata_User = null;

    /** 更新时间 */
    private Date updata_Date = null;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreat_Date() {
        return creat_Date;
    }

    public void setCreat_Date(Date creat_Date) {
        this.creat_Date = creat_Date;
    }

    public String getUpdata_User() {
        return updata_User;
    }

    public void setUpdata_User(String updata_User) {
        this.updata_User = updata_User;
    }

    public Date getUpdata_Date() {
        return updata_Date;
    }

    public void setUpdata_Date(Date updata_Date) {
        this.updata_Date = updata_Date;
    }

    public String getIpFrom() {
        return ipFrom;
    }

    public void setIpFrom(String ipFrom) {
        this.ipFrom = ipFrom;
    }

    public String getIpTo() {
        return ipTo;
    }

    public void setIpTo(String ipTo) {
        this.ipTo = ipTo;
    }

}
