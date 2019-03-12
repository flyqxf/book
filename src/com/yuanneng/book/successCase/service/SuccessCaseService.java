/*
 * @(#)UserLoginServer.java
 */
package com.yuanneng.book.successCase.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.successCase.dao.ISuccessCaseDao;
import com.yuanneng.book.successCase.entity.SuccessBeanBean;


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
public class SuccessCaseService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(SuccessCaseService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private ISuccessCaseDao iSuccessCaseDao;

    

    /**
     * 查询书籍内容
     * @param bookId
     * @return
     * @throws Exception
     */


    public List<SuccessBeanBean> getSuccessCase() {
        List <SuccessBeanBean> adviceTopics = iSuccessCaseDao.getSuccessCase();
        return adviceTopics;
    }

}
