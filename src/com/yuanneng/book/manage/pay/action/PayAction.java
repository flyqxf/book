/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.pay.action;


import com.yuanneng.book.common.action.CommonAction;




public class PayAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
//    @Resource
//    private PayService payService = null;
//    
//    private String indexProperty;
//    
//    private PayBean1 bean = new PayBean1();
//    
//    private List<PayBean1> payBeans = null;


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
       
//        payBeans = payService.getPayBean(bean);
//        
//        CommonPageLinksBean<PayBean1> result = new CommonPageLinksBean<PayBean1>();
//        indexProperty = Constant.STRING_ZERO;
//        result.setResultList(payBeans);
//        result.setIndexProperty(indexProperty);
//        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
//        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
//        result.setTotalProperty(String.valueOf(payBeans.size()));
//        result.setEndProperty(BusinessUtils.getEndProperty(result));
//        //
//        /** 将结果放入session中 */
//        HttpSession session = this.getSession();
//        session.setAttribute("payList", result);
//        session.setAttribute("payCondition", bean);
        
        
        return SUCCESS;
        
    }


//    
//    /**
//     * @return the indexProperty
//     */
//    public String getIndexProperty() {
//        return indexProperty;
//    }
//
//
//    
//    /**
//     * @param indexProperty the indexProperty to set
//     */
//    public void setIndexProperty(String indexProperty) {
//        this.indexProperty = indexProperty;
//    }
//
//
//    
//    /**
//     * @return the bean
//     */
//    public PayBean1 getBean() {
//        return bean;
//    }
//
//
//    
//    /**
//     * @param bean the bean to set
//     */
//    public void setBean(PayBean1 bean) {
//        this.bean = bean;
//    }
//
//
//    
//    /**
//     * @return the payBeans
//     */
//    public List<PayBean1> getPayBeans() {
//        return payBeans;
//    }
//
//
//    
//    /**
//     * @param payBeans the payBeans to set
//     */
//    public void setPayBeans(List<PayBean1> payBeans) {
//        this.payBeans = payBeans;
//    }
//
//
//    
//  
    
}
