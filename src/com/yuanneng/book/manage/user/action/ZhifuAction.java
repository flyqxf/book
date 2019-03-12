/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.user.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.pay.entity.PayBean;
import com.yuanneng.book.manage.user.entity.UserBean;
import com.yuanneng.book.manage.user.service.UserService;


public class ZhifuAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    @Resource
    private UserService userService = null;
    
    private UserBean bean = new UserBean();
    
    private UserBean outUser = new UserBean();
    
    private List<PayBean> payInfos = null;
    private List<PayBean> payInfos_pay = null;
    
    private String userId = null;
    
    private String flg = null;


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
        
        if(!StringUtils.isEmpty(userId)){
            bean.setUserId(userId);
        }
        List<UserBean> users= userService.getUsers(bean);
        if(users.size()>0) {
            outUser = users.get(0);
        }
        HttpSession session = this.getSession();
        payInfos = new ArrayList<PayBean>();
        payInfos_pay = new ArrayList<PayBean>();
        String returnVal= SUCCESS;
        if("1".equals(flg)){
            payInfos = userService.getPayBean_Zhijie(userId);
            session.setAttribute("ZhifuList", payInfos);
        } else if("2".equals(flg)) {
            payInfos = userService.getPayBean_Jianjie(userId);
            session.setAttribute("ZhifuList_jianjie", payInfos);
            returnVal="success1";
        } else {
            payInfos_pay = userService.getPayBean_Zhijie(userId);
            returnVal="success2";
            session.setAttribute("ZhifuList_pay", payInfos_pay);
        }
       
        
        
        return returnVal;
        
    }


    
    /**
     * @return the bean
     */
    public UserBean getBean() {
        return bean;
    }


    
    /**
     * @param bean the bean to set
     */
    public void setBean(UserBean bean) {
        this.bean = bean;
    }



    
    /**
     * @return the outUser
     */
    public UserBean getOutUser() {
        return outUser;
    }
    
    /**
     * @param outUser the outUser to set
     */
    public void setOutUser(UserBean outUser) {
        this.outUser = outUser;
    }

    
    /**
     * @return the payInfos
     */
    public List<PayBean> getPayInfos() {
        return payInfos;
    }



    
    /**
     * @param payInfos the payInfos to set
     */
    public void setPayInfos(List<PayBean> payInfos) {
        this.payInfos = payInfos;
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
     * @return the flg
     */
    public String getFlg() {
        return flg;
    }



    
    /**
     * @param flg the flg to set
     */
    public void setFlg(String flg) {
        this.flg = flg;
    }



    
//    /**
//     * @return the payInfos_pay
//     */
//    public List<PayBean> getPayInfos_pay() {
//        return payInfos_pay;
//    }
//
//
//
//    
//    /**
//     * @param payInfos_pay the payInfos_pay to set
//     */
//    public void setPayInfos_pay(List<PayBean> payInfos_pay) {
//        this.payInfos_pay = payInfos_pay;
//    }
//    
    
    

}
