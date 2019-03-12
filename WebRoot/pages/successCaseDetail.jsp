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
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/buttons.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cloud.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/size.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/successCase/successCase.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/successCase/successCaseDetail.js"></script>
<script type="text/javascript">
link = "${successBeanBean.link}"

</script>
</head>

<body class="sarchbody">

	<s:include value="%{pageContext.request.contextPath}/pages/common/header.jsp" />

<div id="m-content">
<s:include value="%{pageContext.request.contextPath}/pages/common/menu1.jsp" />
            <div class="m-right-content">
            <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index()">首页</a></li>
    <li>成功案例</li>
    </ul>
    <p >
    <s:if test='preSuccessBeanBean == null'>
    上一篇
    </s:if>
    <s:else>
    <a href="javascript:void(0)" onclick="detail('${preSuccessBeanBean.id}')" style="text-decoration:underline">上一篇</a>
    </s:else>
    &nbsp;|&nbsp;
    <s:if test='nextSuccessBeanBean == null'>
    下一篇
    </s:if>
    <s:else>
    <a href="javascript:void(0)" onclick="detail('${nextSuccessBeanBean.id}')" style="text-decoration:underline">下一篇</a>
    </s:else>
    
    </p>
    </div>
    
    <div class="formbody">
    
    <%--
    <div id="usual1" class="usual adviceBox"> 
    
    <div id="title" class="adviceTitle"><s:property value='successBeanBean.title' /></div>
    <br />
    <div id = "detail" class="adviceDetail"><s:property value='successBeanBean.successCase' /></div>
     
	</div> 
	--%>
    </div>
</div>
</div>


</body>

</html>
