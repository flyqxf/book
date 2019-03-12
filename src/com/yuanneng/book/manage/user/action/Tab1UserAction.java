/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.manage.user.action;

import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.user.entity.UserBean;
import com.yuanneng.book.manage.user.service.UserService;



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
public class Tab1UserAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
    @Resource
    private UserService userService = null;

    private String userId=null;
    
    private UserBean bean = null;
    /**
     * 
     */
    @Override
    public String doMain() {
        
        UserBean userBean = new UserBean();
        userBean.setUserId(userId);
        
        List<UserBean> users = userService.getUsers(userBean);
        if(users.size()>0) {
            bean = users.get(0);
        }
        return SUCCESS;

    }
    
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * @return the bean
     */
    public UserBean getBean() {
        return bean;
    }
    
    /**
     * @param bean the bean to set
     */
    public void setBean(UserBean bean) {
        this.bean = bean;
    }
    

}
