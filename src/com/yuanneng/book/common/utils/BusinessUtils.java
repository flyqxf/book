package com.yuanneng.book.common.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import ch.ethz.ssh2.Connection;

import com.yuanneng.book.common.entity.CodeBaseBean;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.validator.ValidatorUtils;

/**
 * BusinessUtils.java
 * 
 * 功 能： 业务共通Utils
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.08.16         guot            新规做成
 * </pre>
 */
public class BusinessUtils {

    /**
     * 默认的主机名
     */
    public final static String DEFAULT_HOST_NAME = "unknownHost";

    /**
     * request请求的标头
     */
    public static final String X_FORWARDED_FOR = "x-forwarded-for";

    /**
     * request请求的标头
     */
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";

    /**
     * request请求的标头
     */
    public static final String WL_Proxy_Client_IP = "WL-Proxy-Client-IP";

    /**
     * request请求的标头
     */
    public static final String HTTP_CLIENT_IP = "http_client_ip";

    /**
     * request请求的标头
     */
    public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";

    /**
     * 获取UUID值
     * 
     * @return UUID值
     */
    public static synchronized String getUUID() {
        // 采用时间+UUID的方式随即命名
        String uuid = java.util.UUID.randomUUID().toString();
        return uuid.replaceAll(Constant.HORIZONTAL_LINE, Constant.STRING_BLANK);
    }

    /**
     * 获取UVO
     * 
     * @return UVO对象
     */
    public static UserValueObject getUVO() {
        // 取得session值
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        HttpSession session = request.getSession(false);
        if (null == session) {
            return null;
        }
        // 读取session中的用户
        UserValueObject uvo = (UserValueObject) session.getAttribute(Constant.UVO);
        return uvo;
    }

    /**
     * 翻页处理，计算每页的最后一条数据的编号
     * 
     * @param page 翻页用的bean
     * @return 此页最后一条数据的编号
     */
    public static String getEndProperty(CommonPageLinksBean<? extends Object> result) {
        int end = 0;
        try {
            int total = Integer.parseInt(result.getTotalProperty());
            int index = Integer.parseInt(result.getIndexProperty());
            int row = Integer.parseInt(result.getRowProperty());
            end = ((index + row) > total) ? (total - 1) : (index + row - 1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return String.valueOf(end);
    }

    /**
     * 获取指定管理ID的项目列表
     * 
     * @param codeKey 管理ID
     * @return 项目列表
     */
    @SuppressWarnings("unchecked")
    public static List<CodeBaseBean> getCodeMap(String codeKey) {
        Map<String, List<CodeBaseBean>> codeListMap = (Map<String, List<CodeBaseBean>>) ServletActionContext
                .getServletContext().getAttribute("CodeListMap");
        return codeListMap.get(codeKey);
    }

    /**
     * 取得系统时间
     * 
     * @return 系统时间
     */
    public static Date getSystemTime() {
        Calendar cl = Calendar.getInstance();
        Date date = cl.getTime();
        return date;
    }

    /**
     * 取得系统时间,字符串类型
     * 
     * @param 日期时间格式
     * @return 系统时间，字符串类型
     */
    public static String getSystemTimeString(FormatedTime format) {
        Date date = getSystemTime();
        SimpleDateFormat formater = new SimpleDateFormat(format.getFormatStr());
        String dateStr = formater.format(date);
        return dateStr;
    }

    /**
     * 字符串类型的时间
     * 
     * @param 日期类型的时间
     * @param 日期时间格式
     * @return 字符串类型的时间
     */
    public static String getTimeString(Date date, FormatedTime format) {
        SimpleDateFormat formater = new SimpleDateFormat(format.getFormatStr());
        String dateStr = formater.format(date);
        return dateStr;
    }

    /**
     * date类型的时间
     * 
     * @param 字符串类型的时间
     * @param 日期时间格式
     * @return date类型的时间
     */
    public static Date getTime(String dateStr, FormatedTime format) {
        SimpleDateFormat formater = new SimpleDateFormat(format.getFormatStr());
        Date date = null;
        try {
            date = formater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 密码的md5算出
     * 
     * @param password 要转换的密码
     * @return 转换后的密码
     * @throws Exception 转换错误异常
     */
    public static String getPasswordMD5(String password) throws Exception {

        MessageDigest md = MessageDigest.getInstance(Constant.MD5);
        md.update(password.getBytes());
        byte[] b = md.digest();
        int i = 0;
        StringBuffer buff = new StringBuffer();
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                buff.append(Constant.STRING_ZERO);
            }
            buff.append(Integer.toHexString(i));
        }
        return buff.toString();
    }

    /**
     * 清除session信息
     * 
     */
    public static void clearSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
//        UserValueObject uvo = (UserValueObject) session.getAttribute(Constant.UVO);
//        String userName=null;
//        if(uvo != null) {
//        UserBean uBean = uvo.getUser();
//        userName = uBean.getUserName();
//        
//        } else {
//            AdminUserBean adminUserBean = (AdminUserBean) session.getAttribute(Constant.ADMIN_USER_NAME);
//            if(adminUserBean != null) {
//                userName = adminUserBean.getUserId();
//            }
//        }
        
        session.invalidate();
//        if(userName != null) {
//        ServletActionContext.getServletContext().setAttribute(userName, null);
//        }
    }

    /**
     * 获取n天前的时间
     * 
     * @param dateCount 天数
     * @return 返回结果
     */
    public static String getDateFromTo(int dateCount) {
        /** 当前系统时间 */
        Date nowDate = new Date();
        /** 前n天的时间 */
        Date dBefore = new Date();

        /** 得到日历 */
        Calendar calendar = Calendar.getInstance();
        /** 把当前时间赋给日历 */
        calendar.setTime(nowDate);
        /** 设置为前dateCount天 */
        calendar.add(Calendar.DAY_OF_MONTH, -dateCount);
        /** 得到前dateCount天的时间 */
        dBefore = calendar.getTime();
        /** 设置时间格式 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dBefore);
    }

    /**
     * 获取n天前到今天为止的所有日期的集合
     * 
     * @param dateCount 天数
     * @return 返回结果
     */
    public static List<String> getDatesFromTo(int dateCount) {
        List<String> dates = new ArrayList<String>();
        for (int i = dateCount - 1; i >= 0; i--) {
            dates.add(getDateFromTo(i));
        }
        return dates;
    }

    /**
     * 获取某天到某天的所有日期的集合
     * 
     * @param dateCount 天数
     * @return 返回结果
     */
    public static List<String> getDatesFromTo(String[] dateRange) {
        if (dateRange.length != 2) {
            return null;
        }
        Date dateStart = getTime(dateRange[0], FormatedTime.HYPHEN_YYYYMMDD);
        Date dateEnd = getTime(dateRange[1], FormatedTime.HYPHEN_YYYYMMDD);
        if (null == dateStart || null == dateEnd) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        List<String> dates = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0;; i++) {
            calendar.setTime(dateStart);
            calendar.add(Calendar.DAY_OF_MONTH, i);
            Date date = calendar.getTime();
            dates.add(sdf.format(date));
            if (date.equals(dateEnd)) {
                break;
            }
        }
        return dates;
    }

    /**
     * 获取ip段中所有ip地址
     * 单个IP及IP范围都可输入，IP和IP之间用半角逗号分隔。
     * 如：192.168.1.23-192.168.3.254,192.168.4.133
     * 
     * @param target
     * @return
     */
    public static List<String> getIpList(String target) {
        List<String> ipList = new ArrayList<String>();
        if (target != null && target.length() > 0) {
            String[] str = target.split(Constant.COMMA);
            for (String str2 : str) {
                /** ip段 */
                if (str2.indexOf(Constant.HORIZONTAL_LINE) > 0) {
                    String[] ips = str2.split(Constant.HORIZONTAL_LINE);
                    /** ip段前后正确 */
                    if (ValidatorUtils.isValidIpAddr(ips[0], ips[1])) {
                        List<String> list = getIps(ips[0], ips[1]);
                        /** 添加分段IP */
                        for (String ip : list) {
                            ipList.add(ip);
                        }
                    } else {
                        /** 格式有误返回 */
                        ipList = null;
                        return ipList;
                    }
                } else {
                    /** 单个ip */
                    ipList.add(str2);
                }
            }
        }
        return ipList;
    }

    /**
     * 获取ip段中ip地址
     * 
     * @param ipStart
     * @param ipEnd
     * @return
     */
    private static List<String> getIps(String ipStart, String ipEnd) {
        List<String> ips = new ArrayList<String>();
        boolean ifRes = true;
        String[] sstr = ipStart.split("\\.");
        String[] estr = ipEnd.split("\\.");

        int s0 = Integer.parseInt(sstr[0]);
        int s1 = Integer.parseInt(sstr[1]);
        int s2 = Integer.parseInt(sstr[2]);
        int s3 = Integer.parseInt(sstr[3]);
        /** ip第四段不为255 **/
        if (s3 != 255)
            ips.add(ipStart);
        int e0 = Integer.parseInt(estr[0]);
        int e1 = Integer.parseInt(estr[1]);
        int e2 = Integer.parseInt(estr[2]);
        int e3 = Integer.parseInt(estr[3]);
        if (e3 == 255)
            e3 = 254;
        while (ifRes) {
            /** 开始ip和结束ip相同时，跳出循环 **/
            if (s0 == e0 && s1 == e1 && s2 == e2 && s3 == e3) {
                ifRes = false;
            } else {
                /** ip第四段只到254 **/
                if (s3 >= 254) {
                    s3 = 1;
                    if (s2 == 255) {
                        s2 = 0;
                        if (s1 == 255) {
                            s1 = 0;
                            s0++;
                        } else {
                            s1++;
                        }
                    } else {
                        s2++;
                    }
                } else {
                    s3++;
                }
                ips.add(s0 + "." + s1 + "." + s2 + "." + s3);
            }
        }
        return ips;
    }

    /**
     * 取得主机名字
     * 
     * @return 主机名字
     */
    public static String getHostName() {
        String hostName = DEFAULT_HOST_NAME;
        try {
            InetAddress host = InetAddress.getLocalHost();
            hostName = host.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostName;
    }

    /**
     * 获取client端访问ip
     * 
     * @return ip
     */
    public static String getClientIpAddr() {
        // 取得request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        String ip = request.getHeader(X_FORWARDED_FOR);
        if (ip == null || ip.length() == Constant.NUM_0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(PROXY_CLIENT_IP);
        }
        if (ip == null || ip.length() == Constant.NUM_0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(WL_Proxy_Client_IP);
        }
        if (ip == null || ip.length() == Constant.NUM_0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == Constant.NUM_0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(HTTP_CLIENT_IP);
        }
        if (ip == null || ip.length() == Constant.NUM_0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(HTTP_X_FORWARDED_FOR);
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(Constant.COMMA) != Constant.NUM_MINUS_1) {
            ip = ip.substring(ip.lastIndexOf(Constant.COMMA) + Constant.NUM_1, ip.length()).trim();
        }
        return ip;
    }

    /**
     * 验证用户名密码是否连接成功
     * 
     * @param ip ip地址
     * @param user 用户名密码
     * @param pwd 密码
     * @return 返回结果
     */
    public static String checkConnectTo(String ip, String user, String pwd) {
        String result = "0";
        Connection conn = new Connection(ip);
        try {
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(user, pwd);
            if (isAuthenticated == false) {
                result = "1";
                throw new IOException("连接失败");
            }
        } catch (IOException e) {
            result = "1";
        }
        return result;
    }

    /**
     * 密码加密
     * 
     * @param sSrc 加密文字
     * @param sKey 加密规则
     * @return 返回结果
     */
    public static String pwdForEncrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        // "算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        // 此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return new BASE64Encoder().encode(encrypted);
    }

    /**
     * 密码解密密
     * 
     * @param sSrc 解密密文字
     * @param sKey 加密规则
     * @return 返回结果
     */
    public static String pwdForDecrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            // 先用base64解密
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    /**
     * 获取百分比
     * 
     * @param num 数量
     * @param totalPeople 总数
     * @param dig 小数位数
     * @return 百分比
     */
    public static String getPercent(int num, int totalPeople, int dig) {
        String percent = null;
        double percentDouble = 0.0;
        if (totalPeople == 0) {
            percentDouble = 0.0;
        } else {
            percentDouble = num * 1.0 / totalPeople;
        }
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(dig);
        percent = nf.format(percentDouble);
        return percent;
    }

   
}
