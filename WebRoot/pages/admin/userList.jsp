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

  
<script type="text/javascript">
 showflg="${showflg}";
 province_val = "${bean.province_val}";
 city_val = "${bean.city_val}";
$(document).ready(function(e) {

    $(".select3").uedSelect({
        width : 152
    });
    
     $("#usual1 ul").idTabs();
    
    //init();
    $("#select").one('click').click(select);
    DateControl("dateFrom");
    DateControl("dateTo");
    initShow();
     $(".scbtn1").click(function() 
    {    if(showflg == '1') {
          $(".seachform2").show();
          showflg="2";
        } else {
            $(".seachform2").hide();
            showflg="1";
        }
        
    });
    $("#export").one('click').click(exportExcel); 

});

var exportExcel = function() {
    $("#userForm").attr("action","./exportExcel.action");
    $("#userForm").submit();
};

var initShow = function() {
    if(showflg == '1') {
    $(".seachform2").hide();
        } else {
            $(".seachform2").show();
        }
};
 var init=function(){
     if(province_val !=null&&province_val!=""){
         $("#province").append("<option value='"+province_val+"'></option>");  //添加一项option
     }
     if(city_val !=null&&city_val!=""){
         $("#city").append("<option value='"+city_val+"'></option>");  //添加一项option
     }
      // 初始化chooseLocation
      $('.select-group').chooseLocation();

      // 使用select2美化下拉框样式
      $('.select2-theme select').select2({
        minimumResultsForSearch: Infinity
      });
      
     
    };
 var select = function() {
    var pro = $("#province").find('option:selected').html();
    var pro_val = $("#province").val();
    var city = $("#city").find('option:selected').html();
    var city_val = $("#city").val();
    
    $("#pro").val(pro);
    $("#cty").val(city);
    $("#pro_val").val(pro_val);
    $("#cty_val").val(city_val);
    $("#showflg").val(showflg);
    $("#userForm").submit();
 };
 
 var detail=function(userId) {
    var url = "../user/userDetail.action";
    $("#userId").val(userId);
    
    $("#userForm").attr("action",url);
    $("#userForm").submit();
 };
 var index = function() {
var url = "../index/indexAction.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
};
 
 var turnAdmin=function(userId) {
    parem = {
        "userId" : userId
    };
    showInfoMessageDouble("是否赋予管理者权限？","提示信息",addAdmin);
    
 };
 
 var delAdmin=function(userId) {
    delParem = {
        "userId" : userId
    };
    showInfoMessageDouble("是否移除管理者权限？","提示信息",delA);
    
 };
 
 
var addAdmin = function() {
    ajaxPostAction("../userJ/addAdminRole.action", parem, editResult, "权限追加");
};

var delA = function() {
    ajaxPostAction("../userJ/delAdminRole.action", delParem, editResult, "权限删除");
};
 
//录入后判断返回结果
var editResult = function(data) {
    if (data != undefined && data != "") {
        var jsonObj = eval("(" + data + ")");
        var status = jsonObj.status;
        var msg = jsonObj.msg;

        // 处理成功情况
        if (status == "success") {
            showInfoMessage(msg, "提示信息", "/user/userAction.action");
        } else {
            showInfoMessage(msg, "提示信息",null);
        }
    }
};
 
 
 
</script>
</head>

<body class="sarchbody">
<s:include value="%{pageContext.request.contextPath}/pages/admin/common/header.jsp" />

    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index();">首页</a></li>
    <li>会员管理</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    <form id="userForm" method="post" action="./userAction.action">
    
     <s:hidden id="pro" name = "bean.province"  />
    <s:hidden id="pro_val" name = "bean.province_val"  />
    <s:hidden id="cty" name = "bean.city"  />
    <s:hidden id="cty_val" name = "bean.city_val"  />
    <s:hidden id="showflg" name = "showflg"  />
    <s:hidden id="userId" name = "userId" />
    <s:hidden id="indexProperty" name = "showflg" value="%{#session.userInfoList.indexProperty}"/>
    <ul class="seachform1">
    
    <li><label>会员ID</label><input name="bean.userId" type="text" class="scinput1" value ="${bean.userId }"/></li>
    <li><label>会员名称</label><input name="bean.userName" type="text" class="scinput1"  value ="${bean.userName }"/></li>
    <li><label>手机号</label><input name="bean.mobile" type="text" class="scinput1"  value ="${bean.mobile}"/></li>
    </ul>
    
    <ul class="seachform2">
    
    
    
    
    
    <li><label>支付方式</label>  
    <div class="vocation">
    <select class="select3" id="zhifu" name="bean.receivables_flg">
    <option value = ""  <s:if test='bean.receivables_flg == null || bean.receivables_flg == ""'>selected</s:if> >全部</option>
    <option value = "1" <s:if test='bean.receivables_flg == "1"'>selected</s:if>>支付宝</option>
    <option value = "2" <s:if test='bean.receivables_flg == "2"'>selected</s:if>>微信</option>
    <option value = "3" <s:if test='bean.receivables_flg == "3"'>selected</s:if>>银联</option>
    </select>
    </div>
    </li>
    
    <li><label>支付账号</label><input type="text" class="scinput1" name="bean.zhanghao" value="${bean.zhanghao}"/></li>
    <li><label>账号状态</label>  
    <div class="vocation">
    <select class="select3" name="bean.status">
    <option value="" <s:if test='bean.status == null || bean.status == ""'>selected</s:if>>全部</option>
    <option value="0" <s:if test='bean.status == "0"'>selected</s:if>>正常</option>
    <option value="1" <s:if test='bean.status == "1"'>selected</s:if>>冻结</option>
    </select>
    </div>
    </li>
   
     <li><label>会员区分</label>  
    <div class="vocation" >
    <select class="select3" name="bean.user_flg">
    <option value="" <s:if test='bean.user_flg == null || bean.user_flg == ""'>selected</s:if>>全部</option>
    <option value="1" <s:if test='bean.user_flg == "1"'>selected</s:if>>学员</option>
    <option value="2" <s:if test='bean.user_flg == "2"'>selected</s:if>>销售员</option>
    </select>
    </div>
    </li>     
     <li><label>入会时间</label><input id="dateFrom" type="text" class="scinput1" name="bean.register_time_from" value="${bean.register_time_from }"/></li>
    <li><label>一</label><input id="dateTo" type="text" class="scinput1" name="bean.register_time_to"  value="${bean.register_time_to }"/></li>
    

    
    </ul>
    
    <ul class="seachform1">
    <li class="sarchbtn"><label>&nbsp;</label><input id="select" type="button" class="scbtn" value="查询"/>   <input name="" type="button" class="scbtn1" value="更多条件"/>   <input id="export" type="button" class="scbtn2" value="导出EXCEL"/></li>  
    </ul>
   </form> 
    

    <div class="formtitle"></div>
    
    <table class="tablelist">
        <thead>
        <tr>
        
        <th>会员ID</th>
        <th>会员名称</th>
        <th>电话</th>
        <th>总推荐人数</th>
        <th>入会时间</th>
        <th>会员区分</th>
        <th>收款方式</th>
        <th>收款账号</th>
        <th>状态</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{#session.userInfoList.resultList}"
                            begin="%{#session.userInfoList.indexProperty}"
                            end="%{#session.userInfoList.endProperty}" 
                            status="res">
        <tr>
        
        <td>${userId}</td>
        <td>${userName}</td>
        <td>${mobile}</td>
        <td>${tuijianRenshu}人</td>
        <td>${register_time}</td>
        <td>${user_flg_name}</td>
        <td>${receivables_flg_name}</td>
        <td>${zhanghao}</td>
        <td>${status_name}</td>
        <td><a href="javascript:void(0)" onclick="detail('${userId}')">查看&nbsp;&nbsp;&nbsp;</a>
        <s:if test='user_flg != "0"'>
        <a href="javascript:void(0)" onclick="turnAdmin('${userId}')">追加管理权限&nbsp;&nbsp;&nbsp;</a>
        </s:if>
        <s:elseif test='user_flg=="0"'>
        <a href="javascript:void(0)" onclick="delAdmin('${userId}')">删除管理权限&nbsp;&nbsp;&nbsp;</a></td>
        </s:elseif>
        </tr> 
        </s:iterator>

        </tbody>
    </table>
    <gsp:pageLinks totalProperty="totalProperty" indexProperty="indexProperty" rowProperty="rowProperty"
                  submit="true" action="../user/pageLinks.action" name="userInfoList" />
    </div>
    
    </div>
<div class="clear"></div>
   <s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
   

</body>

</html>
