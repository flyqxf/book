/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.jiaoxue.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.jiaoxue.entity.BookBean;


public interface IJiaoxueDao extends CommonDao {

    List<BookBean> getBookBean();
    
    void deleteBooks();
    
    void insert(CommonBean bean);
}
