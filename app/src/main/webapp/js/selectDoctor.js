/**
 * Created by ryan on 11/6/15.
 */
function getPersonalInfo(doctorID, callback) {
    $.ajax('/alert/getdoctorinfo/' + doctorID, {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var outputHTML =
                'Name: ' + data.firstName + ' ' + data.lastName + '</br>' +
                'Email: ' + data.email + '</br>';
            callback(outputHTML);
        },
        error: function () {
            alert("error getting list.")
        }
    });
};

function getAppointments(doctorID, callback) {
    $.ajax('/alert/getdoctorappt/' + doctorID, {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var outputHTML = '';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                outputHTML +=
                    '<div class="mini_appointment"><div style="float: left; margin-right: 5px;">' +
                    //'<a href="appointment/edit/' + data[i].appointmentID + '" class="btn btn-info" role="button">Edit</a>' +
                    '</div>' +
                    '<div>' +
                    'Date: ' + data[i].date + '</br>' +
                    'Patient: ' + data[i].patientID + '</br>' +

                    '</div></div>';
            }
            outputHTML += '<a href="appointment/createappointment/' + doctorID + '" class="btn btn-info" role="button">Create Appointment</a>';
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
        var docID = e.currentTarget.id;
        getPersonalInfo(docID, function (result) {
            $(e.currentTarget).find("#personal_info_" + e.currentTarget.id).html(result);
        });
        getAppointments(docID, function (result) {
            $(e.currentTarget).find("#appointments_" + e.currentTarget.id).html(result);
        });
    });
});