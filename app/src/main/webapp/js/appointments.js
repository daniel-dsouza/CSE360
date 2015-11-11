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
                outputHTML += '<option value="' + data[i].userID + '">' + data[i].firstName + '</option>';
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
function checkReason(){
    var reason = $("#reason").val();

    //http://jsfiddle.net/5vzZf/1/
    if (reason.match(/\s/g)){
        //alert('There is a space! The username is "' + username + '"');
    } else {
        alert('You must use atleast one space between the words');
        return false;
    }
    return true;
}