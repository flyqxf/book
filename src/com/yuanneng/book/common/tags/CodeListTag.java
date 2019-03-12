package com.yuanneng.book.common.tags;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.yuanneng.book.common.entity.CodeBaseBean;

//自定义标签的规范   该标签的功能:显示所有的学生的详细资料   
//1、继承：javax.servlet.jsp.tagext.TagSupport   
//2、重写方法doEndTag和doStartTag（系统自动调用）   
// TODO 未整理，先跑着
public class CodeListTag extends SimpleTagSupport {

    /**
     * @return the codeListId
     */
    public String getCodeListId() {
        return codeListId;
    }

    /**
     * @param codeListId the codeListId to set
     */
    public void setCodeListId(String codeListId) {
        this.codeListId = codeListId;
    }

    private String codeListId;

    private String key;

    private String value;

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    public CodeListTag() {
    }

    @Override
    public void doTag() throws JspException, IOException {
        // getJspContext.
        ServletContext app = ((PageContext) getJspContext()).getServletContext();

        @SuppressWarnings("unchecked")
        Map<String, List<CodeBaseBean>> codeListAll = (Map<String, List<CodeBaseBean>>) app
                .getAttribute("CodeListMap");

        List<CodeBaseBean> codeList = codeListAll.get(codeListId);
        // getJspContext().setAttribute(key, codeList);
        for (CodeBaseBean item : codeList) {
            getJspContext().setAttribute(key, item.getKey());
            getJspContext().setAttribute(value, item.getName());
            getJspBody().invoke(null);
        }
    }
}
