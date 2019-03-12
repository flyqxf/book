/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.wenzhang.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.manage.wenzhang.entity.WenzhangBean;
import com.yuanneng.book.manage.wenzhang.service.WenzhangService;



public class Tab1WenzhangAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private WenzhangService wenzhangService = null;
    private String id = null;
    private WenzhangBean bean = new WenzhangBean();
    
    


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
       
        if(!StringUtils.isEmpty(id)) {
            HttpSession session = this.getSession();
            @SuppressWarnings("unchecked")
            CommonPageLinksBean<WenzhangBean> result = (CommonPageLinksBean<WenzhangBean>) session.getAttribute("wenzhangList");
            List<WenzhangBean> lst = result.getResultList();
            for(WenzhangBean wBean: lst) {
                String wId = wBean.getId();
                if(id.equals(wId)) {
                    bean = wBean;
                    break;
                }
            }
        }
        
        
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
