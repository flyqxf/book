/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.article.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

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
public class ArticlePageLinkAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 注入的Servic层
     */
    @Resource
    private ArticleService articleService=null;
    /**
     * 起点数据编号
     */
    private String indexProperty;
    
    private String tableListFlg=Constant.STRING_ONE;

    /**
     * 任务检索页面初期显示
     * <p>
     * 调用Servic取得需要从数据库获取的检索条件和任务检索结果
     * </p>
     * 
     * @return 处理结果 SUCCESS: 正常、ERROR: 异常
     * @exception 待定
     */
    @Override
    public String doMain() {

        HttpSession session = this.getSession();
        UserValueObject uvo = BusinessUtils.getUVO();
        String userId = uvo.getUser().getUserId();
        List<ArticleBean> articleBeans = articleService.selectArticle(userId);
       
        
        CommonPageLinksBean<ArticleBean> result = new CommonPageLinksBean<ArticleBean>();
        if (StringUtils.isEmpty(indexProperty)) {
            indexProperty = Constant.STRING_ZERO;
        }
        result.setResultList(articleBeans);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        result.setTotalProperty(String.valueOf(articleBeans.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        

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
