<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>元能100信息服务</title>

<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/buttons.css" rel="stylesheet">



<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cloud.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
    
msg="${msg}";
    $(document).ready(function () {
        if (msg != null && msg != '') {
            alert(msg);
        }
        chgReceivables();
    });
    
    
    var saler = function() {
        $("#registerForm").submit();
    };
    var chgReceivables= function() {
        var flg = $("#receivables_flg").val();
        if(flg =='1') {
            $("#idAliPay").show();
            $("#idWeChat").hide();
            $("#idBankName").hide();
            $("#idBankCode").hide();
            $("#idPersonName").hide();
        }else if(flg =='2') {
            $("#idAliPay").hide();
            $("#idWeChat").show();
            $("#idBankName").hide();
            $("#idBankCode").hide();
            $("#idPersonName").hide();
        } else if(flg =='3') {
            $("#idAliPay").hide();
            $("#idWeChat").hide();
            $("#idBankName").show();
            $("#idBankCode").show();
            $("#idPersonName").show();
        }
    
    };
     

</script> 
</head>

<body style="background:#fff3e1;">
<s:include value="%{pageContext.request.contextPath}/pages/common/message.jsp" />
<form id="registerForm" method="post" action="./changeSalerConfirm.action" method="post">
<div class="reg-form">
<%--
  <div  class="form-item form-item-account">
    <label>登 录 名<b><font color="red">*</font></b></label>
    <input id="form-account" class="field" type="text" id="userId" placeholder="建议使用您的手机号码"  maxlength="32" autocomplete="off" name="userBean.userId" value="<s:property value='userBean.userId '/>" >
  </div>
  <div class="form-item form-item-account">
    <label>设 置 密 码<b><font color="red">*</font></b></label>
    <input id="form-account" class="field" id="pwd1" type="password"  placeholder="设 置 密 码"  maxlength="20" autocomplete="off" name="password" value="<s:property value='password'/>">
  </div>
  <div class="form-item form-item-account">
    <label>确 认 密 码<b><font color="red">*</font></b></label>
    <input  class="field" type="password" id="pwd2" placeholder="确 认 密 码"  maxlength="20" autocomplete="off" name="rePassword" value="<s:property value='rePassword'/>">
  </div>
  <div  class="form-item form-item-account">
    <label>姓  名<b><font color="red">*</font></b></label>
    <input id="form-account" class="field"  id="userName" type="text" placeholder="真实姓名"  maxlength="16" autocomplete="off" name="userBean.userName" value="<s:property value='userBean.userName'/>">
  </div>
  <div class="form-item form-item-account">
    <label>邮箱地址<b><font color="red">*</font></b></label>
    <input  class="field" type="text" placeholder="邮箱地址"  maxlength="96" autocomplete="off" name="userBean.mail" value="<s:property value='userBean.mail'/>">
  </div>
  <div class="form-item form-item-account">
    <label>手机号码<b><font color="red">*</font></b></label>
    <input  class="field" type="text" placeholder="手机号码"  maxlength="11" autocomplete="off" name="userBean.mobile" value="<s:property value='userBean.mobile'/>">
  </div>
  --%>
  <div class="form-item form-item-account" name="code">
    <label  >专属优惠码<b><font color="red">*</font></b></label>
    <select class="select" name="code">
    <option value="1"   <s:if test='code == "1"'>selected</s:if> >同手机号码</option>
    <option value="2"  <s:if test='code == "2"'>selected</s:if> >同登录名</option>
    
   </select>
   
  </div>
  <div class="form-item form-item-account" name="userBean.receivables_flg" >
    <label>收款方式<b><font color="red">*</font></b></label>
    <select class="select" name="userBean.receivables_flg" id="receivables_flg" onchange="chgReceivables()">
    <option value="1"  <s:if test='userBean.receivables_flg == "1"'>selected</s:if> >支付宝</option>
    <option value="2" <s:if test='userBean.receivables_flg == "2"'>selected</s:if> >微信</option>
    <option value="3" <s:if test='userBean.receivables_flg == "3"'>selected</s:if> >银行卡</option>
    
   </select>
  </div>
  <div class="form-item form-item-account" id="idAliPay">
    <label>支付宝<b><font color="red">*</font></b></label>
    <input  class="field" type="text" placeholder="支付宝"  maxlength="110" autocomplete="off" name="userBean.id_zhifubao" value="<s:property value='userBean.id_zhifubao'/>">

    
  </div>
  <div class="form-item form-item-account" id="idWeChat">
    <label>微信号<b><font color="red">*</font></b></label>
    <input  class="field" type="text" placeholder="微信号"  maxlength="60" autocomplete="off" name="userBean.id_weixin" value="<s:property value='userBean.id_weixin'/>">
  </div>
  <div class="form-item form-item-account" id="idBankName">
    <label>银行名称<b><font color="red">*</font></b></label>
    <select class="select" name="userBean.bank" id="bank" onchange="chgBank()">
        <option value="中国银行"  <s:if test='userBean.bank == "中国银行"'>selected</s:if> >中国银行</option>
<option value="中国建设银行"  <s:if test='userBean.bank == "中国建设银行"'>selected</s:if> >中国建设银行</option>
<option value="中国农业银行"  <s:if test='userBean.bank == "中国农业银行"'>selected</s:if> >中国农业银行</option>
<option value="中国邮政储蓄银行"  <s:if test='userBean.bank == "中国邮政储蓄银行"'>selected</s:if> >中国邮政储蓄银行</option>
<option value="中国光大银行"  <s:if test='userBean.bank == "中国光大银行"'>selected</s:if> >中国光大银行</option>
<option value="中国民生银行"  <s:if test='userBean.bank == "中国民生银行"'>selected</s:if> >中国民生银行</option>
<option value="交通银行"  <s:if test='userBean.bank == "交通银行"'>selected</s:if> >交通银行</option>
<option value="招商银行"  <s:if test='userBean.bank == "招商银行"'>selected</s:if> >招商银行</option>
<option value="中信银行"  <s:if test='userBean.bank == "中信银行"'>selected</s:if> >中信银行</option>
<option value="华夏银行"  <s:if test='userBean.bank == "华夏银行"'>selected</s:if> >华夏银行</option>
<option value="浦发银行"  <s:if test='userBean.bank == "浦发银行"'>selected</s:if> >浦发银行</option>
<option value="平安银行"  <s:if test='userBean.bank == "平安银行"'>selected</s:if> >平安银行</option>
<option value="广发银行"  <s:if test='userBean.bank == "广发银行"'>selected</s:if> >广发银行</option>
<option value="兴业银行"  <s:if test='userBean.bank == "兴业银行"'>selected</s:if> >兴业银行</option>
<option value="浙商银行"  <s:if test='userBean.bank == "浙商银行"'>selected</s:if> >浙商银行</option>
<option value="渤海银行"  <s:if test='userBean.bank == "渤海银行"'>selected</s:if> >渤海银行</option>
<option value="恒丰银行"  <s:if test='userBean.bank == "恒丰银行"'>selected</s:if> >恒丰银行</option>

   </select>
    <!-- <input  class="field" type="text" placeholder="银行名称"  maxlength="60" autocomplete="off" name="userBean.bank" value="<s:property value='userBean.bank'/>"> -->
  </div>
  <div class="form-item form-item-account" id="idBankCode">
    <label>银行账号<b><font color="red">*</font></b></label>
    <input  class="field" type="text" placeholder="银行账号"  maxlength="60" autocomplete="off" name="userBean.bank_card_number" value="<s:property value='userBean.bank_card_number'/>">
  </div>
  <div class="form-item form-item-account" id="idPersonName">
    <label>开户名称<b><font color="red">*</font></b></label>
    <input  class="field" type="text" placeholder="开户名称"  maxlength="60" autocomplete="off" name="userBean.bank_card_name" value="<s:property value='userBean.bank_card_name'/>">
  </div>
  <%--
  <div class="form-item form-item-account">
    <label>优惠码</label>
    <input  class="field" type="text" placeholder="优惠码"  maxlength="32" autocomplete="off" name="userBean.register_code" value="<s:property value='userBean.register_code'/>">
  </div>
  --%>
  
  
 <div class="input-tip"> <span></span> </div> 
  
  <div>
  <a class="btn-register" type="button" onclick="saler()">成为销售</a>
  
</div>
 <div class="input-tip"> <span></span> </div>   
  
</div>
</form>
</body>
</html>
