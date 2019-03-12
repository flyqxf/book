/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.login.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.manage.login.entity.AdminUserBean;
import com.yuanneng.book.manage.login.service.AdminUserLoginService;


public class AdminLoginAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 页面参数：登录用户名
     */
    private String userName = null;

    /**
     * 页面参数：登录密码
     */
    private String password = null;

    /**
     * 页面参数：验证码
     */
    private String code = null;

    /**
     * 页面参数：显示错误信息
     */
    private String showD101Message = Constant.STRING_ONE;

    /**
     * 被注入的service层
     */
    @Resource
    private AdminUserLoginService  adminUserLoginService;


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
        /** 获取产生的验证码 */
        String oldCode = (String) this.getSession().getAttribute("code");
        /** 输入验证码转大写 */
        String c = code.toUpperCase();
        /** 判断验证码正确性 */
        if (!c.equals(oldCode)) {
            addActionError(messageHelper.getMessage(Constant.BOOKD0011E));
            return ERROR;
        }

        /** 判断密码正确性 */
        AdminUserBean adminUserBean = adminUserLoginService.equelUserPwd(userName, password);
        if (adminUserBean == null) {
            addActionError(messageHelper.getMessage(Constant.BOOKD0010E, Constant.MSG_ADD_USER_NAME,
                    Constant.MSG_ADD_PASSWORD));
            // 清除密码,密码不显示在页面端
            password = null;
            return ERROR;
        }

        
        /** 获取session */
        HttpSession session = this.getSession();
        /** 判断有其他用户登录则移除登录session */
        if (session.getAttribute(Constant.ADMIN_USER_NAME) != null) {
            session.removeAttribute(Constant.ADMIN_USER_NAME);
        }
        /** 将登录的用户信息存入session */
        session.setAttribute(Constant.ADMIN_USER_NAME, adminUserBean);

        
            // 清除密码,密码不显示在页面端
            password = null;
            return SUCCESS;
        
    }

    /**
     * 用户登录校验处理
     * <p>
     * 检测输入信息的合法性
     * </p>
     */
    @Override
    public void validate() {
        /** 用户名称不能为空检测 */
        if (!checkRequired(userName, new String[] { Constant.MSG_ADD_USERNAME })) {
            return;
        }

        /** 用户名输入长度检测 */
        if (!checkLength(userName, 32, Constant.MSG_ADD_USERNAME)) {
            return;
        }

        /** 用户名禁止字符检测 */
        if (!checkXss(userName, Constant.MSG_ADD_USERNAME)) {
            return;
        }

        /** 密码不能为空检测 */
        if (!checkRequired(password, new String[] { Constant.MSG_ADD_PASSWORD })) {
            return;
        }

        /** 密码长度检测 */
        if (!checkLength(password, 18, Constant.MSG_ADD_PASSWORD)) {
            return;
        }

        /** 密码禁止字符检测 */
        if (!checkXss(password, Constant.MSG_ADD_PASSWORD)) {
            return;
        }

        /** 验证码不能为空检测 */
        if (!checkRequired(code, new String[] { Constant.MSG_ADD_CHECKCODE })) {
            return;
        }

        /** 验证码禁止字符检测 */
        if (checkXss(code, Constant.MSG_ADD_CHECKCODE)) {
            return;
        }

    }

    /**
     * 用户名取得
     * 
     * @return 返回结果
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名设置
     * 
     * @param userName 设置参数
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 密码取得
     * 
     * @return 返回结果
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码设置
     * 
     * @param password 设置参数
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 员工工号取得
     * 
     * @return 返回结果
     */
    public String getCode() {
        return code;
    }

    /**
     * 员工工号设置
     * 
     * @param code 设置参数
     */
    public void setCode(String code) {
        this.code = code;
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
