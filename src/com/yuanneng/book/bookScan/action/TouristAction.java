/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.bookScan.action;

import java.util.List;
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
public class TouristAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    /**
     * 注入的Service层
     */
    @Resource
    public BookScanService bookScanService;
 
    private String logTime= null;
    
    private String userName= null;
    
    
    /**
     * 书籍检索
     */
    @Override
    public String doMain() {

        //String bookId =  PropertyUtil.getProperty("bookId");
        List <BookDetailBean> bookDetailBeans = bookScanService.getBookDetail();
        Map<String,List<BookDetailBean>> bookDirectoryMap = bookScanService.getBookContent(bookDetailBeans);
        List<String> capters = bookScanService.getBookDirectory(bookDetailBeans);
        Map<String,BookDetailBean> partMap = bookScanService.getPart();
//        String maxScanCount = PropertyUtil.getProperty("maxScanCount");
        
        String canReadChapter = PropertyUtil.getProperty("canReadChapter");
        
//        Iterator<Entry<String, BookDetailBean>> it = partMap.entrySet().iterator();
//        while(it.hasNext()) {
//            Entry<String, BookDetailBean> map = it.next();
//            BookDetailBean bean = map.getValue();
//            String content = bean.getContent();
//            int scanCnt = Integer.parseInt(maxScanCount);
//            int maxlen = content.length();
//            if(maxlen>scanCnt) {
//                maxlen = scanCnt;
//            }
//            String contentS = content.substring(0, maxlen).concat("...请注册后浏览后续内容");
//            bean.setContent(contentS);
//        }
        
        
     // 获取session
        HttpSession session = this.getSession();
        
        session.setAttribute(Constant.BOOK_DETAIL, bookDirectoryMap);
        session.setAttribute(Constant.BOOK_DIRECTORY, capters);
        session.setAttribute(Constant.BOOK_PART, partMap);
        session.setAttribute("canReadChapter", canReadChapter);
        
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
    
    

}
