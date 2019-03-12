/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.help.action;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.help.entity.HelpBean;
import com.yuanneng.book.help.service.HelpService;


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
public class HelpDetailAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
    private  HelpBean helpBean = null;
    /**
     * 注入的Servic层
     */
    @Resource
    private HelpService helpService=null;
    private String id;
    /**
     * 
     */
    @Override
    public String doMain() {
        helpBean = helpService.selectHelpDetail(id);
        
        return SUCCESS;

    }
    
    /**
     * @return the helpBean
     */
    public HelpBean getHelpBean() {
        return helpBean;
    }
    
    /**
     * @param helpBean the helpBean to set
     */
    public void setHelpBean(HelpBean helpBean) {
        this.helpBean = helpBean;
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
