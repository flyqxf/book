/*
 * @(#)IUserDisplayDao.java
 */
package com.yuanneng.book.sysmanage.dao;

import java.util.List;

import com.yuanneng.book.common.dao.CommonDao;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.sysmanage.entity.UserBean;
import com.yuanneng.book.sysmanage.entity.UserEventLogBean;

/**
 * IUserDisplayDao.java
 * 
 * 功 能： 用户一览Service的Dao
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.5         shanjixiang        新规做成
 * </pre>
 */
public interface IUserDisplayDao extends CommonDao {


    /**
     * 条件检索用户信息
     * <p>
     * 编辑service输入值，调用sql语句,处理sql的返回结果
     * </p>
     * 
     * @param condition 检索条件
     * 
     * @return 返回结果
     */
    List<UserBean> getUserBeans(CommonBean condition);
//
//    /**
//     * 条件检索用户信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 检索条件
//     * 
//     * @return 返回结果
//     */
//    List<UserBean> getUserBeansForSearch(CommonBean condition);
//
//    /**
//     * 条件检索用户信息(不管是不是消除过的user)
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 检索条件
//     * 
//     * @return 返回结果
//     */
//    List<UserBean> getAllUserBeans(CommonBean condition);
//
//    /**
//     * 条件检索用户信息(模糊查询)
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 检索条件
//     * 
//     * @return 返回结果
//     */
//    List<UserBean> selectUserBeans(CommonBean condition);
//
//    /**
//     * 添加用户信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 添加的信息
//     * 
//     * @return 返回结果
//     */
//    int addUserBean(CommonBean condition);
//
//    /**
//     * 添加组织机构
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 添加的信息
//     * 
//     * @return 返回结果
//     */
//    int addOrgBean(CommonBean condition);
//
//    /**
//     * 跟新用户前查询锁定用户
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition
//     * @return
//     */
//    UserBean selUpdateUserBean(CommonBean condition);
//
//    /**
//     * 更新用户信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 修改信息
//     * @return 返回结果
//     */
//    void updateUserBean(CommonBean condition);
//
//    /**
//     * 删除用户信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 修改信息
//     * @return 返回结果
//     */
//    int deleteUserBean(CommonBean condition);
//
    /**
     * 用户修改密码
     * <p>
     * 编辑service输入值，调用sql语句,处理sql的返回结果
     * </p>
     * 
     * @param condition 修改密码
     * @return 返回结果
     */
    int updateUserPwd(CommonBean condition);
//
//    /**
//     * 用户重置密码
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 修改密码
//     * @return 返回结果
//     */
//    int resetPwd(CommonBean condition);
//
//    /**
//     * 新增角色
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 修改密码
//     * @return 返回结果
//     */
//    int addRole(CommonBean condition);
//
//    /**
//     * 删除角色权限
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 删除条件
//     */
//    int delRolePermisstion(CommonBean condition);
//
//    /**
//     * 删除角色
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 删除条件
//     * @return 返回结果
//     */
//    int delRoles(CommonBean condition);
//
//    /**
//     * 查询权限数量
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 查询条件条件
//     * @return 返回结果
//     */
//    List<RolePermissionBean> getRolePermisstions(CommonBean CommonBean);
//
//    /**
//     * 查询所有菜单名称
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 查询条件条件
//     * @return 返回结果
//     */
//    List<ItemManagerBean> getAllItemManage();
//
//    /**
//     * 更新权限前锁定
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param CommonBean 查询条件条件
//     * @return 返回结果
//     */
//    List<RolePermissionBean> getRolePers(CommonBean CommonBean);
//
//    /**
//     * 添加权限
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param condition 查询条件条件
//     * @return 返回结果
//     */
//    int addRolePermission(CommonBean CommonBean);
//
//    /**
//     * 更新角色前查询锁定
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param CommonBean 查询条件条件
//     * @return 返回结果
//     */
//    List<RolesBean> selRolesBean(CommonBean CommonBean);
//
//    /**
//     * 更新角色
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param CommonBean 更新条件
//     * @return 返回结果
//     */
//    int updateRolesBean(CommonBean CommonBean);
//
    /**
     * 添加用户登录日志
     * <p>
     * 编辑service输入值，调用sql语句,处理sql的返回结果
     * </p>
     * 
     * @param CommonBean 添加参数
     * @return 返回结果
     */
    int addUserLog(CommonBean CommonBean);

    /**
     * 查询用户登录日志
     * <p>
     * 编辑service输入值，调用sql语句,处理sql的返回结果
     * </p>
     * 
     * @param CommonBean 添加参数
     * @return 返回结果
     */
    UserEventLogBean selectUserLog(CommonBean CommonBean);

    /**
     * 用户表进行更新前的锁定
     * <p>
     * 用户表进行更新前的锁定
     * </p>
     * 
     * @param CommonBean 锁定的参数
     * @return 返回结果
     */
    int selectLockUser(CommonBean CommonBean);

    /**
     * 用户状态变成锁定状态
     * <p>
     * 用户状态变成锁定状态
     * </p>
     * 
     * @param CommonBean 锁定的参数
     * @return 返回结果
     */
    int lockUser(CommonBean CommonBean);
//
//
//
//    /**
//     * 更新查询节点用户名密码信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param CommonBean 查询条件条件
//     * @return 返回结果
//     */
//    void updNodeUserAndPwd(CommonBean CommonBean);
//
//    /**
//     * 更新查询节点用户名密码信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param CommonBean 查询条件条件
//     * @return 返回结果
//     */
//    int updNodeUserAndPwdForIP(CommonBean CommonBean);
//
//    /**
//     * 删除配置文件路径信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param CommonBean 查询条件条件
//     * @return 返回结果
//     */
//    void delFilePath(CommonBean CommonBean);
//
//    /**
//     * 新增配置文件路径信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param CommonBean 查询条件条件
//     * @return 返回结果
//     */
//    void insertFilePath(CommonBean CommonBean);
//
//    /**
//     * 查询配置文件路径信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param CommonBean 查询条件条件
//     * @return 返回结果
//     */
//    List<String> getFilePathForName(CommonBean CommonBean);
//
//
//    /**
//     * 更新查询节点用户名密码信息
//     * <p>
//     * 编辑service输入值，调用sql语句,处理sql的返回结果
//     * </p>
//     * 
//     * @param CommonBean 查询条件条件
//     * @return 返回结果
//     */
//    int insertNodeUserAndPwd(CommonBean CommonBean);

}
