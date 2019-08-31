$(document).ready(function() {

	$.ajaxSetup({
	    beforeSend : function(xhr) {
	        xhr.overrideMimeType('text/html;charset=Shift_JIS');
	    }
	});
	 $(window).ready(function() {
		$.ajax({
			url : "DataBase/data2.csv",
			   dataType: 'text',
			   contentType: 'charset=utf-8',
			success : function(data) {
				var employee_data = data.split(/\r\n|\n|\r/);
				var html='';
				for (var count = 0; count < employee_data.length; count++) {
					var cell_data = employee_data[count].split(",");
					html += '<tr id="project-box" class="cursor-enable row-click-able" scope="col-xs-" data-href="projectpage.jsp" >';
					for (var cell_count = 0; cell_count < cell_data.length; cell_count++) {
						if (count !== 0) {
							html += '<td scope="col-xs-"><a href="projectpage/project'+count+'.html"><p>'+ cell_data[cell_count] + '</p></a></td>';
						}
					}
					html += '</tr>';
				}
				$('tbody').append(html);
			}
		});

	});


});

