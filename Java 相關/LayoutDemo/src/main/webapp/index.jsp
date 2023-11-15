<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Layout Demo</title>
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
	</head>
	<body>
		<%@ include file="layout.jsp" %>
		<div id="content" class="mx-auto vh-100 d-flex flex-column justify-content-center w-100">
			<h4 class="fw-bold text-center">首頁</h4>
			<div id="chart_div" style="width:80%; height:80%" class="mx-auto"></div>
		</div>
	</body>
</html>