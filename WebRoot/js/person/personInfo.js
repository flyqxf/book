$(document).ready(function(e) {
    $("#editPerson").off('click').click(personSubmit);
});
     
var personSubmit = function() {

    var url="../person/personEdit.action";
    $("#personForm").attr("action",url);
    $("#personForm").submit();
};

