/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.manage.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.user.entity.UserBean;
import com.yuanneng.book.manage.user.entity.UserXiaoshouBean;


public interface IUserDao extends CommonDao {


    /**
     * 会员列表
     * @return
     */
    List<UserBean> getUsers(CommonBean bean);
    List<UserXiaoshouBean> getTuijianUsers(CommonBean bean);
   
    
    
    void lockUser(CommonBean bean);
    
    void resetPwd(CommonBean bean);
    
    void updatePay_zhijie(CommonBean bean);
    void updatePay_jianjie(CommonBean bean);
    void insertPayHistory(CommonBean bean);
    void updateAchStatus(@Param("userId")String userId,@Param("flg")String flg,@Param("date")String date);
    
    void updateUser_flg(@Param("userId")String userId,@Param("user_flg")String user_flg);
    void addAdminUser(@Param("userId")String userId,@Param("userPassword")String userPassword);
    UserBean getUser(@Param("userId")String userId);
    void delAdminUser(@Param("userId")String userId);
    int getAdminUserCnt(@Param("userId")String userId);
}
