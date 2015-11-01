/**
 * Created by daniel on 10/31/15.
 */

function loadDoctors() {
    $.ajax('/appointment/getdoctors/' + $("#special").val(), {
        type:'GET',
        dataType:'json',
        success:function(data) {
            var outputHTML = '<option value="">List of Doctors</option>';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                outputHTML += '<option value="' + data[i].name + '">' + data[i].firstName + '</option>';
            }
            outputHTML += '</option>';

            $('#doctor').html(outputHTML)
        },
        error: function() {

            alert("error getting list.")
        }
    })
}

function loadTimes() {
    $.ajax('/appointment/gettimes/' + $("#doctor").val(), {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var outputHTML = '<option value="">List of Times</option>';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                outputHTML += '<option value="' + data[i].appointmentID + '">' + data[i].date + ' ' + data[i].time + '</option>';
            }
            outputHTML += '</option>';

            $('#date').html(outputHTML)
        },
        error: function () {
            alert("error getting list.")
        }
    })
}