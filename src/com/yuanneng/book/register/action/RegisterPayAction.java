/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.common.validator.ValidatorUtils;
import com.yuanneng.book.register.service.RegisterService;
import com.yuanneng.book.sysmanage.entity.UserBean;


public class RegisterPayAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private UserBean userBean = null;
    
    @Resource
    private RegisterService registerService;
    
    private String msg = null;
    private String rePassword = null;
    private String password = null;
    private String resFlg = "1";
    private String code = null;
    private static final String stringBlank = " ";
    private String price = null;
    private String youhui = null;
    
    @Override
    public String doMain() throws Exception {

        msg = checkItem(userBean);
        if(msg != null) {
            resFlg = "2";
            return INPUT;
        }
        /*
        if(code.equals("1")) {
            userBean.setCode(userBean.getMobile());
        } else {
            userBean.setCode(userBean.getUserId());
        }
        */
        
        String pwd = BusinessUtils.getPasswordMD5(password);
        userBean.setUserPassword(pwd);
        
        //registerService.insertUser(userBean);
        
        //msg = "注册成功！";
        
        
        HttpSession session = this.getSession();
        session.setAttribute("registerUserBean", userBean);
        
        price = registerService.getPrice();
        
        if(price == null) {
            
            msg = "未设置产品价格";
            resFlg = "2";
            return INPUT;
        }
        
        String privilege = registerService.getPrivilege();
        if(privilege == null) {
            msg = "未设置优惠金额";
            resFlg = "2";
            return INPUT;
        }

        BigDecimal prc = new BigDecimal(price);

        BigDecimal prvlg = new BigDecimal(privilege);

        youhui = prc.subtract(prvlg).toString();
        
        
        
        return SUCCESS;

    }
    
    private String checkItem(UserBean userBean) {
        String message = null;
        
        //登录名check
        String userId = userBean.getUserId();
        //必须输入
        if(StringUtils.isEmpty(userId)) {
            message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_ACCOUNTE });
        } else if(userId.length()>32) {
            message = "登录名不能超过32位。";
        } else if (userId.contains(stringBlank)) {
            message = messageHelper.getMessage(Constant.BOOKD0023E, new String[] { Constant.MSG_ADD_ACCOUNTE });
        } else if (!ValidatorUtils.isValidInputString(userId)) {
            message = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_ACCOUNTE});
        } else if(registerService.isExsitsUser(userId)){
            message = "登录名已存在。";
        }
        if(message != null) {
            return message;
        }
        
        //密码check
        String pwd = password;
        if(StringUtils.isEmpty(pwd)) {
            message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_PASSWORD });
        } else if (!ValidatorUtils.isValidInputString(pwd)) {
            message = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_PASSWORD});
        } else if (pwd.contains(stringBlank)) {
            message = messageHelper.getMessage(Constant.BOOKD0023E, new String[] { Constant.MSG_ADD_PASSWORD });
        } else {
            int min = Integer.parseInt(PropertyUtil.getProperty(Constant.MIN_PASSWORD));
            int max = Integer.parseInt(PropertyUtil.getProperty(Constant.MAX_PASSWORD));
            if (!ValidatorUtils.isValidPassword(pwd, min, max)){
                message = messageHelper.getMessage(Constant.BOOKD0017E, new String[] { String.valueOf(min),String.valueOf(max),Constant.MSG_ADD_PASSWORD });
            }
        }
        if(message != null) {
            return message;
        }
        
        //确认密码
        if(StringUtils.isEmpty(rePassword)) {
            message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_RE_PASSWORD });
        } else if (!ValidatorUtils.isValidInputString(rePassword)) {
            message = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_RE_PASSWORD});
        } else if (rePassword.contains(stringBlank)) {
            message = messageHelper.getMessage(Constant.BOOKD0023E, new String[] { Constant.MSG_ADD_RE_PASSWORD });
        } else {
            int min = Integer.parseInt(PropertyUtil.getProperty(Constant.MIN_PASSWORD));
            int max = Integer.parseInt(PropertyUtil.getProperty(Constant.MAX_PASSWORD));
            if (!ValidatorUtils.isValidPassword(rePassword, min, max)){
                message = messageHelper.getMessage(Constant.BOOKD0017E, new String[] { String.valueOf(min),String.valueOf(max),Constant.MSG_ADD_RE_PASSWORD });
            } else if(!pwd.equals(rePassword)) {
                message = messageHelper.getMessage(Constant.BOOKD0008E);
            }
        }
        if(message != null) {
            return message;
        }
        
        //姓名check
        String userName = userBean.getUserName();
        if(StringUtils.isEmpty(userName)) {
            message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_REALNAME });
        } else if (userName.length() > 16) {
            
            message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.MSG_ADD_REALNAME,"16" });
        } else if (!ValidatorUtils.isValidInputString(userName)) {
            message = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_REALNAME});
        }
        if(message != null) {
            return message;
        }
        
        //邮箱地址
        String mail = userBean.getMail();
        if(!StringUtils.isEmpty(mail)) {
            if (!ValidatorUtils.isValidInputString(mail)) {
                message = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_EMAIL});
            } else if (!ValidatorUtils.isValidMailAddr(mail)) {
                message = messageHelper.getMessage(Constant.BOOKZ0002E, new Object[] { Constant.MSG_ADD_EMAIL,
                    Constant.MSG_ADD_ACCENDANTMAIL_CMT });
            }
        }
        if(message != null) {
            return message;
        }
        
        //手机号码
        String mobile = userBean.getMobile();
        if(StringUtils.isEmpty(mobile)) {
            message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_PHONE });
        }  else if (mobile.contains(stringBlank)) {
            message = messageHelper.getMessage(Constant.BOOKD0023E, new String[] { Constant.MSG_ADD_PHONE });
        } else if (!ValidatorUtils.isValidInputString(mobile)) {
            message = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_PHONE});
        } else if (!ValidatorUtils.isValidMobileNo(mobile)) {
            message = messageHelper.getMessage(Constant.BOOKZ0002E, new String[] { Constant.MSG_ADD_PHONE, "例：12345678901" });
        } else if(registerService.isExsitsMobile(mobile)){
            message = "该手机号码已被注册。";
        }
        if(message != null) {
            return message;
        }
       /* 
        //支付宝
        String aliPayAccount = userBean.getId_zhifubao();
        String weiChatAccount = userBean.getId_weixin();
        if(StringUtils.isEmpty(aliPayAccount) && StringUtils.isEmpty(weiChatAccount)) {
            message = "支付宝和微信号不能同时为空。";
        } else if(aliPayAccount.length()>60) {
            message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.ALIPAY_NAME,"60" });
        } else if(weiChatAccount.length()>60) {
            message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.WECHAT_NAME,"60" });
        }
        
        if(message != null) {
            return message;
        }
        
        //优惠码
        String registerCode=userBean.getRegister_code();
        if(!StringUtils.isEmpty(registerCode)) {
            if(userId.length()>32) {
                message = "优惠码不能超过32位。";
            } else if (registerCode.contains(stringBlank)) {
                message = messageHelper.getMessage(Constant.BOOKD0023E, new String[] { Constant.MSG_ADD_REGISTER_CODE });
            } else if (!ValidatorUtils.isValidInputString(registerCode)) {
                message = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_REGISTER_CODE});
            } else if(!registerService.isExsitsMobile(registerCode)){
                message = "该优惠码不存在。";
            }
            
        }
        */
        
        return message;
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

    
    /**
     * @return the resFlg
     */
    public String getResFlg() {
        return resFlg;
    }

    
    /**
     * @param resFlg the resFlg to set
     */
    public void setResFlg(String resFlg) {
        this.resFlg = resFlg;
    }

    
    /**
     * @return the rePassword
     */
    public String getRePassword() {
        return rePassword;
    }

    
    /**
     * @param rePassword the rePassword to set
     */
    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    
    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    
    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    
    /**
     * @return the youhui
     */
    public String getYouhui() {
        return youhui;
    }

    
    /**
     * @param youhui the youhui to set
     */
    public void setYouhui(String youhui) {
        this.youhui = youhui;
    }
    
    
}
