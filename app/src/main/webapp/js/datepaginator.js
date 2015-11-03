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
            showCalendar: false,
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

    if (!selected) //http://stackoverflow.com/questions/5515310/is-there-a-standard-function-to-check-for-null-undefined-or-blank-variables-in
    {
        alert("Please choose a future date");
        return false;
    }
    else {
        document.getElementById('day').value = selected;
        return true;
    }


};