/*
 * @(#)UserLoginAction.java
 */
package com.yuanneng.book.sysmanage.action.useraction;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.log.LogHelper;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.FormatedTime;
import com.yuanneng.book.sysmanage.action.useraction.UserLoginAction;
import com.yuanneng.book.sysmanage.entity.UserBean;
import com.yuanneng.book.sysmanage.entity.UserEventLogBean;
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
public class UserLoginAction extends CommonAction {
    /**
     * 日志
     */
    private static Log log = LogFactory.getLog(UserLoginAction.class);

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
        UserBean userBean = userLoginService.equelUserPwd(userName, password);
        if (userBean == null) {
            addActionError(messageHelper.getMessage(Constant.BOOKD0010E, Constant.MSG_ADD_USER_NAME,
                    Constant.MSG_ADD_PASSWORD));
            // 清除密码,密码不显示在页面端
            password = null;
            return ERROR;
        }
        /** 用户被锁定 */
        if (Constant.STRING_ONE.equals(userBean.getFlag())) {
            addActionError(messageHelper.getMessage(Constant.BOOKD0012E));
            // 清除密码,密码不显示在页面端
            password = null;
            return ERROR;
        }
        /** 用户锁定失败 */
        else if (Constant.STRING_TWO.equals(userBean.getFlag())) {
            addActionError(messageHelper.getMessage(Constant.BOOKZ0008E,
                    new Object[] { Constant.MSG_ADD_USER_NAME }));
            // 清除密码,密码不显示在页面端
            password = null;
            return ERROR;
        }

       
        /** 用户状态的检查 */
        if (!userBean.getStatus().equals(Constant.USER_STATUS_NORMAL)) {
            addActionError(messageHelper.getMessage(Constant.BOOKD0012E));
            // 清除密码,密码不显示在页面端
            password = null;
            return ERROR;
        }

        
        /** 设置日志参数 */
        String cleIp = BusinessUtils.getClientIpAddr();
        LogHelper.debug(log, "……………………………………本机的ip：" + cleIp);
        UserEventLogBean userLog = new UserEventLogBean();
        /** 查询日志结果 */
        UserEventLogBean userLogResult = new UserEventLogBean();

        /** 添加日志ID */
        userLog.setLogId(BusinessUtils.getUUID());
        /** 用户ID */
        userLog.setUserId(userBean.getUserId());
        /** 用户名 */
        userLog.setUserName(userBean.getUserName());
        userLog.setLoginIP(cleIp);

        /** 查询登录日志 */
        userLogResult = userEventLogService.selectUserLog(userLog);

        /** 获取当前时间 */
        Date loginDate = new Date();

        /** 本次登录时间 */
        userLog.setStart_Date(loginDate);

        /** 插入登录日志 */
        userEventLogService.addUserLog(userLog);

        /** 将用户信息加入到登录session的UserValueObject对象中 */
        UserValueObject uvo = new UserValueObject();
        /** 添加用户信息 */
        uvo.setUser(userBean);
        /** 添加登录ip */
        uvo.setLoginIp(cleIp);
        /** 添加上次登录时间 */
        if (userLogResult != null) {
            uvo.setLoginDate(BusinessUtils.getTimeString(userLogResult.getStart_Date(),
                    FormatedTime.HYPHEN_YYYYMMDD_HHMMSS));
        }
        
        
      //同一账户只能登陆一个
        HttpSession oldSession = (HttpSession) ServletActionContext.getServletContext().getAttribute(userName);//取得容器,容器中根据用户唯一标识userID存放session
        if (oldSession != null)   
        {  
         // 第二次登陆后第一次无效  
            try{
                oldSession.invalidate();// 清除第一次登陆的session
                ServletActionContext.getServletContext().setAttribute(userName, null);
            }catch(IllegalStateException e) {
                
            }
        }  
        
        HttpSession session = this.getSession();
        session.setAttribute(Constant.UVO, uvo);
        ServletActionContext.getServletContext().setAttribute(userName, session);//放入当前最新session
        
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
