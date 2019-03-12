/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import java.io.BufferedOutputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.demo.WxPayResult;
import com.yuanneng.book.common.action.CommonAction;


public class WeChatPayStatusConfirmActon extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    public static Logger logger = Logger.getLogger(WeChatPayStatusConfirmActon.class);

    //private static Log log = LogFactory.getLog(WeChatPayAction.class);

    private String resJson = null;
    private String orderno = null;
    

    
    private String msg = null;
    
    @Override
    public String doMain()  throws Exception{
        
//        HttpSession session = this.getSession();
//        UserBean userBean = (UserBean) session.getAttribute("registerUserBean");
        HttpServletRequest request = this.getRequest();
        HttpServletResponse response = this.getResponse();
        
        //示例报文
//      String xml = "<xml><appid><![CDATA[wxb4dc385f953b356e]]></appid><bank_type><![CDATA[CCB_CREDIT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1228442802]]></mch_id><nonce_str><![CDATA[1002477130]]></nonce_str><openid><![CDATA[o-HREuJzRr3moMvv990VdfnQ8x4k]]></openid><out_trade_no><![CDATA[1000000000051249]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[1269E03E43F2B8C388A414EDAE185CEE]]></sign><time_end><![CDATA[20150324100405]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[1009530574201503240036299496]]></transaction_id></xml>";
        String inputLine;
        String notityXml = "";
        String resXml = "";

        try {
            while ((inputLine = request.getReader().readLine()) != null) {
                notityXml += inputLine;
            }
            request.getReader().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("接收到的报文：" + notityXml);
        
        Map m = parseXmlToList2(notityXml);
        WxPayResult wpr = new WxPayResult();
        wpr.setAppid(m.get("appid").toString());
        wpr.setBankType(m.get("bank_type").toString());
        wpr.setCashFee(m.get("cash_fee").toString());
        wpr.setFeeType(m.get("fee_type").toString());
        wpr.setIsSubscribe(m.get("is_subscribe").toString());
        wpr.setMchId(m.get("mch_id").toString());
        wpr.setNonceStr(m.get("nonce_str").toString());
        wpr.setOpenid(m.get("openid").toString());
        wpr.setOutTradeNo(m.get("out_trade_no").toString());
        wpr.setResultCode(m.get("result_code").toString());
        wpr.setReturnCode(m.get("return_code").toString());
        wpr.setSign(m.get("sign").toString());
        wpr.setTimeEnd(m.get("time_end").toString());
        wpr.setTotalFee(m.get("total_fee").toString());
        wpr.setTradeType(m.get("trade_type").toString());
        wpr.setTransactionId(m.get("transaction_id").toString());
        //WeChatPayRes weChatPayRes = WeChatPayRes.getSingle();
        if("SUCCESS".equals(wpr.getResultCode())){
            //支付成功
            resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
            + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            logger.debug(resXml);
            logger.debug("支付成功");
            response.setContentType("text/xml");
            BufferedOutputStream out = new BufferedOutputStream(
                    response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
//            UserBean userBean = new UserBean();
//            userBean.setOrderId(wpr.getOutTradeNo());
//            userBean.setDel_flg("0");
//            registerService.updateUserSts(userBean);
            
            
            //weChatPayRes.setSts(wpr.getOutTradeNo(), "1");
            
            msg = "注册成功！";
            
            return SUCCESS;
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
            + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
            
            logger.debug(resXml);
            logger.debug("支付失败："+m.get("err_code").toString()+"----订单号："+m.get("out_trade_no").toString()+"----支付失败时间：："
                        +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            response.setContentType("text/xml");
            BufferedOutputStream out = new BufferedOutputStream(
                    response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
            //weChatPayRes.setSts(wpr.getOutTradeNo(), "2");
          //该页面可做页面美工编辑
            msg = "缴费失败，请重新操作！";
            
            return SUCCESS;
        }


    }
    
    /**
     * description: 解析微信通知xml
     * 
     * @param xml
     * @return
     * @author ex_yangxiaoyi
     * @see
     */
    @SuppressWarnings({ "unused", "rawtypes", "unchecked" })
    private static Map parseXmlToList2(String xml) {
        Map retMap = new HashMap();
        try {
            StringReader read = new StringReader(xml);
            // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
            InputSource source = new InputSource(read);
            // 创建一个新的SAXBuilder
            SAXBuilder sb = new SAXBuilder();
            // 通过输入源构造一个Document
            Document doc = (Document) sb.build(source);
            Element root = doc.getRootElement();// 指向根节点
            List<Element> es = root.getChildren();
            if (es != null && es.size() != 0) {
                for (Element element : es) {
                    retMap.put(element.getName(), element.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retMap;
    }

    
    /**
     * @return the resJson
     */
    public String getResJson() {
        return resJson;
    }

    
    /**
     * @param resJson the resJson to set
     */
    public void setResJson(String resJson) {
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
    
}
