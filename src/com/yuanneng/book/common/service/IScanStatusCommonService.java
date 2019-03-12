/*
 * @(#)IScanStatusCommonService.java
 */
package com.yuanneng.book.common.service;

/**
 * IScanStatusCommonService.java
 * 
 * 功 能： 扫描状态监视service的共同接口
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.29         meiqiong        新规做成
 * </pre>
 */
public interface IScanStatusCommonService<T> extends CommonService {

    public void excute();

    public T getT();

    public void setT(T t);
}
