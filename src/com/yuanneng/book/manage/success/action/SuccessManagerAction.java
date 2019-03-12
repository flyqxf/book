/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.success.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.success.entity.SuccessManagerBean;
import com.yuanneng.book.manage.success.service.SuccessManagerService;

public class SuccessManagerAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private SuccessManagerService successManagerService = null;

    
    private List<SuccessManagerBean> successManagerBeans = null;
    
    private int size = 0;
    
    private String path=null;


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
       
        successManagerBeans = successManagerService.getSuccessBean();
        if(successManagerBeans == null) {
            successManagerBeans = new ArrayList<SuccessManagerBean>();
        }
        size = successManagerBeans.size();
        path=PropertyUtil.getProperty("successPath");
        
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
     * @return the path
     */
    public String getPath() {
        return path;
    }


    
    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    
}
