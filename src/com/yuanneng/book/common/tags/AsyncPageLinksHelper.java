package com.yuanneng.book.common.tags;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yuanneng.book.common.utils.PropertyUtil;

public class AsyncPageLinksHelper {

    /**
     * 日志
     */
    // TODO log未修正
    private static Log log = LogFactory.getLog(AsyncPageLinksHelper.class);

    /**
     * 最大页数
     */
    protected int maxPageCount = 10;

    /**
     * 最大link数
     */
    protected int maxLinkNo = 1;

    /**
     * 页面迁移link集合
     */
    protected Map<String, String> links = new HashMap<String, String>();

    /**
     * property文件的配置（pageLinks.XXXXX）
     */
    protected static String PAGE_LINKS_PREFIX = "pageLinks.";

    /**
     * 显示的页码个数
     */
    protected static String MAX_DSP_SIZE = "maxDirectLinkCount";

    /**
     * property文件的配置（前XXX页）
     */
    protected static String PREV_LINKS = "prev";

    /**
     * property文件的配置（后XXX页）
     */
    protected static String NEXT_LINKS = "next";

    /**
     * property文件的配置（后缀）
     */
    protected static String CHAR_LINKS = ".char";

    /**
     * property文件的配置（首页）
     */
    protected static String FIRST_LINKS = "first";

    /**
     * property文件的配置（尾页）
     */
    protected static String LAST_LINKS = "last";

    private AsyncPageLinksHelper() {
        getLinkProperty();
    }

    private static AsyncPageLinksHelper single = null;

    // 静态工厂方法
    public static AsyncPageLinksHelper getInstance() {
        if (single == null) {
            single = new AsyncPageLinksHelper();
        }
        return single;
    }

    public String getTotalAsync(int row, int startIndex, int totalCount) {
        StringBuilder sb = new StringBuilder();
        addFirstAsync(sb, row, startIndex, totalCount);
        addPrevAsync(sb, row, startIndex, totalCount);
        addDirectAsync(sb, row, startIndex, totalCount);
        addNextAsync(sb, row, startIndex, totalCount);
        addLastAsync(sb, row, startIndex, totalCount);
        addTotalAsync(sb, row, startIndex, totalCount);
        return sb.toString();
    }

    /**
     * HTML生成 关于首页的
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    public void addFirstAsync(StringBuilder sb, int row, int startIndex, int totalCount) {
        // 输出HTML
        String linkKey = FIRST_LINKS + CHAR_LINKS;
        String linkValue = links.get(linkKey);
        // 前xxx页不保存在map中时，就跳过
        if (StringUtils.isEmpty(linkValue)) {
            return;
        }
        if (startIndex <= 0) {
            sb.append("<span>" + linkValue + "</span>");
        } else {
            sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinks(");
            sb.append("'" + row + "'");
            sb.append(",");
            sb.append("'0'");
            sb.append(")\">");
            sb.append(linkValue);
            sb.append("</a>");
        }
    }

    /**
     * HTML生成 关于尾页的
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    public void addLastAsync(StringBuilder sb, int row, int startIndex, int totalCount) {
        // 输出HTML
        String linkKey = LAST_LINKS + CHAR_LINKS;
        String linkValue = links.get(linkKey);
        // 前xxx页不保存在map中时，就跳过
        if (StringUtils.isEmpty(linkValue)) {
            return;
        }
        // 最后一页的第一条数据编号
        int times = totalCount / row;
        int index = row * times;
        if (index == totalCount) {
            index = index - row;
        }
        if (startIndex >= index) {
            sb.append("<span>" + linkValue + "</span>");
        } else {
            sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinks(");
            sb.append("'" + row + "'");
            sb.append(",");
            sb.append("'" + index + "'");
            sb.append(")\">");
            sb.append(linkValue);
            sb.append("</a>");
        }
    }

    /**
     * HTML生成 关于尾页的
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    public void addTotalAsync(StringBuilder sb, int row, int startIndex, int totalCount) {

        // 总页数+总件数
        int pageCount = getPageCount(row, totalCount);
        sb.append("<span><label>");
        sb.append("总数：" + totalCount + ",");
        sb.append(" 共" + pageCount + "页");
        sb.append("</label></span>");
    }

    /**
     * HTML生成 关于前XXX页的
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    public void addPrevAsync(StringBuilder sb, int row, int startIndex, int totalCount) {
        // 前XXX页的link
        for (int i = maxLinkNo; i > 0; i--) {
            String linkKey = PREV_LINKS + i + CHAR_LINKS;
            String linkValue = links.get(linkKey);
            // 前xxx页不保存在map中时，就跳过
            if (StringUtils.isEmpty(linkValue)) {
                continue;
            }
            int index = startIndex - (i * row);
            if (index < 0) {
                sb.append("<span>" + linkValue + "</span>");
            } else {
                sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinks(");
                sb.append("'" + row + "'");
                sb.append(",");
                sb.append("'" + index + "'");
                sb.append(")\">");
                sb.append(linkValue);
                sb.append("</a>");
            }
        }
    }

    /**
     * HTML生成 关于页号的html
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    public void addDirectAsync(StringBuilder sb, int row, int startIndex, int totalCount) {
        // 显示页数的长度
        String directLinkNo = links.get(MAX_DSP_SIZE);
        if (directLinkNo != null) {
            try {
                maxPageCount = Integer.parseInt(directLinkNo);
            } catch (NumberFormatException e) {
                // 数字转化失败的场合
                log.error(e.getMessage());
            }
        }

        // 总页数
        int pageCount = getPageCount(row, totalCount);

        // 当前页数
        int pageIndex = getPageIndex(row, startIndex);

        // 初期化显示的起始页，起点为0
        int startPage = 0;
        // 初期化显示的长度
        int endPage = 0;

        // 算法：计算起始页和显示长度的两条数据
        if (pageCount > maxPageCount && pageIndex > (maxPageCount / 2)) {
            // 算出显示长度
            endPage = maxPageCount;

            startPage = (pageIndex - (endPage / 2)) - 1;
            // 重设置起点
            if (startPage + endPage > pageCount) {
                startPage = pageCount - endPage;
            }
        } else {
            endPage = pageCount < maxPageCount ? pageCount : maxPageCount;
            startPage = 0;
        }

        // 显示的页数
        int size = startPage + endPage;
        // 输出html
        for (int i = startPage; i < size; i++) {
            int idx = i + 1;
            if (pageIndex == idx) {
                sb.append("<span><b>");
                sb.append(idx);
                sb.append("</b></span>");
            } else {
                sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinks(");
                sb.append("'" + row + "'");
                sb.append(",");
                sb.append("'" + i * row + "'");
                sb.append(")\">");
                sb.append(idx);
                sb.append("</a>");
            }
        }
    }

    /**
     * HTML生成 关于前XXX页的
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    public void addNextAsync(StringBuilder sb, int row, int startIndex, int totalCount) {
        // 输出html
        for (int i = 1; i <= maxLinkNo; i++) {
            String linkKey = NEXT_LINKS + i + CHAR_LINKS;
            String linkValue = links.get(linkKey);
            // 前xxx页不保存在map中时，就跳过
            if (StringUtils.isEmpty(linkValue)) {
                continue;
            }

            int index = startIndex + (i * row);
            if (index > (totalCount - 1)) {
                sb.append("<span>" + linkValue + "</span>");
            } else {
                sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinks(");
                sb.append("'" + row + "'");
                sb.append(",");
                sb.append("'" + index + "'");
                sb.append(")\">");
                sb.append(linkValue);
                sb.append("</a>");
            }
        }
    }

    /**
     * HTML生成 关于首页的
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    protected void addFirstSubmit(StringBuilder sb, int row, int startIndex, int totalCount) {
        // 输出HTML
        String linkKey = FIRST_LINKS + CHAR_LINKS;
        String linkValue = links.get(linkKey);
        // 前xxx页不保存在map中时，就跳过
        if (StringUtils.isEmpty(linkValue)) {
            return;
        }
        if (startIndex <= 0) {
            sb.append("<span>" + linkValue + "</span>");
        } else {
            sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinkSubmit(");
            sb.append(row);
            sb.append(",");
            sb.append("0");
            addCurrentPageNo(sb, row, startIndex);
            sb.append(")\">");
            sb.append(linkValue);
            sb.append("</a>");
        }
    }

    /**
     * HTML生成 关于尾页的
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    protected void addLastSubmit(StringBuilder sb, int row, int startIndex, int totalCount) {

        // 输出HTML
        String linkKey = LAST_LINKS + CHAR_LINKS;
        String linkValue = links.get(linkKey);
        // 前xxx页不保存在map中时，就跳过
        if (StringUtils.isEmpty(linkValue)) {
            return;
        }
        // 最后一页的第一条数据编号
        int times = totalCount / row;
        int index = row * times;
        if (index == totalCount) {
            index = index - row;
        }
        if (startIndex >= index) {
            sb.append("<span>" + linkValue + "</span>");
        } else {
            sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinkSubmit(");
            sb.append(row);
            sb.append(",");
            sb.append(index);
            addCurrentPageNo(sb, row, startIndex);
            sb.append(")\">");
            sb.append(linkValue);
            sb.append("</a>");
        }
    }

    /**
     * HTML生成 关于前XXX页的
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    protected void addPrevSubmit(StringBuilder sb, int row, int startIndex, int totalCount) {
        // 输出HTML
        for (int i = maxLinkNo; i > 0; i--) {
            String linkKey = PREV_LINKS + i + CHAR_LINKS;
            String linkValue = links.get(linkKey);
            // 前xxx页不保存在map中时，就跳过
            if (StringUtils.isEmpty(linkValue)) {
                continue;
            }
            int index = startIndex - (i * row);
            if (index < 0) {
                sb.append("<span>" + linkValue + "</span>");
            } else {
                sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinkSubmit(");
                sb.append(row);
                sb.append(",");
                sb.append(index);
                addCurrentPageNo(sb, row, startIndex);
                sb.append(")\">");
                sb.append(linkValue);
                sb.append("</a>");
            }
        }
    }

    /**
     * HTML生成 关于页号的html
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    protected void addDirectSubmit(StringBuilder sb, int row, int startIndex, int totalCount) {
        // 显示页数的长度
        String directLinkNo = links.get(MAX_DSP_SIZE);
        if (directLinkNo != null) {
            try {
                maxPageCount = Integer.parseInt(directLinkNo);
            } catch (NumberFormatException e) {
                // 数字转化失败的场合
                log.error(e.getMessage());
            }
        }

        // 总页数
        int pageCount = getPageCount(row, totalCount);

        // 当前页数
        int pageIndex = getPageIndex(row, startIndex);

        // 初期化显示的起始页，起点为0
        int startPage = 0;
        // 初期化显示的长度
        int endPage = 0;

        // 算法：计算起始页和显示长度的两条数据
        if (pageCount > maxPageCount && pageIndex > (maxPageCount / 2)) {
            // 算出显示长度
            endPage = maxPageCount;

            startPage = (pageIndex - (endPage / 2)) - 1;
            // 重设置起点
            if (startPage + endPage > pageCount) {
                startPage = pageCount - endPage;
            }
        } else {
            endPage = pageCount < maxPageCount ? pageCount : maxPageCount;
            startPage = 0;
        }

        // 显示的页数
        int size = startPage + endPage;
        // 输出html
        for (int i = startPage; i < size; i++) {
            int idx = i + 1;
            if (pageIndex == idx) {
                sb.append("<span><b>");
                sb.append(idx);
                sb.append("</b></span>");
            } else {
                sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinkSubmit(");
                sb.append(row);
                sb.append(",");
                sb.append(i * row);
                addCurrentPageNo(sb, row, startIndex);
                sb.append(")\">");
                sb.append(idx);
                sb.append("</a>");
            }
        }
    }

    /**
     * HTML生成 关于前XXX页的
     * 
     * @param sb html页面保存用的StringBuilder
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     */
    protected void addNextSubmit(StringBuilder sb, int row, int startIndex, int totalCount) {
        // 输出html
        for (int i = 1; i <= maxLinkNo; i++) {
            String linkKey = NEXT_LINKS + i + CHAR_LINKS;
            String linkValue = links.get(linkKey);
            // 前xxx页不保存在map中时，就跳过
            if (StringUtils.isEmpty(linkValue)) {
                continue;
            }

            int index = startIndex + (i * row);
            if (index > (totalCount - 1)) {
                sb.append("<span>" + linkValue + "</span>");
            } else {
                sb.append("<a href=\"javascript:void(0)\" onclick=\"pageLinkSubmit(");
                sb.append(row);
                sb.append(",");
                sb.append(index);
                addCurrentPageNo(sb, row, startIndex);
                sb.append(")\">");
                sb.append(linkValue);
                sb.append("</a>");
            }
        }
    }

    /**
     * 根据每页的行数和起始编号计算取得页数
     * 
     * @param row 每页的行数
     * @param startIndex 起始数据编号
     * @return 页数
     */
    protected int getPageIndex(int row, int startIndex) {

        // 初期化页数
        int pageIndex = 0;
        if (row > 0) {
            pageIndex = startIndex / row + 1;
        } else {
            pageIndex = 0;
        }
        // 正常情况下都是整除，没有余数
        if (row > 0 && startIndex % row > 0) {
            pageIndex++;
        }

        return pageIndex;

    }

    /**
     * 取得总页数
     * 
     * @param row 每页的行数
     * @param totalCount 总数据量
     * @return 总页数
     */
    protected int getPageCount(int row, int totalCount) {

        // 初期化总页数
        int pageCount = 0;
        if (row > 0) {
            pageCount = totalCount / row;
            if (totalCount % row > 0) {
                pageCount++;
            }
        } else {
            pageCount = 1;
        }
        return pageCount;
    }

    /**
     * 取得配置信息的link
     */
    private void getLinkProperty() {
        // 取得pageLinks.XXXXX的所有配置信息
        Enumeration<String> enume = PropertyUtil.getPropertyNames(PAGE_LINKS_PREFIX);
        while (enume.hasMoreElements()) {
            String propName = (String) enume.nextElement();
            // 去掉前缀的key
            String id = propName.substring(PAGE_LINKS_PREFIX.length());
            // 画面显示的link内容
            String link = PropertyUtil.getProperty(propName);

            // key为prev或者next开头的场合
            if ((id != null) && (id.startsWith(PREV_LINKS) || id.startsWith(NEXT_LINKS))) {
                // 取得prev或者next后面的数字
                String strLinkNo = id.substring(4, id.lastIndexOf(CHAR_LINKS));
                int intLinkNo = 0;
                try {
                    // 数字转换成数字类型
                    intLinkNo = Integer.parseInt(strLinkNo);
                } catch (NumberFormatException e) {
                    // 失败的场合，循环继续
                    continue;
                }
                // 重置最大link数
                if (intLinkNo > maxLinkNo) {
                    maxLinkNo = intLinkNo;
                }
                // 去掉前缀的key-value保存起来（只针对前XXX页，后XXX页的配置信息）
                links.put(id, link);
            } else if ((id != null) && (id.startsWith(FIRST_LINKS) || (id.startsWith(LAST_LINKS)))) {
                // 去掉前缀的key-value保存起来（只针对首页，尾页）
                links.put(id, link);
            } else if (MAX_DSP_SIZE.equals(id)) {
                // 去掉前缀的key-value保存起来（只针对配置信息为"maxDirectLinkCount"时）
                links.put(id, link);
            }
        }
    }

    /**
     * 取得数值类型的数值
     * 
     * @param obj 数值对象
     * @return int型数值
     * @throws JspException JSP例外
     */
    protected int getInt(Object obj) throws JspException {
        int retInt = 0;
        String value = ObjectUtils.toString(obj);
        if (StringUtils.isNotEmpty(value)) {
            try {
                retInt = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                // TODO log
                log.error(e.getMessage());
                throw new JspException(e);
            }
        }
        return retInt;
    }

    /**
     * 返回name和property定位的对象
     * 
     * @param pageContext 页面上下文信息
     * @param name 名称（FORM名）
     * @param property
     * @return 返回name和property定位的对象
     * @throws JspException JSP例外
     */
    protected Object lookup(PageContext pageContext, String name, String property)
            throws JspException {
        if (StringUtils.isEmpty(property)) {
            return null;
        }
        Object retObj = null;
        if (StringUtils.isEmpty(name)) {
            retObj = pageContext.getAttribute(property, PageContext.SESSION_SCOPE);
        } else {
            retObj = pageContext.getAttribute(name, PageContext.SESSION_SCOPE);
            if (property == null) {
                return retObj;
            }
            try {
                return PropertyUtils.getProperty(retObj, property);
            } catch (IllegalAccessException e) {
                throw new JspException("lookup.access".concat(name).concat(property));
            } catch (IllegalArgumentException e) {
                throw new JspException("lookup.argument".concat(name).concat(property));
            } catch (InvocationTargetException e) {
                throw new JspException("lookup.target".concat(name).concat(property));
            } catch (NoSuchMethodException e) {
                throw new JspException("lookup.method".concat(name).concat(property));
            }
        }
        return retObj;
    }

    /**
     * 从页面上下文根据key取得value值
     * 
     * @param pageContext 页面上下文
     * @param key 键值
     * @return 根据key取得的value值（布尔类型）
     */
    protected boolean getPageContextFlg(PageContext pageContext, String key) {
        //
        Object obj = pageContext.getAttribute(key);
        Boolean bol = new Boolean(false);
        if (obj != null && obj instanceof Boolean) {
            bol = (Boolean) obj;
        }
        return bol.booleanValue();
    }

    /**
     * 在页面上下文里，给key值设置true的值
     * 
     * @param pageContext 页面上下文
     * @param key 键值
     */
    protected void setPageContextFlg(PageContext pageContext, String key) {
        // 给key设值
        pageContext.setAttribute(key, Boolean.valueOf(true));
    }

    private void addCurrentPageNo(StringBuilder sb, int row, int startIndex) {
        int currentPageNo = startIndex / row + 1;
        if (startIndex % row > 0)
            currentPageNo++;
        sb.append(",");
        sb.append(currentPageNo);
    }
}
