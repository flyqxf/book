/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.manage.sale.action;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.sale.entity.ConditionBean;
import com.yuanneng.book.manage.sale.entity.SaleBean;

public class SaleOrderAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 起点数据编号
     */
    private String indexProperty;
    
    private String orderKey = null;
    
    private String order = null;
    
    private String showflg = null;
    
    private ConditionBean conditionBean = new ConditionBean();


    
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
        
        conditionBean = (ConditionBean) session.getAttribute("saleCondition");

        
        @SuppressWarnings("unchecked")
        CommonPageLinksBean<SaleBean> result = (CommonPageLinksBean<SaleBean>) session.getAttribute("saleList");
        if (StringUtils.isEmpty(indexProperty)) {
            indexProperty = Constant.STRING_ZERO;
        }
        
        List<SaleBean> resList = result.getResultList();
        resList = sort(resList);
        
        
        
        result.setResultList(resList);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        result.setTotalProperty(String.valueOf(resList.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        

        session.setAttribute("saleList", result);
        

        return SUCCESS;

    }
    
    //
    private List<SaleBean> sort(List<SaleBean> resList) {
        
        Collections.sort(resList, new Comparator<SaleBean>(){

            @Override
            public int compare(SaleBean o1, SaleBean o2) {
                
                int res = 0;
                
                int a1 = 0;
                int a2 = 0;
                
                if("personSum_zhijie".equals(orderKey)) {
                    a1 = o1.getPersonSum_zhijie();
                    a2 = o2.getPersonSum_zhijie();
                } else if("personSum_jianjie".equals(orderKey)) {
                    a1 = o1.getPersonSum_jianjie();
                    a2 = o2.getPersonSum_jianjie();
                } else if("paySummary".equals(orderKey)) {
                    if(new BigDecimal(o1.getPaySummary()).compareTo(new BigDecimal(o2.getPaySummary()))>0) {
                        a1 = 2;
                        a2 = 1;
                    }
                    
                } else if("personThisMonth_zhijie".equals(orderKey)) {
                    a1 = o1.getPersonThisMonth_zhijie();
                    a2 = o2.getPersonThisMonth_zhijie();
                } else if("personThisMonth_jianjie".equals(orderKey)) {
                    a1 = o1.getPersonThisMonth_jianjie();
                    a2 = o2.getPersonThisMonth_jianjie();
                } else if("paySummary_thisMonth".equals(orderKey)) {
                    if(new BigDecimal(o1.getPaySummary_thisMonth()).compareTo(new BigDecimal(o2.getPaySummary_thisMonth()))>0) {
                        a1 = 2;
                        a2 = 1;
                    }
                    
                }
                
                //降序
                if("1".equals(order)) {
                    res =a1 - a2;
                } else {
                    res =a2 - a1;
                }
                
                
                return res;
            }
            
        });
        
        return resList;
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
     * @return the conditionBean
     */
    public ConditionBean getConditionBean() {
        return conditionBean;
    }


    
    /**
     * @param conditionBean the conditionBean to set
     */
    public void setConditionBean(ConditionBean conditionBean) {
        this.conditionBean = conditionBean;
    }


    
    /**
     * @return the orderKey
     */
    public String getOrderKey() {
        return orderKey;
    }


    
    /**
     * @param orderKey the orderKey to set
     */
    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }


    
    /**
     * @return the order
     */
    public String getOrder() {
        return order;
    }


    
    /**
     * @param order the order to set
     */
    public void setOrder(String order) {
        this.order = order;
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
