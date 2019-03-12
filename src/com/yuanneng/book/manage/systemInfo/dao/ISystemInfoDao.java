/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.systemInfo.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.systemInfo.entity.SystemInfoBean;

/**
 * IUserDisplayDao.java
 * 
 * 功 能： 用户一览Service的Dao
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.5         shanjixiang        新规做成
 * </pre>
 */
public interface ISystemInfoDao extends CommonDao {



    List<SystemInfoBean> getSystemInfo(CommonBean condition);




}
