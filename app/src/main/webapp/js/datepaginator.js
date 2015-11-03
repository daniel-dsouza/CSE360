/**
 * Created by r_Ang_000 on 11/2/2015.
 */
/*
 See more options at:
 http://jondmiles.com/bootstrap-datepaginator/#usage
 */


$(document).ready(function() {

    var options = {
        selectedDateFormat: "YYYY-MM-DD",
        onSelectedDateChanged: function(event, date) {
            document.getElementById('day').value=formatDate(date);
        }
    }
    $('#paginator').datepaginator(options);

    /* $('#paginator').on('selectedDateChanged', function(event, date) {
        document.getElementById('day').value=date;
    });
    */


});
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