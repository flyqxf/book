/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.register.service.RegisterService;
import com.yuanneng.book.sysmanage.entity.UserBean;


public class BackToRegisterAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private RegisterService registerService;
    
    private UserBean userBean = null;
    
    @Override
    public String doMain() throws Exception {
        HttpSession session = this.getSession();
        
        userBean = (UserBean) session.getAttribute("registerUserBean");
        
        return SUCCESS;

    }

    
    /**
     * @return the userBean
     */
    public UserBean getUserBean() {
        return userBean;
    }

    
    /**
     * @param userBean the userBean to set
     */
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    
}
