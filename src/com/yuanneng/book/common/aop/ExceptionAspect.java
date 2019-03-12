package com.yuanneng.book.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import com.yuanneng.book.common.exception.BASEException;
import com.yuanneng.book.common.utils.Constant;

@Aspect
public class ExceptionAspect {

    private static final String MESSAGE = "异常发生.";

    /**
     * ACTION的方法开始日志
     * 
     * @param joinPoint 切点
     * @throws BASEException
     */
    @AfterThrowing(throwing = "e", pointcut = "(execution(* com.yuanneng.book..*Action.*(..))"
            + " && !execution(* com.yuanneng.book..*Action.get*(..))"
            + " && !execution(* com.yuanneng.book..*Action.set*(..)))"
            + " || execution(* com.yuanneng.book..*Service.*(..))")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) throws BASEException {
        // 抛出异常初次封装完毕的情况
        if (e instanceof BASEException) {
            // 什么也不做
            return;
        }
        // 抛出异常没有初次封装的情况
        StringBuilder sb = new StringBuilder();
        // 类名
        sb.append(joinPoint.getTarget().getClass().getName());
        // 方法名
        sb.append(Constant.DOT).append(joinPoint.getSignature().getName())
                .append(Constant.BRACKETS).append(Constant.COLON);
        // message
        sb.append(MESSAGE);
        // 抛出异常
        throw new BASEException(e, sb.toString(), joinPoint.getTarget().getClass());
    }
}
