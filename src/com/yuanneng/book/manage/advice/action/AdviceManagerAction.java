/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.advice.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.advice.entity.AdviceManagerBean;
import com.yuanneng.book.manage.advice.service.AdviceManagerService;

public class AdviceManagerAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private AdviceManagerService adviceManagerService = null;

    
    private List<AdviceManagerBean> adviceManagerBeans = null;
    
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
       
        adviceManagerBeans = adviceManagerService.getAdviceBean();
        if(adviceManagerBeans == null) {
            adviceManagerBeans = new ArrayList<AdviceManagerBean>();
        }
        size = adviceManagerBeans.size();
        path=PropertyUtil.getProperty("advicePath");
        
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
