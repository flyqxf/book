/*
 * @(#)CommonBean.java
 */
package com.yuanneng.book.common.entity;

import java.io.Serializable;

import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;

/**
 * CommonBean.java
 * 
 * 功 能： 所有entity类的共同父类
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.29         meiqiong        新规做成
 * </pre>
 */
public class CommonBean implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据库名称
     */
    protected String schema;

    public CommonBean() {
        setSchema(PropertyUtil.getProperty(Constant.SCHEMA));
    }

    /**
     * @return 数据库名称
     */
    public String getSchema() {
        return schema;
    }

    /**
     * @param schema 数据库名称
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }
}
