/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.utils.CommonUtil;
import com.utils.ConfigUtil;
import com.utils.PayCommonUtil;
import com.utils.RequestHandler;
import com.utils.TenpayUtil;
import com.utils.XMLUtil;
import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.register.service.RegisterService;
import com.yuanneng.book.sysmanage.entity.UserBean;


public class WeChatPayStatusGetActon extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    public static Logger logger = Logger.getLogger(WeChatPayStatusGetActon.class);

    //private static Log log = LogFactory.getLog(WeChatPayAction.class);
    @Resource
    private RegisterService registerService;
    //private String resJson = null;
    //private String resJson = null;
    private String orderno = null;
    /** 处理结果JSON **/
    private Map<String, Object> resJson = new HashMap<String, Object>();
    private static String appid = "wx8444c06e67cf9c96";
    private static String appsecret = "e8379783ff2336770269096defa26718";
    private static String partner = "1452144702";
    //这个参数partnerkey是在商户后台配置的一个32位的key,微信商户平台-账户设置-安全设置-api安全
    private static String partnerkey = "e8379783ff2336770269096defa26718";

    
    @Override
    public String doMain()  throws Exception{
        
       
     // 1 参数
        // 订单号
        String orderId = orderno;
        // 商户号
        String mch_id = partner;
        // 随机字符串
        String nonce_str = getNonceStr();
        resJson.put("errCode", "0");
        resJson.put("userId", "");

        // 商户订单号
        String out_trade_no = orderId;
        SortedMap<Object,Object> packageParams =new TreeMap<Object,Object>();
        //SortedMap<String, String> packageParams = new TreeMap<String, String>();
        packageParams.put("appid", appid);
        packageParams.put("mch_id", mch_id);
        packageParams.put("out_trade_no", orderId);
        
        packageParams.put("nonce_str", nonce_str);
       
        

        RequestHandler reqHandler = new RequestHandler(null, null);
        reqHandler.init(appid, appsecret, partnerkey);

        String sign =PayCommonUtil.createSign("utf-8", packageParams);
        packageParams.put("sign", sign);
        String reuqestXml =PayCommonUtil.getRequestXml(packageParams);
         
        String result=CommonUtil.httpsRequest(ConfigUtil.CHECK_ORDER_URL, "POST",reuqestXml);
        logger.debug(result);
        @SuppressWarnings("unchecked")
        Map<String, String> map =XMLUtil.doXMLParse(result);
        
        String returnCode =map.get("return_code");
        String resultCode =map.get("result_code");
        String trade_state  = (String) map.get("trade_state");
        String  sts = "";
        if("FAIL".equals(returnCode)) {
            sts ="FAIL1";
        } else if("FAIL".equals(resultCode)) {
            sts ="FAIL2";
        } else {
            sts = trade_state;
        }
        
//        String sign = reqHandler.createSign(packageParams);
//        String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
//                + mch_id + "</mch_id>"+ "<out_trade_no>" + out_trade_no
//                + "</out_trade_no>" + "<nonce_str>" + nonce_str
//                + "</nonce_str>" + "<sign>" + sign + "</sign>"
//                + "</xml>";
//        String createOrderURL = "https://api.mch.weixin.qq.com/pay/orderquery";
//        
//        new GetWxOrderno();
//      SUCCESS—支付成功
//      REFUND—转入退款
//      NOTPAY—未支付
//      CLOSED—已关闭
//      REVOKED—已撤销（刷卡支付）
//      USERPAYING--用户支付中
//      PAYERROR--支付失败(其他原因，如银行返回失败)
//       String  sts = GetWxOrderno.getResultCode(createOrderURL, xml);
       //if("FAIL".equals(sts) ||"PAYERROR".equals(sts)||"REVOKED".equals(sts)||"CLOSED".equals(sts)||"REFUND".equals(sts)) {
//       if("PAYERROR".equals(sts)||"REVOKED".equals(sts)||"CLOSED".equals(sts)||"REFUND".equals(sts)) {
//           resJson = "2";
//       }else if("SUCCESS".equals(sts)) {
//           resJson = "1";
//       }
       HashMap<String,String> h = new HashMap<String,String>();
       h.put("SUCCESS", "支付成功");
       h.put("FAIL1", "付款失败");
       h.put("FAIL2", "订单失效");
       h.put("REFUND", "转入退款");
      // h.put("NOTPAY", "未支付");
       h.put("CLOSED", "已关闭");
       h.put("REVOKED", "已撤销（刷卡支付）");
       h.put("USERPAYING", "用户支付中");
       h.put("PAYERROR", "支付失败(其他原因，如银行返回失败)");
       // resJson.put("errCode", "0");
       if(h.containsKey(sts)) {
       if("SUCCESS".equals(sts)) {
           UserBean userBean = new UserBean();
           userBean.setOrderId(out_trade_no);
           userBean.setDel_flg("0");
           String userId = registerService.updateUserSts(userBean);
           resJson.put("errCode", "1");
           resJson.put("userId", userId);
           
       } else {
           UserBean userBean = new UserBean();
           userBean.setOrderId(out_trade_no);
           
           registerService.deleteUserByOutTradeNo(userBean);
           resJson.put("errcode", "2");
           resJson.put("userId", "");
//           resJson.put("errMsg","支付失败！原因："+h.get(sts));
           
       }
       }
        
        return SUCCESS;
               

    }
    /**
     * 获取随机字符串
     * @return
     */
    public static String getNonceStr() {
        // 随机数
        String currTime = TenpayUtil.getCurrTime();
        // 8位日期
        String strTime = currTime.substring(8, currTime.length());
        // 四位随机数
        String strRandom = TenpayUtil.buildRandom(4) + "";
        // 10位序列号,可以自行调整。
        return strTime + strRandom;
    }
    
    
   
    
    /**
     * @return the resJson
     */
    public Map<String, Object> getResJson() {
        return resJson;
    }
    
    /**
     * @param resJson the resJson to set
     */
    public void setResJson(Map<String, Object> resJson) {
        this.resJson = resJson;
    }
    /**
     * @return the orderno
     */
    public String getOrderno() {
        return orderno;
    }

    
    /**
     * @param orderno the orderno to set
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
    
    
    
    
}
