/*
 * @(#)LogHelper.java
 */
package com.yuanneng.book.common.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.MDC;

import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.exception.BASEException;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.sysmanage.entity.UserBean;

/**
 * LogHelper.java
 * 
 * 功 能： 输出日志用的类
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.12         meiqiong        新规做成
 * </pre>
 */
public class LogHelper {

    /**
     * 监视日志
     */
    private static Log alertLog = LogFactory.getLog(Constant.LOG_ALERT);

    /**
     * event日志
     */
    private static Log eventLog = LogFactory.getLog(Constant.LOG_EVENT);

    /**
     * ERROR关键字
     */
    public final static String ERROR = "error";

    /**
     * 用户ID的主键
     */
    public final static String USER_ID = "userId";

    /**
     * 用户ID的主键
     */
    public final static String IP = "ip";

    /**
     * 主机名的主键
     */
    public final static String HOST_NAME = "hostName";

    /**
     * 时间的主键
     */
    public final static String TIMER = "timer";

    /**
     * 输出DEBUG级别的日志
     */
    public static void debug(Log log, String message) {
        if (log.isDebugEnabled()) {
            // 取得UVO
            UserValueObject uvo = getUVO();
            // 日志输出
            MDC.put(HOST_NAME, BusinessUtils.getHostName());
            MDC.put(USER_ID, uvo.getUser().getUserId());
            MDC.put(IP, uvo.getLoginIp());
            log.debug(message);
            MDC.remove(HOST_NAME);
            MDC.remove(USER_ID);
            MDC.remove(IP);
        }
    }

    /**
     * 输出INFO级别的日志
     */
    public static void info(Log log, String message) {
        if (log.isInfoEnabled()) {
            // 取得UVO
            UserValueObject uvo = getUVO();
            // 日志输出
            MDC.put(HOST_NAME, BusinessUtils.getHostName());
            MDC.put(USER_ID, uvo.getUser().getUserId());
            MDC.put(IP, uvo.getLoginIp());
            log.info(message);
            MDC.remove(HOST_NAME);
            MDC.remove(USER_ID);
            MDC.remove(IP);
        }
    }

    /**
     * 输出WARN级别的日志
     */
    public static void warn(Log log, String message) {
        if (log.isWarnEnabled()) {
            // 取得UVO
            UserValueObject uvo = getUVO();
            // 日志输出
            MDC.put(HOST_NAME, BusinessUtils.getHostName());
            MDC.put(USER_ID, uvo.getUser().getUserId());
            MDC.put(IP, uvo.getLoginIp());
            log.warn(message);
            MDC.remove(HOST_NAME);
            MDC.remove(USER_ID);
            MDC.remove(IP);
        }
    }

    /**
     * 输出ERROR级别的日志
     */
    public static void error(Log log, String message) {
        if (log.isErrorEnabled()) {
            // 取得UVO
            UserValueObject uvo = getUVO();
            // 日志输出
            MDC.put(HOST_NAME, BusinessUtils.getHostName());
            MDC.put(USER_ID, uvo.getUser().getUserId());
            MDC.put(IP, uvo.getLoginIp());
            log.error(message);
            MDC.remove(HOST_NAME);
            MDC.remove(USER_ID);
            MDC.remove(IP);
        }
    }

    /**
     * 输出ERROR级别的日志
     */
    public static void error(Throwable e) {
        Log log = LogFactory.getLog(ERROR);
        if (log.isErrorEnabled()) {
            // 取得UVO
            UserValueObject uvo = getUVO();
            // 日志输出
            MDC.put(HOST_NAME, BusinessUtils.getHostName());
            MDC.put(USER_ID, uvo.getUser().getUserId());
            MDC.put(IP, uvo.getLoginIp());
            log.error(e.getMessage(), e);
            MDC.remove(HOST_NAME);
            MDC.remove(USER_ID);
            MDC.remove(IP);
        }
    }

    /**
     * 输出ERROR级别的日志
     */
    public static void error(BASEException e) {
        // 定义logger
        Log log = LogFactory.getLog(e.getClazz());
        if (log.isErrorEnabled()) {
            // 取得UVO
            UserValueObject uvo = getUVO();
            // 日志输出
            MDC.put(HOST_NAME, BusinessUtils.getHostName());
            MDC.put(USER_ID, uvo.getUser().getUserId());
            MDC.put(IP, uvo.getLoginIp());
            log.error(e.getMessage(), e);
            MDC.remove(HOST_NAME);
            MDC.remove(USER_ID);
            MDC.remove(IP);
        }
    }

    /**
     * 输出监视日志
     */
    public static void alert(Throwable e) {
        if (alertLog.isErrorEnabled()) {
            // 取得UVO
            UserValueObject uvo = getUVO();
            // 日志输出
            MDC.put(HOST_NAME, BusinessUtils.getHostName());
            MDC.put(USER_ID, uvo.getUser().getUserId());
            MDC.put(IP, uvo.getLoginIp());
            alertLog.error(e.getMessage(), e);
            MDC.remove(HOST_NAME);
            MDC.remove(USER_ID);
            MDC.remove(IP);
        }
    }

    /**
     * 输出event日志
     */
    public static void event(String timer, String message) {
        if (eventLog.isInfoEnabled()) {
            // 取得UVO
            UserValueObject uvo = getUVO();
            // 日志输出
            MDC.put(HOST_NAME, BusinessUtils.getHostName());
            MDC.put(USER_ID, uvo.getUser().getUserId());
            MDC.put(IP, uvo.getLoginIp());
            MDC.put(TIMER, timer);
            // TODO 具体的事件日志格式未定义,action名和中文事件名未定义
            eventLog.info(message);
            MDC.remove(HOST_NAME);
            MDC.remove(USER_ID);
            MDC.remove(IP);
            MDC.remove(TIMER);
        }
    }

    /**
     * 输出日志时,取不到VUO情况下的逻辑处理
     */
    private static UserValueObject getUVO() {
        // TODO
        UserValueObject uvo = null;
        try {
            uvo = BusinessUtils.getUVO();
        } catch (Exception e) {
            UserBean user = new UserBean();
            uvo = new UserValueObject();
            user.setUserId("testUser0001");
            String loginIp = "192.168.0.100";
            uvo.setLoginIp(loginIp);
            uvo.setUser(user);
            return uvo;
        }
        if (uvo == null) {
            uvo = new UserValueObject();
            // TODO 本地测试用
            UserBean user = new UserBean();
            user.setUserId("testUser0001");
            String loginIp = "192.168.0.100";
            uvo.setLoginIp(loginIp);
            uvo.setUser(user);
        }
        return uvo;
    }
}
