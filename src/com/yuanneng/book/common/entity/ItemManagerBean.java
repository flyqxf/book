/*
 * @(#)ItemManagerBean.java
 */
package com.yuanneng.book.common.entity;

import com.yuanneng.book.common.entity.CommonBean;

/**
 * ItemManagerBean.java
 * 
 * 功 能： 页面项目管理
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.04.01         zhangrb        新规做成
 * </pre>
 */
public class ItemManagerBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /** 管理ID */
    private String managerId = null;

    /** 项目区分 */
    private String differentiate = null;

    /** 项目名称 */
    private String name = null;

    /** 选择的权限值：-1--> 没有任何权限；0-->编辑权限（包括查看）；1-->查看权限 */
    private String selPow = "-1";

    /**
     * 管理ID取得
     * 
     * @return 管理ID
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * 管理ID设置
     * 
     * @return 管理ID
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    /**
     * 项目区分取得
     * 
     * @return 项目区分
     */
    public String getDifferentiate() {
        return differentiate;
    }

    /**
     * 项目区分设置
     * 
     * @return 项目区分
     */
    public void setDifferentiate(String differentiate) {
        this.differentiate = differentiate;
    }

    /**
     * 项目名称取得
     * 
     * @return 项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 项目名称设置
     * 
     * @return 项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getSelPow() {
        return selPow;
    }

    public void setSelPow(String selPow) {
        this.selPow = selPow;
    }

}
