package com.yuanneng.book.common.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yuanneng.book.common.log.LogHelper;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.FormatedTime;

public class ActionLogFilter implements Filter {

    private static final String REGEX = ".action$";

    private static final String ACTION = "client action: ";

    private static Log log = LogFactory.getLog(ActionLogFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // event日志输出用的时间去的
        String timer = BusinessUtils.getSystemTimeString(FormatedTime.HYPHEN_YYYYMMDD_HHMMSS_SSS);
        // ACTION名取得
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();
        // 去掉后缀
        String regexPath = Pattern.compile(REGEX).matcher(path).replaceFirst(Constant.STRING_BLANK);
        String msg = ACTION.concat(Constant.DOUBLE_QUOTE).concat(regexPath)
                .concat(Constant.DOUBLE_QUOTE).concat(Constant.LOG_START);
        // debug开始日志输出
        LogHelper.info(log, msg);

        // 执行处理
        chain.doFilter(request, response);

        // event日志输出
        LogHelper.event(timer, regexPath);

        msg = ACTION.concat(Constant.DOUBLE_QUOTE).concat(regexPath).concat(Constant.DOUBLE_QUOTE)
                .concat(Constant.LOG_END);
        // debug结束日志输出
        LogHelper.info(log, msg);

    }

    @Override
    public void destroy() {
    }
}
