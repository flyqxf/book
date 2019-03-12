/*
 * @(#)LoginAction.java
 */
package com.yuanneng.book.common.action;

import org.apache.log4j.Logger;

import com.yuanneng.book.common.utils.Constant;



/**
 * LoginAction.java
 * 
 * 功 能： 登录页面跳转Action
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.27         shanjixiang        新规做成
 * </pre>
 */
public class LoginAction extends CommonAction {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(LoginAction.class);

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 页面参数：显示错误信息
     */
    private String showD101Message = null;

    /**
     * 页面参数：是否session超时(1:超时)
     */
    private String sessionTimeOut = null;

    @Override
    public String doMain() throws Exception {
        if (Constant.STRING_ONE.equals(sessionTimeOut)) {
            String msg = messageHelper.getMessage(Constant.BOOKD0016E);
            this.addActionError(msg);
            showD101Message = Constant.STRING_ONE;
        }

        return SUCCESS;
    }

    /**
     * @return 是否session超时(1:超时)
     */
    public String getSessionTimeOut() {
        return sessionTimeOut;
    }

    /**
     * @param sessionTimeOut 是否session超时(1:超时)
     */
    public void setSessionTimeOut(String sessionTimeOut) {
        this.sessionTimeOut = sessionTimeOut;
    }

    /**
     * @return the 显示错误信息
     */
    public String getShowD101Message() {
        return showD101Message;
    }

    /**
     * @param showD101Message 显示错误信息
     */
    public void setShowD101Message(String showD101Message) {
        this.showD101Message = showD101Message;
    }


    
}
