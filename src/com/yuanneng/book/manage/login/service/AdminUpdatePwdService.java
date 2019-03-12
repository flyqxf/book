/*
 * @(#)UpdatePwdServer.java
 */
package com.yuanneng.book.manage.login.service;

import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.manage.login.dao.IAdminUserDisplayDao;
import com.yuanneng.book.manage.login.entity.AdminUserBean;

/**
 * UpdatePwdServer.java
 * 
 * 功 能： UpdateUserPwdAction的service
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.12         shanjixiang        新规做成
 * </pre>
 */
public class AdminUpdatePwdService implements CommonService {

    /**
     * 注入的ISelectUserDao层
     */    
    @Resource
    public IAdminUserDisplayDao iAdminUserDisplayDao;

    /**
     * 查询判断旧密码是否正确
     * 
     * @param userBean 查询的用户
     * @return 检索结果(非正常情况下为null)
     * @throws Exception 密码MD5转换异常
     */
    public AdminUserBean equelUserPwd(String userId, String userOldPwd) throws Exception {
        /** 设置查询参数 */
        
        AdminUserBean adminUserBean = new AdminUserBean();
        adminUserBean.setUserId(userId);
        
        
        List<AdminUserBean> adminUserBeans = iAdminUserDisplayDao.getUserBeans(adminUserBean);
        /** 若返回空则修改失败 */
        if (adminUserBeans.size() <= 0) {
            return null;
        }
        /** 获取查询用户的密码 */
        String userPwd = adminUserBeans.get(0).getUserPassword();
        String pwd = BusinessUtils.getPasswordMD5(userOldPwd);
        if (!pwd.equals(userPwd)) {
            return null;
        }
        return adminUserBeans.get(0);
    }

    /**
     * 修改密码
     * 
     * @param userBean 修改的对象参数
     * @return 返回结果
     * @throws Exception
     */
    public int changePwd(AdminUserBean adminUserBean) throws Exception {

        String pwd = adminUserBean.getUserPassword();
        /** 密码MD5 */
        pwd = BusinessUtils.getPasswordMD5(pwd);
        adminUserBean.setUserPassword(pwd);
        int upRes = 0;
        upRes = iAdminUserDisplayDao.updatePwd(adminUserBean);
        return upRes;

    }

}
