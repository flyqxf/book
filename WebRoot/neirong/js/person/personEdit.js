$(document).ready(function(e) {
    $("#updatePerson").off('click').click(personSubmit);
});
     
var personSubmit = function() {

    var url="../person/personUpdate.action";
    $("#personUpdateForm").attr("action",url);
    $("#personUpdateForm").submit();
};

