package com.yuanneng.book.common.exception;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yuanneng.book.common.log.LogHelper;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;

public class UrlNotFoundHandler extends ActionSupport {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private static Log log = LogFactory.getLog(UrlNotFoundHandler.class);

    @Override
    public String execute() {
        BusinessUtils.clearSession();
        // 日志记录
        String path = ServletActionContext.getRequest().getServletPath();
        LogHelper.error(log,
                MessageFormat.format(PropertyUtil.getProperty(Constant.BOOKZ0028E), path));
        return SUCCESS;
    }
}
