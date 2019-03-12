/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.systemInfo.service;

import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.manage.systemInfo.dao.ISystemInfoDao;
import com.yuanneng.book.manage.systemInfo.entity.SystemInfoBean;


public class SystemInfoService implements CommonService {


    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private ISystemInfoDao iSystemInfoDao;

    
    public List<SystemInfoBean> getSystemInfo(SystemInfoBean bean) {
        
        List<SystemInfoBean> systemInfo = iSystemInfoDao.getSystemInfo(bean);
        
        
        return systemInfo;
    }
    
   

}
