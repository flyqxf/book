package com.yuanneng.book.common.dao;

import java.util.List;

import com.yuanneng.book.common.entity.CodeExtendBean;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.common.entity.OrganizationBean;
import com.yuanneng.book.common.entity.PolicyBean;
import com.yuanneng.book.common.entity.TemplateBean;
import com.yuanneng.book.common.entity.VulNewsSubConfigBean;

/**
 * ICommonSqlDao.java
 * 
 * 功 能： 共通SQL处理Dao
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.31         肖健            新规做成
 * </pre>
 */
public interface ICommonSqlDao extends CommonDao {

    /**
     * 查询页面项目管理表数据
     * 
     * @return 页面项目管理表数据
     */
    public List<CodeExtendBean> getCodeListRecord();

    /**
     * 查询组织机构表数据
     * 
     * @return 组织机构表数据
     */
    public List<OrganizationBean> getOrgListRecord();

    /**
     * 组织机构管辖IP地址范围查询
     * 
     * @param orgId 组织机构ID
     * @return 管辖IP地址列表
     */
    public String select_Cmn_017(String orgId);

    /**
     * 删除关键字
     * 
     * @param bean 查询条件
     * @return 查询结果
     */
    public int deleteKeyword(CommonBean bean);

    /**
     * 添加关键字
     * 
     * @param bean 添加条件
     * @return 添加结果
     */
    public int addKeyword(CommonBean bean);

    /**
     * 修改关键字
     * 
     * @param bean 修改条件
     * @return 修改结果
     */
    public int updateKeyword(CommonBean bean);

    /**
     * 检索所有邮箱
     * 
     * @param bean 查询条件
     * @return 查询结果
     */
    public List<VulNewsSubConfigBean> selectAllMails(CommonBean bean);

    /**
     * 更新邮箱
     * 
     * @param bean 更新条件
     * @return 更新结果
     */
    public int updateMail(CommonBean bean);

    /**
     * 删除邮箱
     * 
     * @param bean 删除条件
     * @return 删除结果
     */
    public int deleteMail(CommonBean bean);

    /**
     * 添加邮箱
     * 
     * @param bean 添加条件
     * @return 添加结果
     */
    public int addMail(CommonBean bean);

    /**
     * 查询模板信息
     * 
     * @param bean 查询条件
     * @return 查询结果
     */
    public List<TemplateBean> getTemplateRecord(CommonBean bean);

    /**
     * 查询策略信息
     * 
     * @param bean 查询条件
     * @return 查询结果
     */
    public List<PolicyBean> getPolicyRecord(CommonBean bean);
}
