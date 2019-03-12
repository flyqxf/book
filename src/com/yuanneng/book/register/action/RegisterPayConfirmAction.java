/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alipay.util.AlipayNotify;
import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.register.service.RegisterService;
import com.yuanneng.book.sysmanage.entity.UserBean;


public class RegisterPayConfirmAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    @Resource
    private RegisterService registerService;

    
    private String msg = null;
    private String userId = "";
    
    @Override
    public String doMain() throws Exception {
        HttpSession session = this.getSession();
        HttpServletRequest request =this.getRequest();
        
        UserBean userBean = (UserBean) session.getAttribute("registerUserBean");
        
//        if(!StringUtils.isEmpty(registerCode)) {
//            if(registerCode.length()>32) {
//                msg = "优惠码不能超过32位。";
//            } else if (registerCode.contains(" ")) {
//                msg = messageHelper.getMessage(Constant.BOOKD0023E, new String[] { Constant.MSG_ADD_REGISTER_CODE });
//            } else if (!ValidatorUtils.isValidInputString(registerCode)) {
//                msg = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_REGISTER_CODE});
//            } else if(!registerService.isExsitsMobile(registerCode)){
//                msg = "该优惠码不存在。";
//            }
//            
//        }
//        
//        if(!StringUtils.isEmpty(msg)) {
//            return INPUT;
//        }
        
//        userBean.setRegister_code(registerCode);
        
      //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        @SuppressWarnings("rawtypes")
        Map requestParams = request.getParameterMap();
        for (@SuppressWarnings("rawtypes")
        Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
            
        }
        
      //交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
        
        
      //计算得出通知验证结果
        boolean verify_result = AlipayNotify.verify(params);
        
        if(verify_result){//验证成功
            //////////////////////////////////////////////////////////////////////////////////////////
            //请在这里加上商户的业务逻辑程序代码

            //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
            if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //如果有做过处理，不执行商户的业务程序
            }
            
            //registerService.insertUser(userBean);
            //userId = userBean.getUserId();
            msg = "注册成功！";
            
            return SUCCESS;

            //////////////////////////////////////////////////////////////////////////////////////////
        }else{
            //该页面可做页面美工编辑
            msg = "注册失败！";
            
            return SUCCESS;
        }
        
        

    }

    
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }


    
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }


    
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
}
