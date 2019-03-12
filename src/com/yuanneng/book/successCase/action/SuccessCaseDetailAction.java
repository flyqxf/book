/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.successCase.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.successCase.entity.SuccessBeanBean;


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
public class SuccessCaseDetailAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
 
    private String id = null;
    
    private SuccessBeanBean successBeanBean = null;
    
    private SuccessBeanBean preSuccessBeanBean = null;
    
    private SuccessBeanBean nextSuccessBeanBean = null;
    
    
    /**
     * 康复指导详细信息取得
     */
    @Override
    public String doMain() {

        
        /** 将结果放入session中 */
        HttpSession session = this.getSession();
        
        @SuppressWarnings("unchecked")
        CommonPageLinksBean<SuccessBeanBean> result = (CommonPageLinksBean<SuccessBeanBean>) session.getAttribute(Constant.SUCCESS_CASE_LIST);
        
        List<SuccessBeanBean> successBeanBeans = result.getResultList();
        
        for(int i = 0;i<successBeanBeans.size();i++) {
            SuccessBeanBean bean = successBeanBeans.get(i);
            String adviceId = bean.getId();
            if(adviceId.equals(id)) {
                successBeanBean = bean;
                if(i>0) {
                    preSuccessBeanBean = successBeanBeans.get(i-1);
                }
                if(i<successBeanBeans.size()-1) {
                    nextSuccessBeanBean = successBeanBeans.get(i+1);
                }
            }
        }
        successBeanBean.setPath(PropertyUtil.getProperty("successPath"));
        return SUCCESS;

    }


    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }


    
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }



    
    /**
     * @return the successBeanBean
     */
    public SuccessBeanBean getSuccessBeanBean() {
        return successBeanBean;
    }



    
    /**
     * @param successBeanBean the successBeanBean to set
     */
    public void setSuccessBeanBean(SuccessBeanBean successBeanBean) {
        this.successBeanBean = successBeanBean;
    }



    
    /**
     * @return the preSuccessBeanBean
     */
    public SuccessBeanBean getPreSuccessBeanBean() {
        return preSuccessBeanBean;
    }



    
    /**
     * @param preSuccessBeanBean the preSuccessBeanBean to set
     */
    public void setPreSuccessBeanBean(SuccessBeanBean preSuccessBeanBean) {
        this.preSuccessBeanBean = preSuccessBeanBean;
    }



    
    /**
     * @return the nextSuccessBeanBean
     */
    public SuccessBeanBean getNextSuccessBeanBean() {
        return nextSuccessBeanBean;
    }



    
    /**
     * @param nextSuccessBeanBean the nextSuccessBeanBean to set
     */
    public void setNextSuccessBeanBean(SuccessBeanBean nextSuccessBeanBean) {
        this.nextSuccessBeanBean = nextSuccessBeanBean;
    }

    
   
}
