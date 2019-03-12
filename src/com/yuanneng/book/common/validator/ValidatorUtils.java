package com.yuanneng.book.common.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.FormatedTime;
import com.yuanneng.book.common.utils.PropertyUtil;

public class ValidatorUtils {

    /**
     * IP地址正则表达式
     */
    private static final String IP_PATTERN = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";

    /**
     * IP地址范围正则表达式
     */
    private static final String IP_RANGE_PATTERN = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}-\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";

    /**
     * IP地址分割
     */
    private static final String IP_SPLITER = "\\.";

    /**
     * 时间分割
     */
    private static final String TIME_SPLITER = "\\:";

    /**
     * IP段最大数
     */
    private static final int MAX_IP_NUM = 255;

    /**
     * 邮箱地址正则表达式
     */
    private static final String MAIL_PATTERN = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]*@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 网卡地址正则表达式
     */
    private static final String MAC_PATTERN = "^[a-f0-9A-F]{2}:[a-f0-9A-F]{2}:[a-f0-9A-F]{2}:[a-f0-9A-F]{2}:[a-f0-9A-F]{2}:[a-f0-9A-F]{2}$";

    /**
     * 手机号码的长度
     */
    private static final int MOBILENO_LENGTH = 11;

    /**
     * 邮箱的长度
     */
    private static final int MAX_EMAIL_LENGTH = Integer.parseInt(PropertyUtil
            .getProperty(Constant.MAX_EMAIL_LENGTH));

    /**
     * 时间格式正则表达式
     */
    private static final String TIME_PATTERN = "(([0-1][0-9])|2[0-3]):[0-5][0-9]";

    /**
     * 日期格式正则表达式(yyyy/MM/dd)
     */
    private static final String DATE_PATTERN = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";

    /**
     * 英数字格式正则表达式
     */
    private static final String ALPHA_NUMBER_PATTERN = "[0-9a-zA-Z]*";

    /**
     * 英字正则表达式
     */
    private static final String PASSWORD_PATTERN_1 = "[\\s\\S]*[a-zA-Z]+[\\s\\S]*";

    /**
     * 数字正则表达式
     */
    private static final String PASSWORD_PATTERN_2 = "[\\s\\S]*[0-9]+[\\s\\S]*";

    /**
     * 非英数字正则表达式
     */
    private static final String PASSWORD_PATTERN_3 = "[\\s\\S]*[^0-9a-zA-Z]+[\\s\\S]*";

    /**
     * 包含XSS特殊字符的正则表达式
     */
    private static final String XSS_CHARACTOR_PATTERN = "[\\s\\S]*[&<>\"`'/]+[\\s\\S]*";

    /**
     * 必须输入效验
     * 
     * @param item 效验的内容
     * @return 效验结果
     */
    public static boolean isRequired(String item) {
        if (StringUtils.isEmpty(item)) {
            return false;
        }
        return true;
    }

    /**
     * 长度效验
     * 
     * @param item 效验的内容
     * @param min 最短长度
     * @param max 最长长度
     * @return 效验结果
     */
    public static boolean isOverLength(String item, int min, int max) {
        if (!StringUtils.isEmpty(item)) {
            if (item.length() > max || item.length() < min) {
                return false;
            }
        }
        return true;
    }

    /**
     * 长度效验
     * 
     * @param item 效验的内容
     * @param max 最长长度
     * @return 效验结果
     */
    public static boolean isOverLength(String item, int max) {
        if (!StringUtils.isEmpty(item)) {
            if (item.length() > max) {
                return false;
            }
        }
        return true;
    }

    /**
     * 全数字效验
     * 
     * @param item 效验内容
     * @return 效验结果
     */
    public static boolean isNumber(String item) {
        if (null == item || StringUtils.isNumeric(item)) {
            return true;
        }
        return false;
    }

    /**
     * 半角英数字效验
     * 
     * @param item 效验内容
     * @return 效验结果
     */
    public static boolean isAlphaNumber(String item) {
        if (StringUtils.isEmpty(item)) {
            return true;
        }
        if (item.matches(ALPHA_NUMBER_PATTERN)) {
            return true;
        }
        return false;
    }
    

    /**
     * IP地址格式检测
     * 
     * @param ipAddr IP地址
     * @return 检测结果
     */
    public static boolean isValidIpAddr(String ipAddr) {
        if (StringUtils.isEmpty(ipAddr)) {
            return true;
        }
        if (ipAddr.matches(IP_PATTERN)) {
            String[] ipA = ipAddr.split(IP_SPLITER);
            try {
                if (Integer.parseInt(ipA[0]) < 1 || Integer.parseInt(ipA[0]) > MAX_IP_NUM) {
                    return false;
                }
                if (Integer.parseInt(ipA[1]) < 0 || Integer.parseInt(ipA[1]) > MAX_IP_NUM) {
                    return false;
                }
                if (Integer.parseInt(ipA[2]) < 0 || Integer.parseInt(ipA[2]) > MAX_IP_NUM) {
                    return false;
                }
                if (Integer.parseInt(ipA[3]) < 1 || Integer.parseInt(ipA[3]) > (MAX_IP_NUM - 1)) {
                    return false;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * IP地址大小比较
     * 
     * @param startIP IP地址开始
     * @param endIP IP地址结束
     * @return 检测结果 （true：IP地址开始 <= IP地址结束，false：IP地址开始 > IP地址结束）
     */
    public static boolean isValidIpAddr(String startIP, String endIP) {
        // 判断IP地址长度
        if (isValidIpAddr(startIP) && isValidIpAddr(endIP)) {
            // 分离出IP地址中的四个数字位
            String[] startIPArray = startIP.split(IP_SPLITER);
            String[] endIPArray = endIP.split(IP_SPLITER);

            // 取得各个数字
            long[] startIPNum = new long[4];
            long[] endIPNum = new long[4];
            for (int i = 0; i < 4; i++) {
                startIPNum[i] = Long.parseLong(startIPArray[i].trim());
                endIPNum[i] = Long.parseLong(endIPArray[i].trim());
            }

            // 各个数字乘以相应的数量级
            long startIPNumTotal = startIPNum[0] * 256 * 256 * 256 + startIPNum[1] * 256 * 256
                    + startIPNum[2] * 256 + startIPNum[3];
            long endIPNumTotal = endIPNum[0] * 256 * 256 * 256 + endIPNum[1] * 256 * 256
                    + endIPNum[2] * 256 + endIPNum[3];

            if (startIPNumTotal > endIPNumTotal) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    /**
     * 电话号码格式检测
     * 
     * @param MobileNo 电话号码
     * @return 检测结果
     */
    public static boolean isValidMobileNo(String MobileNo) {
        if (StringUtils.isEmpty(MobileNo)) {
            return true;
        }
        if (isNumber(MobileNo) && MOBILENO_LENGTH == MobileNo.length()) {
            return true;
        }
        return false;
    }

    /**
     * 邮箱地址格式检测
     * 
     * @param mail 邮箱地址
     * @return 检测结果
     */
    public static boolean isValidMailAddr(String mail) {
        if (StringUtils.isEmpty(mail)) {
            return true;
        }
        if (mail.length() > MAX_EMAIL_LENGTH) {
            return false;
        }
        if (mail.matches(MAIL_PATTERN)) {
            return true;
        }
        return false;
    }

    /**
     * 网卡地址格式检测
     * 
     * @param mac 网卡地址
     * @return 检测结果
     */
    public static boolean isValidMacAddr(String mac) {
        if (StringUtils.isEmpty(mac)) {
            return true;
        }
        if (mac.matches(MAC_PATTERN)) {
            return true;
        }
        return false;
    }

    /**
     * 时间格式检测
     * 
     * @param time 时间
     * @return 检测结果
     */
    public static boolean isValidTime(String time) {
        if (StringUtils.isEmpty(time)) {
            return true;
        }
        if (time.matches(TIME_PATTERN)) {
            return true;
        }
        return false;
    }

    /**
     * 时间大小比较
     * 
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 检测结果 （true：开始时间 <= 结束时间，false：开始时间 > 结束时间）
     */
    public static boolean isValidTime(String startTime, String endTime) {
        // 判断时间长度
        if (startTime.length() != 5 || endTime.length() != 5) {
            return true;
        }
        // 分离出时间中的两个数字位
        String[] startArray = startTime.split(TIME_SPLITER);
        String[] endArray = endTime.split(TIME_SPLITER);

        // 取得各个数字
        long[] startNum = new long[2];
        long[] endNum = new long[2];
        for (int i = 0; i < 2; i++) {
            startNum[i] = Long.parseLong(startArray[i].trim());
            endNum[i] = Long.parseLong(endArray[i].trim());
        }

        // 判断小时
        if (startNum[0] > endNum[0]) {
            return false;
        } else if (startNum[0] < endNum[0]) {
            return true;
        } else {
            // 判断分钟
            if (startNum[1] > endNum[1]) {
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * 日期格式检测
     * 只针对"yyyy/mm/dd"格式的
     * 
     * @param date 日期
     * @return 检测结果
     */
    public static boolean isValidDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return true;
        }
        if (!date.matches(DATE_PATTERN)) {
            return false;
        }
        SimpleDateFormat format = new SimpleDateFormat(FormatedTime.HYPHEN_YYYYMMDD.getFormatStr());
        try {
            format.setLenient(false);
            format.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 密码复杂度检测
     * 
     * @param password 密码
     * @param min 最短长度
     * @param max 最长长度
     * @return 检测结果
     */
    public static boolean isValidPassword(String password, int min, int max) {
        if (StringUtils.isEmpty(password)) {
            return true;
        }
        // 长度检测
        if (password.length() < min || password.length() > max) {
            return false;
        }
        // 复杂度检测
//        if (!password.matches(PASSWORD_PATTERN_1) || !password.matches(PASSWORD_PATTERN_2)
//                || !password.matches(PASSWORD_PATTERN_3)) {
//            return false;
//        }
        return true;
    }

    /**
     * IP地址范围检测
     * 
     * @param ipString IP地址范围
     * @return 检测结果
     */
    public static boolean isValidIpString(String ipString) {
        if (StringUtils.isEmpty(ipString)) {
            return true;
        }
        // 分割
        String[] ips = ipString.split(Constant.COMMA);

        for (String item : ips) {
            if (item.matches(IP_RANGE_PATTERN)) {
                String[] rangeIps = item.split(Constant.HORIZONTAL_LINE);
                if (!isValidIpAddr(rangeIps[0]) || !isValidIpAddr(rangeIps[1])
                        || !isValidIpAddr(rangeIps[0], rangeIps[1])) {
                    return false;
                }
                continue;
            } else if (item.matches(IP_PATTERN)) {
                if (!isValidIpAddr(item)) {
                    return false;
                }
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 防跨站检测，一些特殊字符不能从页面输入
     * 
     * @param inputString 输入框内容
     * @return 检测结果
     */
    public static boolean isValidInputString(String inputString) {
        if (StringUtils.isEmpty(inputString)) {
            return true;
        }
        // 复杂度检测
        if (inputString.matches(XSS_CHARACTOR_PATTERN)) {
            return false;
        }
        return true;
    }
}
