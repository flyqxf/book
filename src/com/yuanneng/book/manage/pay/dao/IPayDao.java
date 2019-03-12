/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.pay.entity.PayBean;
import com.yuanneng.book.manage.pay.entity.PayBean1;


public interface IPayDao extends CommonDao {

    List<PayBean1> getPayBean(CommonBean bean);
    
    PayBean getPayBean_zhijie(@Param("userId")String userId,@Param("date")String date);
    
    PayBean getPayBean_jianjie(@Param("userId")String userId,@Param("date")String date);
    
    List<PayBean> getPayBean_zhijie_lst(@Param("userId")String userId,@Param("userName")String userName,@Param("date")String date);
    
    List<PayBean> getPayBean_jianjie_lst(@Param("userId")String userId,@Param("userName")String userName,@Param("date")String date);
}
