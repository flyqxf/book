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
userId="${outUser.userId}";
msg = "${msg}";
unpaid_qqq="${outPayBean.unpaid_qqq}";
unpaid_qq="${outPayBean.unpaid_qq}";
unpaid_dq="${outPayBean.unpaid_dq}";
$(document).ready(function(e) {
    $("#pay1").one('click').click(pay1);
    if(msg != '') {
        showInfoMessage(msg);
    }
});

var pay1 = function(){
    var select = "";
    var payName = $("#payName").val();
    var paySum = $("#paySum").val();
    var sum = 0;
    $("input[type='checkbox']:checked").each(function(){
        
        if(select != '') {
            select = select + ",";
        }
        select = select + this.value;
        
    });
    if(select.indexOf('1')>=0) {
        sum = sum + parseInt(unpaid_qqq);
    }
    if(select.indexOf('2')>=0) {
        sum = sum + parseInt(unpaid_qq);
    }
    if(select.indexOf('3')>=0) {
        sum = sum +parseInt(unpaid_dq);
    }
    
    if(select == ''){
        showInfoMessage("请选择支付内容","提示信息",null);
        return false;
    }else if(payName == ''){
        showInfoMessage("请输入支付人","提示信息",null);
        return false;
    }else if(paySum == ''){
        showInfoMessage("请输入支付金额","提示信息",null);
        return false;
    } else if(!isChinaOrLett(paySum)) {
    
        showInfoMessage("支付金额请输入数字","提示信息",null);
        return false;
    } else if(paySum > sum ) {
        showInfoMessage("支付金额不能大于待支付金额","提示信息",null);
        return false;
    }
    $("#select").val(select);
    $("#userId").val(userId);
    
    showInfoMessageDouble("确认要支付吗？","支付确认",function(){$("#payForm").submit();
    
    });

};
function isChinaOrLett(s){
var regu = "^[0-9\\s]+$";
var re = new RegExp(regu);
if (re.test(s)) {
    return true;
}else{
    return false;
}
};
var index = function() {
var url = "../index/indexAction.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
};
</script>
</head>

<body class="sarchbody">
<%--<s:include value="%{pageContext.request.contextPath}/pages/admin/common/header.jsp" />
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)" onclick="index();">首页</a></li>
    <li>费用支付（间接）</li>
    </ul>
    </div> --%>
    <div class="formbody">
    
销售业绩
<table width="539" height="146" border="3">
      <tr>
        <th colspan="5" bgcolor="#9900FF" scope="col"><span class="STYLE2">间接销售业绩</span></th>
      </tr>
      <tr>
        <td bgcolor="#9900FF"><div align="center" class="STYLE2">项目</div></td>
        <td bgcolor="#9900FF"><div align="center" class="STYLE2">间接人数</div></td>
        <td bgcolor="#9900FF"><div align="center" class="STYLE2">奖励金额</div></td>
        <td bgcolor="#9900FF"><div align="center" class="STYLE2">未支付金额</div></td>
        <td bgcolor="#9900FF"><div align="center" class="STYLE2">操作</div></td>
      </tr>
      <s:iterator value="%{#session.ZhifuList_jianjie}"
                            
                            status="res">
      <tr>
        <td width="87"><s:if test='#res.index==0'><div align="center">前前期</div></s:if>
        <s:elseif test='#res.index==1'><div align="center">前期</div></s:elseif>
        <s:elseif test='#res.index==2'><div align="center">当期</div></s:elseif>
        </td>
        <td width="82"><div align="center"><strong>${personSum}</strong></div></td>
        <td width="132"><div align="center">${pay}元</div></td>
        <td width="132"><div align="center">${unpaid}元</div></td>
        <td width="68"><input type="checkbox" name="checkbox" value="<s:property value='#res.index+1' />" /></td>
      </tr>
      </s:iterator>
      <!-- <tr>
        <td>前期</td>
        <td>${outPayBean.personSum_Summary_qq}</td>
        <td>${outPayBean.pay_qq}元</td>
        <td>${outPayBean.unpaid_qq}元</td>
        <td><input type="checkbox" name="checkbox2"  value="2"/></td>
      </tr>
      <tr>
        <td>当期</td>
        <td><strong>${outPayBean.personSum_Summary_dq}</strong></td>
        <td>${outPayBean.pay_dq}元</td>
        <td>${outPayBean.unpaid_dq}元</td>
        <td><input type="checkbox" name="checkbox3"  value="3"/></td>
      </tr>
      <tr>
        <td colspan="2"><div align="right"><strong>收入合计</strong></div></td>
        <td colspan="3"><div align="center" class="STYLE1">${outPayBean.pay_summary}元</div></td>
      </tr>
       -->
    </table>

<label></label>
<p><br />
  支付信息：<br />
  会员ID：${outUser.userId} <br />     会员名称：${outUser.userName}<br />
  <s:if test='outUser.receivables_flg == "1"'>
  账户类型：${outUser.receivables_flg_name}  <br />
  账号： ${outUser.id_zhifubao}<br />
  </s:if>
  <s:elseif test='outUser.receivables_flg == "2"'>
  账户类型：${outUser.receivables_flg_name}  <br />
  账号： ${outUser.id_weixin}<br />
  </s:elseif>
  <s:elseif test='outUser.receivables_flg == "3"'>
  账户类型：${outUser.receivables_flg_name} 开户行：${outUser.bank} <br />
  账号： ${outUser.bank_card_number}<br />
  </s:elseif>
  <br />
   <form method="post" id="payForm" action="./payJianjie.action">
  <s:hidden id="userId" name = "userId" value="<s:property value='outUser.userId'/>" />
  <s:hidden id="select" name = "select" />
  支付人：
  <input type="text" name="payName"  class="scinput1"  id="payName" value="${payName}"/>
  支付金额：
  <input type="text" name="paySum" class="scinput1" maxlength="5" id="paySum" value="${paySum}"/>
  </form>
</p>
<p>
  <input id="pay1" type="button" class="scbtn" value="支付"/>&nbsp;&nbsp;<input id="pay1" type="button" class="scbtn" value="返回" onclick="history.go(-1);"/>
  <br />
</p>

</div>
<s:include value="%{pageContext.request.contextPath}/pages/common/modalMessageStr.jsp" />
</body>

</html>
