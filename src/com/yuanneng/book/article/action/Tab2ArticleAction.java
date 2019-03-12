/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.article.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.article.entity.ArticleBean;
import com.yuanneng.book.article.service.ArticleService;
import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;


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
public class Tab2ArticleAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
    private  List<ArticleBean> articleBeans = null;
    /**
     * 注入的Servic层
     */
    @Resource
    private ArticleService articleService=null;
    private String indexProperty;
    private String tableListFlg=Constant.STRING_ZERO;
    /**
     * 
     */
    @Override
    public String doMain() {
        
        UserValueObject uvo = BusinessUtils.getUVO();
        String userId = uvo.getUser().getUserId();
        articleBeans = articleService.selectArticle(userId);
        CommonPageLinksBean<ArticleBean> result = new CommonPageLinksBean<ArticleBean>();
        indexProperty = Constant.STRING_ZERO;
        result.setResultList(articleBeans);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        result.setTotalProperty(String.valueOf(articleBeans.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        //
        /** 将结果放入session中 */
        HttpSession session = this.getSession();
        session.setAttribute(Constant.HELP_LIST, result);
        return SUCCESS;

    }
    
    /**
     * @return the indexProperty
     */
    public String getIndexProperty() {
        return indexProperty;
    }
    
    /**
     * @param indexProperty the indexProperty to set
     */
    public void setIndexProperty(String indexProperty) {
        this.indexProperty = indexProperty;
    }
    
    /**
     * @return the tableListFlg
     */
    public String getTableListFlg() {
        return tableListFlg;
    }
    
    /**
     * @param tableListFlg the tableListFlg to set
     */
    public void setTableListFlg(String tableListFlg) {
        this.tableListFlg = tableListFlg;
    }
    
    

}
