/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.login.action;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.validator.ValidatorUtils;
import com.yuanneng.book.manage.login.entity.AdminUserBean;
import com.yuanneng.book.manage.login.service.AdminUpdatePwdService;

public class AdminUpdatePwdConfirmAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 页面参数：当前密码
     */
    private String nowPwd = null;

    /**
     * 页面参数：新密码
     */
    private String newPwd = null;

    /**
     * 页面参数：确认新密码
     */
    private String reNewPwd = null;

    /**
     * 显示参数：显示信息窗口的标志位
     */
    private String successMsg = null;

    /**
     * 显示参数：显示错误信息用
     */
    private String showD104Message = Constant.STRING_ONE;
    
    private String msg = null;


    /**
     * 被注入的service层
     */
    @Resource
    private AdminUpdatePwdService adminUpdatePwdService;



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

        msg = check(); 
        if(msg != null) {
            return SUCCESS;
        }
        
        /** 取得UVO */
        AdminUserBean adminUserBean = (AdminUserBean) this.getSession().getAttribute(Constant.ADMIN_USER_NAME);
        

        /** 取得旧密码向数据库查询确认 */
        AdminUserBean rst = adminUpdatePwdService.equelUserPwd(adminUserBean.getUserId(), nowPwd);
        if (null == rst) {
            msg = messageHelper
                    .getMessage(Constant.BOOKD0018E, Constant.MSG_ADD_NOW_PASSWORD);
            
            return SUCCESS;
        }
        /** 修改密码操作 */
        /** 设置参数 */
        AdminUserBean condition = new AdminUserBean();
        /** 添加新密码 */
        condition.setUserPassword(newPwd);
        condition.setUserId(adminUserBean.getUserId());
        int result = adminUpdatePwdService.changePwd(condition);
        /** 修改密码失败 */
        if (Constant.NUM_0 == result) {
            msg = messageHelper.getMessage(Constant.BOOKD0003I);
            
            return SUCCESS;
        }
        /** 清空显示内容 */
        this.setNowPwd(null);
        this.setNewPwd(null);
        this.setReNewPwd(null);
        /** 显示窗口 */
        this.setSuccessMsg(messageHelper.getMessage(Constant.BOOKD0019I));
        this.setShowD104Message(Constant.STRING_BLANK);


        /** 设置成功提示消息 */
        msg = "修改密码成功！";

        return SUCCESS;
    }

    /**
     * 输入密码信息校验处理
     * <p>
     * 检测输入信息的合法性
     * </p>
     */
    
    public String check() {

        String msg = null;
        /** 当前密码不能为空检测 */
        if (StringUtils.isEmpty(nowPwd)) {
            msg = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_NOW_PASSWORD });
            
            return msg;
        }
        /** 当前密码禁止字符检测 */
        if (!ValidatorUtils.isValidInputString(nowPwd)) {
            msg = messageHelper.getMessage(Constant.BOOKZ0034E, new Object[] { Constant.MSG_ADD_NOW_PASSWORD });
            return msg;
        }

        /** 新密码不能为空检测 */
        if (StringUtils.isEmpty(newPwd)) {
            msg = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_NEW_PASSWORD });
            return msg;
        }
        

        /** 新密码禁止字符检测 */
        if (!ValidatorUtils.isValidInputString(newPwd)) {
            msg = messageHelper.getMessage(Constant.BOOKZ0034E, new Object[] { Constant.MSG_ADD_NEW_PASSWORD });
            return msg;
        }


        /** 确认新密码不能为空检测 */
        if (StringUtils.isEmpty(reNewPwd)) {
            msg = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_RE_PASSWORD });
            return msg;
        }

        /** 确认新密码禁止字符检测 */
        if (!ValidatorUtils.isValidInputString(reNewPwd)) {
            msg = messageHelper.getMessage(Constant.BOOKZ0034E, new Object[] { Constant.MSG_ADD_RE_PASSWORD });
            return msg;
        }

        /** 新密码与确认新密码一致检测 */
        if (!newPwd.equals(reNewPwd)) {
            msg = messageHelper.getMessage(Constant.BOOKD0008E);
            return msg;
        }

        /** 新旧密码不能相同 */
        if (nowPwd.equals(newPwd)) {
            msg = messageHelper.getMessage(Constant.BOOKD0009E);
            return msg;
        }
        return null;
    }

    /**
     * 当前密码取得
     * 
     * @return 返回结果
     */
    public String getNowPwd() {
        return nowPwd;
    }

    /**
     * 当前密码设置
     * 
     * @param nowPwd 设置参数
     */
    public void setNowPwd(String nowPwd) {
        this.nowPwd = nowPwd;
    }

    /**
     * 新密码取得
     * 
     * @return 返回结果
     */
    public String getNewPwd() {
        return newPwd;
    }

    /**
     * 新密码设置
     * 
     * @param newPwd 设置参数
     */
    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    /**
     * 确认密码取得
     * 
     * @return 返回结果
     */
    public String getReNewPwd() {
        return reNewPwd;
    }

    /**
     * 确认密码设置
     * 
     * @param reNewPwd 设置参数
     */
    public void setReNewPwd(String reNewPwd) {
        this.reNewPwd = reNewPwd;
    }

    /**
     * @return 显示信息窗口的标志位
     */
    public String getSuccessMsg() {
        return successMsg;
    }

    /**
     * @param successMsg 显示信息窗口的标志位
     */
    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    /**
     * @return 显示错误信息用
     */
    public String getShowD104Message() {
        return showD104Message;
    }

    /**
     * @param showD104Message 显示错误信息用
     */
    public void setShowD104Message(String showD104Message) {
        this.showD104Message = showD104Message;
    }

    
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    

}
