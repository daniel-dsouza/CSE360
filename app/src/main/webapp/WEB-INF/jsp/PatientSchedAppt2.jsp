<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 10/7/2015
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script type="text/javascript">//<![CDATA[
  $(document).ready(function () {
    var allOptions = $('#selectprod option')
    $('#selectcat').change(function () {
      $('#selectprod option').remove()
      var classN = $('#selectcat option:selected').prop('class');
      var opts = allOptions.filter('.' + classN);
      $.each(opts, function (i, j) {
        $(j).appendTo('#selectprod');
      });
    });
  });
//]]>

  </script>

</head>
<body>
<center>
  <div class="prodselectbox">
    <div class="cat">Type of Doctor</div><br>
    <div class="catid">
      <select id="selectcat" name="categoryselected">
        <option value="" class="rhth">Select Type of Doctor</option>
        <option class="foot" value="Foot Doctor" id="selectionone">Foot Doctor</option>
        <option class="genphy" value="General Physician" id="selectiontwo">General Physician</option>
        <option class="pedia" value="Pediatrician" id="selectionthree">Pediatrician</option>
        <option class="emerg" value="Emergency Doctor" id="selectionfour">Emergency Doctor</option>
        <option class="pla1" value="Place 1" id="selectionfive">Place 1</option>
        <option class="Pla2" value="Place 2" id="selectionsix">Place 2</option>
        <option class="Pla3" value="Place 3" id="selectionseven">Place 3</option>
      </select>
    </div>
    <br><br><div class="artid">Doctor</div>
    <br>
    <div class="selectarticle">
      <select id="selectprod" name="articleID">
        <option value="" class="rhth23">Select Doctor</option>
        <option value="ang" class="selectors foot">Dr. Ang</option>
        <option value="dsouza" class="hidden selectors foot">Dr. D'Souza</option>
        <option value="1" class="selectors foot">1</option>
        <option value="2" class="selectors foot">2</option>
        <option value="3" class="selectors foot">3</option>
        <option value="4" class="selectors foot">4</option>
        <option value="5" class="selectors foot">5</option>
        <option value="dudley" class="selectors genphy">Dr. Dudley</option>
        <option value="hinze" class="selectors genphy">Dr. Hinze</option>
        <option value="6" class="selectors genphy">6</option>
        <option value="7" class="selectors genphy">7</option>
        <option value="8" class="selectors genphy">8</option>
        <option value="9" class="selectors genphy">9</option>
        <option value="hutchins" class="selectors pedia">Dr. Hutchins</option>
        <option value="lin" class="selectors pedia">Dr. Lin</option>
        <option value="romero" class="selectors emerg">Dr. Romero</option>
        <option value="rose" class="selectors emerg">Dr. Rose</option>
        <option value="venkata" class="selectors emerg">Dr. Venkata</option>
        <option value="10" class="selectors pla1">10</option>
        <option value="11" class="selectors pla1">11</option>
        <option value="12" class="selectors Pla2">12</option>
        <option value="13" class="selectors Pla2">13</option>
        <option value="14" class="selectors Pla2">14</option>
        <option value="15" class="selectors Pla2">15</option>
        <option value="16" class="selectors pla3">16</option>
        <option value="17" class="selectors Pla3">17</option>
        <option value="18" class="selectors Pla3">18</option>
        <option value="19" class="selectors Pla3">19</option>
        <option value="20" class="selectors Pla3">20</option>
        <option value="21" class="selectors Pla3">21</option>
        <option value="22" class="selectors Pla3">22</option>
        <option value="23" class="selectors Pla3">23</option>
      </select>
    </div>
    <div class="form-group">
      <label for="comment">Comment:</label>
      <textarea class="form-control" rows="5" id="comment"></textarea>
    </div>
  </div>
</center>
</body>
</html>
