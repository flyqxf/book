/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.help.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.help.entity.HelpBean;

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
public interface IHelpDao extends CommonDao {


    /**
     * 答疑内容录入
     */
    void insertHelp(CommonBean bean);
    
    List<HelpBean> selectHelp(@Param("userId")String userId);
    
    void deleteHelp(@Param("id")String id);
    HelpBean selectHelpDetail(@Param("id")String id);
    void updateHelp (CommonBean bean);

}
