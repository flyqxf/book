/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.sale.action;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.sale.entity.ConditionBean;
import com.yuanneng.book.manage.sale.entity.SaleBean;
import com.yuanneng.book.manage.sale.service.SaleService;



public class SaleAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private SaleService saleService = null;
    
    private String showflg="1";
    
    private String indexProperty;
    
    private ConditionBean conditionBean = new ConditionBean();
    
    private List<SaleBean> saleBeans = null;


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
       
        saleBeans = saleService.getSaleBean(conditionBean);
        
        CommonPageLinksBean<SaleBean> result = new CommonPageLinksBean<SaleBean>();
        indexProperty = Constant.STRING_ZERO;
        result.setResultList(saleBeans);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        result.setTotalProperty(String.valueOf(saleBeans.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        //
        /** 将结果放入session中 */
        HttpSession session = this.getSession();
        session.setAttribute("saleList", result);
        session.setAttribute("saleCondition", conditionBean);
        
        return SUCCESS;
        
    }


    
    /**
     * @return the saleService
     */
    public SaleService getSaleService() {
        return saleService;
    }


    
    /**
     * @param saleService the saleService to set
     */
    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
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
     * @return the saleBeans
     */
    public List<SaleBean> getSaleBeans() {
        return saleBeans;
    }


    
    /**
     * @param saleBeans the saleBeans to set
     */
    public void setSaleBeans(List<SaleBean> saleBeans) {
        this.saleBeans = saleBeans;
    }

    
  
    
}
