/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.bookScan.action;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.bookScan.entity.BookDetailBean;
import com.yuanneng.book.bookScan.service.BookScanService;
import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;


/**
 * bookScanAction.java
 * 
 * 功 能： 安全检测任务检索初期页面显示Action
 * 
 * <pre>
 * ver       修订日             作者          修订内容
 * ---------------------------------------------------
 * 1.0     2016.03.30         qinxiaofei      初期做成
 * </pre>
 */
public class PartTouristAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    /**
     * 注入的Service层
     */
    @Resource
    public BookScanService bookScanService;
 
    private String id = null;
    
    private String logTime= null;
    
    private String userName= null;
    
    private BookDetailBean partBean= null;
    
    /**
     * 书籍检索
     */
    @Override
    public String doMain() {

     // 获取session
        HttpSession session = this.getSession();
        
        @SuppressWarnings("unchecked")
        Map<String,BookDetailBean> partMap = (Map<String, BookDetailBean>) session.getAttribute(Constant.BOOK_PART);
        
        partBean = partMap.get(id);
        partBean.setPath(PropertyUtil.getProperty("neirongPath"));
        return SUCCESS;

    }

    
    /**
     * @return the logTime
     */
    public String getLogTime() {
        return logTime;
    }

    
    /**
     * @param logTime the logTime to set
     */
    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }


    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }


    
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }


    
    /**
     * @return the partBean
     */
    public BookDetailBean getPartBean() {
        return partBean;
    }


    
    /**
     * @param partBean the partBean to set
     */
    public void setPartBean(BookDetailBean partBean) {
        this.partBean = partBean;
    }
    
    

}
