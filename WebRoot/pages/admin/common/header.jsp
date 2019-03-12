<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
});
var user = function() {
    var url = "${pageContext.request.contextPath}/user/userAction.action";
    deptAction(url,new Array());
};
var xiaoshou = function() {
    var url = "${pageContext.request.contextPath}/sale/saleAction.action";
    deptAction(url,new Array());
};
var pay = function() {
    var url = "${pageContext.request.contextPath}/pay/payAction.action";
    deptAction(url,new Array());
};
var system = function() {
    var url = "${pageContext.request.contextPath}/systemInfo/systemInfo.action";
    deptAction(url,new Array());
};
var jiaoxue = function() {
    var url = "${pageContext.request.contextPath}/jiaoxue/jiaoxue.action";
    deptAction(url,new Array());
};
var wenzhang = function() {
    var url = "${pageContext.request.contextPath}/wenzhang/wenzhang.action";
    deptAction(url,new Array());
};
var index = function() {
    var url = "../index/indexAction.action";
    // 迁移参数设定
    var params = new Array();
    deptAction(url,params);
};
var logoff = function() {
    var url = "../adminlogoff.action";
    deptAction(url,new Array());
};
var updatePwd = function() {
    var url = "${pageContext.request.contextPath}/manageLogin/updatePwd.action";
    newWindow(url,600,1000,"yes","yes");
    
};
var advice = function() {
    var url = "${pageContext.request.contextPath}/adviceManage/adviceManager.action";
    deptAction(url,new Array());
};
var successCase = function() {
    var url = "${pageContext.request.contextPath}/successManage/successManager.action";
    deptAction(url,new Array());
};
</script>

<div id="m-header" style="background:url(${pageContext.request.contextPath}/images/topbg.gif) repeat-x;">
    <div class="topleft">
    <a href="javascript:void(0)" onclick="index();"><img src="${pageContext.request.contextPath}/images/logoAdmin.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="javascript:void(0)" onclick="user()"><img src="${pageContext.request.contextPath}/images/icon01.png" title="会员管理" />
	<h2>会员管理</h2></a></li>
    <li><a  href="javascript:void(0)" onclick="xiaoshou()"><img src="${pageContext.request.contextPath}/images/icon02.png" title="销售统计" />
	<h2>销售统计</h2></a></li>
    <li><a href="javascript:void(0)" onclick="pay()"><img src="${pageContext.request.contextPath}/images/icon03.png" title="费用支付" />
	<h2>费用支付</h2></a></li> 
    <li><a href="javascript:void(0)" onclick="jiaoxue()"><img src="${pageContext.request.contextPath}/images/icon04.png" title="教学内容编辑" />
	<h2>教学内容</h2></a></li>
    <li><a href="javascript:void(0)" onclick="wenzhang()"><img src="${pageContext.request.contextPath}/images/icon05.png" title="学员文档管理" />
	<h2>学员文章</h2></a></li>
	<li><a href="javascript:void(0)" onclick="advice()"><img src="${pageContext.request.contextPath}/images/icon02.png" title="康复指导编辑" />
	<h2>康复指导</h2></a></li>
	<li><a href="javascript:void(0)" onclick="successCase()"><img src="${pageContext.request.contextPath}/images/icon05.png" title="成功案例编辑" />
	<h2>成功案例</h2></a></li>
	<li><a href="javascript:void(0)" onclick="system()"><img src="${pageContext.request.contextPath}/images/icon06.png" title="系统设置" />
	<h2>系统设置</h2></a></li>
    </ul>
         
    <div class="topright">    
    <ul>
    <li><a href="javascript:void(0)" onclick="updatePwd()">修改密码</a></li>
    <li><a href="javascript:void(0)" onclick="logoff()">退出</a></li>
    </ul>

    </div>    
    
    </div>

