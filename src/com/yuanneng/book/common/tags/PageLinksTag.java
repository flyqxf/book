/*
 * @(#)PageLinksTag.java
 */
package com.yuanneng.book.common.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;

/**
 * PageLinksTag.java
 * 
 * 功 能： 翻页功能的标签
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.09         meiqiong        新规做成
 * </pre>
 */
public class PageLinksTag extends TagSupport {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 日志
     */
    // TODO log未修正
    private static Log log = LogFactory.getLog(PageLinksTag.class);

    /**
     * ID
     */
    protected String id = null;

    /**
     * 绑定的form id
     */
    protected String bindFrom = null;

    /**
     * 动作名
     */
    protected String action = null;

    /**
     * 名称
     */
    protected String name = null;

    /**
     * 每页表示的行数
     */
    protected String rowProperty = null;

    /**
     * 起始数据的编号
     */
    protected String indexProperty = null;

    /**
     * 总数据量
     */
    protected String totalProperty = null;

    /**
     * 是否同步提交模式(submit or async)
     */
    protected boolean submit = true;

    /**
     * form名字
     */
    protected String form = null;

    /**
     * css样式
     */
    protected String classStyle = DEFAULT_CLASS_STYLE;

    /**
     * form的默认值
     */
    protected static String FORM_DEFAULT = "pageLinksForm";

    /**
     * 出错信息：ACTION属性必须设置
     */
    protected static String ERROR_MESSAGE_ACTION_REQUIRED = "Action attribute is required when submit attribute is \"false\".";

    /**
     * 出错信息：行数非法
     */
    protected static String WARN_MESSAGE_ILLEGAL_ROW = "Row param is illegal.";

    /**
     * JavaScript的key
     */
    protected static String PAGELINKS_JAVASCRIPT_KEY = "pageLinksJavaScriptKey";

    /**
     * JavaScript的key(异步)
     */
    protected static String ASYNC_PAGELINKS_JAVASCRIPT_KEY = "asyncPageLinksJavaScriptKey";

    /**
     * 默认样式
     */
    protected static String DEFAULT_CLASS_STYLE = PropertyUtil.getProperty("pageLinks.default.css");

    /**
     * 页面帮手
     */
    protected AsyncPageLinksHelper helper = AsyncPageLinksHelper.getInstance();

    /**
     * @return id ID
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * @param id ID
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return action 动作名
     */
    public String getAction() {
        return this.action;
    }

    /**
     * @param action 动作名
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return rowProperty 每页表示的行数
     */
    public String getRowProperty() {
        return rowProperty;
    }

    /**
     * @param rowProperty 每页表示的行数
     */
    public void setRowProperty(String rowProperty) {
        this.rowProperty = rowProperty;
    }

    /**
     * @return indexProperty 起始数据的编号
     */
    public String getIndexProperty() {
        return indexProperty;
    }

    /**
     * @param indexProperty 起始数据的编号
     */
    public void setIndexProperty(String indexProperty) {
        this.indexProperty = indexProperty;
    }

    /**
     * @return totalProperty 总数据量
     */
    public String getTotalProperty() {
        return totalProperty;
    }

    /**
     * @param totalProperty 总数据量
     */
    public void setTotalProperty(String totalProperty) {
        this.totalProperty = totalProperty;
    }

    /**
     * @return submitStyle 是否同步提交模式
     */
    public boolean getSubmit() {
        return submit;
    }

    /**
     * @param submit 是否同步提交模式
     */
    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

    /**
     * @return form 页面form名字
     */
    public String getForm() {
        return form;
    }

    /**
     * @param form 页面form名字
     */
    public void setForm(String form) {
        this.form = form;
    }

    /**
     * @return css样式
     */
    public String getClassStyle() {
        return classStyle;
    }

    /**
     * @param classStyle css样式
     */
    public void setClassStyle(String classStyle) {
        this.classStyle = classStyle;
    }

    public String getBindFrom() {
        return bindFrom;
    }

    public void setBindFrom(String bindFrom) {
        this.bindFrom = bindFrom;
    }

    /**
     * 标签处理主方法
     * 
     * @return 返回值
     * @throws JspException JSP例外
     */
    @Override
    public int doStartTag() throws JspException {

        // 非submit提交模式且action未设定的场合
        if (StringUtils.isEmpty(action)) {
            log.error(ERROR_MESSAGE_ACTION_REQUIRED);
            throw new JspException(ERROR_MESSAGE_ACTION_REQUIRED);
        }

        // 返回行数对象
        Object objRow = helper.lookup(pageContext, name, rowProperty);
        // 转换成数值类型
        int row = helper.getInt(objRow);

        // 数值异常时的处理
        if (row <= 0) {
            if (log.isWarnEnabled()) {
                log.warn(WARN_MESSAGE_ILLEGAL_ROW);
            }
            return EVAL_BODY_INCLUDE;
        }

        // 取得起始数据编号
        Object objIndex = helper.lookup(pageContext, name, indexProperty);
        // 转换成数值类型
        int startIndex = helper.getInt(objIndex);

        // 取得总数据量
        Object objTotal = helper.lookup(pageContext, name, totalProperty);
        // 转换成数值类型
        int totalCount = helper.getInt(objTotal);

        // 初期化
        StringBuilder sb = new StringBuilder();

        // 开头DIV
        sb.append("<div id=\"asyncPages\"");
        if (StringUtils.isNotEmpty(classStyle)) {
            sb.append(" class=\"" + classStyle + "\"");
        }
        sb.append(">");

        // submit提交为true时
        if (submit) {
            // 设定HTML:hidden和js的pageLinkSubmit方法
            defineHtml(row, startIndex, totalCount);

            // 关于首页的页面HTML
            helper.addFirstSubmit(sb, row, startIndex, totalCount);

            // 关于前XXX页的页面HTML
            helper.addPrevSubmit(sb, row, startIndex, totalCount);

            // 关于每页页号的HTML
            helper.addDirectSubmit(sb, row, startIndex, totalCount);

            // 关于后XXX页的页面HTML
            helper.addNextSubmit(sb, row, startIndex, totalCount);

            // 关于尾页的页面HTML
            helper.addLastSubmit(sb, row, startIndex, totalCount);

            // 关于总数和总页数的页面HTML
            helper.addTotalAsync(sb, row, startIndex, totalCount);

        } else {
            // 不是submit提交的场合，设定JS
            defineAsyncHtml(row, startIndex, totalCount);

            // 关于首页的页面HTML
            helper.addFirstAsync(sb, row, startIndex, totalCount);

            // 前XXX页的link
            helper.addPrevAsync(sb, row, startIndex, totalCount);

            // 关于每页页号的link
            helper.addDirectAsync(sb, row, startIndex, totalCount);

            // 关于后XXX页的页面HTML
            helper.addNextAsync(sb, row, startIndex, totalCount);

            // 关于尾页的页面HTML
            helper.addLastAsync(sb, row, startIndex, totalCount);

            // 关于总数和总页数的页面HTML
            helper.addTotalAsync(sb, row, startIndex, totalCount);
        }
        // 末尾DIV
        sb.append("</div>");

        // StringBuilder输出
        if (StringUtils.isEmpty(id)) {
            try {
                JspWriter writer = pageContext.getOut();
                writer.println(sb.toString());
            } catch (IOException e) {
                log.error(e.getMessage());
                throw new JspTagException(e.toString());
            }
        } else {
            // 感觉没什么用
            pageContext.setAttribute(id, sb.toString());
        }

        return EVAL_BODY_INCLUDE;
    }

    /**
     * HTML生成 基本参数的输出
     * 
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     * @throws JspException JSP例外
     */
    protected void defineHtml(int row, int startIndex, int totalCount) throws JspException {

        JspWriter writer = pageContext.getOut();
        try {
            // 设定form默认值
            if (StringUtils.isEmpty(form)) {
                form = FORM_DEFAULT;
            }
            if (StringUtils.isEmpty(bindFrom))
                // 输出form值
                writer.println("<form name=\"" + form + "\" action=\"" + action
                        + "\" method=\"post\">");
            // 如果sessionkey的key值设置为false的场合
            if (!helper.getPageContextFlg(pageContext, PAGELINKS_JAVASCRIPT_KEY + name)) {

                // session中的key值的输出
                writer.println("<input type=\"hidden\" name=\"key\" value=\"" + name + "\"/>");

                // 给每页行数的key值设置为true
                helper.setPageContextFlg(pageContext, PAGELINKS_JAVASCRIPT_KEY + name);
            }

            // 如果每页行数的key值设置为false的场合
            if (!helper.getPageContextFlg(pageContext, PAGELINKS_JAVASCRIPT_KEY + rowProperty)) {

                // 画面输出hidden内容：每页的行数
                writer.println("<input type=\"hidden\" name=\"" + rowProperty + "\" value=\"" + row
                        + "\"/>");

                // 给每页行数的key值设置为true
                helper.setPageContextFlg(pageContext, PAGELINKS_JAVASCRIPT_KEY + rowProperty);
            }

            // 如果起始数据编号的key值设置为false的场合
            if (!helper.getPageContextFlg(pageContext, PAGELINKS_JAVASCRIPT_KEY + indexProperty)) {

                // 画面输出hidden内容：起始数据编号
                writer.println("<input type=\"hidden\" name=\"" + indexProperty + "\" value=\""
                        + startIndex + "\"/>");

                // 给起始数据编号的key值设置为true
                helper.setPageContextFlg(pageContext, PAGELINKS_JAVASCRIPT_KEY + indexProperty);
            }
            // 当前页，默认为
            Integer currentPageNo = startIndex / row + 1;
            writer.println("<input type=\"hidden\" name='currentPageNo' value='" + currentPageNo
                    + "' />");

            if (StringUtils.isEmpty(bindFrom))
                // form结尾输出
                writer.println("</form>");

            // 页面上下文中javascriptkey的值为false的场合
            if (!helper.getPageContextFlg(pageContext, PAGELINKS_JAVASCRIPT_KEY)) {
                String formName = form;
                if (!StringUtils.isEmpty(bindFrom))
                    formName = bindFrom;

                // 输出js方法
                writer.println("<script type=\"text/javascript\">");
                writer.println("<!--");
                writer.println("    pageLinksLock=false;");
                writer.println("    function pageLinkSubmit(row, startIndex,currentPageNo) {");
                writer.println("        if (!pageLinksLock) {");
                writer.println("            pageLinksLock = true;");
                writer.println("            document." + formName + Constant.DOT + rowProperty
                        + ".value = row;");
                writer.println("            document." + formName + Constant.DOT + indexProperty
                        + ".value = startIndex;");
                writer.println("            document." + formName + Constant.DOT
                        + "currentPageNo.value=currentPageNo");
                writer.print("            document.");
                writer.print(formName);
                writer.print(".action='");
                writer.print(action);
                writer.println("'");
                writer.print("            document.");
                writer.print(formName);
                writer.println(".submit();");
                writer.println("        }");
                writer.println("    }");
                writer.println("// -->");
                writer.println("</script>");
                // 在页面上下文设置javascriptkey的值为true
                helper.setPageContextFlg(pageContext, PAGELINKS_JAVASCRIPT_KEY);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new JspTagException(e.toString());
        }
    }

    /**
     * HTML生成 基本参数的输出
     * 
     * @param row 每页的行数
     * @param startIndex 起始数据的编号
     * @param totalCount 总数据
     * @throws JspException JSP例外
     */
    protected void defineAsyncHtml(int row, int startIndex, int totalCount) throws JspException {
        // TODO 标签没有变化！！！！！
        JspWriter writer = pageContext.getOut();
        try {
            // 如果sessionkey的key值设置为false的场合
            if (!helper.getPageContextFlg(pageContext, ASYNC_PAGELINKS_JAVASCRIPT_KEY + name)) {

                // session中的key值的输出
                writer.println("<input type=\"hidden\" name=\"key\" value=\"" + name + "\"/>");

                // 给每页行数的key值设置为true
                helper.setPageContextFlg(pageContext, ASYNC_PAGELINKS_JAVASCRIPT_KEY + name);
            }

            // 如果每页行数的key值设置为false的场合
            if (!helper
                    .getPageContextFlg(pageContext, ASYNC_PAGELINKS_JAVASCRIPT_KEY + rowProperty)) {

                // 画面输出hidden内容：每页的行数
                writer.println("<input type=\"hidden\" name=\"" + rowProperty + "\" value=\"" + row
                        + "\"/>");

                // 给每页行数的key值设置为true
                helper.setPageContextFlg(pageContext, ASYNC_PAGELINKS_JAVASCRIPT_KEY + rowProperty);
            }

            // 如果起始数据编号的key值设置为false的场合
            if (!helper.getPageContextFlg(pageContext, ASYNC_PAGELINKS_JAVASCRIPT_KEY
                    + indexProperty)) {

                // 画面输出hidden内容：起始数据编号
                writer.println("<input type=\"hidden\" name=\"" + indexProperty + "\" value=\""
                        + startIndex + "\"/>");

                // 给起始数据编号的key值设置为true
                helper.setPageContextFlg(pageContext, ASYNC_PAGELINKS_JAVASCRIPT_KEY
                        + indexProperty);
            }
            // 页面上下文中javascriptkey的值为false的场合
            if (!helper.getPageContextFlg(pageContext, ASYNC_PAGELINKS_JAVASCRIPT_KEY)) {
                // 输出js方法
                writer.println("<script type=\"text/javascript\">");
                writer.println("<!--");
                writer.println("var pageLinks = function(row,index) {");
                writer.println("    if (row != undefined && row != \"\" && index != undefined && index != \"\") {");
                writer.println("        var obj = {");
                writer.println("            \"rowProperty\" : row,");
                writer.println("            \"indexProperty\" : index,");
                writer.println("            \"key\" : \"" + name + "\"");
                writer.println("        };");
                writer.println("        ajaxPostAction(\"" + action
                        + "\", obj, showPageLinks, \"翻页处理\");");
                writer.println("    }");
                writer.println("};");
                writer.println("// -->");
                writer.println("</script>");
                // 在页面上下文设置javascriptkey的值为true
                helper.setPageContextFlg(pageContext, ASYNC_PAGELINKS_JAVASCRIPT_KEY);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new JspTagException(e.toString());
        }
    }

    @Override
    public void release() {
        super.release();
        id = null;
        action = null;
        name = null;
        rowProperty = null;
        indexProperty = null;
        totalProperty = null;
        submit = false;
    }

}
