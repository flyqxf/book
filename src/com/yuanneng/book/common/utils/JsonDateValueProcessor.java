package com.yuanneng.book.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * JsonDateValueProcessor.java
 * 
 * 功 能： Json格式对象的转换
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.12         shanjixiang            新规做成
 * </pre>
 */
public class JsonDateValueProcessor implements JsonValueProcessor {

    /**
     * 对象中日期转换模板
     */
    private String format = "yyyy-MM-dd HH:mm:ss";

    /**
     * 构造函数
     */
    public JsonDateValueProcessor() {
        super();
    }

    /**
     * 构造函数
     * 
     * @param format 对象中日期转换模板
     */
    public JsonDateValueProcessor(String format) {
        super();
        this.format = format;
    }

    /**
     * 
     */
    @Override
    public Object processArrayValue(Object paramObject, JsonConfig paramJsonConfig) {
        return process(paramObject);
    }

    /**
     * 
     */
    @Override
    public Object processObjectValue(String paramString, Object paramObject,
            JsonConfig paramJsonConfig) {
        return process(paramObject);
    }

    /**
     * 
     * @param value
     * @return
     */
    private Object process(Object value) {
        if (value instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return sdf.format(value);
        }
        return value == null ? "" : value.toString();
    }

}
