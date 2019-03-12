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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/person/personInfo.js"></script>

<body class="sarchbody">

<form id="personForm" mothod="post">

<div id="m-content">

    

    <s:hidden id="userId" name="personBean.userId"  value="%{personBean.userId}" />
    <s:hidden id="userName" name="personBean.userName"  value="%{personBean.userName}" />
    <s:hidden id="mail"  name="personBean.mail" value="%{personBean.mail}" />
    <s:hidden id="code"  name="personBean.code" value="%{personBean.code}" />
    <s:hidden id="id_zhifubao"  name="personBean.id_zhifubao" value="%{personBean.id_zhifubao}" />
    <s:hidden id="id_weixin"  name="personBean.id_weixin" value="%{personBean.id_weixin}" />
    <s:hidden id="bank" name="personBean.bank"  value="%{personBean.bank}" />
    <s:hidden id="bank_card_name" name="personBean.bank_card_name"  value="%{personBean.bank_card_name}" />
    <s:hidden id="bank_card_number" name="personBean.bank_card_number"  value="%{personBean.bank_card_number}" />
    <s:hidden id="receivables_flg" name="personBean.receivables_flg"  value="%{personBean.receivables_flg}" />
    <s:hidden id="receivables_flg_name" name="personBean.receivables_flg_name"  value="%{personBean.receivables_flg_name}" />
    
    
    <ul class="forminfo">
    <li><label>用户名<b>*</b></label><c><s:property value="personBean.userName"/></c></li>
    <li><label>登录名<b>*</b></label><c><s:property value="personBean.userId"/></c></li>
    <li><label>E_Mail<b>*</b></label><c><s:property value="personBean.mail"/></c></li>
    <li><label>专属优惠码<b>*</b></label><c><s:property value="personBean.code"/></c></li>
    <li><label>收款方式<b>*</b></label><c><s:property value="personBean.receivables_flg_name"/></c></li>
    <li><label>支付宝账号<b>*</b></label><c><s:property value="personBean.id_zhifubao"/></c></li>
    <li><label>微信账号<b>*</b></label><c><s:property value="personBean.id_weixin"/></c></li>
    <li><label>银行名称<b>*</b></label><c><s:property value="personBean.bank"/></c>
    <li><label>开户名称<b>*</b></label><c><s:property value="personBean.bank_card_name"/></c>
    <li><label>银行账号<b>*</b></label><c><s:property value="personBean.bank_card_number"/></c></li>
    
    <li><label>&nbsp;</label><input id="editPerson" type="button" class="btn" value="编辑"/></li>
    </ul>
    
</div> 
 
</form>
</body>

</html>
