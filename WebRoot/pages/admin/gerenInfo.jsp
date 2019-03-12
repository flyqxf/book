<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/jquery-1.11.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

<script type="text/javascript">
$(document).ready(function(e) {
    $("#lock").one('click').click(userIdManage);
    $("#unlock").one('click').click(userIdManage);
    $("#pwdReset").one('click').click(pwdReset);
});
var userIdManage = function() {
    
    var userId = $("#userId").val();
    var status = $("#status").val();
    // 设置参数
    parem = {
        "userId" : userId,
        "status" : status
        
    };
    
    ajaxPostAction("../userJ/lock.action", parem, lockResult, "用户冻结/解锁");
 };


//冻结后判断返回结果
var lockResult = function(data) {
    if (data != undefined && data != "") {
        var jsonObj = eval("(" + data + ")");
        var status = jsonObj.status;
        var msg = jsonObj.msg;
        var userId = jsonObj.userId;
        // 处理成功情况
        if (status == "success") {
            showInfoMessage(msg, "提示信息", "/user/tab1User.action?userId="+userId);
        } else {
            showInfoMessage(msg, "提示信息",null);
        }
    }
};

var pwdReset = function(){
    var url = "../userJ/userPwdReset.action";
    var userId = $("#userId").val();
    // 设置参数
    parem = {
        "userId" : userId
        
    };
    
    ajaxPostAction(url, parem, pwdResetResult, "密码重置");
};
//冻结后判断返回结果
var pwdResetResult = function(data) {
    if (data != undefined && data != "") {
        var jsonObj = eval("(" + data + ")");
        var status = jsonObj.status;
        var msg = jsonObj.msg;

        // 处理成功情况
        if (status == "success") {
            showInfoMessage(msg, "提示信息",null);
        } else {
            showInfoMessage(msg, "提示信息",null);
        }
    }
};

</script>

<body class="sarchbody">

<form id="gerenForm" mothod="post">
<s:hidden id="status" name = "status"  value="%{bean.status}"/>
<s:hidden id="userId" name = "userId"  value="%{bean.userId}"/>
<div id="m-content">
    <ul class="forminfo">
    <li><label>用户名<b>*</b></label><c>${bean.userName}</c></li>
    <li><label>登录名<b>*</b></label><c>${bean.userId}</c></li>
    <li><label>E_Mail<b>*</b></label><c>${bean.mail}</c></li>
    <li><label>所属地区<b>*</b></label><c>${bean.province}·${bean.city}</c></li>
    <li><label>入会时间<b>*</b></label><c>${bean.register_time}</c></li>
    <li><label>专属优惠码<b>*</b></label><c>${bean.code}</c></li>
    <li><label>推荐人编码<b>*</b></label><c>${bean.register_code}</c></li>
    <s:if test='bean.receivables_flg == "1"'>
    <li><label>支付账户<b>*</b></label><label>支付宝</label><c>${bean.id_zhifubao}</c></li>
    </s:if>
    <s:elseif test='bean.receivables_flg == "2"'>
    <li><label>支付账户<b>*</b></label><label>微信</label><c>${bean.id_weixin}</c></li>
    </s:elseif>
    <s:elseif test='bean.receivables_flg == "3"'>
    <li><label>支付账户<b>*</b></label><label>${bean.bank}</label><label>${bean.bank_card_name}</label><c>${bean.bank_card_number}</c></li>
    </s:elseif>
    <li><label>状态<b>*</b></label>
      <span class="STYLE1"> <span class="STYLE2">
      <label><strong>${bean.status_name}</strong></label>
      </span> </span></li>
    <li>
    <s:if test='bean.status == "1"'>
    <input id="unlock" type="button" class="btn" value="账号解锁" />
    </s:if>
    <s:elseif test='bean.status == "0"'>
    <input id="lock" type="button" class="btn" value="账号冻结"/>
    </s:elseif>
    <label>&nbsp;</label>
    <input id="pwdReset" type="button" class="btn" value="密码初始化"/>
    </li>
    </ul>
    
</div> 
 
</form>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
</body>

</html>
