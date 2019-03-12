/*
 * @(#)UpdatePwdServer.java
 */
package com.yuanneng.book.prerson.service;

import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.prerson.dao.IPersonDao;
import com.yuanneng.book.sysmanage.dao.IUserDisplayDao;
import com.yuanneng.book.sysmanage.entity.UserBean;



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
public class UpdatePwdService implements CommonService {

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    public IPersonDao iPersonDao;
    
    @Resource
    public IUserDisplayDao iuserDisplayDao;

    /**
     * 查询判断旧密码是否正确
     * 
     * @param userBean 查询的用户
     * @return 检索结果(非正常情况下为null)
     * @throws Exception 密码MD5转换异常
     */
    public UserBean equelUserPwd(String userId, String userOldPwd) throws Exception {
     // 初始化返回值
        String flag = Constant.STRING_ZERO;
        /** 设置查询参数 */
        UserBean userBean = new UserBean();
        userBean.setFlag(flag);
        userBean.setUserId(userId);
        List<UserBean> list = iuserDisplayDao.getUserBeans(userBean);
        /** 若返回空则修改失败 */
        if (list.size() <= 0) {
            return null;
        }
        /** 获取查询用户的密码 */
        String userPwd = list.get(0).getUserPassword();
        String pwd = BusinessUtils.getPasswordMD5(userOldPwd);
        if (!pwd.equals(userPwd)) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 修改密码
     * 
     * @param userBean 修改的对象参数
     * @return 返回结果
     * @throws Exception
     */
    public int changePwd(UserBean userBean) throws Exception {

        String pwd = userBean.getUserPassword();
        /** 密码MD5 */
        pwd = BusinessUtils.getPasswordMD5(pwd);
        userBean.setUserPassword(pwd);
        int upRes = 0;
        upRes = iPersonDao.updateUserPwd(userBean);
        return upRes;

    }

}
