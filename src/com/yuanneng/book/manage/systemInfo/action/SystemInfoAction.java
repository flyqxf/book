/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.systemInfo.action;


import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.systemInfo.entity.SystemInfoBean;
import com.yuanneng.book.manage.systemInfo.service.SystemInfoService;



public class SystemInfoAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private SystemInfoService systemInfoService = null;
 
    private List<SystemInfoBean> systemInfoBeans = null;

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
       
        systemInfoBeans = systemInfoService.getSystemInfo(new SystemInfoBean());
        
        
        return SUCCESS;
        
    }

    
    /**
     * @return the systemInfoBeans
     */
    public List<SystemInfoBean> getSystemInfoBeans() {
        return systemInfoBeans;
    }

    
    /**
     * @param systemInfoBeans the systemInfoBeans to set
     */
    public void setSystemInfoBeans(List<SystemInfoBean> systemInfoBeans) {
        this.systemInfoBeans = systemInfoBeans;
    }

}
