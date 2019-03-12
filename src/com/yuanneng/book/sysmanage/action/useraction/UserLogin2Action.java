/*
 * @(#)UserLoginAction.java
 */
package com.yuanneng.book.sysmanage.action.useraction;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.sysmanage.service.UserEventLogService;
import com.yuanneng.book.sysmanage.service.UserLoginService;

/**
 * UserLoginAction.java
 * 
 * 功 能： 用户登录验证
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.13         shanjixiang     新规做成
 * </pre>
 */
public class UserLogin2Action extends CommonAction {


    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    

    /**
     * 被注入的service层
     */
    @Resource
    private UserLoginService userLoginService;

    /**
     * 被注入的service层
     */
    @Resource
    private UserEventLogService userEventLogService;

    /**
     * 主要逻辑方法
     * <p>
     * 编辑画面的输入值，调用service,处理service的返回结果
     * </p>
     * 
     * @return 处理结果
     * @exception 待定
     */
    @Override
    public String doMain() throws Exception {
            return SUCCESS;
        
    }

}
