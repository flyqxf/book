<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/cloud.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" >
 // 每半秒请求一次数据，然后判断，跳转，增加用户友好性
$(function(){
        orderno = $("#orderId").val();
        
            start = self.setInterval("checkstatus(orderno)", 3000);
        
    });
   
    function checkstatus(order_no){
        
        if(order_no == undefined || order_no == '' ){
            window.clearInterval(start);
        }
        else{
            /*$.ajax({
                url:"../registerJ/weChatPayStatusGetActon.action",
                type:'POST',
                data:{"orderno":orderno},
                success:function(resJon){
                    alert(resJon);
                }
            });*/
            $.post("../registerJ/weChatPayStatusGetActon.action",{"orderno":orderno},function(resJson) {
                var code = resJson.errCode;
                if(code == '1') {
                     var url = "../register/weChatPayResultActon.action";
                     var params = new Array();
                     params[0] = ["code", code];
                     params[1] = ["userId", resJson.userId];
                     deptAction(url,params);
                } else if(code == '2') {
                    var url = "../register/weChatPayResultActon.action";
                    var params = new Array();
                     params[0] = ["code", code];
                     params[1] = ["userId", resJson.userId];
                     deptAction(url,params);
                }   
            });
        }
    }
</script>



</head>

<body style="background:#fff3e1;">
    <input type = "hidden" id="orderId" value="${orderId}">
    <center>
    <div class="order paybox">
    <h3 class="o-title STYLE1">请扫描二维码进行支付</h3>
    <p class="o-tips">
        <img src="${pageContext.request.contextPath}/images/erweima.png">
    </p>
    <h3 class="o-title STYLE1"><lable id="res"><lable></h3>
  </div>
  </center>
</body>
</html>
