/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.success.service;

import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.manage.success.dao.ISuccessManagerDao;
import com.yuanneng.book.manage.success.entity.SuccessManagerBean;

public class SuccessManagerService implements CommonService {


    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private ISuccessManagerDao iSuccessManagerDao;

    
    public List<SuccessManagerBean> getSuccessBean() {
        
        List<SuccessManagerBean> successManagerBeans=iSuccessManagerDao.getSuccessBean();
        
        return successManagerBeans;
    }
    
    public void updateBook(List<SuccessManagerBean> successManagerBeans) {
        
        iSuccessManagerDao.deleteSuccessBean();
        int i=0;
        for(SuccessManagerBean bean : successManagerBeans) {
            i=i+10;
            String id = String.valueOf(i);
            bean.setId(id);
            iSuccessManagerDao.insert(bean);
        }
    }
  
   
}
