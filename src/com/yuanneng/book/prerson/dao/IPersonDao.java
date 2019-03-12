/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.prerson.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.prerson.entity.AchievementBean;
import com.yuanneng.book.prerson.entity.AchievementSummaryListBean;
import com.yuanneng.book.prerson.entity.CountBean;
import com.yuanneng.book.prerson.entity.PersonBean;

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
public interface IPersonDao extends CommonDao {


    PersonBean getPersion(@Param("userId")String userId);
    void updatePersion(CommonBean commonBean);
    List<AchievementBean> getAchievement(@Param("userId")String userId);
    List<AchievementBean> getAchievements(CommonBean commonBean);
    int getCount(@Param("userId")String userId,@Param("year")String year,@Param("flg")String flg);
    List<AchievementSummaryListBean> getAchievementSummary(@Param("userId")String userId);
    void insertHistory(CommonBean commonBean);
    int updateUserPwd(CommonBean commonBean);
    
}
