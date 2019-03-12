/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.success.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.success.entity.SuccessManagerBean;


public interface ISuccessManagerDao extends CommonDao {

    List<SuccessManagerBean> getSuccessBean();
    
    void deleteSuccessBean();
    
    void insert(CommonBean bean);
}
