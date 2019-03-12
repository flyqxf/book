package com.yuanneng.book.common.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.yuanneng.book.common.dao.ICommonSqlDao;
import com.yuanneng.book.common.entity.CodeExtendBean;
import com.yuanneng.book.common.entity.CommonBean;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.entity.OrganizationBean;
import com.yuanneng.book.common.entity.PolicyBean;
import com.yuanneng.book.common.entity.ResultMap;
import com.yuanneng.book.common.entity.TemplateBean;
import com.yuanneng.book.common.entity.VulNewsSubConfigBean;
import com.yuanneng.book.common.entity.VulNewsSubKeywordBean;
import com.yuanneng.book.common.entity.VulNewsSubNewsBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.CodeConstant;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.FormatedTime;
import com.yuanneng.book.common.utils.PropertyUtil;

/**
 * ICommonService.java
 * 
 * 功 能： 共通Service
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.31         肖健            新规做成
 * </pre>
 */
public class ICommonService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(ICommonService.class);

    /**
     * 起点数据编号
     */
    private String indexProperty;

    /**
     * DAO对象
     */
    @Resource
    public ICommonSqlDao commonSqlDao;

    /**
     * 查询页面项目管理表数据
     * 
     * @return 页面项目管理表数据
     */
    public List<CodeExtendBean> getSearchResult() {
        // 调用DAO处理
        return commonSqlDao.getCodeListRecord();
    }

    /**
     * 查询组织机构表数据
     * 
     * @return 组织机构表数据
     */
    public List<OrganizationBean> getOrgListRecord() {
        // 调用DAO处理
        return commonSqlDao.getOrgListRecord();
    }

    /**
     * 组织机构管辖IP地址范围查询
     * 
     * @param orgId 组织机构ID
     * @return 管辖IP地址列表
     */
    public String searchOrganizationIpList(String orgId) {
        // 调用DAO处理
        return commonSqlDao.select_Cmn_017(orgId);
    }

    /**
     * 编辑曲线
     */
    public JSONArray editCurve(List<ResultMap> total, List<String> dateList) {
        List<String> outList = new ArrayList<String>();
        for (String date : dateList) {
            long num = 0;
            for (ResultMap item : total) {
                if (date.equals(item.getTimeDateStr())) {
                    num++;
                }
            }
            outList.add(String.valueOf(num));
        }
        JSONArray json = new JSONArray();
        for (String item : outList) {
            json.add(Constant.DOUBLE_QUOTE + item + Constant.DOUBLE_QUOTE);
        }
        return json;
    }

    /**
     * 删除关键字一览
     */
    public int deleteKeyword(VulNewsSubKeywordBean condition) {
        // 编辑参数
        condition.setUpdateDate(Constant.STRING_EMPTY.equals(condition.getUpdateDateStr()) ? null
                : BusinessUtils.getTime(condition.getUpdateDateStr(),
                        FormatedTime.HYPHEN_YYYYMMDD_HHMMSS));
        // 调用DAO处理
        int num = commonSqlDao.deleteKeyword(condition);
        return num;
    }

    /**
     * 添加关键字一览
     */
    public int addKeyword(VulNewsSubKeywordBean condition) {
        // 调用DAO处理
        int num = commonSqlDao.addKeyword(condition);
        return num;
    }

    /**
     * 修改关键字一览
     */
    public int updateKeyword(VulNewsSubKeywordBean condition) {
        // 编辑参数
        Date updateDate = Constant.STRING_EMPTY.equals(condition.getUpdateDateStr()) ? null
                : BusinessUtils.getTime(condition.getUpdateDateStr(),
                        FormatedTime.HYPHEN_YYYYMMDD_HHMMSS);
        condition.setUpdateDate(updateDate);
        // 调用DAO处理
        int num = commonSqlDao.updateKeyword(condition);
        return num;
    }

    /**
     * 检索邮箱一览
     */
    public List<VulNewsSubConfigBean> selectAllMails() {
        // 调用DAO处理
        List<VulNewsSubConfigBean> rtn = commonSqlDao.selectAllMails(new CommonBean());
        return rtn;
    }

    /**
     * 更新邮箱
     */
    public int updateMail(VulNewsSubConfigBean condition) {
        // 调用DAO处理
        int num = commonSqlDao.updateMail(condition);
        return num;
    }

    /**
     * 删除邮箱
     */
    public int deleteMail(VulNewsSubConfigBean condition) {
        // 调用DAO处理
        int num = commonSqlDao.deleteMail(condition);
        return num;
    }

    /**
     * 添加邮箱
     */
    public int addMail(VulNewsSubConfigBean condition) {
        // 编辑条件
        condition.setAutoSendMail(Constant.STRING_ZERO);
        // 调用DAO处理
        int num = commonSqlDao.addMail(condition);
        return num;
    }

    /**
     * 根据漏洞管理的检索条件，取得检索结果
     * <p>
     * 一览检索机能
     * </p>
     * 
     * @return 处理结果
     */
    public CommonPageLinksBean<VulNewsSubNewsBean> setNewsResult(List<VulNewsSubNewsBean> rstList) {
        // 初始化
        CommonPageLinksBean<VulNewsSubNewsBean> result = new CommonPageLinksBean<VulNewsSubNewsBean>();
        if (StringUtils.isEmpty(indexProperty)) {
            indexProperty = Constant.STRING_ZERO;
        }

        // 设置结果一览
        result.setResultList(rstList);
        // 设置起始编号
        result.setIndexProperty(indexProperty);

        result.setNumProperty(Integer.parseInt(indexProperty));

        // 设置每页显示行数
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        // 设置总量
        result.setTotalProperty(String.valueOf(rstList.size()));
        // 设置结束编号
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        // 返回结果
        return result;
    }

    /**
     * 获取组织机构管辖IP地址范围，并判断输入IP地址是否符合管辖范围
     * 
     * @param orgId 组织机构ID
     * @param ipAddrList IP地址列表
     */
    public List<String> isValidIpAddrByOrgId(String orgId, List<String> ipAddrList) {
        // 返回值
        List<String> resList = new ArrayList<String>();
        if (StringUtils.equals(CodeConstant.SUPPER_ADMIN_ORGID, orgId)) {
            return resList;
        }
        // 获取指定组织机构IP管辖范围
        String target = searchOrganizationIpList(orgId);
        List<String> ipOrgList = BusinessUtils.getIpList(target);
        Collections.sort(ipAddrList);

        // 逐条检测IP地址
        for (String targetIp : ipAddrList) {
            boolean result = false;
            for (String compareIp : ipOrgList) {
                if (StringUtils.equals(targetIp, compareIp)) {
                    result = true;
                    break;
                }
            }
            if (!result) {
                resList.add(targetIp);
            }
        }
        return resList;
    }

    /**
     * 查询模板数据
     * 
     * @return 查询模板数据
     */
    public List<TemplateBean> getTemplateRecord() {
        // 调用DAO处理
        return commonSqlDao.getTemplateRecord(new CommonBean());
    }

    /**
     * 查询策略数据
     * 
     * @return 查询模板数据
     */
    public List<PolicyBean> getPolicyRecord() {
        // 调用DAO处理
        return commonSqlDao.getPolicyRecord(new CommonBean());
    }

    public String getIndexProperty() {
        return indexProperty;
    }

    public void setIndexProperty(String indexProperty) {
        this.indexProperty = indexProperty;
    }
}
