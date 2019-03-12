/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.advice.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.yuanneng.book.advice.entity.AdviceBean;
import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;


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
public class AdviceDetailAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
 
    private String id = null;
    
    private AdviceBean adviceBean = null;
    
    private AdviceBean preAdviceBean =null;
    
    private AdviceBean nextAdviceBean =null;
    
    
    /**
     * 康复指导详细信息取得
     */
    @Override
    public String doMain() {

        
        /** 将结果放入session中 */
        HttpSession session = this.getSession();
        
        @SuppressWarnings("unchecked")
        CommonPageLinksBean<AdviceBean> result = (CommonPageLinksBean<AdviceBean>) session.getAttribute(Constant.ADVICE_LIST);
        
        List<AdviceBean> adviceTopics = result.getResultList();
        
        for(int i = 0;i<adviceTopics.size();i++) {
            AdviceBean bean = adviceTopics.get(i);
            String adviceId = bean.getId();
            if(adviceId.equals(id)) {
                adviceBean = bean;
                if(i>0) {
                    preAdviceBean = adviceTopics.get(i-1);
                }
                if(i<adviceTopics.size()-1) {
                    nextAdviceBean = adviceTopics.get(i+1);
                }
            }
        }
        adviceBean.setPath(PropertyUtil.getProperty("advicePath"));

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
     * @return the adviceBean
     */
    public AdviceBean getAdviceBean() {
        return adviceBean;
    }


    
    /**
     * @param adviceBean the adviceBean to set
     */
    public void setAdviceBean(AdviceBean adviceBean) {
        this.adviceBean = adviceBean;
    }



    
    /**
     * @return the preAdviceBean
     */
    public AdviceBean getPreAdviceBean() {
        return preAdviceBean;
    }



    
    /**
     * @param preAdviceBean the preAdviceBean to set
     */
    public void setPreAdviceBean(AdviceBean preAdviceBean) {
        this.preAdviceBean = preAdviceBean;
    }



    
    /**
     * @return the nextAdviceBean
     */
    public AdviceBean getNextAdviceBean() {
        return nextAdviceBean;
    }



    
    /**
     * @param nextAdviceBean the nextAdviceBean to set
     */
    public void setNextAdviceBean(AdviceBean nextAdviceBean) {
        this.nextAdviceBean = nextAdviceBean;
    }

   
 

}
