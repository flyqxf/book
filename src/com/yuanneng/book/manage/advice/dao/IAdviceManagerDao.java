/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.advice.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.advice.entity.AdviceManagerBean;


public interface IAdviceManagerDao extends CommonDao {

    List<AdviceManagerBean> getAdviceBean();
    
    void deleteAdviceBean();
    
    void insert(CommonBean bean);
}
