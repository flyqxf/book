/*
 * @(#)ShowBoxAction.java
 */
package com.yuanneng.book.common.action;

import javax.annotation.Resource;

import com.yuanneng.book.common.service.ICommonService;

/**
 * ShowBoxAction.java
 * 
 * 功 能： 首页显示漏洞订阅窗口,异步
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.20         meiqiong        新规做成
 * </pre>
 */
public class ShowBoxAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 返回值
     */
    private String resJson;

    /**
     * 查询服务
     */
    @Resource
    private ICommonService commonService;

    /**
     * @return 返回值
     */
    public String getResJson() {
        return resJson;
    }

    /**
     * @param resJson 返回值
     */
    public void setResJson(String resJson) {
        this.resJson = resJson;
    }

    /**
     * 主要逻辑方法
     * <p>
     * 显示趋势图
     * </p>
     * 
     * @return 处理结果
     */
    @Override
    public String doMain() throws Exception {
        // 取得关键字一览
        return SUCCESS;
    }
}
