<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/layout.tld" prefix="ex" %>

<%

	String email = "";
	String message = "";
	
	if(request.getAttribute("email") !=null) {
		email = (String)request.getAttribute("email");
	}
		
	if(request.getAttribute("message") !=null) {
		message = (String)request.getAttribute("message");
		System.out.println("message:" + message);
	}	

%>

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
		<ex:Layout>
			<div class="w-100 vh-100" style="min-height:100%;padding-top:5rem">
				<div><%=email %></div>
				<div><%=message %></div>
			</div>

		</ex:Layout>
	</body>
</html>