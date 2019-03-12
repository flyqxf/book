/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipaySubmit;
import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.validator.ValidatorUtils;
import com.yuanneng.book.register.service.RegisterService;
import com.yuanneng.book.sysmanage.entity.UserBean;


public class AliPayAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private static Log log = LogFactory.getLog(AliPayAction.class);
    
    @Resource
    private RegisterService registerService;
    
    //支付金额
    private String total_fee = null;
    
    private String sHtmlText = null;
    
    private String registerCode = null;
    
    private String msg = null;
    
    
    private String price = null;
    
    private String youhui = null;
    
    
    @Override
    public String doMain() {
        
        
        HttpSession session = this.getSession();
        
        UserBean userBean = (UserBean) session.getAttribute("registerUserBean");
        
        price = registerService.getPrice();
        
        String privilege = registerService.getPrivilege();
        

        BigDecimal prc = new BigDecimal(price);

        BigDecimal prvlg = new BigDecimal(privilege);

        youhui = prc.subtract(prvlg).toString();
       
        if(!StringUtils.isEmpty(registerCode)) {
            if(registerCode.length()>32) {
                msg = "优惠码不能超过32位。";
            } else if (registerCode.contains(" ")) {
                msg = messageHelper.getMessage(Constant.BOOKD0023E, new String[] { Constant.MSG_ADD_REGISTER_CODE });
            } else if (!ValidatorUtils.isValidInputString(registerCode)) {
                msg = messageHelper.getMessage(Constant.BOOKZ0034E, new String[] { Constant.MSG_ADD_REGISTER_CODE});
            } else if(!registerService.isExsitsRegisterCode(registerCode)){
                msg = "该优惠码不存在。";
            }
            total_fee = youhui;
        } else {
            total_fee = price;
        }
        
        if(!StringUtils.isEmpty(msg)) {
            return INPUT;
        }
        
        userBean.setRegister_code(registerCode);
        session.setAttribute("registerUserBean", userBean);
        
        HttpServletRequest request = this.getRequest();
        
        String path = request.getContextPath();  
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String return_url = basePath+"register/registerPayConfirm.action"; 
        //String return_url = AlipayConfig.return_url;
        
        Date date = new Date();  
        // 支付类型  
        // 必填，不能修改  
        String payment_type = "1";  
        // 服务器异步通知页面路径  
        // 需http://格式的完整路径，不能加?id=123这类自定义参数  
        //String notify_url = "http://192.168.0.222:8080/live/aliapi/async";  
        // 页面跳转同步通知页面路径  
        // 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/  
        //String return_url = "http://192.168.0.222:8080/live/aliapi/return_url";  
        // 商户订单号.  
        // 商户网站订单系统中唯一订单号，必填  
        //String out_trade_no = date.getTime() + "";  
        // 订单名称  
        // 必填  
        String subject = "商品充值";  
          
        //String total_fee = ServletRequestUtils.getStringParameter(request, "amount","");
        //商品描述
        String body = "元能学习系统";
        //商品展示地址
        //String show_url = ServletRequestUtils.getStringParameter(request, "show_url","http://www.elve.cn");
        //需以http://开头的完整路径，例如：http://www.xxx.com/myorder.html

        
        
        
        Map<String, String> sParaTemp = new HashMap<String, String>();
        
        sParaTemp.put("service", AlipayConfig.service);//接口服务----即时到账
        sParaTemp.put("partner", AlipayConfig.partner);//签约支付宝账号
        sParaTemp.put("seller_id", AlipayConfig.seller_id);//收款账号(=签约支付宝账号)
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);//统一编码
        sParaTemp.put("payment_type", AlipayConfig.payment_type);//支付类型
        //sParaTemp.put("notify_url", AlipayConfig.notify_url);//异步通知页面
        sParaTemp.put("return_url", return_url);//页面跳转同步通知页面
        //sParaTemp.put("seller_email", aliPayAccount);//卖家支付宝账号
        sParaTemp.put("out_trade_no", date.getTime()+payment_type);//商品订单编号
        sParaTemp.put("subject", subject);//商品名称
        sParaTemp.put("total_fee", total_fee);//价格
        sParaTemp.put("body", body);
        //sParaTemp.put("show_url", show_url);
        sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);//没有防钓鱼设为空
        sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);//没有防钓鱼设为空
         
        //建立请求
        try {
            sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"post","确认");  
//            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//            String s = gson.toJson(sHtmlText);
           // model.addAttribute("sHtmlText", s);
            //request.setAttribute("sHtmlText", s);
            //result = "{\"success\":true,\"msg\":\"跳转成功\"}";
            //StringUtil.writeToWeb(sHtmlText, "html", response);
        } catch (Exception e) {
            if(log.isErrorEnabled()){
                log.error("支付失败");
            }
            //result = "{\"success\":false,\"msg\":\"跳转失败，请稍候再试！\"}";
            //StringUtil.writeToWeb(result, "html", response);
        }

        return SUCCESS;

    }


    
    /**
     * @return the total_fee
     */
    public String getTotal_fee() {
        return total_fee;
    }


    
    /**
     * @param total_fee the total_fee to set
     */
    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }


    
    /**
     * @return the sHtmlText
     */
    public String getsHtmlText() {
        return sHtmlText;
    }


    
    /**
     * @param sHtmlText the sHtmlText to set
     */
    public void setsHtmlText(String sHtmlText) {
        this.sHtmlText = sHtmlText;
    }



    
    /**
     * @return the registerCode
     */
    public String getRegisterCode() {
        return registerCode;
    }



    
    /**
     * @param registerCode the registerCode to set
     */
    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
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
     * @return the price
     */
    public String getPrice() {
        return price;
    }



    
    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }



    
    /**
     * @return the youhui
     */
    public String getYouhui() {
        return youhui;
    }



    
    /**
     * @param youhui the youhui to set
     */
    public void setYouhui(String youhui) {
        this.youhui = youhui;
    }

    
    
}
