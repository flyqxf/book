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



<link href="${pageContext.request.contextPath}/css/jquery-ui.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/jquery-ui-timepicker-addon.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">




<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/jquery-1.11.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/area.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/chooseLocation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/area/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/size.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/person/achievement.js"></script>

<body class="sarchbody">

<form id="achievementForm" method="post">

<div id="m-content">

    

    <s:hidden id="userId" name="personBean.userId"  value="%{personBean.userId}" />
    <s:hidden id="userName" name="personBean.userName"  value="%{personBean.userName}" />
    <s:hidden id="mail"  name="personBean.mail" value="%{personBean.mail}" />
    <s:hidden id="code"  name="personBean.code" value="%{personBean.code}" />
    <s:hidden id="id_zhifubao"  name="personBean.id_zhifubao" value="%{personBean.id_zhifubao}" />
    <s:hidden id="id_weixin"  name="personBean.id_weixin" value="%{personBean.id_weixin}" />
    <s:hidden id="bank" name="personBean.bank"  value="%{personBean.bank}" />
    <s:hidden id="bank_card_name" name="personBean.bank_card_name"  value="%{personBean.bank_card_name}" />
    <s:hidden id="bank_card_number" name="personBean.bank_card_number"  value="%{personBean.bank_card_number}" />
    <s:hidden id="fromDate" name="achievementBean.startDate"  value="<s:property value='%{achievementBean.startDate}'/>"/>
    <s:hidden id="toDate" name="achievementBean.endDate"  value="<s:property value='%{achievementBean.endDate}'/>"  />
    <div align="left">
    <h3 class="o-title STYLE1">推荐总人数：${personBean.tuijianRenshu}人</h3>
    <s:set var = "achievementSummaryBean" value="%{#session.achievementSummaryBean}" />
    <table class="tablelistAch">
        <tr>
             <td rowspan="4" class="td_Ach">业绩</td>
            <td colspan="4" class="td_Ach">销售业绩（历史）</td>
            <td colspan="4" class="td_Ach">销售业绩（当前未支付）</td>
        </tr>
        <tr>
            <td width="8%">直接介绍</td>
            <td width="15%"><s:property value="#achievementSummaryBean.personSum_zhi_yi"/>人</td>
            <td width="8%">间接介绍</td>
            <td width="15%"><s:property value="#achievementSummaryBean.personSum_jian_yi"/>人</td>
            <td width="8%">直接介绍</td>
            <td width="15%"><s:property value="#achievementSummaryBean.personSum_zhi_wei"/>人</td>
            <td width="8%">间接介绍</td>
            <td width="15%"><s:property value="#achievementSummaryBean.personSum_jian_wei"/>人</td>
        </tr>
        <tr>            <td>收入</td>
            <td><s:property value="#achievementSummaryBean.moneySum_zhi_yi"/>元</td>
            <td>收入</td>
            <td><s:property value="#achievementSummaryBean.moneySum_jian_yi"/>元</td>
            <td>收入</td>
            <td><s:property value="#achievementSummaryBean.moneySum_zhi_wei"/>元</td>
            <td>收入</td>
            <td><s:property value="#achievementSummaryBean.moneySum_jian_wei"/>元</td>
        </tr>
        <tr>
            <td colspan="2">收入合计：</td>
            <td colspan="2" class="fontAch"><s:property value="#achievementSummaryBean.moneySum_yi"/>元</td>
            <td colspan="2">未支付合计：</td>
            <td colspan="2" class="fontAch fontAchColor"><s:property value="#achievementSummaryBean.moneySum_wei"/>元</td>
            
        </tr>
    </table>
    </div>
    <ul class="prosearch">
   <li><label>时间段查询：</label>
   <i>开始年月日</i><a>
   <input type="text" maxlength="19" class="input_width_z1" id="startDate" maxlength="10" value="<s:property value='%{achievementBean.startDate}'/>" ></a>
   <i>结束年月日</i><a>
   <input type="text" maxlength="19" class="input_width_z1" id="endDate" maxlength="10"  value="<s:property value='%{achievementBean.endDate}'/>" ></a>
   <li>
   <label>支付状态：</label>
   </i>
   <a>
   <select name="achievementBean.pay_status">
    <option value="-1" <s:if test='achievementBean.pay_status == "-1"'>selected</s:if>>--请选择--</option>
    <option value="0" <s:if test='achievementBean.pay_status == "0"'>selected</s:if>>未支付</option>
    <option value="1" <s:if test='achievementBean.pay_status == "1"'>selected</s:if>>已支付</option>
   </select>
   </a>
   <input id = "searchAchievement"  name="" type="button" class="sure" value="查询"/></li>
   
   </ul>      

    
    
    <table class="tablelist">
        <thead>
        <tr>
        <th>编号</th>
        <th>会员名称</th>
        <th>支付状态</th>
        <th>注册时间</th>
        <th>劳务费</th>
        <th>劳务费区分</th>
        </tr>
        </thead>
        <tbody>
         <s:iterator value="%{#session.ACHIEVEMENT_LIST.resultList}"
                            begin="%{#session.ACHIEVEMENT_LIST.indexProperty}"
                            end="%{#session.ACHIEVEMENT_LIST.endProperty}" 
                            status="res">
        <tr>
        <td><s:property value="#res.count" /></td>
        <td><s:property value="userName" /></td>
        <td><s:property value="pay_status_name" /></td>
        <td><s:property value="register_time" /></td>
        <td><s:property value="pay" /></td>
        <td><s:property value="flg_name" /></td>
        </tr> 
        </s:iterator>
        </tbody>
    </table>
    </div>
    
</form>
<gsp:pageLinks totalProperty="totalProperty" indexProperty="indexProperty" rowProperty="rowProperty"
                  submit="true" action="../person/pageLinks.action" name="ACHIEVEMENT_LIST" />
</body>

</html>
