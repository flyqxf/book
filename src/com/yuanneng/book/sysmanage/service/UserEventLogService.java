/*
 * @(#)UserEventLogService.java
 */
package com.yuanneng.book.sysmanage.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.sysmanage.dao.IUserDisplayDao;
import com.yuanneng.book.sysmanage.entity.UserEventLogBean;

/**
 * addOrgServer.java
 * 
 * 功 能：对用户日志操作的service
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.05.11         shanjixiang        新规做成
 * </pre>
 */
public class UserEventLogService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(UserEventLogService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    public IUserDisplayDao iuserDisplayDao;

    /**
     * 添加用户登录日志
     * 
     * @param userLog 添加参数
     * @return 返回结果
     */
    public int addUserLog(UserEventLogBean userLog) {

        return iuserDisplayDao.addUserLog(userLog);
    }

    /**
     * 查询用户登录日志
     * 
     * @param userLog 添加参数
     * @return 返回结果
     */
    public UserEventLogBean selectUserLog(UserEventLogBean userLog) {

        return iuserDisplayDao.selectUserLog(userLog);
    }

}
