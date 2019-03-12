/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.wenzhang.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.wenzhang.entity.WenzhangBean;
import com.yuanneng.book.manage.wenzhang.service.WenzhangService;



public class Tab2WenzhangAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private WenzhangService wenzhangService = null;
    private List<WenzhangBean> wenzhangList = null;
    private WenzhangBean bean = null;
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

        wenzhangList=wenzhangService.getWenzhang(bean);
        
        CommonPageLinksBean<WenzhangBean> result = new CommonPageLinksBean<WenzhangBean>();
        indexProperty = Constant.STRING_ZERO;
        result.setResultList(wenzhangList);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        result.setTotalProperty(String.valueOf(wenzhangList.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        
        HttpSession session = this.getSession();
        session.setAttribute("wenzhangList", result);
        session.setAttribute("wenzhangCondition", bean);
        
        return SUCCESS;
        
    }


    
    /**
     * @return the wenzhangList
     */
    public List<WenzhangBean> getWenzhangList() {
        return wenzhangList;
    }


    
    /**
     * @param wenzhangList the wenzhangList to set
     */
    public void setWenzhangList(List<WenzhangBean> wenzhangList) {
        this.wenzhangList = wenzhangList;
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
    public WenzhangBean getBean() {
        return bean;
    }



    
    /**
     * @param bean the bean to set
     */
    public void setBean(WenzhangBean bean) {
        this.bean = bean;
    }
    
    
}
