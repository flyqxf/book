/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.manage.user.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.user.entity.UserJianjieXiaoshouBean;
import com.yuanneng.book.manage.user.entity.UserXiaoshouBean;
import com.yuanneng.book.manage.user.service.UserService;


public class Tab3UserAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
    @Resource
    private UserService userService = null;

    private String userId=null;
    private UserXiaoshouBean bean = new UserXiaoshouBean();
    
    private  List<UserJianjieXiaoshouBean> users = null;
    
    private String indexProperty;
    /**
     * 
     */
    @Override
    public String doMain() {
        
        
        bean.setFlg("2");
        if(!StringUtils.isEmpty(userId)){
            bean.setUserId(userId);
        }
        
        
        users = userService.getJianjieUsers(bean);
        
        CommonPageLinksBean<UserJianjieXiaoshouBean> result = new CommonPageLinksBean<UserJianjieXiaoshouBean>();
        indexProperty = Constant.STRING_ZERO;
        result.setResultList(users);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        result.setTotalProperty(String.valueOf(users.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        //
        /** 将结果放入session中 */
        HttpSession session = this.getSession();
        session.setAttribute("jianjieXiaoshouList", result);
        session.setAttribute("jianjieXiaoshouCondition", bean);
        
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
     * @return the bean
     */
    public UserXiaoshouBean getBean() {
        return bean;
    }

    
    /**
     * @param bean the bean to set
     */
    public void setBean(UserXiaoshouBean bean) {
        this.bean = bean;
    }

    
    /**
     * @return the users
     */
    public List<UserJianjieXiaoshouBean> getUsers() {
        return users;
    }

    
    /**
     * @param users the users to set
     */
    public void setUsers(List<UserJianjieXiaoshouBean> users) {
        this.users = users;
    }
    
   
    

}
