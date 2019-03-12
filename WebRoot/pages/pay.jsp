<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/cloud.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
<script type="text/javascript">
msg="${msg}";
    $(document).ready(function () {
        if (msg != null && msg != '') {
            alert(msg);
        }
        $("#money2").hide();
    });
    var paid = function() {
        var p = $("input[name='apy']:checked").val();
        //var url = "../register/registerPayConfirm.action";
        var url ="";
       if(p == '1') {
            url = "../register/alipayAction.action";
        } else if(p == '2'){
           url = "../register/weChatPayAction.action";
        }
            // 迁移参数设定
           var params = new Array();
            var registerCode = $("#regisiterCode").val();
            var price = $("#idPrice").val();
            var youhui = $("#idYouhui").val();
            params[0] = ["registerCode", registerCode];
            params[1] = ["price", price];
            params[2] = ["youhui", youhui];
            deptAction(url,params);
    
    };
    var back = function() {
        var url = "../register/backToRegister.action";
        // 迁移参数设定
        var params = new Array();
        deptAction(url,params);
    };
    var registerCode = function() {
        var regCode = $("#regisiterCode").val();
        if(regCode != '') {
            $("#money1").hide();
            $("#money2").show();
        } else {
            $("#money1").show();
            $("#money2").hide();
        }
    }
</script>
</head>

<body style="background:#fff3e1;">
<div id="main" class="w">
  <div class="order paybox">
    <h3 class="o-title STYLE1">请输入优惠可以享受价格减免的优惠，如果有请务必输入！！！</h3>
    <p class="o-tips"><strong>优惠码</strong>
      <label>
      <input id="regisiterCode" type="text" name="textfield" onblur="registerCode()"/>
      </label>
    </p>
    <p>原价：<font class="font-red10" color="red">&yen;${price}元 </font>优惠价：<font class="font-red14" color="red">&yen;${youhui}元</font></p>
    <p id="money1">支付金额：<font class="font-red10" color="red">&yen;${price}元</font></p> 
    <p id="money2">支付金额：<font class="font-red14" color="red">&yen;${youhui}元</font></p>
  </div>
  <input type="hidden" id="idPrice" value="${price}">
  <input type="hidden" id="idYouhui" value="${youhui}">
  <div class="bank-area" style=""> 

    <div class="wrap">
    <div class="ui-tab-items">
    <ul class="clearfix" id="tag">
 <li class="current" >支付方式选择</li>
 <%--<li>微信</li> --%>

 </ul>
 </div>
    <div id="tagContent" class="mt25 ">
          <div class="cont_case clearfix" style="display:block;">
         <div class="payment-list ">
         <div class="bank-identific clearfix" style="opacity: 1;">

        
         
         
         
         
       </div>  
        <ul class="clearfix">
        <li class="pl-item"><input type = "radio" name="apy" value="1" checked>支付宝</li>
        <li class="pl-item"><input type = "radio" name="apy" value="2">微信</li>
        
        </ul>
        </div>
        
        <div  class="pay-verify  clearfix">
  <div  class="pv-button">
<input  class="ui-button ui-button-XL disable" type="button" psa="pcCashier_ljzf" clstag="jr|keycount|cashier_jd|cashier_jd_ljzf"  value="立即支付" onclick="javascript:paid()">
<input  class="ui-button ui-button-XL disable" type="button" psa="pcCashier_ljzf" clstag="jr|keycount|cashier_jd|cashier_jd_ljzf"  value="返回" onclick="back()">
  <span  class="font-red ml10">请选择银行支付</span>
  </div>
</div>
        
        
        
      </div>
      
      
        <%--
          <div class="cont_case clearfix" style="display:none;">
        <div class="payment-list ">
        <ul class="clearfix">
        <li class="pl-item"><span id="bank-icbc" class="bank-logo">工商银行</span></li>
        <li class="pl-item"><span id="bank-ccb" class="bank-logo">建设银行</span></li>
        <li class="pl-item"><span id="bank-cmb" class="bank-logo">招商银行</span></li>
        
        </ul>
        </div>
        
        <div  class="pay-verify  clearfix">
  <div  class="pv-button">
<input  class="ui-button ui-button-XL disable" type="button" psa="pcCashier_ljzf" clstag="jr|keycount|cashier_jd|cashier_jd_ljzf"  value="立即支付" onclick="javascript:paid()">
<input  class="ui-button ui-button-XL disable" type="button" psa="pcCashier_ljzf" clstag="jr|keycount|cashier_jd|cashier_jd_ljzf"  value="返回" onclick="back()">
  <span  class="font-red ml10">请选择银行支付</span>
  </div>
</div>
      </div>
        --%>
        </div>
  </div> 

  </div>
</div>
</body>
</html>
<script type=text/javascript>
window.onload=function()   //onload 事件句柄，文档装载结束时调用

{ 
  var tag=document.getElementById("tag").children; //获取Tag下的li，即Tag标签 
  var content=document.getElementById("tagContent").children; //获取Tag标签对应的内容 
  content[0].style.display = "block"; //默认显示第一个标签的内容 
  var len= tag.length; 
  for(var i=0; i<len; i++)   //无论点击谁都能实现当前显示，其余隐藏
    { 
    tag[i].index=i; //为何如此？（看下面解释） 
    tag[i].onclick = function()     //0级DOM的事件句柄注册

        {     

               for(var n=0; n<len; n++)

               {
                  tag[n].className="";
                  content[n].style.display="none"; 
                }   //首先将全部的div隐藏
            tag[this.index].className = "current"; 
            content[this.index].style.display = "block"; 
      } 
   }

}
</script>