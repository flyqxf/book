/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.prerson.action;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.prerson.entity.PersonBean;
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
public class PersonAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
    private  PersonBean personBean = null;
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
//        UserValueObject uvo = BusinessUtils.getUVO();
//        
//        String userId = uvo.getUser().getUserId();
//        
//        personBean=personService.getPersion(userId);
        
        return SUCCESS;

    }
    
    /**
     * @return the personBean
     */
    public PersonBean getPersonBean() {
        return personBean;
    }
    
    /**
     * @param personBean the personBean to set
     */
    public void setPersonBean(PersonBean personBean) {
        this.personBean = personBean;
    }

    
  

}
