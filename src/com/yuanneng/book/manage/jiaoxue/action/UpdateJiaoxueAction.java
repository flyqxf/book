/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.jiaoxue.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.jiaoxue.entity.BookBean;
import com.yuanneng.book.manage.jiaoxue.service.JiaoxueService;



public class UpdateJiaoxueAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private JiaoxueService jiaoxueService = null;

    
    private List<BookBean> bookBeans = null;
    
    private int size = 0;
    
    
    private List<BookBean> jiaoxueList = null;
    
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
       
        if(jiaoxueList != null && jiaoxueList.size() != 0) {
            jiaoxueService.updateBook(jiaoxueList);
            msg = "更新成功";
        }
        bookBeans = jiaoxueService.getBookDetailBean();
        if(bookBeans == null) {
            bookBeans = new ArrayList<BookBean>();
        }
        size = bookBeans.size();
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
     * @return the jiaoxueList
     */
    public List<BookBean> getJiaoxueList() {
        return jiaoxueList;
    }



    
    /**
     * @param jiaoxueList the jiaoxueList to set
     */
    public void setJiaoxueList(List<BookBean> jiaoxueList) {
        this.jiaoxueList = jiaoxueList;
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
