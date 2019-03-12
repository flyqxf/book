<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!-- 各种弹出框提示 -->
<center>
  <!-- 确认提示框 -->
  <div style="z-index:99999" class="modal fade" id="modalMessageAlert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
    <script type="text/javascript">
                    //请求地址
                    var postUrl = "";
                    //设置提示框的信息，msg:提示框内容；title:提示框标题；url:传入请求路径；
                    //method:传入的执行方法；param:执行方法的参数
                    function showInfoMessage(msg, title, url) {
                        postUrl = url;
                        //设置提示框标题
                        $("#myModalLabel1").html(title);
                        //设置提示内容
                        $("#showMsg1").html(msg);
                        //显示提示框
                        $("#modalMessageAlert").modal("show");
                    }
                    //确定按钮出发事件
                    function sendPostBtn() {
                        if (postUrl != null && postUrl.length > 0) {
                            deptAction("${pageContext.request.contextPath}" + postUrl);
                        }
                    }
                </script>
    <div class="modal-dialog login_tab">
      <div class="modal-content" style="width: 55%">

        <!-- 提示框头部 -->
        <div class="modal-header">
          <h4 class="modal-title" style="font-style: center" id="myModalLabel1"></h4>
        </div>

        <!-- 提示框的body部分，提示信息+确定按钮 -->
        <div class="modal-body add">
          <!-- 提示信息-->
          <div id="showMsg1" style="width: 100%"></div>
          <br />
          <br />
          <!-- 确定按钮-->
          <div style="width: 100%">
            <center>
              <button onclick="javascript:sendPostBtn();" type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">确定</button>
            </center>
          </div>
        </div>

      </div>
    </div>
  </div>

  <!-- 确认提示框（参数带有执行的函数） -->
  <div style="z-index:99999" class="modal fade" id="modalMessageAlert3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
    <script type="text/javascript">
                    //执行方法
                    var methodTask3 = null;
                    //设置提示框的信息，msg:提示框内容；title:提示框标题；
                    //method:传入的执行方法；
                    function showInfoMessage2(msg, title, method) {
                        //执行方法名
                        methodTask3 = method;
                        //设置提示框标题
                        $("#myModalLabel3").html(title);
                        //设置提示内容
                        $("#showMsg3").html(msg);
                        //显示提示框
                        $("#modalMessageAlert3").modal("show");
                    }
                    //确定按钮出发事件
                    function sendPostBtn3() {
                        if (typeof (eval(methodTask3)) == "function") {
                            methodTask3();
                        }
                    }
                </script>
    <div class="modal-dialog login_tab">
      <div class="modal-content" style="width: 55%">

        <!-- 提示框头部 -->
        <div class="modal-header">
          <h4 class="modal-title" style="font-style: center" id="myModalLabel3"></h4>
        </div>

        <!-- 提示框的body部分，提示信息+确定按钮 -->
        <div class="modal-body add">
          <!-- 提示信息-->
          <div id="showMsg3" style="width: 100%"></div>
          <br />
          <br />
          <!-- 确定按钮-->
          <div style="width: 100%">
            <center>
              <button onclick="javascript:sendPostBtn3();" type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">确定</button>
            </center>
          </div>
        </div>

      </div>
    </div>
  </div>

  <!-- 确认与取消提示框 -->
  <div style="z-index:99999" class="modal fade" id="modalMessageDouble" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
    <script type="text/javascript">
                    //确定按钮执行的参数
                    //请求地址
                    var trueUrl = "";
                    //参数
                    var trueParams = [];
                    //执行方法
                    var methodTask = null;

                    //取消按钮执行的参数
                    //请求地址
                    var falseUrl = "";
                    //参数
                    var falseParams = [];
                    //执行方法
                    var methodTask2 = null;

                    //设置提示框的信息,
                    //msg:提示信息显示的内容；
                    //title：提示信息的标题；
                    //method:提示框点击确定时要执行的方法；
                    //url:method方法需要请求的地址
                    //param:method方法需要的参数
                    //method2：点击取消按钮时要执行的方法；
                    //url2:method2方法需要的请求地址
                    //param2:method2方法需要的参数
                    function showInfoMessageDouble(msg, title, method, url, param, method2, url2, param2) {
                        //确定按钮执行的方法和参数
                        trueUrl = url;
                        trueParams = param;
                        methodTask = method;
                        //取消按钮执行的方法和参数
                        falseUrl = url2;
                        falseParams = param2;
                        methodTask2 = method2;
                        //设置提示框标题
                        $("#myModalLabelDou").html(title);
                        //设置提示内容
                        $("#showMsgDou").html(msg);
                        //显示提示框
                        $("#modalMessageDouble").modal("show");
                    }
                    //确定按钮出发事件
                    function closeTrue() {
                        if (typeof (eval(methodTask)) == "function") {
                            if (trueUrl != null && trueUrl.length > 0) {
                                if (trueParams != null) {
                                    methodTask("${pageContext.request.contextPath}" + trueUrl, trueParams);
                                } else {
                                    methodTask("${pageContext.request.contextPath}" + trueUrl);
                                }
                            } else {
                                if (trueParams != null) {
                                    methodTask(trueParams);
                                } else {
                                    methodTask();
                                }
                            }
                        }
                    }
                    //取消按钮事件
                    function closeFalse() {
                        if (typeof (eval(methodTask2)) == "function") {
                            if (falseUrl != null && falseUrl.length > 0) {
                                if (falseParams != null) {
                                    methodTask("${pageContext.request.contextPath}" + falseUrl, falseParams);
                                } else {
                                    methodTask("${pageContext.request.contextPath}" + falseUrl);
                                }
                            } else {
                                if (falseParams != null) {
                                    methodTask2(falseParams);
                                } else {
                                    methodTask2();
                                }
                            }
                        }
                    }
                </script>
    <div class="modal-dialog login_tab">
      <div class="modal-content" style="width: 55%">

        <!-- 提示框头部 -->
        <div class="modal-header">
          <h4 class="modal-title" style="font-style: center" id="myModalLabelDou"></h4>
        </div>

        <!-- 提示框的body部分，提示信息+确定按钮 -->
        <div class="modal-body add">
          <!-- 提示信息-->
          <div id="showMsgDou" style="width: 100%"></div>
          <br />
          <br />
          <!-- 确定按钮-->
          <div style="width: 100%">
            <center>
              <button onclick="javascript:closeTrue();" type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">确定</button>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <button onclick="javascript:closeFalse();" type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">取消</button>
            </center>
          </div>
        </div>

      </div>
    </div>
  </div>

</center>

<div style="z-index:99999" class="modal fade" id="modalMessage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog login_tab">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <s:if test="!hasActionErrors() && !hasFieldErrors() && hasActionMessages()">
          <h4 class="modal-title" id="myModalLabel">提示信息：</h4>
        </s:if>
        <s:else>
          <h4 class="modal-title" id="myModalLabel">操作失败：</h4>
        </s:else>
      </div>
      <div class="modal-body add">
        <s:actionerror />
        <s:actionmessage />
        <s:fielderror />
      </div>
    </div>
  </div>
</div>