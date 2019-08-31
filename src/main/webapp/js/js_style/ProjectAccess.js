$(document).ready(function() {
	var actorID = $("#actorID").val();
	submit_formAll(actorID);
	$('#bttSearch').click(function() {
		if (actorID == '' || actorID == null) {
			submit_formAll(actorID);
		} else {
			var numberID = parseInt(actorID);
//			console.log(numberID);
			if (Math.floor(actorID) == actorID && $.isNumeric(actorID)) {
				submit_form(actorID);
			}else{
				$('tbody').html("");
				$('tbody').append("<tr><td style='color:#919191'>IDを見つけません！</td></tr>");
			}
		}
	});

	$("#actorID").on("keypress", function(event) {
		var actorID = $("#actorID").val();
		if (event.keyCode == 13) {
			event.preventDefault();
			if (actorID == "" || actorID == null) {
				submit_formAll(actorID);
			} else {
				var numberID = parseInt(actorID);
				if (Math.floor(actorID) == actorID && $.isNumeric(actorID)) {
					submit_form(actorID);
				}else{
					$('tbody').html("");
					$('tbody').append("<tr><td style='color:#919191' class='notID'>IDを見つけません！</td></tr>");
				}
			}
		}
	});
});

function submit_formAll(actorID) {
	$.ajaxSetup({
	    beforeSend : function(xhr) {
	        xhr.overrideMimeType('text/html;charset=Shift_JIS');
	    }
	});
	$.ajax({
		url : 'project',
		type: 'POST',
		dataType: 'text',
		data : {
			actorID : actorID
		},
		contentType: 'application/json',
		mimeType: 'application/json',
		success : function(result) {
			var product = $.parseJSON(result);
			$('#test').html("");
			$('tbody').html("");
			for (i in product) {
				var html = '';
				$.each(product[i], function(key, val) {
					html += "<td>" + val + "</td>";
				});
				$('tbody').append("<tr id=item" + i + ">" + html + "</tr>");
			}
		}
	});
}

function submit_form(actorID) {
	$.ajaxSetup({
	    beforeSend : function(xhr) {
	        xhr.overrideMimeType('text/html;charset=Shift_JIS');
	    }
	});
	$.ajax({
		type : 'POST',
		url : 'project',
		data : {
			actorID : actorID
		},
		success : function(result) {
			var product = $.parseJSON(result);
			if (product == null) {
				$('tbody').html("");
				$('tbody').append(
						"<p style='color:yellow'>" + actorID + "を存在しません！</p>");
			}
			$('tbody').html("");
			var html = '';
			$.each(product, function(key, val) {
				html += "<td>" + val + "</td>";
			});
			$('tbody').append("<tr id=item" + actorID + ">" + html + "</tr>");
		}
	});
}
