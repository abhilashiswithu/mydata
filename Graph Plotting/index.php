<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Real-time updates</title>
    <link href="examples.css" rel="stylesheet" type="text/css">
	<script language="javascript" type="text/javascript" src="source/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="source/jquery.canvaswrapper.js"></script>
	<script language="javascript" type="text/javascript" src="source/jquery.colorhelpers.js"></script>
	<script language="javascript" type="text/javascript" src="source/jquery.flot.js"></script>
	<script language="javascript" type="text/javascript" src="source/jquery.flot.saturated.js"></script>
	<script language="javascript" type="text/javascript" src="source/jquery.flot.browser.js"></script>
	<script language="javascript" type="text/javascript" src="source/jquery.flot.drawSeries.js"></script>
	<script language="javascript" type="text/javascript" src="source/jquery.flot.uiConstants.js"></script>
	<style>
        fieldset {
            display: inline-block;
            height: 180px;
        }
    </style>
	<script type="text/javascript">
		var k=0,f=0;
		$(function() {
		var array=0;
		// We use an inline data source in the example, usually data would
		// be fetched from a server
		
		var data = [],
			totalPoints = 300;
		function results(a)
		{
			array=a;
			//alert(array);
		}
		
		function getRandomData() {
			
				
				var name=2;
				if(f==0)
				{
					var dataString = 'id='+ name;
					$.ajax({
					type: "POST",
					url: "graph.php",
					data: dataString,
					cache: false,
					success: function(result){
						results(JSON.parse(result));
						//alert(JSON.parse(result));
					}
					});
					
					f=1;
				}
				
			if (data.length > 0)
				data = data.slice(1);
			//alert(array);
			// Do a random walk	
			while (data.length < totalPoints) {
			var prev = data.length > 0 ? data[data.length - 1] : 0,
				y = array[k];
				//alert(array[k]);
				if (y < 0) {
					y = 0;
				} else if (y > 4.5) {
					y = 0;
				}
				data.push(y);
				k++;
				//alert(data);
			}


			// Zip the generated y values with the x values

			var res = [];
			for (var i = 0; i < data.length; ++i) {
				res.push([i, data[i]])
			}

			return res;
		}

		// Set up the control widget

		var updateInterval = 30;
		$("#updateInterval").val(updateInterval).change(function () {
			var v = $(this).val();
			if (v && !isNaN(+v)) {
				updateInterval = +v;
				if (updateInterval < 1) {
					updateInterval = 1;
				} else if (updateInterval > 1000) {
					updateInterval = 1000;
				}
				$(this).val("" + updateInterval);
			}
		});

		var plot = $.plot("#placeholder", [ getRandomData() ], {
			series: {
                shadowSize: 2	// Drawing is faster without shadows
			},
			yaxis: {	//Number 0f values in in y-axis
				 position: 'left', autoScale: 'none', min: 0, max: 4.5
			},
			xaxis: {
				position: 'bottom',
				mode: "time",
				timeBase: "milliseconds",
				timeformat: '%S',labelWidth: "5"
				
			}
		});

		function update() {

			plot.setData([getRandomData()]);

			// Since the axes don't change, we don't need to call plot.setupGrid()

			plot.draw();
			setTimeout(update, updateInterval);
		}

		update();

		// Add the Flot version string to the footer

		$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
	});
		
								
	</script>
</head>
<body>
	
	<div id="header">
		<h2>Real-time</h2>
		<p id="id"></p>
	</div>

	<div id="content">

		<div class="demo-container">
			<div id="placeholder" class="demo-placeholder"></div>
		</div>

		<p>You can update a chart periodically to get a real-time effect by using a timer to insert the new data in the plot and redraw it.</p>

		<p>Time between updates: <input id="updateInterval" type="text" value="" style="text-align: right; width:5em"> milliseconds</p>

	</div>

	<div id="footer">
		Copyright &copy; 2007 - 2014 IOLA and Ole Laursen
	</div>

</body>
</html>

