$(document).ready(function(e) {
  
    
    windowSize();
});

var detail=function(id){
    var url = "../advice/adviceDetail.action";
    var params = new Array();
    params[0] = ["id", id];
    
    deptAction(url,params);
};
var index= function(){
    var url = "../bookScan/bookScanAction.action";
        deptAction(url,new Array());
    };