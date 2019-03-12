/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.login.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.manage.login.dao.IAdminUserDisplayDao;
import com.yuanneng.book.manage.login.entity.AdminUserBean;


public class AdminUserLoginService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(AdminUserLoginService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    public IAdminUserDisplayDao iAdminUserDisplayDao;

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
    public AdminUserBean equelUserPwd(String userName, String password) throws Exception {
        /** 设置查询参数 */
        AdminUserBean adminUserBean = new AdminUserBean();
        adminUserBean.setUserId(userName);
        List<AdminUserBean> list = iAdminUserDisplayDao.getUserBeans(adminUserBean);
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
            
            return null;
        }
        /** 将用户信息中的密码清除掉 */
        list.get(0).setUserPassword(Constant.STRING_BLANK);

        adminUserBean = list.get(0);
        adminUserBean.setUserId(userName);
        return adminUserBean;
    }


   
}
