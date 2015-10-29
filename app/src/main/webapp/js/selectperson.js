/**
 * Created by daniel on 10/28/15.
 */
function setPersonalInfo(patientID, callback) {
    $.ajax('/select_patient/getpatientinfo/' + patientID, {
        type:'GET',
        dataType:'json',
        success:function(data) {
            var outputHTML = "Alert list";
            callback(outputHTML);
        },
        error: function() {
            alert("error getting list.")
        }
    });
};

function setPersonalInfo(patientID, callback) {
    $.ajax('/select_patient/getpatientappointments/' + patientID, {
        type:'GET',
        dataType:'json',
        success:function(data) {
            var outputHTML = "Alert list";
            callback(outputHTML);
        },
        error: function() {
            alert("error getting list.")
        }
    });
};

function setPersonalInfo(patientID, callback) {
    $.ajax('/select_patient/getpatientalerts/' + patientID, {
        type:'GET',
        dataType:'json',
        success:function(data) {
            var outputHTML = "Alert list";
            callback(outputHTML);
        },
        error: function() {
            alert("error getting list.")
        }
    });
};

$(document).ready(function(){
    $('.panel-collapse').on('shown.bs.collapse', function(e){
        //alert('Collapsible element ' + e.currentTarget.id + 'has been completely opened .');
        var patientid = e.currentTarget.id;
        setPersonalInfo(patientid, function(result) {
            alert(result);
            $(e.currentTarget).find("#personal_info_" + e.currentTarget.id).html(result);
        });
        alert($(e.currentTarget.id).attr('id'));
        $(e.currentTarget.id).find("#personal_info_" + e.currentTarget.id).html(result);
        var apps = $(e.currentTarget.id).find("div[id^=appointments]");
        var als = $(e.currentTarget.id).find("div[id^=alerts]");
    });
});