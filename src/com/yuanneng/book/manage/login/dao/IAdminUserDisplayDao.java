/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.login.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.login.entity.AdminUserBean;

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
public interface IAdminUserDisplayDao extends CommonDao {


    /**
     * 条件检索用户信息
     * <p>
     * 编辑service输入值，调用sql语句,处理sql的返回结果
     * </p>
     * 
     * @param condition 检索条件
     * 
     * @return 返回结果
     */
    List<AdminUserBean> getUserBeans(CommonBean condition);

    int updatePwd(CommonBean condition);


}
