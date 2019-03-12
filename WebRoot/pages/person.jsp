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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/person/person.js"></script>
<style media="screen">
    *{margin:0;padding:0}
    .select-group{
      margin:10px auto;
    }
    select{
      width:27%;
      margin-right:3%;
    }
    h3{
      line-height:30px;
      font-weight:normal;
    }
  </style>
  

</head>

<body class="sarchbody">

	<s:include value="%{pageContext.request.contextPath}/pages/common/header.jsp" />

<div id="m-content">
<s:include value="%{pageContext.request.contextPath}/pages/common/menu1.jsp" />
            <div class="m-right-content">
            <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">个人中心</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
    <ul> 
    <li><a href="#tab1" class="selected">个人信息</a></li> 
    <li><a href="#tab2">我的业绩</a></li> 
    <li><a href="#tab3">业绩统计</a></li> 
    <li><a href="#tab4">密码修改</a></li> 
    </ul>
    </div> 
    
    <div id="tab1" class="tabson" style="height:600px">
        <iframe src="../person/tab1Person.action"  width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    </div> 
    
    
    <div id="tab2" class="tabson" style=" height:600px">
    <iframe src="../person/tab2Person.action"  width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    </div>  
     <div id="tab3" class="tabson" style=" height:600px">
    <iframe src="../person/tab3Person.action"  width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    </div>  
    <div id="tab4" class="tabson" style="height:600px">
        <iframe src="../person/tab4Person.action"  width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    </div>
    </div> 
 
    <script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
    </script>
    </div>

</div>
</div>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />

</body>

</html>
