$(document).ready(function(e) {
    $("#searchAchievement").off('click').click(searchAchievement);
    DateControl("startDate");
    DateControl("endDate");
});
     
var searchAchievement = function() {
    
   $("#fromDate").val($("#startDate").val());
   $("#toDate").val($("#endDate").val());
    
    var url="../person/searchAchievement.action";
    $("#achievementForm").attr("action",url);
    $("#achievementForm").submit();
};

