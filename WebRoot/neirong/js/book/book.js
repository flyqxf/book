$(document).ready(function() {
//    $("#indexPage").show();
//    $("#bookPage").hide();
    //var url = "../bookScanJ/partAction.action";
    
    // 迁移参数设定
    //var params = new Array();
    //params[0] = ["id", id];
    
    //$.post(url, {"id" : id }, function(data) {
        $("#chapterSpan").html(chapter);
        $("#part").html(part);
        //$(".welinfo1").load(link );
        $("#bookFrame").attr("src",link );
        windowSize();
    //});

});
