<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
selectedTab = "${selectedTab}";
url="${url}";
$(document).ready(function(e) {
    $("#usual1 ul").idTabs();
    if(selectedTab == null || selectedTab == '') {
        selectedTab = "2";
    }; 
    init(selectedTab);
    if(url == null || url == '') {
        url = "../wenzhang/tab1Wenzhang.action";
    }
    $("#tabDetail1").attr("src",url);
});
var init = function(selectedTab) {
    if(selectedTab =="1") {
        $(".itab a:first").addClass("selected");
        $(".itab a:last").removeClass("selected");
        $("#tab1").show();
        $("#tab2").hide();
    } else {
        $(".itab a:first").removeClass("selected");
        $(".itab a:last").addClass("selected");
        $("#tab1").hide();
        $("#tab2").show();
    }

};
var detail = function(id) {
    var url = "./wenzhang.action";
    // 迁移参数设定
    var params = new Array();
    params[0] = ["id", id];

    deptAction(url,params);
    
};
var showWenzhang = function() {
    var url = "./wenzhang.action";
    // 迁移参数设定
    var params = new Array();

    deptAction(url,params);
};
var index = function() {
var url = "../index/indexAction.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
};
</script>
</head>

<body>
<s:include value="%{pageContext.request.contextPath}/pages/admin/common/header.jsp" />
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index();">首页</a></li>
    <li>学员文章</li>
    </ul>
    </div>
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div id = "tabSet" class="itab">
    <ul> 
    <li><a href="#tab1" >详细&回答</a></li> 
    <li><a href="#tab2" >学员文章一览</a></li> 
    </ul>
    </div> 
    
    <div id="tab1" class="tabson">
    
    <iframe id = "tabDetail1"   width="100%" height="500" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    
    </div> 
    <div id="tab2" class="tabson">
    <iframe src="../wenzhang/tab2Wenzhang.action"  width="100%" height="500" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    </div>  
       
    </div> 
 
    <script type="text/javascript"> 
     // $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
    //$('.tablelist tbody tr:odd').addClass('odd');
    </script>
    
    </div>


</body>

</html>
