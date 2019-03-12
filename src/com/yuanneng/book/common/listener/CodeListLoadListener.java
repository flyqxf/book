package com.yuanneng.book.common.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yuanneng.book.common.dao.ICommonSqlDao;
import com.yuanneng.book.common.entity.CodeBaseBean;
import com.yuanneng.book.common.entity.CodeExtendBean;
import com.yuanneng.book.common.utils.Constant;

/**
 * CodeListLoadListener.java
 * 
 * 功 能： 共通页面项目列表获取Listener
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.31         肖健            新规做成
 * </pre>
 */
public class CodeListLoadListener implements ServletContextListener {

    /**
     * CodeListMap保存主键名
     */
    private static final String CODE_LIST_MAP_KEY = "CodeListMap";


    /**
     * ServletContext失效时处理
     * 
     * @param src ServletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent src) {
    }

    /**
     * ServletContext初始化处理
     * 
     * @param src ServletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent src) {
        ServletContext sct = src.getServletContext();

        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(src
                .getServletContext());
        ICommonSqlDao cmnSqlDao = (ICommonSqlDao) ac.getBean("commonSqlDao");

        // 获取CODELIST查询结果
        Map<String, List<CodeBaseBean>> codeListMap = getCodeListMap(cmnSqlDao);

        // 设定CODELISTMAP
        sct.setAttribute(CODE_LIST_MAP_KEY, codeListMap);
    }

    /**
     * 获取页面表示项目处理
     * 
     * @param cmnSqlDao 共通SQLDAO
     * @return 查询结果
     */
    private Map<String, List<CodeBaseBean>> getCodeListMap(ICommonSqlDao cmnSqlDao) {
        Map<String, List<CodeBaseBean>> codeListMap = new HashMap<String, List<CodeBaseBean>>();
        List<CodeExtendBean> resultList = null;

        resultList = cmnSqlDao.getCodeListRecord();
        if (resultList != null && resultList.size() > 0) {
            String id = Constant.STRING_BLANK;
            List<CodeBaseBean> codeList = new ArrayList<CodeBaseBean>();
            for (CodeExtendBean code : resultList) {
                if (StringUtils.isEmpty(id)) {
                    id = code.getId();
                }
                if (StringUtils.equals(id, code.getId())) {
                    codeList.add(new CodeBaseBean(code.getKey(), code.getName()));
                } else {
                    List<CodeBaseBean> temp = new ArrayList<CodeBaseBean>();
                    temp.addAll(codeList);
                    codeListMap.put(id, temp);
                    id = code.getId();
                    codeList.clear();
                    codeList.add(new CodeBaseBean(code.getKey(), code.getName()));
                }
            }
            codeListMap.put(id, codeList);
        }
        return codeListMap;
    }

}
