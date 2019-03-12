/*
 * @(#)UserLoginServer.java
 */
package com.yuanneng.book.sysmanage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.sysmanage.dao.IUserDisplayDao;
import com.yuanneng.book.sysmanage.entity.UserBean;

/**
 * UserLoginServer.java
 * 
 * 功 能： UserLoginAction的service
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.13         shanjixiang        新规做成
 * </pre>
 */
public class UserLoginService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(UserLoginService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    public IUserDisplayDao iuserDisplayDao;

    /**
     * 输入密码错误的ID保存MAP
     */
    public Map<String, Integer> failureUserCount;

    /**
     * 查询判断密码是否正确
     * 
     * @param userName 查询的用户
     * @return 用户信息
     * @throws Exception 密码MD5转换异常
     */
    public UserBean equelUserPwd(String userName, String password) throws Exception {
        // 初始化返回值
        String flag = Constant.STRING_ZERO;
        /** 设置查询参数 */
        UserBean userBean = new UserBean();
        userBean.setFlag(flag);
        userBean.setUserId(userName);
        List<UserBean> list = iuserDisplayDao.getUserBeans(userBean);
        /** 若返回空则修改失败 */
        if (list.size() <= 0) {
            return null;
        }

        /** 获取查询用户的密码 */
        String userPwd = list.get(0).getUserPassword();
        /** 密码MD5转化 */
        String pwd = BusinessUtils.getPasswordMD5(password);
        /** 判断密码是否相同 */
        if (!pwd.equals(userPwd)) {
            flag = addUserCount(userName);
            if (Constant.STRING_ZERO.equals(flag)) {
                userBean = null;
            } else {
                userBean.setFlag(flag);
            }
            return userBean;
        } else {
            clearUserCount(userName);
        }
        /** 将用户信息中的密码清除掉 */
        list.get(0).setUserPassword(Constant.STRING_BLANK);

        userBean = list.get(0);
        userBean.setUserId(userName);
        return userBean;
    }
    
    
//
//    /**
//     * 查询判断密码是否正确
//     *
//     * @param userName 查询的用户
//     * @return 用户信息
//     * @throws Exception 密码MD5转换异常
//     */
//    public UserBean equelUserPwdMD5(String userName, String password) throws Exception {
//        // 初始化返回值
//        String flag = Constant.STRING_ZERO;
//        /** 设置查询参数 */
//        UserBean userBean = new UserBean();
//        userBean.setFlag(flag);
//        userBean.setUserName(userName);
//        List<UserBean> list = iuserDisplayDao.getUserBeans(userBean);
//        /** 若返回空则修改失败 */
//        if (list.size() <= 0) {
//            return null;
//        }
//
//        /** 获取查询用户的密码 */
//        String userPwd = list.get(0).getPassword();
//        /** 判断密码是否相同 */
//        if (!password.equals(userPwd)) {
//            flag = addUserCount(userName);
//            if (Constant.STRING_ZERO.equals(flag)) {
//                userBean = null;
//            } else {
//                userBean.setFlag(flag);
//            }
//            return userBean;
//        } else {
//            clearUserCount(userName);
//        }
//        /** 将用户信息中的密码清除掉 */
//        list.get(0).setPassword(Constant.STRING_BLANK);
//
//        userBean = list.get(0);
//        userBean.setUserName(userName);
//        return userBean;
//    }
    /**
     * 清除用户的错误计数
     * 
     * @param userName 用户ID
     */
    public void clearUserCount(String userName) {
        if (null == failureUserCount) {
            failureUserCount = new HashMap<String, Integer>();
            return;
        } else {
            failureUserCount.remove(userName);
        }
    }
//
    /**
     * 增加用户的错误计数
     * 
     * @param userName 用户ID
     * @return flag 返回值 (0:正常,1:更新DB变成锁定状态,2:更新DB变成锁定状态未成功)
     */
    public synchronized String addUserCount(String userName) {
        String flag = Constant.STRING_ZERO;
        if (null == failureUserCount) {
            failureUserCount = new HashMap<String, Integer>();
        }
        if (failureUserCount.keySet().contains(userName)) {
            int count = failureUserCount.get(userName);
            int lockCount = Integer.parseInt(PropertyUtil.getProperty(Constant.LOCK_USER_COUNT));
            if (count >= lockCount) {
                UserBean condition = new UserBean();
                condition.setUserName(userName);
                condition.setSchema(PropertyUtil.getProperty(Constant.SCHEMA));
                // 锁定DB数据
                int cnt = iuserDisplayDao.selectLockUser(condition);
                // 更新DB数据
                if (cnt != Constant.NUM_0) {
                    iuserDisplayDao.lockUser(condition);
                    // 清空map(因为没有保存的意义了)
                    clearUserCount(userName);
                    flag = Constant.STRING_ONE;
                } else {
                    // 由于没有锁定数据,没有更新DB成功
                    flag = Constant.STRING_TWO;
                }
            } else {
                failureUserCount.put(userName, ++count);
            }
        } else {
            failureUserCount.put(userName, Constant.NUM_1);
        }
        return flag;
    }
}
