/**
 * Created by daniel on 10/20/15.
 */
function loadAlerts(element) {
    $.ajax('/alert/getalerts', {
        type:'GET',
        dataType:'json',
        success:function(data) {
            var outputHTML = 'Alert list';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                outputHTML +=
                    '<div id="alert' + i + '" style="background-color: #FF6666; border-radius: 5px; margin: 10px; padding: 10px">' +
                    '<div class="row" >' +
                    '<div class="col-lg-8">'+
                    '<div style="float:left"><h2>Patient#: ' + data[i].patientID + '</h2><h5 style="padding: 0px 5px 0px;">' + data[i].alertDateAndTime+ '</h5></div>' +
                    '<div style="float:left; padding: 20px 0px 10px 10px; width=100%">' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;" data-toggle="collapse" data-target="#reason' + i +' ">' + 'Expand Detail' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;" onclick="resolvealert(alert' + i + ',' + data[i].alertID + ')">' + 'Resolve' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;">' + 'Health Conditions' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;">' + 'Medical History' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;">' + 'Labs' + '</button>' +
                    '<button type="button" class="btn btn-primary btn-md" style="float:left; margin: 0px 5px 5px 0px;">' + 'Prescriptions' + '</button>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '<div class="row collapse out" style="margin: 0px 5px 10px" id="reason' + i + '">' + data[i].reason + '</div>' +
                    '</div>';
            }
            $('#'+element).html(outputHTML)
        },
        error: function() {
            alert("error getting list.")
        }
    });
};

/**
 * Created by daniel on 10/20/15.
 */
function resolvealert(divid, alertid) {
    $.ajax('/alert/resolvealert/' + alertid, {
        type:'GET',
        dataType:'json',
        success:function(data) {
            alert("nom");
            $('#' + divid).hide();
        },
        error: function() {
            alert("error getting list.");
            $(divid).hide("slow");

        }
    })
};