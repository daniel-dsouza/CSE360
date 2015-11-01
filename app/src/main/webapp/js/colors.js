/**
 * Created by daniel on 11/1/15.
 */
function getRandomColor() {
    var letters = '56789A'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 6)];
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