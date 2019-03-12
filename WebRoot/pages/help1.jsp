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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/help/helpIframe.js"></script>
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
    <div id="resList">
    <form id="formSearch1" method="post"  action="../help/helpDetail.action">
    <s:hidden id="indexProperty" name = "indexProperty"  value="%{#session.HELP_LIST.indexProperty}" />
    <s:hidden id="id" />
    <s:hidden id="tableListFlg"   value="%{tableListFlg }" />
    <table class="tablelist">
        <thead>
        <tr>
        
        <th width="5%">编号</th>
        <th width="40%">标题</th>
        <th width="16%">籍贯</th>
        <th width="15%">发布时间</th>
        <th width="12%">是否回答</th>
        <th width="13%">操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{#session.HELP_LIST.resultList}"
                            begin="%{#session.HELP_LIST.indexProperty}"
                            end="%{#session.HELP_LIST.endProperty}" 
                            status="res">
        <tr>
        
        <td><s:property value='#res.index+1' /></td>
        <td><s:property value='title' /></td>
        <td><s:property value='province' /><s:property value='city' /></td>
        <td><s:property value='createTime' /></td>
        <td><s:property value='status' /></td>
        <td><a href="javascript:void(0)"  onclick="helpDetail('${id}')" class="tablelink">查看</a> 
        &nbsp;&nbsp;&nbsp;
            <a href="javascript:void(0)"  onclick="delHelp('${id}')" class="tablelink"> 删除</a></td>
        </tr> 
        </s:iterator>
    
        </tbody>
    </table>
    </form>
    <gsp:pageLinks totalProperty="totalProperty" indexProperty="indexProperty" rowProperty="rowProperty"
                  submit="true" action="../help/helpPageLinks.action" name="HELP_LIST" />
   
  
    <s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
 </div>
<div id="resDetail">
   
     <li><span id = "chapterSpanC" style="font-size:30px;"></span></li>
    
    
    
    <li>
    <div id = "contentDiv"  >
      
    </div>
    </li>
   </div>
</body>

</html>
