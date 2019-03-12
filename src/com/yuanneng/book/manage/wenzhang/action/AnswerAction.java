/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.manage.wenzhang.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.mysql.jdbc.StringUtils;
import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.wenzhang.service.WenzhangService;


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
public class AnswerAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    
    private String id =null;
    private String leibie =null;
    private String answer =null;
   
    /**
     * 返回值
     */
    private String resJson;

    /**
     * 注入的Servic层
     */
    @Resource
    private WenzhangService wenzhangService=null;
    /**
     * 
     */
    @Override
    public String doMain() {
        
     // 设定JSON返回值
        Map<String, Object> map = new HashMap<String, Object>();
        
        if(StringUtils.isNullOrEmpty(answer)) {
            map.put("status", "false");
            map.put("msg", "请输入审批/回答内容");
        }else {
        
            wenzhangService.answer(id,leibie,answer);
        
            /** 将结果放入session中 */
            map.put("status", "success");
            map.put("msg", "审批/答疑成功");
        }
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
     * @return the leibie
     */
    public String getLeibie() {
        return leibie;
    }
    
    /**
     * @param leibie the leibie to set
     */
    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }
    
    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }
    
    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
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
