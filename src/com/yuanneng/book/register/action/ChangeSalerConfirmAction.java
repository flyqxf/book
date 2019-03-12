/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.validator.ValidatorUtils;
import com.yuanneng.book.register.service.RegisterService;
import com.yuanneng.book.sysmanage.entity.UserBean;


public class ChangeSalerConfirmAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private UserBean userBean = null;
    
    @Resource
    private RegisterService registerService;
    
    private String msg = null;
    private String resFlg = "1";
    private String code = null;

    
    @Override
    public String doMain() throws Exception {

        msg = checkItem(userBean);
        if(msg != null) {
            resFlg = "2";
            return INPUT;
        }
        
//        if(code.equals("1")) {
            userBean.setCode(code);
//        } else {
//            userBean.setCode(userBean.getUserId());
//        }

        
        //msg = "注册成功！";
        HttpSession session = this.getSession();
        UserValueObject uvo = (UserValueObject) session.getAttribute(Constant.UVO);
        String userId = uvo.getUser().getUserId();
        userBean.setUserId(userId);
        
        registerService.changeSaler(userBean);
        
        return SUCCESS;

    }
    
    private String checkItem(UserBean userBean) {
        String message = null;
        
        String receivables_flg = userBean.getReceivables_flg();
        if("1".equals(receivables_flg)) {
          //支付宝
            String aliPayAccount = userBean.getId_zhifubao();
            if(StringUtils.isEmpty(aliPayAccount)) {
                message =messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.ALIPAY_NAME });
            } else if(aliPayAccount.length()>110) {
                message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.ALIPAY_NAME,"110" });
            }
            
        }else if("2".equals(receivables_flg)) {
            String weiChatAccount = userBean.getId_weixin();
            if(StringUtils.isEmpty(weiChatAccount)) {
                message =messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.WECHAT_NAME });
            } else if(weiChatAccount.length()>60) {
                message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.WECHAT_NAME,"60" });
            }
        } else {
            String bank= userBean.getBank();
            String bank_card_number = userBean.getBank_card_number();
            String bank_card_name = userBean.getBank_card_name();
            
            if(StringUtils.isEmpty(bank)) {
                message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.BANK_NAME });
            } else if(StringUtils.isEmpty(bank_card_number)) {
                message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.BANK_CARD_NUMBER });
            } else if(StringUtils.isEmpty(bank_card_name)) {
                message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.BANK_CARD_NAME });
            } else if(bank.length()>60) {
                message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.BANK_NAME,"60" });
            } else if(bank_card_number.length()>60) {
                message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.BANK_CARD_NUMBER,"60" });
            } else if(!ValidatorUtils.isNumber(bank_card_number)) {
                message = messageHelper.getMessage(Constant.BOOKZ0023E, new String[] { Constant.BANK_CARD_NUMBER});
            } else if(bank_card_name.length()>60) {
                message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.BANK_CARD_NAME,"60" });
            } 
        }
        
       
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
    
    
}
