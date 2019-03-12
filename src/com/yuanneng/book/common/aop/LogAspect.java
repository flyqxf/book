package com.yuanneng.book.common.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.yuanneng.book.common.log.LogHelper;
import com.yuanneng.book.common.utils.Constant;

@Aspect
public class LogAspect {

    // 本地日志记录对象
    private static Log log = LogFactory.getLog(LogAspect.class);

    /**
     * ACTION的方法开始日志
     * 
     * @param joinPoint 切点
     */
    @Before("execution(* com.yuanneng.book..*Action.*(..))"
            + "&& !execution(* com.yuanneng.book..*Action.get*(..))"
            + "&& !execution(* com.yuanneng.book..*Action.set*(..))")
    public void doActionBefore(JoinPoint joinPoint) {
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = (joinPoint.getSignature().getName()).concat(Constant.BRACKETS);
        // 输出内容
        String msg = className.concat(Constant.DOT).concat(methodName).concat(Constant.LOG_START);
        // 开始日志输出
        LogHelper.info(log, msg);
    }

    /**
     * ACTION的方法结束日志
     * 
     * @param joinPoint 切点
     */
    @AfterReturning("execution(* com.yuanneng.book..*Action.*(..))"
            + "&& !execution(* com.yuanneng.book..*Action.get*(..))"
            + "&& !execution(* com.yuanneng.book..*Action.set*(..))")
    public void doActionAfterReturning(JoinPoint joinPoint) {
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = (joinPoint.getSignature().getName()).concat(Constant.BRACKETS);
        // 输出内容
        String msg = className.concat(Constant.DOT).concat(methodName).concat(Constant.LOG_END);
        // 开始日志输出
        LogHelper.info(log, msg);
    }

    /**
     * SERVICE的方法开始日志
     * 
     * @param joinPoint 切点
     */
    @Before("execution(* com.yuanneng.book..*Service.*(..))")
    public void doServiceBefore(JoinPoint joinPoint) {
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = (joinPoint.getSignature().getName()).concat(Constant.BRACKETS);
        // 输出内容
        String msg = className.concat(Constant.DOT).concat(methodName).concat(Constant.LOG_START);
        // 开始日志输出
        LogHelper.info(log, msg);
    }

    /**
     * SERVICE的方法结束日志
     * 
     * @param joinPoint 切点
     */
    @AfterReturning("execution(* com.yuanneng.book..*Service.*(..))")
    public void doServiceAfterReturning(JoinPoint joinPoint) {
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = (joinPoint.getSignature().getName()).concat(Constant.BRACKETS);
        // 输出内容
        String msg = className.concat(Constant.DOT).concat(methodName).concat(Constant.LOG_END);
        // 开始日志输出
        LogHelper.info(log, msg);
    }
}
