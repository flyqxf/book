$(document).ready(function(e) {
    linkC();
});
var linkC=function(){
    $(".formbody").load('/book/advice/'+link);
};
var index= function(){
    var url = "../bookScan/bookScanAction.action";
        deptAction(url,new Array());
    };