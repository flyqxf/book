/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.wenzhang.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.wenzhang.entity.WenzhangBean;


public interface IWenzhangDao extends CommonDao {

    List<WenzhangBean> getWenzhang(CommonBean bean);
    void updateHelp(CommonBean bean);
    void updateArticle(CommonBean bean);

}
