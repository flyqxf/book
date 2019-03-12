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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/kindeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/size.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/help/help.js"></script>
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
<script type="text/javascript">
    KE.show({
        id : 'content7'
    });
    var province_val = "${helpBean.province_val}";
    var city_val = "${helpBean.city_val}";
    
  </script>
<body class="sarchbody">

	<s:include value="%{pageContext.request.contextPath}/pages/common/header.jsp" />

<div id="m-content">
<s:include value="%{pageContext.request.contextPath}/pages/common/menu1.jsp" />
            <div class="m-right-content">
            <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index()">首页</a></li>
    <li>答疑解惑</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
    <ul> 
    <li><a href="#tab1" class="selected">我要提问</a></li> 
    <li><a href="#tab2">我提过的问题</a></li> 
    </ul>
    </div> 
    
    <div id="tab1" class="tabson">
    <form id="formAdd" method = "post" action="../help/helpAdd.action">
    <s:hidden id="pro" name = "helpBean.province"  />
    <s:hidden id="pro_val" name = "helpBean.province_val"  />
    <s:hidden id="cty" name = "helpBean.city"  />
    <s:hidden id="cty_val" name = "helpBean.city_val"  />
    <s:hidden id="content" name = "helpBean.content" />
    <s:hidden id="id" name="id"  value="%{helpBean.id}" />
    <s:include value="%{pageContext.request.contextPath}/pages/common/message.jsp" />
    <ul class="forminfo">
    <li><label>问题标题<b>*</b></label><input name="helpBean.title" type="text" id="title" class="dfinput" placeholder="请填写单位名称"  style="width:518px;" maxlength='20' value="<s:property value='%{helpBean.title}'/>"/></li>
   
    <li><label>居住地点<b>*</b></label>
    
    <div class="usercity">
    <div class="select-group">
    <div class="cityleft">
    <select id="province" class="select2 pro"></select>
    </div>
    <div class="cityright">
    <select id="city"  class="select2 city"></select>
        </div>
  </div>
    </div>
    </li>
    <li><label>问题内容<b>*</b></label>
    

    <textarea id="content7" name="content" style="width:700px;height:250px;visibility:hidden;" maxlength='10000'><s:property value='%{helpBean.content}'/></textarea>
    
    </li>
    <s:if test="helpBean.answer != null && helpBean.answer !=''">
    <li><label>回答内容</label>
    

    <textarea style="width:700px;height:200px;" maxlength='10000' disabled ><s:property value='%{helpBean.answer}' /></textarea>
    
    </li>
    </s:if>
    <s:else>
    <li><label>&nbsp;</label><input name="" type="button"  id = "helpSubmit" class="btn" value="马上发布"/></li>
    </s:else>
    
    </ul>
    </form>
    </div> 
    
    
    <div id="tab2" class="tabson" style="height:750px">
    <iframe src="../help/tab2Help.action"  width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0"  style="border:0;"></iframe>
    </div>  
       
    </div> 
    </div>
</div>
</div>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />

</body>

</html>
