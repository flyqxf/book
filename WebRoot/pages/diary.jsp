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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/diary/diary.js"></script>
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
    <li>心得日记</li>
    </ul>
    </div>
    
    <div class="mainbox">
          <div class="tools">
    <ul class="toolbar">

            </ul>
    <ul class="toolbar1">
              <li onclick="today()"><span></span>今天</li>
            </ul>
  </div>
  
          <!--<table class="tablelist">-->
          <div class="Calendar">
          <input type="hidden" id="idYear" name = "year"  value="<s:property value='year'/>" >
          <input type="hidden"  id="idMonth" name = "month"  value="<s:property value='month'/>">
          <input type="hidden"  id="diaryId" >
          
    <div id="idCalendarPre">
        <<
    </div>
    <div id="idCalendarNext">
        >>
    </div>
    <span id="idCalendarYear"><s:property value='year' /></span> 年 <span id="idCalendarMonth"><s:property value='month' /></span> 月
    <table cellspacing="0">
              <thead>
        <tr>
                  <td width="14%">周日</td>
                  <td width="14%">周一</td>
                  <td width="14%">周二</td>
                  <td width="14%">周三</td>
                  <td width="14%">周四</td>
                  <td width="15%">周五</td>
                  <td width="15%">周六</td>
                </tr>
      </thead>
              <tbody id="idCalendar">
       <s:iterator value="%{dayList}" >
        <tr>
            <s:iterator value="top" id="day">
                <s:if test="%{#session.DIARY_TODAY_DAY==#day && #session.DIARY_TODAY_YEAR == year && #session.DIARY_TODAY_MONTH == month}">
                  <td class="onToday"><a href = "javascript:void(0);" onclick="showDiv(<s:property value='#day'/>)"  style="color:#C60;"><s:property value='#day'/><br><s:property value='diaryTitle.get(#day)'/></a></td>
                </s:if>
                <s:else>
                    <s:set name="haveDiaryFlg" value="0" />
                    <s:iterator value="%{haveDiaryDayList}" id="haveDiaryday">
                        <s:if test="%{#haveDiaryday==#day && #session.DIARY_YEAR == year && #session.DIARY_MONTH == month}">
                            <s:set name="haveDiaryFlg" value="1" />
                        </s:if>
                    </s:iterator>
                    <s:if test="%{#haveDiaryFlg==1}">
                    <td><a href = "javascript:void(0);" onclick="showDiv(<s:property value='#day'/>)" ><s:property value='#day'/><br><s:property value='diaryTitle.get(#day)'/></a></td>
                    </s:if>
                    <s:else>
                     <td><a href = "javascript:void(0);" onclick="showDiv(<s:property value='#day'/>)" ><s:property value='#day'/><br><s:property value='diaryTitle.get(#day)'/></a></td>
                     </s:else>
                </s:else>
            </s:iterator>
                </tr>
        </s:iterator>
      </tbody>
            </table>
  </div>
          
          <!-- </table>--> 
          
          <!--leftinfo end--> 
          
          <!--mainleft end--> 
          
          <!--mainright end--> 
          
        </div>
        
<!--添加记事-->        
<div id="popup_container" class="ui-draggable pop" style="display:none;" >
          <div class="rl" onclick="close();">
    <h1 id="popup_title" style="cursor: move;">添加心得日记</h1>
    <a id="topbanner-close" style="position: absolute; right: 5px; top: 5px; display: block; width: 22px; height: 22px; background: transparent url(../images/close.png) no-repeat scroll 0px 0px;" fclog="9740.101424.304108.1.2_955_6214"  href="javascript:void(0);" onclick="closeDiv()"></a> </div>
          <div id="popup_content" class="prompt">
    <div id="popup_message">
              <ul class="forminfo">
        <li id="popup_prompt">
                  <label style="width:60px;"> 标题: </label>
                  <div class="toolbar">
            <input class="dfinput" id = "title" type="text" style="width:350px;" placeholder="请填写标题" maxlength="20" name="title">
            <br />
            </div>
                </li>
           <li id="popup_prompt">
                  <label style="width:60px;">内容: </label>
                  <textarea class="ke-textarea" id = "content" style="height: 90px;" name="content"></textarea>
                </li>
      </ul>
            </div>
    <div id="popup_panel">
              <input id="btnInsertDiary" class="scbtn" type="button" value="保存" name="">
              <input id="btnCancelDiary" class="scbtn2" type="button" value="取消" name="" onclick="closeDiv()">
            </div>
  </div>
        </div>
        <!--添加记事-->
        
        
        
        
         
        
        <!--查看记事--> 
        <div id="popup_container2" class="ui-draggable pop" style="display:none;" >
          <div class="rl" onclick="close2();">
    <h1 id="popup_title" style="cursor: move;">查看记事</h1>
    <a id="topbanner-close2" style="position: absolute; right: 5px; top: 5px; display: block; width: 22px; height: 22px; background: transparent url(../images/close.png) no-repeat scroll 0px 0px;" fclog="9740.101424.304108.1.2_955_6214"  href="javascript:void(0);" onclick="closeDiv2()"></a> </div>
          <div id="popup_content" class="prompt">
    
    <div id="popup_pane2">
    <div id="popup_pane3">
              <input class="delbtn"   type="button" id = "updateDiary" value="保存" name="">
              <input class="delbtn" type="button" id = "delDiary" value="删除" name="">
            </div>
              <h3><input class="dfinput" id = "editTitle" type="text" style="width:350px;" placeholder="请填写标题"  maxlength="20" name="title"></h3>
              <p class="pic" id="diaryTime"></p>
              <ul class="forminfo" style="padding:0">
              <li id="popup_prompt">
                  <textarea class="ke-textarea" id = "editContent" style=" width:90%;height: 190px;"></textarea>
                </li>
                </ul> 
            </div>
  </div>
        </div>
</div>
</div>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
</body>
       




</html>
