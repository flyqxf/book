<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/jquery-1.11.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
var index = function() {
var url = "../index/indexAction.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
}
</script>
</head>

<body>
<s:include value="%{pageContext.request.contextPath}/pages/admin/common/header.jsp" />
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index();">首页</a></li>
    <li>系统设置</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>常用设置</span></div>
    
    <div class="toolsli">

    <table width="952" height="221" border="3" class="tablelistSys">
  <tr>
    <th scope="col">项目</th>
    <th scope="col">内容</th>
    <th scope="col">项目</th>
    <th scope="col">内容</th>

  </tr>
  <s:iterator value="systemInfoBeans" id="bean" status="st">
  <s:if  test="#st.Odd">
  <tr>
  </s:if>
  
    <td>${name}</td>
    <td>${value}</td>
  
     
  <s:if  test="#st.Even || #st.Last">
  </tr>
  </s:if>
  
  </s:iterator>
  
</table>

    
    </div>
    
</body>

</html>
