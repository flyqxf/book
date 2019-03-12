<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!-- 黄色区域提示 -->
<s:if test="hasActionErrors() || hasFieldErrors() || hasActionMessages()">
<div class="errobox" id="unAsyncMessageShowBox">
    <button type="button" class="close" data-dismiss="alert">×</button>
    
   <s:actionerror />
    <s:actionmessage />
    <s:fielderror />
</div>
</s:if>

<div class="errobox" id="asyncMessageShowBox" style="display:none" >
    <button type="button" class="close" data-dismiss="alert">×</button>
    <h4></h4>
    <h4><div id="asyncMessageShow"></div>
</div>