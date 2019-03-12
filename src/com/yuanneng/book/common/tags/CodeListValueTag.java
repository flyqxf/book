package com.yuanneng.book.common.tags;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.yuanneng.book.common.entity.CodeBaseBean;
import com.yuanneng.book.common.utils.Constant;

// TODO 未整理，先跑着
public class CodeListValueTag extends SimpleTagSupport {

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

    public CodeListValueTag() {
    }

    @Override
    public void doTag() throws JspException, IOException {
        // getJspContext.
        ServletContext app = ((PageContext) getJspContext()).getServletContext();

        @SuppressWarnings("unchecked")
        Map<String, List<CodeBaseBean>> codeListAll = (Map<String, List<CodeBaseBean>>) app
                .getAttribute("CodeListMap");

        List<CodeBaseBean> codeList = codeListAll.get(codeListId);
        JspWriter writer = getJspContext().getOut();
        boolean printOut = false;
        for (CodeBaseBean item : codeList) {
            if (StringUtils.isNotEmpty(key) && key.equals(item.getKey())) {
                printOut = true;
                writer.println(item.getName());
                break;
            }
        }
        if (!printOut) {
            writer.println(Constant.STRING_BLANK);
        }
    }
}
