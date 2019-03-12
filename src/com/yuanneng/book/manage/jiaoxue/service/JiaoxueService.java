/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.jiaoxue.service;

import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.manage.jiaoxue.dao.IJiaoxueDao;
import com.yuanneng.book.manage.jiaoxue.entity.BookBean;

public class JiaoxueService implements CommonService {


    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IJiaoxueDao iJiaoxueDao;

    
    public List<BookBean> getBookDetailBean() {
        
        List<BookBean> bookBeans=iJiaoxueDao.getBookBean();
        
        return bookBeans;
    }
    
    public void updateBook(List<BookBean> books) {
        
        iJiaoxueDao.deleteBooks();
        int i=0;
        for(BookBean bean : books) {
            i++;
            String id = String.valueOf(i);
            bean.setId(id);
            iJiaoxueDao.insert(bean);
        }
    }
  
   
}
