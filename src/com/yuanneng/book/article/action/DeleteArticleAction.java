/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.article.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

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
public class DeleteArticleAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 注入的Servic层
     */
    @Resource
    private ArticleService articleService=null;
    
    private String id = null;
    /**
     * 返回值
     */
    private String resJson;
    
    /**
     * 
     */
    @Override
    public String doMain() {
        articleService.deleteArticle(id);
        
     // 设定JSON返回值
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "success");
        map.put("msg", "文章删除成功");
        // 设定字符串返回值
        resJson = JSONObject.fromObject(map).toString();
       
        return SUCCESS;

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


    
    /**
     * @return the resJson
     */
    public String getResJson() {
        return resJson;
    }


    
    /**
     * @param resJson the resJson to set
     */
    public void setResJson(String resJson) {
        this.resJson = resJson;
    }
   

}
