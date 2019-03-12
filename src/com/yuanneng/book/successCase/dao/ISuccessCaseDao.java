/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.successCase.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.successCase.entity.SuccessBeanBean;

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
public interface ISuccessCaseDao extends CommonDao {


    /**
     * 检索书籍目录
     * @return 返回结果
     */
    List<SuccessBeanBean> getSuccessCase();


}
