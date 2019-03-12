package com.yuanneng.book.common.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.login.entity.AdminUserBean;

public class UserLoginFilter implements Filter {

    // 不需要session的URL一览
    private Set<String> noSessionUrls = null;
    private List<String> ManageUrls = null;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 判断:session为空的时候进入到login首页画面
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        if (!isCorrectSession(session) && isNeedSessionUrl(req)) {
            
            String url = "/login.action?sessionTimeOut=1";
            if(isManageUrl(req)) {
                url = "/adminlogin.action?sessionTimeOut=1";
            }
            
            // TODO error日志记录
            // 显示login页面
            session = null;
            req.getRequestDispatcher(url)
                    .forward(request, response);
        } else {
            // TODO 权限chechk用
            // * 放行
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // 不需要session的URL一览的做成
        noSessionUrls = new HashSet<String>();
        
      
        // loginURL
        noSessionUrls.add(PropertyUtil.getProperty(Constant.LOGIN_URL));
        // 登录Action的URL
        noSessionUrls.add(PropertyUtil.getProperty(Constant.USER_LOGIN_URL));
        // 验证码URL
        noSessionUrls.add(PropertyUtil.getProperty(Constant.AUTH_CODE_URL));
        // 忘记密码URL
        noSessionUrls.add(PropertyUtil.getProperty(Constant.FORGET_PASSWORD_URL));
        // 找回密码URL
        noSessionUrls.add(PropertyUtil.getProperty(Constant.FIND_PASSWORD_URL));
        // 重设密码首页URL
        noSessionUrls.add(PropertyUtil.getProperty(Constant.RESET_PASSWORD_URL));
        // 重设密码提交URL
        noSessionUrls.add(PropertyUtil.getProperty(Constant.RESET_PASSWORD_SUBMIT_URL));
        // 发生系统错误的绝对路径
        noSessionUrls.add(PropertyUtil.getProperty(Constant.ERROR_PATH));
        // 外部直接访问url
        noSessionUrls.add(PropertyUtil.getProperty(Constant.DIRECT_LOGIN_URL));
        noSessionUrls.add("/manageLogin/adminLogin.action");
        noSessionUrls.add("/adminlogin.action");
        noSessionUrls.add("/userLogin2.action");
        noSessionUrls.add("/sysmanage/userLogin2.action");
        noSessionUrls.add("/register/register.action");
        noSessionUrls.add("/register/registerPay.action");
        noSessionUrls.add("/tourist/touristAction.action");
        noSessionUrls.add("/bookScanJ/partTouristAction.action");
        noSessionUrls.add("/register/agree.action");
        noSessionUrls.add("/register/registerPayConfirm.action");
        noSessionUrls.add("/register/alipayAction.action");
        noSessionUrls.add("/register/weChatPayAction.action");
        noSessionUrls.add("/register/weChatPayStatusConfirmActon.action");
        noSessionUrls.add("/registerJ/weChatPayStatusGetActon.action");
        noSessionUrls.add("/register/weChatPayResultActon.action");
        noSessionUrls.add("/register/backToRegister.action");
        noSessionUrls.add("/successCase/successCaseListTourist.action");
        noSessionUrls.add("/successCase/successCaseListDetailTourist.action");
        noSessionUrls.add("/bookScan/bookScanAction.action");
        noSessionUrls.add("/tourist/partTouristAction.action");
        
        
        
        getManageUrls();
    }

    private boolean isManageUrl(HttpServletRequest request) {
        
        boolean isManageUrl = false;
        // ACTION名取得
        String path = request.getServletPath();
        
        for(String url:ManageUrls ) {
            if(path.contains(url)) {
                isManageUrl = true;
                break;
            }
        }
        return isManageUrl;
        
    }
    private void getManageUrls() {
        String urls = PropertyUtil.getProperty("manageUrls");
        String[] mUrls = urls.split(Constant.COMMA);
        ManageUrls = Arrays.asList(mUrls);
        
    }
    private boolean isCorrectSession(HttpSession session) {
        if (null == session) {
            return false;
        }
        UserValueObject uvo = (UserValueObject) session.getAttribute(Constant.UVO);
        AdminUserBean adminUserBean = (AdminUserBean) session.getAttribute(Constant.ADMIN_USER_NAME);
        if (null == uvo && null == adminUserBean) {
            return false;
        }
//        if (null == uvo.getUser()) {
//            return false;
//        }
//        if (StringUtils.isEmpty(uvo.getUser().getUserId())) {
//            return false;
//        }
        return true;
    }

    private boolean isNeedSessionUrl(HttpServletRequest request) {
        // ACTION名取得
        String path = request.getServletPath();
        // 判断
        if (noSessionUrls.contains(path)) {
            return false;
        } else {
            return true;
        }
    }
}
