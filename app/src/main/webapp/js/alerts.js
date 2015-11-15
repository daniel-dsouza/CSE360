/**
 * Created by daniel on 10/20/15.
 */
function loadAlerts(element) {
    $.ajax('/alert/getalerts', {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var outputHTML = 'Alert list';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                outputHTML +=
                    '<div id="alert' + i + '" style="background-color: #FF6666; border-radius: 5px; margin: 10px; padding: 10px">' +
                    '<div class="row" >' +
                    '<div class="col-lg-8">' +
                    '<div style="float:left"><h2>Patient#: ' + data[i].patientID + '</h2><h5 style="padding: 0px 5px 0px;">' + data[i].alertDateAndTime + '</h5></div>' +
                    '<div style="float:left; padding: 20px 0px 10px 10px; width=100%">' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;" data-toggle="collapse" data-target="#reason' + i + ' ">' + 'Expand Detail' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;" onclick="resolvealert(alert' + i + ',' + data[i].alertID + ')">' + 'Resolve' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;" onclick="redirect(' + data[i].patientID + ',' + "'" + 'health_conditions' + "'" + ')">' + 'Health Conditions' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;" onclick="redirect(' + data[i].patientID + ',' + "'" + 'view_medical_history' + "'" + ')">' + 'Medical History' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;" onclick="redirect(' + data[i].patientID + ',' + "'" + 'view_lab_report' + "'" + ')">' + 'Lab Reports' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;" onclick="redirect(' + data[i].patientID + ',' + "'" + 'e_prescribe' + "'" + ')">' + 'Prescriptions' + '</button>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '<div class="row collapse out" style="margin: 0px 5px 10px" id="reason' + i + '">' + data[i].reason + '</div>' +
                    '</div>';
            }
            $('#' + element).html(outputHTML)
        },
        error: function () {
            //alert("error getting list.")
        }
    });
}

function loadAlertsHsp(element) {
    $.ajax('/alert/getalerts', {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var outputHTML = 'Alert list';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                outputHTML +=
                    '<div id="alert' + i + '" style="background-color: #FF6666; border-radius: 5px; margin: 10px; padding: 10px">' +
                    '<div class="row" >' +
                    '<div class="col-lg-8">' +
                    '<div style="float:left"><h2>Patient#: ' + data[i].patientID + '</h2><h5 style="padding: 0px 5px 0px;">' + data[i].alertDateAndTime + '</h5></div>' +
                    '<div style="float:left; padding: 20px 0px 10px 10px; width=100%">' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;" data-toggle="collapse" data-target="#reason' + i + ' ">' + 'Expand Detail' + '</button>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '<div class="row collapse out" style="margin: 0px 5px 10px" id="reason' + i + '">' + data[i].reason + '</div>' +
                    '</div>';
            }
            $('#' + element).html(outputHTML)
        },
        error: function () {
            //alert("error getting list.")
        }
    });
}

function loadAlertsPopUp(divid) {
    var alertID = document.getElementById(divid);
    if (alertID != null) //since alert div id only shows up in emergency, we can make a check for it
    {
        $.ajax('/alert/getalertspopup', {
            type: 'GET',
            dataType: 'json',
            success: function (data) {

                var outputHTML = 'Emergency Alert detected\n\n';
                outputHTML += '==========================\n';
                var len = data.length;
                for (var i = 0; i < len; i++) {
                    outputHTML +=
                        'Patient#: ' + data[i].patientID + '\nTime: ' + data[i].alertDateAndTime + '\n' +
                        'Reason: ' + data[i].reason + '\n==========================\n';
                }
                alert(outputHTML);
            },
            error: function () {
                //alert("error getting list.")
            }
        });
    }
}

function resolvealert(divid, alertid) {
    $.ajax('/alert/resolvealert/' + alertid, {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            alert("nom");
            $('#' + divid).hide();
        },
        error: function () {
            //alert("error getting list.");
            $(divid).hide("slow");

        }
    });
    showEmergencyRoom('alert');
}
function showEmergencyRoom(divid) {

    var alertID = document.getElementById(divid);
    if (alertID != null) //since alert div id only shows up in emergency, we can make a check for it
    {
        $.ajax('/alert/check', {
                type: 'GET',
                dataType: 'json',
                success: function (data) {
                    if (data.alertsPresent) {
                        // blink('#' + divid, -1, 1000);
                        $('#' + divid).show();

                    }
                    else {
                        $('#' + divid).hide();
                    }

                }
            }
        )
    } else {
        $('#' + divid).hide();
    }
}

//http://jsfiddle.net/jadendreamer/Nx4qS/
function blink(elem, times, speed) {
    if (times > 0 || times < 0) {
        if ($(elem).hasClass("blink")) $(elem).removeClass("blink");
        else $(elem).addClass("blink");
    }

    clearTimeout(function () {
        blink(elem, times, speed);
    });

    if (times > 0 || times < 0) {
        setTimeout(function () {
            blink(elem, times, speed);
        }, speed);
        times -= .5;
    }
}

function redirect(id, action) {
    var hc = "select_patient/" + id + "/" + action;
    window.location.href = hc;
}


