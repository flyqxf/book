/*
 * @(#)CommonAction.java
 */
package com.yuanneng.book.common.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.MessageHelper;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.common.validator.ValidatorUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * CommonAction.java
 * 
 * 功 能： 所有ACTION的共同父类
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.29         meiqiong        新规做成
 * </pre>
 */
public abstract class CommonAction extends ActionSupport implements Preparable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 空格
     */
    private static final String stringBlank = " ";

    /**
     * message生成用类
     */
    @Resource
    protected MessageHelper messageHelper;

    /**
     * 共通的execute方法
     * <p>
     * 在执行逻辑之前和之后，有一些共通的处理
     * </p>
     * 
     * @return 处理结果
     * @exception Exception
     */
    @Override
    public final String execute() throws Exception {
        String result = null;
        // TODO start
        result = doMain();
        // TODO end
        return result;
    }

    /**
     * 抽象的doMain方法
     * <p>
     * 每个ACTION都在这里扩充自己的逻辑处理
     * </p>
     * 
     * @return 处理结果
     * @exception Exception
     */
    public abstract String doMain() throws Exception;

    /**
     * 取得session对象
     * <p>
     * 取得session对象
     * </p>
     * 
     * @return session对象
     */
    public HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 取得request对象
     * <p>
     * 取得request对象
     * </p>
     * 
     * @return session对象
     */
    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     * 取得response对象
     * <p>
     * 取得response对象
     * </p>
     * 
     * @return response对象
     */
    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    /**
     * validator和action主方法处理前，提前拦截处理
     * 
     * @throws Exception 例外
     */
    @Override
    public void prepare() throws Exception {
    }

    /**
     * 输入效验：必须输入效验
     * <p>
     * 输入项目的必须输入效验
     * </p>
     * 
     * @param item 效验的内容
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkRequired(String item, String field, String messageId, Object[] obj) {
        if (StringUtils.isEmpty(item)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * 输入效验：必须输入效验
     * <p>
     * 输入项目的必须输入效验
     * </p>
     * 
     * @param item 效验的内容
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkRequired(String item, Object[] obj) {
        return checkRequired(item, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0001E, obj);
    }

    /**
     * 时间不能为空校验
     * 
     * @param item 时间
     * @param obj message参数
     * @return 返回结果
     */
    public boolean checkDateRequired(Date item, Object[] obj) {
        if (item == null) {
            String msg = messageHelper.getMessage(Constant.BOOKZ0001E, obj);
            this.addFieldError(Constant.DEFAULT_FIELD_NAME, msg);
            return false;
        }
        return true;
    }

    /**
     * 检测前面的时间小于等于后面的时间
     * 
     * @param from 前面的时间
     * @param to 后面的时间
     * @param obj message参数
     * @return 返回结果
     */
    public boolean checkDateTime(Date from, Date to, Object[] obj) {
        if (from == null || to == null) {
            return true;
        }
        if (from.getTime() > to.getTime()) {
            String msg = messageHelper.getMessage(Constant.BOOKZ0002E, obj);
            this.addFieldError(Constant.DEFAULT_FIELD_NAME, msg);
            return false;
        }
        return true;
    }

    /**
     * 输入效验：长度效验
     * <p>
     * 输入项目的输入长度效验
     * </p>
     * 
     * @param item 效验的内容
     * @param min 最短长度
     * @param max 最长长度
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkLength(String item, int min, int max, String field, String messageId,
            Object[] obj) {
        if (!StringUtils.isEmpty(item)) {
            if (item.length() > max || item.length() < min) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
                return false;
            }
        }
        return true;
    }

    /**
     * 输入效验：长度效验
     * <p>
     * 输入项目的输入长度效验
     * </p>
     * 
     * @param item 效验的内容
     * @param min 最短长度
     * @param max 最长长度
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkLength(String item, int min, int max, String obj) {
        String[] msgAdd = new String[3];
        msgAdd[0] = obj;
        msgAdd[1] = String.valueOf(min);
        msgAdd[2] = String.valueOf(max);
        return checkLength(item, min, max, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0005E, msgAdd);
    }

    /**
     * 验证数组ips内是否都是IP地址，是否有重复IP
     * 
     * @param ips 参数
     * @return 返回结果
     */
    public boolean checkIPS(List<String> ips) {
        if (ips == null) {
            return false;
        }
        for (int i = 0; i < ips.size(); i++) {
            /** 验证ip */
            if (!ValidatorUtils.isValidIpAddr(ips.get(i))) {
                return false;
            }
            /** 查找重复IP */
            for (int j = 0; j < ips.size(); j++) {
                if (i != j && ips.get(i).equals(ips.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 输入效验：长度效验
     * <p>
     * 输入项目的输入长度效验
     * </p>
     * 
     * @param item 效验的内容
     * @param max 最长长度
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkLength(String item, int max, String field, String messageId, Object[] obj) {
        if (!StringUtils.isEmpty(item)) {
            if (item.length() > max) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
                return false;
            }
        }
        return true;
    }

    /**
     * 输入效验：长度效验
     * <p>
     * 输入项目的输入长度效验
     * </p>
     * 
     * @param item 效验的内容
     * @param max 最长长度
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkLength(String item, int max, String obj) {
        String[] msgAdd = new String[3];
        msgAdd[0] = obj;
        msgAdd[1] = String.valueOf(max);
        return checkLength(item, max, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0006E, msgAdd);
    }

    /**
     * 输入效验：固定长度效验
     * <p>
     * 输入项目的输入固定长度效验
     * </p>
     * 
     * @param item 效验的内容
     * @param length 固定长度
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkEqualLen(String item, int length, String field, String messageId,
            Object[] obj) {
        if (!StringUtils.isEmpty(item)) {
            if (item.length() != length) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
                return false;
            }
        }
        return true;
    }

    /**
     * 输入效验：固定长度效验
     * <p>
     * 输入项目的输入固定长度效验
     * </p>
     * 
     * @param item 效验的内容
     * @param length 固定长度
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkEqualLen(String item, int length, String obj) {
        String[] msgAdd = new String[2];
        msgAdd[0] = obj;
        msgAdd[1] = String.valueOf(length);
        return checkEqualLen(item, length, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0020E, msgAdd);
    }

    /**
     * 输入效验：邮箱格式效验
     * <p>
     * 输入项目的邮箱格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkEmail(String item, String field, String messageId, Object[] obj) {
        if (!StringUtils.isEmpty(item)) {
            if (!ValidatorUtils.isValidMailAddr(item)) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
                return false;
            }
        }
        return true;
    }

    /**
     * 输入效验：邮箱格式效验
     * <p>
     * 输入项目的邮箱格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkEmail(String item, Object[] obj) {
        return checkEmail(item, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0002E, obj);
    }

    /**
     * 输入效验：网卡地址格式效验
     * <p>
     * 输入项目的网卡地址格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkMac(String item, String field, String messageId, Object[] obj) {
        if (!StringUtils.isEmpty(item)) {
            if (!ValidatorUtils.isValidMacAddr(item)) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
                return false;
            }
        }
        return true;
    }

    /**
     * 输入效验：邮箱格式效验
     * <p>
     * 输入项目的邮箱格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkMac(String item, Object[] obj) {
        return checkMac(item, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0002E, obj);
    }

    /**
     * 输入效验：手机号格式效验
     * <p>
     * 输入项目的手机号格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkMobile(String item, String field, String messageId, Object[] obj) {
        if (!ValidatorUtils.isValidMobileNo(item)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * 输入效验：手机号格式效验
     * <p>
     * 输入项目的手机号格式效验
     * </p>
     * 
     * @param item 效验的内容
     * 
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkMobile(String item, Object[] obj) {
        return checkMobile(item, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0002E, obj);
    }

    /**
     * 输入效验：IP地址格式效验
     * <p>
     * 输入项目的IP地址格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkIpAddr(String item, String field, String messageId, Object[] obj) {
        if (!ValidatorUtils.isValidIpAddr(item)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * 输入效验：IP地址格式效验
     * <p>
     * 输入项目的IP地址格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkIpAddr(String item, Object[] obj) {
        return checkIpAddr(item, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0002E, obj);
    }

    /**
     * 输入效验：时间格式效验
     * <p>
     * 输入项目的时间格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkTime(String item, String field, String messageId, Object[] obj) {
        if (!ValidatorUtils.isValidTime(item)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * 输入效验：时间格式效验
     * <p>
     * 输入项目的时间格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkTime(String item, Object[] obj) {
        return checkTime(item, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0002E, obj);
    }

    /**
     * 输入效验：日期格式效验
     * <p>
     * 输入项目的日期格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkDate(String item, String field, String messageId, Object[] obj) {
        if (!ValidatorUtils.isValidDate(item)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * 输入效验：日期格式效验
     * <p>
     * 输入项目的日期格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkDate(String item, Object[] obj) {
        return checkDate(item, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0002E, obj);
    }

    /**
     * 输入效验：IP地址范围效验
     * <p>
     * 输入项目的IP地址范围效验
     * </p>
     * 
     * @param ipFrom IP地址开始
     * @param ipTo IP地址结束
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public void compareIpAddr(String ipFrom, String ipTo, String field, String messageId,
            Object[] obj) {
        if (!StringUtils.isEmpty(ipFrom) && !StringUtils.isEmpty(ipTo)) {
            if (!ValidatorUtils.isValidIpAddr(ipFrom, ipTo)) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
            }
        }
    }

    /**
     * 输入效验：IP地址范围效验
     * <p>
     * 输入项目的IP地址范围效验
     * </p>
     * 
     * @param ipFrom IP地址开始
     * @param ipTo IP地址结束
     * @param obj message补充文字
     * @return 效验结果
     */
    public void compareIpAddr(String ipFrom, String ipTo, Object[] obj) {
        compareIpAddr(ipFrom, ipTo, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0004E, obj);
    }

    /**
     * 输入效验：多个IP地址范围效验
     * <p>
     * 输入项目的IP地址范围效验
     * </p>
     * 
     * @param ipFrom IP地址开始
     * @param ipTo IP地址结束
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean compareIpTarget(String ipFrom, String ipTo, String field, String messageId,
            Object[] obj) {
        if (!StringUtils.isEmpty(ipFrom) && !StringUtils.isEmpty(ipTo)) {
            if (!ValidatorUtils.isValidIpAddr(ipFrom, ipTo)) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
                return false;
            }
        }
        return true;
    }

    /**
     * 输入效验：多个IP地址范围效验
     * <p>
     * 输入项目的IP地址范围效验
     * </p>
     * 
     * @param ipFrom IP地址开始
     * @param ipTo IP地址结束
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean compareIpTarget(String ipFrom, String ipTo, Object[] obj) {
        return compareIpTarget(ipFrom, ipTo, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0004E, obj);
    }

    /**
     * 输入效验：IP(From)或IP(To)存在效验
     * <p>
     * 输入项目的IPIP(From)或IP(To)存在效验
     * </p>
     * 
     * @param ipFrom IP地址开始
     * @param ipTo IP地址结束
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public void checkIpExist(String ipFrom, String ipTo, String field, String messageId,
            Object[] obj) {
        if ((StringUtils.isEmpty(ipFrom) && !StringUtils.isEmpty(ipTo))
                || (!StringUtils.isEmpty(ipFrom) && StringUtils.isEmpty(ipTo))) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
        }
    }

    /**
     * 输入效验：IP(From)或IP(To)存在效验
     * <p>
     * 输入项目的IP(From)或IP(To)存在效验
     * </p>
     * 
     * @param ipFrom IP地址开始
     * @param ipTo IP地址结束
     * @param obj message补充文字
     * @return 效验结果
     */
    public void checkIpExist(String ipFrom, String ipTo, Object[] obj) {
        checkIpExist(ipFrom, ipTo, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0002E, obj);
    }

    /**
     * 输入效验：IP(From)或IP(To)存在效验
     * <p>
     * 输入项目的IPIP(From)或IP(To)存在效验
     * </p>
     * 
     * @param ipFrom IP地址开始
     * @param ipTo IP地址结束
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public void checkFile(String field, String messageId, Object[] obj) {
        if (!StringUtils.isEmpty(field)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
        }
    }

    /**
     * 输入效验：IP(From)或IP(To)存在效验
     * <p>
     * 输入项目的IP(From)或IP(To)存在效验
     * </p>
     * 
     * @param ipFrom IP地址开始
     * @param ipTo IP地址结束
     * @param obj message补充文字
     * @return 效验结果
     */
    // public void checkFileaa(String ipFrom, String ipTo, Object[] obj) {
    // checkFile(ipFrom, ipTo, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0002E,
    // obj);
    // }

    /**
     * 输入效验：半角英数字格式效验
     * <p>
     * 输入项目的半角英数字格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkAlphaNumber(String item, String field, String messageId, Object[] obj) {
        if (!ValidatorUtils.isAlphaNumber(item)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * 输入效验：半角英数字格式效验
     * <p>
     * 输入项目的半角英数字格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkAlphaNumber(String item, Object[] obj) {
        return checkAlphaNumber(item, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0003E, obj);
    }

    /**
     * 输入效验：全数字格式效验
     * <p>
     * 输入项目的数字格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkNumber(String item, String field, String messageId, Object[] obj) {
        if (!ValidatorUtils.isNumber(item)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;

        }
        return true;
    }

    /**
     * 输入效验：全数字格式效验
     * <p>
     * 输入项目的数字格式效验
     * </p>
     * 
     * @param item 效验的内容
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkNumber(String item, Object[] obj) {
        return checkNumber(item, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0023E, obj);
    }

    /**
     * 输入效验：时间范围效验
     * <p>
     * 输入项目的时间范围效验
     * </p>
     * 
     * @param timeFrom 开始时间
     * @param timeTo 结束时间
     * @param field 画面的项目名称
     * @param messageId 效验出错时，输出的messageID
     * @param obj message补充文字
     * @return 效验结果
     */
    public void compareTime(String timeFrom, String timeTo, String field, String messageId,
            Object[] obj) {
        if (!StringUtils.isEmpty(timeFrom) && !StringUtils.isEmpty(timeTo)) {
            if (ValidatorUtils.isValidTime(timeFrom) && ValidatorUtils.isValidTime(timeTo)) {
                if (!ValidatorUtils.isValidTime(timeFrom, timeTo)) {
                    String msg = messageHelper.getMessage(messageId, obj);
                    this.addFieldError(field, msg);
                }
            }
        }
    }

    /**
     * 输入效验：时间范围效验
     * <p>
     * 输入项目的时间范围效验
     * </p>
     * 
     * @param timeFrom 开始时间
     * @param timeTo 结束时间
     * @param obj message补充文字
     * @return 效验结果
     */
    public void compareTime(String timeFrom, String timeTo, Object[] obj) {
        compareTime(timeFrom, timeTo, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0004E, obj);
    }

    /**
     * 输入效验：密码复杂度效验
     * <p>
     * 输入密码的复杂度效验
     * </p>
     * 
     * @param password 密码
     * @param field 项目名称
     * @param min 长度最小值
     * @param max 长度最大值
     * @param messageId messageId
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkPassword(String password, String field, int min, int max, String messageId,
            Object[] obj) {
        if (!ValidatorUtils.isValidPassword(password, min, max)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * 输入效验：密码复杂度效验
     * <p>
     * 输入密码的复杂度效验
     * </p>
     * 
     * @param password 密码
     * @param obj 补足文字
     * @return 效验结果
     */
    public boolean checkPassword(String password, String obj) {
        int min = Integer.parseInt(PropertyUtil.getProperty(Constant.MIN_PASSWORD));
        int max = Integer.parseInt(PropertyUtil.getProperty(Constant.MAX_PASSWORD));
        return checkPassword(password, Constant.DEFAULT_FIELD_NAME, min, max, Constant.BOOKD0017E,
                new Object[] { min, max, obj });
    }

    /**
     * 输入效验：二次密码一致效验
     * <p>
     * 二次密码一致效验
     * </p>
     * 
     * @param password 密码
     * @param passwordConfirm 密码确认
     * @param field 项目名称
     * @param messageId messageId
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkSamePassword(String password, String passwordConfirm, String field,
            String messageId, Object[] obj) {
        if (StringUtils.isNotEmpty(password) && StringUtils.isNotEmpty(passwordConfirm)) {
            if (!password.equals(passwordConfirm)) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
                return false;
            }
        }
        return true;
    }

    /**
     * 输入效验：二次密码一致效验
     * <p>
     * 二次密码一致效验
     * </p>
     * 
     * @param password 密码
     * @param passwordConfirm 密码确认
     * @param field 项目名称
     * @param messageId messageId
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkSamePassword(String password, String passwordConfirm) {
        return checkSamePassword(password, passwordConfirm, Constant.DEFAULT_FIELD_NAME,
                Constant.BOOKD0008E, null);
    }

    /**
     * 输入效验：新旧密码不能一致效验
     * <p>
     * 新旧密码不能一致效验
     * </p>
     * 
     * @param nowPassword 旧密码
     * @param newPassword 新密码
     * @param field 项目名称
     * @param messageId messageId
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkNotSamePassword(String nowPassword, String newPassword, String field,
            String messageId, Object[] obj) {
        if (StringUtils.isNotEmpty(nowPassword) && StringUtils.isNotEmpty(newPassword)) {
            if (nowPassword.equals(newPassword)) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
                return false;
            }
        }
        return true;
    }

    /**
     * 输入效验：新旧密码不能一致效验
     * <p>
     * 新旧密码不能一致效验
     * </p>
     * 
     * @param nowPassword 旧密码
     * @param newPassword 新密码
     * @return 效验结果
     */
    public boolean checkNotSamePassword(String nowPassword, String newPassword) {
        return checkNotSamePassword(nowPassword, newPassword, Constant.DEFAULT_FIELD_NAME,
                Constant.BOOKD0009E, null);
    }

    /**
     * IP地址范围效验
     * <p>
     * IP地址范围效验
     * </p>
     * 
     * @param ipString ip地址范围
     * @param field 项目名称
     * @param messageId messageId
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkIPLongString(String ipString, String field, String messageId, Object[] obj) {
        if (!ValidatorUtils.isValidIpString(ipString)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * IP地址范围效验
     * <p>
     * IP地址范围效验
     * </p>
     * 
     * @param ipString ip地址范围
     * @return 效验结果
     */
    public boolean checkIPLongString(String ipString) {
        return checkIPLongString(ipString, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0031E, null);
    }


    /**
     * 至少要check一个checkbox
     * <p>
     * 至少要check一个checkbox
     * </p>
     * 
     * @param field 项目名称
     * @param messageId messageId
     * @param obj message补充文字
     * @param itemArrays 被检测的数组
     * @return 效验结果
     */
    public boolean checkCheckArray(String field, String messageId, Object[] obj,
            String[]... itemArrays) {
        boolean isNull = true;
        for (String[] item : itemArrays) {
            if (item != null) {
                isNull = false;
                break;
            }
        }

        if (isNull) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * 至少要check一个checkbox
     * <p>
     * 至少要check一个checkbox
     * </p>
     * 
     * @param obj message补充文字
     * @param itemArrays 被检测的数组
     * @return 效验结果
     */
    public boolean checkCheckArray(String obj, String[]... itemArrays) {
        return checkCheckArray(Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0033E,
                new Object[] { (Object) obj }, itemArrays);
    }

    /**
     * 字符串不包含空格check
     * 
     * @param item 传入字符串
     * @param obj message参数
     * @return 返回结果
     */
    public boolean checkStringContainSpace(String str, Object[] obj) {
        if (str.contains(stringBlank)) {
            String msg = messageHelper.getMessage(Constant.BOOKD0023E, obj);
            this.addFieldError(Constant.DEFAULT_FIELD_NAME, msg);
            return false;
        }
        return true;
    }

    /**
     * 防跨站检测，一些特殊字符不能从页面输入
     * <p>
     * 防跨站检测，一些特殊字符不能从页面输入
     * </p>
     * 
     * @param inputString 页面输入内容
     * @param field 项目名称
     * @param messageId messageId
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkXss(String inputString, String field, String messageId, Object[] obj) {
        if (!ValidatorUtils.isValidInputString(inputString)) {
            String msg = messageHelper.getMessage(messageId, obj);
            this.addFieldError(field, msg);
            return false;
        }
        return true;
    }

    /**
     * 防跨站检测，一些特殊字符不能从页面输入
     * <p>
     * 防跨站检测，一些特殊字符不能从页面输入
     * </p>
     * 
     * @param inputString 页面输入内容
     * @param inputName 输入框的内容
     * @return 效验结果
     */
    public boolean checkXss(String inputString, String inputName) {
        return checkXss(inputString, Constant.DEFAULT_FIELD_NAME, Constant.BOOKZ0034E,
                new Object[] { inputName });
    }

    /**
     * IP地址范围效验
     * <p>
     * IP地址范围效验
     * </p>
     * 
     * @param ipString ip地址范围
     * @param field 项目名称
     * @param messageId messageId
     * @param obj message补充文字
     * @return 效验结果
     */
    public boolean checkDateNum(String item, int min, int max, String field, String messageId,
            Object[] obj) {
        if (!StringUtils.isEmpty(item)) {
            if (Integer.parseInt(item) < min || Integer.parseInt(item) > max) {
                String msg = messageHelper.getMessage(messageId, obj);
                this.addFieldError(field, msg);
                return false;
            }
        }
        return true;
    }

   

    
}
