/**
 * Created by daniel on 11/1/15.
 */
function getRandomColor() {
    var letters = '13579BD'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 7)];
    }
    return color;
}

function setRandomColors(){
    $("div").each(function(){
        $(this).css("background-color",getRandomColor());
    });
}

$( document ).ready(function() {
    setRandomColors();
    setInterval("setRandomColors()", 50);
});