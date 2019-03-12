/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.success.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.success.entity.SuccessManagerBean;
import com.yuanneng.book.manage.success.service.SuccessManagerService;


public class UpdateSuccessAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private SuccessManagerService successManagerService = null;

    
    private List<SuccessManagerBean> successManagerBeans = null;
    
    private int size = 0;
    
    
    private List<SuccessManagerBean> successList = null;
    
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
       
        if(successList != null && successList.size() != 0) {
            successManagerService.updateBook(successList);
            msg = "更新成功";
        }
        successManagerBeans = successManagerService.getSuccessBean();
        if(successManagerBeans == null) {
            successManagerBeans = new ArrayList<SuccessManagerBean>();
        }
        size = successManagerBeans.size();
        return SUCCESS;
        
    }
    

    
    
    /**
     * @return the successManagerBeans
     */
    public List<SuccessManagerBean> getSuccessManagerBeans() {
        return successManagerBeans;
    }



    
    /**
     * @param successManagerBeans the successManagerBeans to set
     */
    public void setSuccessManagerBeans(List<SuccessManagerBean> successManagerBeans) {
        this.successManagerBeans = successManagerBeans;
    }



    
    /**
     * @return the successList
     */
    public List<SuccessManagerBean> getSuccessList() {
        return successList;
    }



    
    /**
     * @param successList the successList to set
     */
    public void setSuccessList(List<SuccessManagerBean> successList) {
        this.successList = successList;
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
