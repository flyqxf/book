/*
 * @(#)LogoffAction.java
 */
package com.yuanneng.book.common.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.manage.login.entity.AdminUserBean;

/**
 * LogoffAction.java
 * 
 * 功 能： 用户退出Action
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.30         shanjixiang     新规做成
 * </pre>
 */
public class LogoffAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String doMain() throws Exception {

        HttpSession session = this.getSession();
        /** 清除登录session中的用户信息 */
        UserValueObject uvo =(UserValueObject) session.getAttribute(Constant.UVO); 
        AdminUserBean bean = (AdminUserBean) session.getAttribute(Constant.ADMIN_USER_NAME);
        //session.removeAttribute(Constant.UVO);
        session.removeAttribute(Constant.ADMIN_USER_NAME);
        /** 销毁登录session */
        //BusinessUtils.clearSession();
        String userId = null;
        if(uvo != null) {
            userId = uvo.getUser().getUserName();
        } else if(bean != null){
            userId = bean.getUserId();
        }
        
        
        ServletActionContext.getServletContext().removeAttribute(userId);

        return SUCCESS;
    }
}
