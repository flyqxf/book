<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<body unload="closeIt()">
<head oncontextmenu="self.event.returnValue=false" onselectstart="return false">
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/book/book.js"></script>
<script type="text/javascript">
var chapter = "${partBean.chapter}";
var part = "${partBean.part}";
var link = "${partBean.path}"+"${partBean.link}";
document.oncontextmenu=function(e){ 
return false; 
};

 
</script>  
</head>



            

     <div class="m-right-content">

            <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><span id = "chapterSpan"></span></li>
    <li><span id = "part"></span></li>
    </ul>
    </div>
    
    <div id = "neirong" class="mainindex1">
    
    
    <div class="welinfo1" style="height:550px">
<iframe src="" id="bookFrame"  width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    </div>
    
    </div>

    </div>
</body>
</html>
