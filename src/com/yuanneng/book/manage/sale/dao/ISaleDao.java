/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.sale.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.sale.entity.SaleBean;


public interface ISaleDao extends CommonDao {

    List<SaleBean> getSaleBean(CommonBean bean);
}
