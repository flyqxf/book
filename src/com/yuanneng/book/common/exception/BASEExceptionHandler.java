package com.yuanneng.book.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.yuanneng.book.common.log.LogHelper;
import com.yuanneng.book.common.utils.BusinessUtils;

public class BASEExceptionHandler extends ActionSupport {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 值栈关键字
     */
    private static final String KEY_VALUESTACK = "struts.valueStack";

    /**
     * 值栈中保存抛出异常的关键字
     */
    private static final String KEY_EXCEPTION = "exception";

    @Override
    public String execute() {
        BusinessUtils.clearSession();
        Object obj = findGSPException();
        // 封装好的GSPException的情况
        if (obj instanceof BASEException) {
            // 塑形成指定的例外
            BASEException gspEx = (BASEException) obj;
            // 监视日志
            LogHelper.alert(gspEx);
            // debug日志
            LogHelper.error(gspEx);
        } else if (obj instanceof Exception) {
            // 塑形成普通的例外
            Exception ex = (Exception) obj;
            // 监视日志
            LogHelper.alert(ex);
            // debug日志
            LogHelper.error(ex);
        } else {
            // 塑形成普通的例外
            Exception ex = new Exception(obj.toString());
            // 监视日志
            LogHelper.alert(ex);
            // debug日志
            LogHelper.error(ex);
        }
        return SUCCESS;
    }

    /**
     * 值栈中寻找例外对象
     * 
     * @return 找到的对象
     */
    private Object findGSPException() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        // 取得值栈
        ValueStack vs = (ValueStack) request.getAttribute(KEY_VALUESTACK);
        // 获取异常
        Object ex = vs.findValue(KEY_EXCEPTION);
        // 返回
        return ex;
    }
}
