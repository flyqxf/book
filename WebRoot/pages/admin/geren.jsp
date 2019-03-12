<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
 <link href="${pageContext.request.contextPath}/css/jquery-ui.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/jquery-ui-timepicker-addon.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select2.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet">



<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/jquery-1.11.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/area2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/chooseLocation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
        width : 345           
    });
    $(".select2").uedSelect({
        width : 167  
    });
    $(".select3").uedSelect({
        width : 100
    });
});
var pay_Zhijie = function(userId) {
    var url = "./zhifu.action";
    
    $("#gerenForm").attr("action",url);
    $("#userId").val(userId);
    $("#flg").val("1");
    
    
    $("#gerenForm").submit();
};
var pay_Jianjie = function(userId) {
    
    var url = "./zhifu.action";
    
    $("#gerenForm").attr("action",url);
    $("#userId").val(userId);
    $("#flg").val("2");
    
    $("#gerenForm").submit();
};
var index = function() {
var url = "../index/indexAction.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
};
</script>
<style type="text/css">
<!--
.STYLE1 {color: #00FF00}
.STYLE2 {color: #FF0000}
-->
</style>
</head>

<body>
<s:include value="%{pageContext.request.contextPath}/pages/admin/common/header.jsp" />
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index();">首页</a></li>
    <li>会员管理</li>
    </ul>
    </div>
    <form id="gerenForm" method="post">
    <s:hidden id="userId" name = "userId" />
    <s:hidden id="flg" name = "flg" />
    </form>
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
    <ul> 
    <li><a href="#tab1" class="selected">个人信息</a></li> 
    <li><a href="#tab2">直接销售明细</a></li> 
    <li><a href="#tab3">间接销售明细</a></li> 
    </ul>
    </div> 
    
    <div id="tab1" class="tabson">
        <iframe src="../user/tab1User.action?userId=${userId}"  width="100%" height="600" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    </div> 
    
    <div id="tab2" class="tabson">
    <iframe src="../user/tab2User.action?userId=${userId}"  width="100%" height="600" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    
    </div>  
    
    <div id="tab3" class="tabson">
    <iframe src="../user/tab3User.action?userId=${userId}"  width="100%" height="600" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
       
    
    </div>
    
    </div>
<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
    </script>
    
     </div>

    
</body>

</html>
