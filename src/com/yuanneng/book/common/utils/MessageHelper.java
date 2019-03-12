package com.yuanneng.book.common.utils;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class MessageHelper {

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        String msg = messageSource.getMessage(code, args, defaultMessage, locale);
        return msg != null ? msg.trim() : msg;
    }

    public String getMessage(String code, Object[] args) {
        // TODO default值没有
        String msg = messageSource.getMessage(code, args, null, null);
        return msg != null ? msg.trim() : msg;
    }

    public String getMessage(String code) {
        // TODO
        String msg = messageSource.getMessage(code, null, null, null);
        return msg != null ? msg.trim() : msg;
    }

    public String getMessage(String code, String... args) {
        // TODO
        String msg = messageSource.getMessage(code, (Object[]) args, null, null);
        return msg != null ? msg.trim() : msg;
    }
}
