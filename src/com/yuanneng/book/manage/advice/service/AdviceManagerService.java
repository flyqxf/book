/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.advice.service;

import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.manage.advice.dao.IAdviceManagerDao;
import com.yuanneng.book.manage.advice.entity.AdviceManagerBean;

public class AdviceManagerService implements CommonService {


    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IAdviceManagerDao iAdviceManagerDao;

    
    public List<AdviceManagerBean> getAdviceBean() {
        
        List<AdviceManagerBean> adviceManagerBeans=iAdviceManagerDao.getAdviceBean();
        
        return adviceManagerBeans;
    }
    
    public void updateBook(List<AdviceManagerBean> adviceManagerBeans) {
        
        iAdviceManagerDao.deleteAdviceBean();
        int i=0;
        for(AdviceManagerBean bean : adviceManagerBeans) {
            i=i+10;
            String id = String.valueOf(i);
            bean.setId(id);
            iAdviceManagerDao.insert(bean);
        }
    }
  
   
}
