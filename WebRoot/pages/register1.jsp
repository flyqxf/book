<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>

<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/buttons.css" rel="stylesheet">



<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cloud.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
    
msg="${msg}";
    $(document).ready(function () {
        if (msg != null && msg != '') {
            alert(msg);
        }
    });
    
    
    var pay = function() {
        $("#registerForm").submit();
    };
    var back = function() {
        var url = "../login.action";
        // 迁移参数设定
        var params = new Array();
        deptAction(url,params);
    };
</script> 
</head>

<body style="background:#fff3e1;">
<s:include value="%{pageContext.request.contextPath}/pages/common/message.jsp" />
<form id="registerForm" method="post" action="./registerPay.action" method="post">
<div class="reg-form">
  <div  class="form-item form-item-account">
    <label>登 录 名<b><font color="red">*</font></b></label>
    <input id="form-account" class="field" type="text" id="userId" placeholder="建议使用您的手机号码"  maxlength="32" autocomplete="off" name="userBean.userId" value="<s:property value='userBean.userId '/>" >
  </div>
  <div class="form-item form-item-account">
    <label>设 置 密 码<b><font color="red">*</font></b></label>
    <input id="form-account" class="field" id="pwd1" type="password"  placeholder="设 置 密 码"  maxlength="20" autocomplete="off" name="password" value="<s:property value='password'/>">
  </div>
  <div class="form-item form-item-account">
    <label>确 认 密 码<b><font color="red">*</font></b></label>
    <input  class="field" type="password" id="pwd2" placeholder="确 认 密 码"  maxlength="20" autocomplete="off" name="rePassword" value="<s:property value='rePassword'/>">
  </div>
  <div  class="form-item form-item-account">
    <label>姓  名<b><font color="red">*</font></b></label>
    <input id="form-account" class="field"  id="userName" type="text" placeholder="真实姓名"  maxlength="16" autocomplete="off" name="userBean.userName" value="<s:property value='userBean.userName'/>">
  </div>
  <div class="form-item form-item-account">
    <label>邮箱地址<b><font color="red"></font></b></label>
    <input  class="field" type="text" placeholder="邮箱地址"  maxlength="96" autocomplete="off" name="userBean.mail" value="<s:property value='userBean.mail'/>">
  </div>
  <div class="form-item form-item-account">
    <label>手机号码<b><font color="red">*</font></b></label>
    <input  class="field" type="text" placeholder="手机号码"  maxlength="11" autocomplete="off" name="userBean.mobile" value="<s:property value='userBean.mobile'/>">
  </div>
  <%--<div class="form-item form-item-account" name="code">
    <label  >专属优惠码<b><font color="red">*</font></b></label>
    <select class="select" name="code">
    <option value="1" selected>同手机号码</option>
    <option value="2" >同登录名</option>
    
   </select>
   
  </div>
  <div class="form-item form-item-account">
    <label>支付宝<b><font color="red">*</font></b></label>
    <input  class="field" type="text" placeholder="支付宝"  maxlength="60" autocomplete="off" name="userBean.id_zhifubao" value="<s:property value='userBean.id_zhifubao'/>">

    
  </div>
  <div class="form-item form-item-account">
    <label>微信号<b><font color="red">*</font></b></label>
    <input  class="field" type="text" placeholder="微信号"  maxlength="60" autocomplete="off" name="userBean.id_weixin" value="<s:property value='userBean.id_weixin'/>">
  </div>
  <div class="form-item form-item-account">
    <label>优惠码</label>
    <input  class="field" type="text" placeholder="优惠码"  maxlength="32" autocomplete="off" name="userBean.register_code" value="<s:property value='userBean.register_code'/>">
  </div>
  <div class="form-item form-item-account" name="userBean.receivables_flg">
    <label>收款方式<b><font color="red">*</font></b></label>
    <select class="select" name="userBean.receivables_flg">
    <option value="1" selected>支付宝</option>
    <option value="2" >微信</option>
    
   </select>
  </div>
  --%>
 <div class="input-tip"> <span></span> </div> 
  
  <div>
  <a class="btn-register" type="button" onclick="pay()">注册并付款</a>
  
</div>
 <div class="input-tip"> <span></span> </div>   
  
</div>
</form>
</body>
</html>
