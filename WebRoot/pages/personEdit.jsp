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
<link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/buttons.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select2.css" rel="stylesheet">


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/jquery-1.11.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/area.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/chooseLocation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/select2.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/size.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/person/personUpdate.js"></script>

<body class="sarchbody">


<div id="m-content" >

    

    <s:hidden id="userId"  value="%{personBean.userId}" />
    <s:hidden id="receivables_flg" name="personBean.receivables_flg"  value="%{personBean.receivables_flg}" />
    <ul class="forminfo">
    <li>用户名<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  maxlength="16" size="40" id="userName"  name="personBean.userName" value="<s:property value='%{personBean.userName}'/>"></li>
    <li>登录名<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="personBean.userId"/></li>
    <li>E_Mail<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  maxlength="96"  size="60"  id="mail"  name="personBean.mail" value="<s:property value='%{personBean.mail}'/>" ></li>
    <li>专属优惠码<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="personBean.code"/></li>
    <li>收款方式<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="personBean.receivables_flg_name"/></li>
    <li>支付宝账号<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  maxlength="60" size="40" id="id_zhifubao"  name="personBean.id_zhifubao" value="<s:property value='personBean.id_zhifubao'/>"></li>
    <li>微信账号<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  maxlength="60" size="40" id="id_weixin"  name="personBean.id_weixin" value="<s:property value='personBean.id_weixin'/>"></li>
    <li>银行名称<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  maxlength="60" size="40" id="bank"  name="personBean.bank" value="<s:property value='personBean.bank'/>"></li>
    <li>开户名称<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  maxlength="32" size="40" id="bank_card_name"  name="personBean.bank_card_name" value="<s:property value='personBean.bank_card_name'/>"></li>
    <li>银行账号<b>*</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  maxlength="16" size="40" id="bank_card_number"  name="personBean.bank_card_number" value="<s:property value='personBean.bank_card_number'/>"></li>
    <li><input id="updatePerson" type="button" class="btn" value="修改"/>&nbsp;&nbsp;&nbsp;<input id="cancel" type="button" class="btn" value="取消"/></li>
    </ul>
    
</div> 
 <s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />

</body>

</html>
