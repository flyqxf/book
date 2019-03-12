/*
 * @(#)UserLoginServer.java
 */
package com.yuanneng.book.advice.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.advice.dao.IAdviceDao;
import com.yuanneng.book.advice.entity.AdviceBean;
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
public class AdvieService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(AdvieService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IAdviceDao iAdviceDao;

    

    /**
     * 查询书籍内容
     * @param bookId
     * @return
     * @throws Exception
     */


    public List<AdviceBean> getAdviceTopic() {
        List <AdviceBean> adviceTopics = iAdviceDao.getAdviceTopic();
        return adviceTopics;
    }

}
