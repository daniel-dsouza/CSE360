/**
 * Created by daniel on 10/31/15.
 */

function getStats(id, callback) {
    $.ajax('/stats/' + id, {
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            callback(data);
        },
        error: function () {
            alert("error getting data.")
        }
    });
}
$(document).ready(function () {
    $('.panel-collapse').on('shown.bs.collapse', function (e) {
        getStats(e.currentTarget.id, function (json) {
            $(e.currentTarget).find(".display").highcharts(json);
        });
    });
});