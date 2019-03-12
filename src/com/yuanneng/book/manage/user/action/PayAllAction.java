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
import com.yuanneng.book.manage.pay.entity.PayBean1;
import com.yuanneng.book.manage.user.entity.UserBean;
import com.yuanneng.book.manage.user.service.UserService;


public class PayAllAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    @Resource
    private UserService userService = null;
    
    
    private String userId = null;
    
    private String select = null;

    private String payName = null;
    
    private String paySum = null;
    
    private UserBean outUser = new UserBean();
    
    private PayBean1 outPayBean = new PayBean1();
    
    private String msg = null;

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
        

        HttpSession session = this.getSession();
        PayBean1 payBean = (PayBean1) session.getAttribute("ZhifuList");
        payBean.setUserId(userId);
        payBean.setPayName(payName);
        payBean.setPay(paySum);
        
        userService.pay_all(payBean,select);
        
        UserBean bean = new UserBean();
        if(!StringUtils.isEmpty(userId)){
            bean.setUserId(userId);
        }
        List<UserBean> users= userService.getUsers(bean);
        if(users.size()>0) {
            outUser = users.get(0);
        }
        
        PayBean1 pBean = new PayBean1();
        pBean.setUserId(userId);
        List<PayBean1> payInfos = new ArrayList<PayBean1>();
        payInfos = userService.getPayBean(pBean);
        if(payInfos.size()>0) {
            outPayBean = payInfos.get(0);
        }
        session.setAttribute("ZhifuList", outPayBean);
        msg="支付成功!";
        
        return SUCCESS;
        
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
     * @return the select
     */
    public String getSelect() {
        return select;
    }


    
    /**
     * @param select the select to set
     */
    public void setSelect(String select) {
        this.select = select;
    }



    
    /**
     * @return the payName
     */
    public String getPayName() {
        return payName;
    }



    
    /**
     * @param payName the payName to set
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }



    
    /**
     * @return the paySum
     */
    public String getPaySum() {
        return paySum;
    }



    
    /**
     * @param paySum the paySum to set
     */
    public void setPaySum(String paySum) {
        this.paySum = paySum;
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
     * @return the outPayBean
     */
    public PayBean1 getOutPayBean() {
        return outPayBean;
    }



    
    /**
     * @param outPayBean the outPayBean to set
     */
    public void setOutPayBean(PayBean1 outPayBean) {
        this.outPayBean = outPayBean;
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
