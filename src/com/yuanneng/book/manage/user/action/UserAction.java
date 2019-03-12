/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.user.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.user.entity.UserBean;
import com.yuanneng.book.manage.user.service.UserService;


public class UserAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    @Resource
    private UserService userService = null;
    
    private UserBean bean = new UserBean();
    
    private List<UserBean> users = null;
    
    private String showflg="1";
    
    private String indexProperty;
    

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
        String receivables_flg = bean.getReceivables_flg();
        String zhanghao = bean.getZhanghao();
        if("1".equals(receivables_flg)){
            bean.setId_zhifubao(zhanghao);
        } else if("2".equals(receivables_flg)) {
            bean.setId_weixin(zhanghao);
        } else if("3".equals(receivables_flg)) {
            bean.setBank_card_number(zhanghao);
        }
        
        String province = bean.getProvince();
        String city = bean.getCity();
        if("--请选择--".equals(province)) {
            bean.setProvince(null);
        }
        if("--请选择--".equals(city)) {
            bean.setCity(null);
        }
        users = userService.getUsers(bean);
        
        CommonPageLinksBean<UserBean> result = new CommonPageLinksBean<UserBean>();
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
        session.setAttribute("userInfoList", result);
        session.setAttribute("manageUserFlg", showflg);
        session.setAttribute("manageUserCondition", bean);
        
        
        return SUCCESS;
        
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
     * @return the users
     */
    public List<UserBean> getUsers() {
        return users;
    }


    
    /**
     * @param users the users to set
     */
    public void setUsers(List<UserBean> users) {
        this.users = users;
    }



    
    /**
     * @return the showflg
     */
    public String getShowflg() {
        return showflg;
    }



    
    /**
     * @param showflg the showflg to set
     */
    public void setShowflg(String showflg) {
        this.showflg = showflg;
    }

    
    
   
}
