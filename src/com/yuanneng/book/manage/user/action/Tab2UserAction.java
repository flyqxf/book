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
import com.yuanneng.book.manage.user.entity.UserXiaoshouBean;
import com.yuanneng.book.manage.user.service.UserService;



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
public class Tab2UserAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
    @Resource
    private UserService userService = null;

    private String userId=null;
    private UserXiaoshouBean bean = new UserXiaoshouBean();
    
    private  List<UserXiaoshouBean> users = null;
    
    private String indexProperty;
    /**
     * 
     */
    @Override
    public String doMain() {
        
        
        bean.setFlg("1");
        if(!StringUtils.isEmpty(userId)){
            bean.setUserId(userId);
        }
        String province = bean.getProvince();
        String city = bean.getCity();
        if("--请选择--".equals(province)) {
            bean.setProvince(null);
        }
        if("--请选择--".equals(city)) {
            bean.setCity(null);
        }
        
        users = userService.getTuijianUsers(bean);
        
        CommonPageLinksBean<UserXiaoshouBean> result = new CommonPageLinksBean<UserXiaoshouBean>();
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
        session.setAttribute("zhijieXiaoshouList", result);
        session.setAttribute("zhijieXiaoshouCondition", bean);
        
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
    public List<UserXiaoshouBean> getUsers() {
        return users;
    }

    
    /**
     * @param users the users to set
     */
    public void setUsers(List<UserXiaoshouBean> users) {
        this.users = users;
    }
    
   
    

}
