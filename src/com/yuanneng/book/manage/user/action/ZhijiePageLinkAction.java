/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.manage.user.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.user.entity.UserXiaoshouBean;

public class ZhijiePageLinkAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 起点数据编号
     */
    private String indexProperty;
    private UserXiaoshouBean bean = new UserXiaoshouBean();
    private String userId = null;


    
    /**
     * 任务检索页面初期显示
     * <p>
     * 调用Servic取得需要从数据库获取的检索条件和任务检索结果
     * </p>
     * 
     * @return 处理结果 SUCCESS: 正常、ERROR: 异常
     * @exception 待定
     */
    @Override
    public String doMain() {

        HttpSession session = this.getSession();
        
        bean = (UserXiaoshouBean) session.getAttribute("zhijieXiaoshouCondition");
        userId = bean.getUserId();
        
        @SuppressWarnings("unchecked")
        CommonPageLinksBean<UserXiaoshouBean> result = (CommonPageLinksBean<UserXiaoshouBean>) session.getAttribute("zhijieXiaoshouList");
        if (StringUtils.isEmpty(indexProperty)) {
            indexProperty = Constant.STRING_ZERO;
        }
//        result.setResultList(users);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
//        result.setTotalProperty(String.valueOf(users.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        

        session.setAttribute("zhijieXiaoshouList", result);
        

        return SUCCESS;

    }

    
    /**
     * @return the indexProperty
     */
    public String getIndexProperty() {
        return indexProperty;
    }

    
    /**
     * @param indexProperty the indexProperty to set
     */
    public void setIndexProperty(String indexProperty) {
        this.indexProperty = indexProperty;
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

    

}
