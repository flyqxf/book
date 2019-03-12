/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.register.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.manage.pay.entity.PayBean;
import com.yuanneng.book.sysmanage.entity.UserBean;

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
public interface IRegisterDao extends CommonDao {


    void insertUser(CommonBean commonBean);
    void insertUserTemp(CommonBean commonBean);
    void insertAchievement(CommonBean commonBean);
    /**
     * 根据优惠码取得userId
     * @param code
     * @return
     */
    String getUserId(@Param("code")String code);
    /**
     * 根据userId取得注册时使用的优惠码
     * @param userId
     * @return
     */
    String getRegisterCode(@Param("userId")String userId);
    
    int getUserCnt(@Param("userId")String userId);
    int getMobileCnt(@Param("mobile")String mobile);
    int getMailCnt(@Param("mail")String mail);

    List<PayBean> getPay_zhijie_cnt(@Param("userId")String userId);
    List<PayBean> getPay_jianjie_cnt(@Param("userId")String userId);
    void insertPay_zhijie(CommonBean commonBean);
    void insertPay_jianjie(CommonBean commonBean);
    
    void updatePay_zhijie(CommonBean commonBean);
    void updatePay_jianjie(CommonBean commonBean);
    
    int getMaxQishu_zhijie(@Param("userId")String userId);
    int getMaxQishu_jianjie(@Param("userId")String userId);
    
    void changeSaler(CommonBean commonBean);
    UserBean getUserInfo(@Param("userId")String userId);
    
    void updateUserSts(CommonBean commonBean);
    void updateTuijianRenshu(@Param("userLst")List<String> userLst);
    
    void deleteUserByOutTradeNo(CommonBean commonBean);
    UserBean selectUserByOutTradeNo(CommonBean commonBean);
    UserBean getTuijianUser(@Param("code")String code);
}
