/**
 * Created by daniel on 10/28/15.
 */
function getPersonalInfo(patientID, callback) {
    $.ajax('/select_patient/getpatientinfo/' + patientID, {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var outputHTML =
                'Name: ' + data.firstName + ' ' + data.lastName + '</br>' +
                'Age: ' + data.age + '</br>' +
                'Insurance: ' + data.insurance + '</br>' +
                'Gender: ' + data.gender + '</br>';
            callback(outputHTML);
        },
        error: function () {
            alert("error getting list.")
        }
    });
};

function getAppointments(patientID, callback) {
    $.ajax('/select_patient/getpatientappointments/' + patientID, {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var outputHTML = '';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                outputHTML +=
                    '<div class="mini_appointment"><div style="float: left; margin-right: 5px;">' +
                    '<a href="appointment/' + data[i].appointmentID + '/edit" class="btn btn-info" role="button">Edit</a>' +
                    '</div>' +
                    '<div>' +
                    'Date: ' + data[i].date + '</br>' +
                    'Doctor: ' + data[i].doctorID + '</br>' +
                    '</div></div>';
            }
            callback(outputHTML);
        },
        error: function () {
            alert("error getting list.")
        }
    });
};

function getAlerts(patientID, callback) {
    $.ajax('/select_patient/getpatientalerts/' + patientID, {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var outputHTML = '';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                outputHTML +=
                    '<div style="background-color: #FF6666; border-radius: 3px; margin: 1px; padding: 2px">' +
                    data[i].alertDateAndTime +
                    '</div>'
            }
            callback(outputHTML);
        },
        error: function () {
            alert("error getting list.")
        }
    });
};

$(document).ready(function () {
    $('.panel-collapse').on('shown.bs.collapse', function (e) {
        //alert('Collapsible element ' + e.currentTarget.id + 'has been completely opened .');
        var patientid = e.currentTarget.id;
        getPersonalInfo(patientid, function (result) {
            $(e.currentTarget).find("#personal_info_" + e.currentTarget.id).html(result);
        });
        getAppointments(patientid, function (result) {
            $(e.currentTarget).find("#appointments_" + e.currentTarget.id).html(result);
        });
        getAlerts(patientid, function (result) {
            $(e.currentTarget).find("#alerts_" + e.currentTarget.id).html(result);
        });

    });
});