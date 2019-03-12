/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.prerson.action;

import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.prerson.entity.CountBean;
import com.yuanneng.book.prerson.service.PersonService;


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
public class ShowCountAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
    private  List<CountBean> countBeans = null;
    /**
     * 注入的Servic层
     */
    @Resource
    private PersonService personService=null;
    
    /**
     * 
     */
    @Override
    public String doMain() {

        UserValueObject uvo = BusinessUtils.getUVO();
        
        String userId = uvo.getUser().getUserId();
      
        countBeans=personService.getCount(userId);
        
        return SUCCESS;

    }

    
    /**
     * @return the countBeans
     */
    public List<CountBean> getCountBeans() {
        return countBeans;
    }

    
    /**
     * @param countBeans the countBeans to set
     */
    public void setCountBeans(List<CountBean> countBeans) {
        this.countBeans = countBeans;
    }

    
    

}
