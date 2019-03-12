/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.index.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.manage.index.entity.IndexBean;
import com.yuanneng.book.manage.index.entity.IndexDetailBean;


public interface IIndexDao extends CommonDao {


    /**
     * 检索会员总数及总收入
     * @param condition
     * @return
     */
    IndexBean getUsers();
    /**
     * 销售人员数
     * @return
     */
    List<String> getSaleSum();
    /**
     * 已分配金额
     * @return
     */
    String getDistribution();
    /**
     * 未分配金额
     * @return
     */
    String getNotDistribution();
    
    List<IndexDetailBean> getUsrs();



}
