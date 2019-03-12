<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/cloud.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
var agree = function(){
    var url = "../register/changeSaler.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
};
</script>
</head>

<body style="background:#fff3e1;">
<div class="ui-dialog" style="width: 947px; position: fixed; z-index: 10000; overflow: hidden; top: 2px; left: 197px;">
<div class="ui-dialog-title" style="width: 927px;">
<span>销售注册协议</span>
</div>

<div class="ui-dialog-content" style="width: 927px; height:545px; overflow: hidden;">
<div class="protocol">
<div class="protocol-con">
<h4>用户注册协议</h4>
<p> 本协议是您与本网站网站（简称"本站"，网址：www.com）所有者（以下简称为""）之间就作权归本网站站服务等相关事宜所订立的契约，请您仔细阅读本注册协议，您点击"同意并继续"按钮后，本协议即构成对双方有约束力的法律文件。</p>
<h5>第1条 本站服务条款的确认和接纳</h5>
<p>本站的各项电子服务的所有权和运作权归本网站所有。用户同意所有注册协议条款并完成注册程序，才能成为本站的正式用户。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。             </p>
<h5>第2条 本站服务条款的确认和接纳</h5>
<p>本站的各项电子服务的所有权和运作权归本网站所有。用户同意所有注册协议条款并完成注册程序，才能成为本站的正式用户。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。             </p>
</div>
<div class="protocol-button">
<button onclick="javascript:agree()">同意并继续</button>
</div>



</div>

</div>




</div>
</body>
</html>

