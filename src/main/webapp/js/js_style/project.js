$(document).ready(function() {
	$.ajaxSetup({
	    beforeSend : function(xhr) {
	        xhr.overrideMimeType('text/html;charset=Shift_JIS');
	    }
	});
	 $(window).ready(function() {
		$.ajax({
			url : "../DataBase/data.csv",
			   dataType: 'text',
			   contentType: 'charset=utf-8',
			success : function(data) {
				var employee_data = data.split(/\r\n|\n|\r/);
				var project_table = '';
				var case_details='';
				for (var count = 0; count < employee_data.length; count++) {
					var cell_data = employee_data[count].split(",");
					for (var cell_count = 0; cell_count < cell_data.length; cell_count++) {
						if (count === 1 && cell_count === 0) {
							$('#project-title').append(cell_data[2]);
							project_table += '<tr>';
							project_table +='<th class="mailBox">Max月額</th>' ;
							project_table +='<td><span class="red bold">' + cell_data[3] +'</span></td>';
							project_table += '</tr>';
							project_table += '<tr>';
							project_table +='<th class="mailBox">最寄駅</th>' ;
							project_table +='<td><span class="red bold">' + cell_data[4] +'</span></td>';
							project_table += '</tr>';
							project_table += '<tr>';
							project_table +='<th class="mailBox">案件番号</th>' ;
							project_table +='<td><span class="red bold">' + cell_data[1] +'</span></td>';
							project_table += '</tr>';
							project_table += '<tr>';
							project_table +='<th class="mailBox">募集対象</th>' ;
							project_table +='<td><span class="red bold">' + cell_data[5] +'</span></td>';
							project_table += '</tr>';
							project_table += '<tr>';
							project_table +='<th class="mailBox">応募終了日</th>' ;
							project_table +='<td><span class="red bold">' + cell_data[6] +'</span></td>';
							project_table += '</tr>';

							case_details += '<tr>';
							case_details +='<th class="mailBox">案件概要</th>' ;
							case_details +='<td><span class="red bold">' + cell_data[22] +'</span></td>';
							case_details += '</tr>';
							case_details += '<tr>';
							case_details +='<th class="mailBox">掲載日</th>' ;
							case_details +='<td><span class="red bold">' + cell_data[8] +'</span></td>';
							case_details += '</tr>';
							case_details += '<tr>';
							case_details +='<th class="mailBox">作業開始</th>' ;
							case_details +='<td><span class="red bold">' + cell_data[9] +'</span></td>';
							case_details += '</tr>';
							case_details += '<tr>';
							case_details +='<th class="mailBox">作業期間</th>' ;
							case_details +='<td><span class="red bold">' + cell_data[10] +'</span></td>';
							case_details += '</tr>';
							case_details += '<tr>';
							case_details +='<th class="mailBox">募集人数</th>' ;
							case_details +='<td><span class="red bold">' + cell_data[10] +'</span></td>';
							case_details += '</tr>';
							case_details += '<tr>';
							case_details +='<th class="mailBox">案件種別</th>' ;
							case_details +='<td><span class="red bold">' + cell_data[11] +'</span></td>';
							case_details += '</tr>';
							case_details += '<tr>';
							case_details +='<th class="mailBox">面談回数</th>' ;
							case_details +='<td><span class="red bold">' + cell_data[15] +'</span></td>';
							case_details += '</tr>';
							case_details += '<tr>';
							case_details +='<th class="mailBox">日本語要求</th>' ;
							case_details +='<td><span class="red bold">' + cell_data[16] +'</span></td>';
							case_details += '</tr>';
							case_details += '<tr>';
							case_details +='<th class="mailBox">開発言語</th>' ;
							case_details +='<td><span class="red bold">' + cell_data[21] +'</span></td>';
							case_details += '</tr>';
						}
					}
				}
				$('#case-information').html(project_table);
				$('#case-details').html(case_details);
			}
		});
	});
});
