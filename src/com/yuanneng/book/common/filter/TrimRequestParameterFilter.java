package com.yuanneng.book.common.filter;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TrimRequestParameterFilter implements Filter {

    private static Log log = LogFactory.getLog(TrimRequestParameterFilter.class);

    private String trimPattern;

    private boolean ignoreFlag = false;

    @Override
    public void init(FilterConfig config) throws ServletException {
        String trimPattern = config.getInitParameter("trimPattern");

        if (trimPattern == null) {
            log.warn("trimPattern cannot be null.");
            this.ignoreFlag = true;
        } else {
            try {
                Pattern.compile(trimPattern);
                this.trimPattern = trimPattern;
            } catch (PatternSyntaxException e) {
                log.warn("The format of trimPattern is not correct.");
                this.ignoreFlag = true;
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String contentType = request.getContentType();
        if (!ignoreFlag) {
            if (contentType != null && contentType.startsWith("multipart/form-data")) {
                chain.doFilter(request, response);
            } else {
                if (request instanceof HttpServletRequest) {
                    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                    chain.doFilter(getParameterTrimmedHttpServletRequest(httpServletRequest),
                            response);
                } else {
                    chain.doFilter(request, response);
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        this.trimPattern = null;
    }

    protected HttpServletRequest getParameterTrimmedHttpServletRequest(HttpServletRequest request) {
        return new ParameterTrimmedHttpServletRequest(request, this.trimPattern);
    }
}
