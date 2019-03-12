/*
 * @(#)CommonPageLinksBean.java
 */
package com.yuanneng.book.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * CommonPageLinksBean.java
 * 
 * 功 能： 共同的CommonPageLinks用的bean
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.09         meiqiong        新规做成
 * </pre>
 */
public class CommonPageLinksBean<T> implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 起点数据编号
     */
    private String indexProperty;

    /**
     * 终点数据编号
     */
    private String endProperty;

    /**
     * 数据序号
     */
    private int numProperty;

    /**
     * 每页显示数据长度
     */
    private String rowProperty;

    /**
     * 总数据量
     */
    private String totalProperty;

    /**
     * 结果一览
     */
    private List<T> resultList;

    /**
     * @return the indexProperty
     */
    public String getIndexProperty() {
        return indexProperty;
    }

    /**
     * @param indexProperty the indexProperty to set
     */
    public void setIndexProperty(String indexProperty) {
        this.indexProperty = indexProperty;
    }

    /**
     * @return the endProperty
     */
    public String getEndProperty() {
        return endProperty;
    }

    /**
     * @param endProperty the endProperty to set
     */
    public void setEndProperty(String endProperty) {
        this.endProperty = endProperty;
    }

    /**
     * @return the rowProperty
     */
    public String getRowProperty() {
        return rowProperty;
    }

    /**
     * @param rowProperty the rowProperty to set
     */
    public void setRowProperty(String rowProperty) {
        this.rowProperty = rowProperty;
    }

    /**
     * @return the totalProperty
     */
    public String getTotalProperty() {
        return totalProperty;
    }

    /**
     * @param totalProperty the totalProperty to set
     */
    public void setTotalProperty(String totalProperty) {
        this.totalProperty = totalProperty;
    }

    /**
     * @return the resultList
     */
    public List<T> getResultList() {
        return resultList;
    }

    /**
     * @param resultList the resultList to set
     */
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public int getNumProperty() {
        return numProperty;
    }

    public void setNumProperty(int numProperty) {
        this.numProperty = numProperty;
    }

}
