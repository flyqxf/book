<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body style="background:#fff3e1;">
<div></div>
<center>
<p style="font-size:30px;">${msg}</p>
<p style="font-size:30px;">请牢记你的注册账号：${userId}</p>
<input type="button" value="关闭"  class="btn"  onclick="javascript:window.close()">
<center>
</body>
</html>

