/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.manage.pay.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.pay.entity.PayBean1;

public class PayPageLinkAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 起点数据编号
     */
    private String indexProperty;
    private PayBean1 bean = new PayBean1();


    
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
        
        bean = (PayBean1) session.getAttribute("payCondition");

        
        @SuppressWarnings("unchecked")
        CommonPageLinksBean<PayBean1> result = (CommonPageLinksBean<PayBean1>) session.getAttribute("payList");
        if (StringUtils.isEmpty(indexProperty)) {
            indexProperty = Constant.STRING_ZERO;
        }
//        result.setResultList(users);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
//        result.setTotalProperty(String.valueOf(users.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        

        session.setAttribute("payList", result);
        

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
    public PayBean1 getBean() {
        return bean;
    }


    
    /**
     * @param bean the bean to set
     */
    public void setBean(PayBean1 bean) {
        this.bean = bean;
    }

    
  

}
