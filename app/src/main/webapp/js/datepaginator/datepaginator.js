/**
 * Created by r_Ang_000 on 11/2/2015.
 */
/*
 See more options at:
 http://jondmiles.com/bootstrap-datepaginator/#usage
 */

var selected;//globals suck
$(document).ready(function () {

        var d = startDate();

        var options = {
            startDate: d,//first date to be picked. User can not select the past
            startDateFormat: "YYYY-MM-DD",
            selectedDate: d,//first date to be selected by default
            selectedDateFormat: "YYYY-MM-DD",
            onSelectedDateChanged: function (event, date) {
                selected = formatDate(date);
            }
        }
        $('#paginator').datepaginator(options);

        /*$('#paginator').on('selectedDateChanged', function(event, date) {
         document.getElementById('day').value=formatDate(date); //This way is a vulnerability. If you inspect element,
         //you can modify the text area. Inject symbols and our program will crash
         }); */

    }
);
//http://stackoverflow.com/questions/23593052/format-javascript-date-to-yyyy-mm-dd
function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
};
function startDate() {
    var d = new Date(),
        month = '' + (d.getMonth() + 1),
        day = '' + (d.getDate() - 2),//Start 2 from today. The user must select in the future
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
};

function getDate() {

    var bool = 0;//0 is false

    if (!selected) //http://stackoverflow.com/questions/5515310/is-there-a-standard-function-to-check-for-null-undefined-or-blank-variables-in
    {
        alert("Please choose a future date");
        return false;
    }
    else {
        var d = new Date(),//get current date
            month = '' + (d.getMonth() + 1),
            day = '' + (d.getDate()),
            year = d.getFullYear();

        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        var current = [year, month, day].join('-');
        if (selected < current) {
            alert("Please choose a future date");
            bool = 0;
        } else {
            document.getElementById('day').value = selected;
            bool = 1;
        }
    }

    var reason = $("#reason").val();
    //http://jsfiddle.net/5vzZf/1/
    if (reason.match(/\s/g)){
        //alert('There is a space! The username is "' + username + '"');
    } else {
        alert('You must use atleast one space between the words');
        bool = 0;
    }
    return bool;
};