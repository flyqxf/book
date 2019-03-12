/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.article.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanneng.book.article.entity.ArticleBean;
import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;

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
public interface IArticleDao extends CommonDao {


    /**
     * 答疑内容录入
     */
    void insertArticle(CommonBean bean);
    
    List<ArticleBean> selectArticle(@Param("userId")String userId);
    
    void deleteArticle(@Param("id")String id);
    ArticleBean selectArticleDetail(@Param("id")String id);
    void updateArticle (CommonBean bean);
}
