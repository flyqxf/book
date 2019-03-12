/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.diary.entity.DiaryBean;

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
public interface IDiaryDao extends CommonDao {


    /**
     * 检索书籍目录
     * @return 返回结果
     */
    List<DiaryBean> getHaveDiaryDayList(CommonBean bean);
    
    int getHaveDiaryDayCnt(CommonBean bean);
    List<DiaryBean> getDiaryList(CommonBean bean);
    void insertDiary(CommonBean bean);
    void updateDiary (CommonBean bean);
    void deleteDiary (@Param("id")String id);

}
