package com.yuanneng.book.common.entity;

public class VulNewsSubConfigBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id = null;

    /**
     * 是否自动发送邮件
     */
    private String autoSendMail = null;

    /**
     * 名字
     */
    private String name = null;

    /**
     * 邮件地址
     */
    private String mailAddress = null;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return 是否自动发送邮件
     */
    public String getAutoSendMail() {
        return autoSendMail;
    }

    /**
     * @param autoSendMail 是否自动发送邮件
     */
    public void setAutoSendMail(String autoSendMail) {
        this.autoSendMail = autoSendMail;
    }

    /**
     * @return 名字
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 邮件地址
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * @param mailAddress 邮件地址
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

}
