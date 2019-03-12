package com.yuanneng.book.common.exception;

import javax.annotation.Resource;

import com.yuanneng.book.common.utils.MessageHelper;

public class BASEException extends Exception {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 错误消息
     */
    private String message = null;

    /**
     * 错误消息ID
     */
    private String messageId = null;

    /**
     * message生成用类
     */
    @Resource
    protected MessageHelper messageHelper;

    /**
     * 异常发生的类
     */
    private Class<? extends Object> clazz = null;

    /**
     * 构造函数
     * 
     * @param cause 发生原因
     * @param errorCode 错误信息编号
     */
    public BASEException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    /**
     * 构造函数
     * 
     * @param cause 发生原因
     * @param errorCode 错误信息编号
     */
    public BASEException(String messageId, Throwable cause) {
        super(cause);
        this.messageId = messageId;
        this.message = messageHelper.getMessage(messageId, new String[] {});

    }

    /**
     * 构造函数
     * 
     * @param cause 发生原因
     * @param errorCode 错误信息编号
     */
    public BASEException(Throwable cause, String messageId, Object[] args) {
        super(cause);
        this.messageId = messageId;
        this.message = messageHelper.getMessage(messageId, args);

    }

    /**
     * 构造函数
     * 
     * @param cause 发生原因
     * @param message 错误消息
     * @param clazz 异常发生的类
     */
    public BASEException(Throwable cause, String message, Class<? extends Object> clazz) {
        this(cause, message);
        this.clazz = clazz;
    }

    /**
     * @return 错误消息
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * @param message 错误消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * @return 错误消息ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 
     * @param messageId 错误消息ID
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * @return 异常发生的类
     */
    public Class<? extends Object> getClazz() {
        return clazz;
    }

    /**
     * @param clazz 异常发生的类
     */
    public void setClazz(Class<? extends Object> clazz) {
        this.clazz = clazz;
    }

}
