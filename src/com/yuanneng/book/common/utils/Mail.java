package com.yuanneng.book.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class Mail {

    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

    private static final String TRUE = "true";

    private static final String MAIL_SMTP_HOST = "mail.smtp.host";

    private static final String MAIL_USER = "mail.user";

    private static final String MAIL_PASSWORD = "mail.password";

    private static final String CHAR_SET = "text/html;charset=UTF-8";

    private static final String FROM_PERSONAL = PropertyUtil
            .getProperty(Constant.EMAIL_FROM_PERSONAL);

    /**
     * 
     * @param smtp SMTP服务器
     * @param to 收件人
     * @param copyto 抄送人
     * @param sCopyto 秘密抄送人
     * @param title 邮件主题
     * @param content 邮件内容
     * @param username 发件人登录名
     * @param password 密码
     * @throws MessagingException 发送邮件异常
     * @throws UnsupportedEncodingException
     */
    public static void sendMail(String smtp, String to, String copyto, String sCopyto,
            String title, String content, String username, String password)
            throws MessagingException, UnsupportedEncodingException {
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        // TODO 不知道做什么用的
        /*
         * 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host /
         * mail.user / mail.from
         */
        // 表示SMTP发送邮件，需要进行身份验证
        props.put(MAIL_SMTP_AUTH, TRUE);
        props.put(MAIL_SMTP_HOST, smtp);
        // 发件人的账号
        props.put(MAIL_USER, username);
        // 访问SMTP服务时需要提供的密码
        props.put(MAIL_PASSWORD, password);

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty(MAIL_USER);
                String password = props.getProperty(MAIL_PASSWORD);
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress from = new InternetAddress(props.getProperty(MAIL_USER));
        from.setPersonal(MimeUtility.encodeText(FROM_PERSONAL));
        message.setFrom(from);

        // 设置收件人
        InternetAddress toUser = new InternetAddress(to);
        message.setRecipient(RecipientType.TO, toUser);

        if (copyto != null) {
            // 设置抄送
            InternetAddress cc = new InternetAddress(copyto);
            message.setRecipient(RecipientType.CC, cc);
        }

        // 设置密送，其他的收件人不能看到密送的邮件地址
        InternetAddress bcc = new InternetAddress("aaaaa@163.com");
        message.setRecipient(RecipientType.BCC, bcc);

        // 设置邮件标题
        message.setSubject(title);

        // 设置邮件的内容体
        message.setContent(content, CHAR_SET);

        // 发送邮件
        Transport.send(message);

    }
}
