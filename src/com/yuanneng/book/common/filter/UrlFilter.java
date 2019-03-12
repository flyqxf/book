package com.yuanneng.book.common.filter;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

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
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;

public class UrlFilter implements Filter {

    private static final String URL_SPLITER = "/";

    private static final String URL_ROOTER = "/";

    private static final String ACTION = ".action";

    private static final String KEY_OF_FILE_SEPARATOR = "file.separator";

    private Set<String> EXCLUTION_PATHS = null;

    private Set<String> allFiles = null;

    private static Log log = LogFactory.getLog(UrlFilter.class);

    public final static String LOGIN_URL = "/directLogin";

    public final static String AUTHCODE_URL = "/sysuser/authCode.action";

    public final static String USER_LOGIN_URL = "/sysmanage/userLogin.action";

    public final static String ASYNC_ERROR_URL = "/common/error.action";

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (null == allFiles) {
            setIncludePaths(req);
        }
        // ACTION名取得
        String path = req.getServletPath();
        // 初始页面
        if (path.equals("/")) {
            req.getRequestDispatcher(PropertyUtil.getProperty(Constant.LOGIN_URL)).forward(request,
                    response);
            return;
        }
        String parts[] = path.split(URL_SPLITER);
        String end = parts[parts.length - Constant.NUM_1];
        // TODO 原则待定
        // 原则:1.没有点的通过 2.以.action结尾的通过 3.自己内部的文件通过
//        if (end.indexOf(Constant.DOT) == Constant.NUM_MINUS_1 || end.endsWith(ACTION)||end.endsWith(".jsp")||end.endsWith(".html")||end.endsWith(".htm")||end.endsWith(".JSP")||end.endsWith(".HTML")||end.endsWith(".HTM")
//                || allFiles.contains(path)) {
            // //----------------如果session被清除，直接跳登录页面
            // if(!path.equals(LOGIN_URL) &&
            // !path.equals(AUTHCODE_URL) &&
            // !path.equals(USER_LOGIN_URL) &&
            // !path.equals(ASYNC_ERROR_URL) &&
            // !allFiles.contains(path)){
            // // 读取session中的用户
            // UserValueObject uvo = (UserValueObject) ((HttpServletRequest)
            // request).getSession().getAttribute(Constant.UVO);
            // if(uvo == null) {
            // req.getRequestDispatcher(PropertyUtil.getProperty(Constant.LOGIN_URL)).forward(
            // request, response);
            // return;
            // }
            // }
            chain.doFilter(request, response);
//        } else {
//            // 清除session
//            // BusinessUtils.clearSession();
//            // 日志记录
//            LogHelper.error(log,
//                    MessageFormat.format(PropertyUtil.getProperty(Constant.BOOKZ0028E), path));
//
//            // 显示页面
//            req.getRequestDispatcher(PropertyUtil.getProperty(Constant.NOT_FOUND_PATH)).forward(
//                    request, response);
//        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        EXCLUTION_PATHS = new HashSet<String>();
        String[] foders = PropertyUtil.getProperty(Constant.UNACCESS_FOLDERS).split(Constant.COMMA);
        for (String folder : foders) {
            EXCLUTION_PATHS.add(folder);
        }
    }

    private void setIncludePaths(HttpServletRequest request) {
        allFiles = new HashSet<String>();
        String rootPath = request.getSession().getServletContext().getRealPath(URL_ROOTER);
        setFiles(rootPath, rootPath);
    }

    private void setFiles(String path, String rootPath) {
        File subPath = new File(path);
        File[] files = subPath.listFiles();
        for (int i = Constant.NUM_0; i < files.length; i++) {
            if (files[i].isFile()) {
                String urlPath = files[i]
                        .getAbsolutePath()
                        .substring(rootPath.length())
                        .replace(System.getProperties().getProperty(KEY_OF_FILE_SEPARATOR),
                                URL_SPLITER);
                allFiles.add(URL_ROOTER.concat(urlPath));
            } else if (!EXCLUTION_PATHS.contains(files[i].getAbsolutePath().substring(
                    rootPath.length()))) {
                setFiles(files[i].getAbsolutePath(), rootPath);
            }
        }
    }
}
