<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawStacked);

 function drawStacked() {
       var data = google.visualization.arrayToDataTable([
         ['City', '2010 Population', '2000 Population'],
         ['New York City, NY', 8175000, 8008000],
         ['Los Angeles, CA', 3792000, 3694000],
         ['Chicago, IL', 2695000, 2896000],
         ['Houston, TX', 2099000, 1953000],
         ['Philadelphia, PA', 1526000, 1517000]
       ]);

       var options = {
         title: 'Population of Largest U.S. Cities',
         chartArea: {width: '50%'},
         isStacked: true,
         hAxis: {
           title: 'Total Population',
           minValue: 0,
         },
         vAxis: {
           title: 'City'
         }
       };
       var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
       chart.draw(data, options);
  }
</script>
<%@ include file="/WEB-INF/view/header.jsp" %>
	<div class="w-100 vh-100" style="min-height:100%;padding-top:5rem">
		<div id="chart_div" style="width:80%; height:80%" class="mx-auto"></div>
	</div>
<%@ include file="/WEB-INF/view/footer.jsp" %>