/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.jiaoxue.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.jiaoxue.entity.BookBean;
import com.yuanneng.book.manage.jiaoxue.service.JiaoxueService;



public class JiaoxueAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private JiaoxueService jiaoxueService = null;

    
    private List<BookBean> bookBeans = null;
    
    private String path=null;
    
    private int size = 0;
    
    


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
       
        bookBeans = jiaoxueService.getBookDetailBean();
        if(bookBeans == null) {
            bookBeans = new ArrayList<BookBean>();
        }
        size = bookBeans.size();
        path=PropertyUtil.getProperty("neirongPath");
        
        return SUCCESS;
        
    }


 

    
    /**
     * @return the bookBeans
     */
    public List<BookBean> getBookBeans() {
        return bookBeans;
    }


    
    /**
     * @param bookBeans the bookBeans to set
     */
    public void setBookBeans(List<BookBean> bookBeans) {
        this.bookBeans = bookBeans;
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
