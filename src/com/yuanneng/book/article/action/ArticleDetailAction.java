/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.article.action;

import javax.annotation.Resource;

import com.yuanneng.book.article.entity.ArticleBean;
import com.yuanneng.book.article.service.ArticleService;
import com.yuanneng.book.common.action.CommonAction;


/**
 * InitTaskAction.java
 * 
 * 功 能： 安全检测任务检索初期页面显示Action
 * 
 * <pre>
 * ver       修订日             作者          修订内容
 * ---------------------------------------------------
 * 1.0     2016.03.30         qinxiaofei      初期做成
 * </pre>
 */
public class ArticleDetailAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
    private  ArticleBean articleBean = null;
    /**
     * 注入的Servic层
     */
    @Resource
    private ArticleService articleService=null;
    private String id;
    /**
     * 
     */
    @Override
    public String doMain() {
        articleBean = articleService.selectArticleDetail(id);
        
        return SUCCESS;

    }
    
    /**
     * @return the articleBean
     */
    public ArticleBean getArticleBean() {
        return articleBean;
    }
    
    /**
     * @param articleBean the articleBean to set
     */
    public void setArticleBean(ArticleBean articleBean) {
        this.articleBean = articleBean;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    
    
    

}
