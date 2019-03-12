/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.advice.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.advice.entity.AdviceManagerBean;
import com.yuanneng.book.manage.advice.service.AdviceManagerService;


public class UpdateAdviceAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private AdviceManagerService adviceManagerService = null;

    
    private List<AdviceManagerBean> adviceManagerBeans = null;
    
    private int size = 0;
    
    
    private List<AdviceManagerBean> adviceList = null;
    
    private String msg = null;
    


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
       
        if(adviceList != null && adviceList.size() != 0) {
            adviceManagerService.updateBook(adviceList);
            msg = "更新成功";
        }
        adviceManagerBeans = adviceManagerService.getAdviceBean();
        if(adviceManagerBeans == null) {
            adviceManagerBeans = new ArrayList<AdviceManagerBean>();
        }
        size = adviceManagerBeans.size();
        return SUCCESS;
        
    }
    

    
    
    /**
     * @return the adviceManagerBeans
     */
    public List<AdviceManagerBean> getAdviceManagerBeans() {
        return adviceManagerBeans;
    }



    
    /**
     * @param adviceManagerBeans the adviceManagerBeans to set
     */
    public void setAdviceManagerBeans(List<AdviceManagerBean> adviceManagerBeans) {
        this.adviceManagerBeans = adviceManagerBeans;
    }



    
    /**
     * @return the adviceList
     */
    public List<AdviceManagerBean> getAdviceList() {
        return adviceList;
    }



    
    /**
     * @param adviceList the adviceList to set
     */
    public void setAdviceList(List<AdviceManagerBean> adviceList) {
        this.adviceList = adviceList;
    }



    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
  
    
}
