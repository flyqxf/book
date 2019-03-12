/*
 * @(#)UserLoginServer.java
 */
package com.yuanneng.book.article.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.article.dao.IArticleDao;
import com.yuanneng.book.article.entity.ArticleBean;
import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;


/**
 * UserLoginServer.java
 * 
 * 功 能： UserLoginAction的service
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.13         shanjixiang        新规做成
 * </pre>
 */
public class ArticleService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(ArticleService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IArticleDao iArticleDao;

    /**
     * 
     */
    public void addArticle(ArticleBean articleBean) {
        
        String id = BusinessUtils.getUUID();
        String createUser = BusinessUtils.getUVO().getUser().getUserId();
        
        articleBean.setId(id);
        articleBean.setCreateUser(createUser);
        
        iArticleDao.insertArticle(articleBean);
    }
    
    public void editArticle(ArticleBean articleBean) {
        
        
        iArticleDao.updateArticle(articleBean);
    }
    
    public List<ArticleBean> selectArticle(String userId) {
        List<ArticleBean> articleBeans =  iArticleDao.selectArticle(userId);
        for(ArticleBean articleBean:articleBeans) {
            String status = articleBean.getStatus();
            if(Constant.STRING_ONE.equals(status)) {
                status = "已审核";
            } else {
                status = "未审核";
            }
            articleBean.setStatus(status);
        }
        return articleBeans;
    }
    
    public void deleteArticle(String id) {
        iArticleDao.deleteArticle(id);
    }
    
    public ArticleBean selectArticleDetail(String id) {
        return iArticleDao.selectArticleDetail(id);
    }

}
