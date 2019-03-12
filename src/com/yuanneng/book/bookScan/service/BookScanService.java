/*
 * @(#)UserLoginServer.java
 */
package com.yuanneng.book.bookScan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.bookScan.dao.IBookScanDao;
import com.yuanneng.book.bookScan.entity.BookDetailBean;
import com.yuanneng.book.common.service.CommonService;


/**
 * UserLoginServer.java
 * 
 * 功 能： UserLoginAction的service
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.13         shanjixiang        新规做成
 * </pre>
 */
public class BookScanService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(BookScanService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IBookScanDao iBookScanDao;

    private Map<String,BookDetailBean> partMap = new HashMap<String,BookDetailBean>();

    /**
     * 查询书籍内容
     * @param bookId
     * @return
     * @throws Exception
     */


    public List<BookDetailBean> getBookDetail() {
        List <BookDetailBean> bookDetailBeans = iBookScanDao.getBookDirectory();
        return bookDetailBeans;
    }
    
    /**
     * 页面显示用数据构建
     * @param bookId
     * @return
     */
    public Map<String,List<BookDetailBean>> getBookContent(List<BookDetailBean> bookDetailBeans) {
        Map<String,List<BookDetailBean>> bookDirectoryMap = new HashMap<String,List<BookDetailBean>>();
        for(BookDetailBean bookDetailBean:bookDetailBeans) {
            String chapter = bookDetailBean.getChapter();
            if(!bookDirectoryMap.containsKey(chapter)) {
                //同一章的内容保存用List
                List<BookDetailBean> bookDetailBeanList = new ArrayList<BookDetailBean>();
                bookDetailBeanList.add(bookDetailBean);
                bookDirectoryMap.put(chapter, bookDetailBeanList);
            }else {
                List<BookDetailBean> bookDetailBeanList = bookDirectoryMap.get(chapter);
                bookDetailBeanList.add(bookDetailBean);
                
            }
        }
        return bookDirectoryMap;
    }
    
    /**
     * 目录信息
     * @param bookDetailBeans
     * @return
     */
    public List<String> getBookDirectory (List<BookDetailBean> bookDetailBeans) {
        List<String> chapters = new ArrayList<String>();
        for(BookDetailBean bookDetailBean:bookDetailBeans) {
            String chapter = bookDetailBean.getChapter();
            if(!chapters.contains(chapter)) {
                chapters.add(chapter);
            }
            partMap.put(bookDetailBean.getId(), bookDetailBean);
        }
        return chapters;
    }
    
    public  Map<String,BookDetailBean> getPart() {
        return partMap;
    }
    
}
