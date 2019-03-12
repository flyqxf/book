$(document).ready(function(e) {
    
    $(".select1").uedSelect({
        width : 345           
    });
    $(".select2").uedSelect({
        width : 167  
    });
    $(".select3").uedSelect({
        width : 100
    });
    
   
    $("#usual1 ul").idTabs();
    
    $('.tablelist tbody tr:odd').addClass('odd');
    init();
    windowSize();
    
    $("#articleSubmit").off('click').click(articleSubmit);
});



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
    
var articleSubmit = function() {
    var pro = $("#province").find('option:selected').html();
    var pro_val = $("#province").val();
    var city = $("#city").find('option:selected').html();
    var city_val = $("#city").val();
    var title = $("#title").val();
    var content= KE.util.getData('content7');
    
    
    
    $("#pro").val(pro);
    $("#cty").val(city);
    $("#pro_val").val(pro_val);
    $("#cty_val").val(city_val);
    $("#content").val(content);
    
    
    var url = "../articleJ/articleAdd.action";
    var t = "问题录入";
    
    var id=$("#id").val();
    if(id != null && id!="") {
        url =  "../articleJ/articleEdit.action";
        t = "问题修改";
    }
    parem = {
            "pro" : pro,
            "city":city,
            "pro_val" : pro_val,
            "city_val":city_val,
            "title":title,
            "id":id,
            "content":content
        };
    
    
    ajaxPostAction(url, parem, addResult,t);
    

};

//录入后判断返回结果
var addResult = function(data) {
    if (data != undefined && data != "") {
        var jsonObj = eval("(" + data + ")");
        var status = jsonObj.status;
        var msg = jsonObj.msg;

        // 处理成功情况
        if (status == "success") {
            showInfoMessage(msg, "提示信息", "/article/article.action");
        } else {
            showInfoMessage(msg, "提示信息",null);
        }
    }
};

var detail = function(id) {
    var url = "../article/articleDetail.action";
    // 迁移参数设定
    var params = new Array();
    params[0] = ["id", id];
    
//    $.post(url, {"id" : id }, function(data) {
//        
//        $("#resList").hide();
//        $("#chapterSpanC").html(data.title);
//        $("#contentDiv").html(data.content);
//        $("#resDetail").show();
//    });

    deptAction(url,params);
};
var index= function(){
    var url = "../bookScan/bookScanAction.action";
        deptAction(url,new Array());
    };

