package com.yuanneng.book.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * AppUtil.java
 * 
 * 功 能： 业务共通Utils
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.27         梅琼            新规做成
 * </pre>
 */
public class AppUtil implements ApplicationContextAware {

    private static ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext paramApplicationContext)
            throws BeansException {
        appContext = paramApplicationContext;
    }

    public static Object getBean(String paramString) {
        return appContext.getBean(paramString);
    }
}
