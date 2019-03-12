/*
/person/tab1Person.action * @(#)InitTaskAction.java
 */
package com.yuanneng.book.prerson.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONObject;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.validator.ValidatorUtils;
import com.yuanneng.book.prerson.entity.PersonBean;
import com.yuanneng.book.prerson.service.PersonService;



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
public class PersonUpdateAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    /**
     * 注入的Servic层
     */
    @Resource
    private PersonService personService=null;

    private String userId = null;
    private String userName = null;
    private String mail = null;
    private String id_zhifubao = null;
    private String id_weixin = null;
    private String bank = null;
    private String bank_card_name = null;
    private String bank_card_number = null;
    private String receivables_flg=null;
    private String resJson;
    
    /**
     * 
     */
    @Override
    public String doMain() {
        
        PersonBean personBean = new PersonBean();
        
        personBean.setUserId(userId);
        personBean.setUserName(userName);
        personBean.setMail(mail);
        personBean.setId_zhifubao(id_zhifubao);
        personBean.setId_weixin(id_weixin);
        personBean.setBank(bank);
        personBean.setBank_card_name(bank_card_name);
        personBean.setBank_card_number(bank_card_number);
        personBean.setReceivables_flg(receivables_flg);

        String msg = checkItem(personBean);
        Map<String, Object> map = new HashMap<String, Object>();
        
        if(msg != null) {
            map.put("status", "fails");
            map.put("msg", msg);
        } else {        
        
            personService.updatePersion(personBean);
        
            map.put("status", "success");
            map.put("msg", "个人信息修改成功");
        }
     // 设定字符串返回值
        resJson = JSONObject.fromObject(map).toString();
        
        return SUCCESS;

    }

    private String checkItem(PersonBean personBean) {
        String message = null;

        //姓名check
        String userName = personBean.getUserName();
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
//        
        //邮箱地址
        String mail = personBean.getMail();
        if(StringUtils.isEmpty(mail)) {
            message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_EMAIL });
        } else if (!ValidatorUtils.isValidInputString(mail)) {
            message = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_EMAIL});
        } else if (!ValidatorUtils.isValidMailAddr(mail)) {
            message = messageHelper.getMessage(Constant.BOOKZ0002E, new Object[] { Constant.MSG_ADD_EMAIL,
                    Constant.MSG_ADD_ACCENDANTMAIL_CMT });
        }
        if(message != null) {
            return message;
        }
        
        String receivables_flg = personBean.getReceivables_flg();
        if("1".equals(receivables_flg)) {
          //支付宝
            String aliPayAccount = personBean.getId_zhifubao();
            if(StringUtils.isEmpty(aliPayAccount)) {
                message =messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.ALIPAY_NAME });
            } else if(aliPayAccount.length()>110) {
                message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.ALIPAY_NAME,"110" });
            }
            
        }else if("2".equals(receivables_flg)) {
            String weiChatAccount = personBean.getId_weixin();
            if(StringUtils.isEmpty(weiChatAccount)) {
                message =messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.WECHAT_NAME });
            } else if(weiChatAccount.length()>60) {
                message = messageHelper.getMessage(Constant.BOOKZ0006E, new String[] {  Constant.WECHAT_NAME,"60" });
            }
        } else {
            String bank= personBean.getBank();
            String bank_card_number = personBean.getBank_card_number();
            String bank_card_name = personBean.getBank_card_name();
            
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
        
        
//        
//        //手机号码
//        String mobile = userBean.getMobile();
//        if(StringUtils.isEmpty(mobile)) {
//            message = messageHelper.getMessage(Constant.BOOKZ0001E, new String[] { Constant.MSG_ADD_PHONE });
//        }  else if (mobile.contains(stringBlank)) {
//            message = messageHelper.getMessage(Constant.BOOKD0023E, new String[] { Constant.MSG_ADD_PHONE });
//        } else if (!ValidatorUtils.isValidInputString(mobile)) {
//            message = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_PHONE});
//        } else if (!ValidatorUtils.isValidMobileNo(mobile)) {
//            message = messageHelper.getMessage(Constant.BOOKZ0002E, new String[] { Constant.MSG_ADD_PHONE, "例：12345678901" });
//        } else if(registerService.isExsitsMobile(mobile)){
//            message = "该手机号码已被注册。";
//        }
//        if(message != null) {
//            return message;
//        }
       
        
        return message;
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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    
    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }


    
    
    
    /**
     * @return the id_zhifubao
     */
    public String getId_zhifubao() {
        return id_zhifubao;
    }


    
    /**
     * @param id_zhifubao the id_zhifubao to set
     */
    public void setId_zhifubao(String id_zhifubao) {
        this.id_zhifubao = id_zhifubao;
    }


    
    /**
     * @return the id_weixin
     */
    public String getId_weixin() {
        return id_weixin;
    }


    
    /**
     * @param id_weixin the id_weixin to set
     */
    public void setId_weixin(String id_weixin) {
        this.id_weixin = id_weixin;
    }


    
    /**
     * @return the bank
     */
    public String getBank() {
        return bank;
    }


    
    /**
     * @param bank the bank to set
     */
    public void setBank(String bank) {
        this.bank = bank;
    }


    
    /**
     * @return the bank_card_name
     */
    public String getBank_card_name() {
        return bank_card_name;
    }


    
    /**
     * @param bank_card_name the bank_card_name to set
     */
    public void setBank_card_name(String bank_card_name) {
        this.bank_card_name = bank_card_name;
    }


    
    /**
     * @return the bank_card_number
     */
    public String getBank_card_number() {
        return bank_card_number;
    }


    
    /**
     * @param bank_card_number the bank_card_number to set
     */
    public void setBank_card_number(String bank_card_number) {
        this.bank_card_number = bank_card_number;
    }


    /**
     * @return the resJson
     */
    public String getResJson() {
        return resJson;
    }


    
    /**
     * @param resJson the resJson to set
     */
    public void setResJson(String resJson) {
        this.resJson = resJson;
    }

    
    /**
     * @return the receivables_flg
     */
    public String getReceivables_flg() {
        return receivables_flg;
    }

    
    /**
     * @param receivables_flg the receivables_flg to set
     */
    public void setReceivables_flg(String receivables_flg) {
        this.receivables_flg = receivables_flg;
    }

    
    

}
