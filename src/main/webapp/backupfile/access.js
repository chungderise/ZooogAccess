$(document).ready(function(){
			$('#bttSearch').click(function(){
				var actorID=$("#actorID").val();
				if (actorID=="") {
					submit_formAll();
				} else {
					submit_form();
				}

			});

			$("#actorID").on("keypress",function(event){
				var actorID=$("#actorID").val();
				if (event.keyCode == 13) {
				event.preventDefault();
				if (actorID=="") {
					submit_formAll();
				} else {
					submit_form();
				}
				}
			});

			// Loginボタン
			$("#login").click(function(){
				$('#loginForm').show();
				$('#login').hide();
			});
			 //キャンセルボタン
			$("#canelAccess").click(function(){
				$('#loginForm').hide();
				$('#userName').html("");
				$('#login').show();
			});

			$('#loginAccess').click(function(){
				login_access();

			});
		});

		function submit_formAll(){
			var actorID=$("#actorID").val();
/*			if(actorID==""){
				$('#result').html("");
				$('#result').append("<p style='color:yellow'>IDを入力してください！</p>");}*/
				$.ajax({
					type: 'POST',
					url: 'actor',
					data:{actorID:actorID},
					success : function(result){
						var product = $.parseJSON(result);
							 $('#test').html("");
						for (i in product){
							var html='';
							$.each(product[i], function(key, val) {
								html+="<td>"  + val+ "</td>";
							});

							$('tbody').append("<tr>"  + html+ "</tr>");
						}
					}
				});
		}

		function submit_form(){
			var actorID=$("#actorID").val();
		if(actorID==""){
			$('#result').html("");
			$('#result').append("<p style='color:yellow'>IDを入力してください！</p>");}
			$.ajax({
				type: 'POST',
				url: 'actor',
				data:{actorID:actorID},
				success : function(result){
					var product = $.parseJSON(result);
					$('#result').html("");
					if (product == null) {
						$('#loginForm').show();
						$('#result').append("<p style='color:yellow'>"+actorID+"を存在しません！</p>");
//						return false;
					}
					$('tbody').html("");
					$.each(product, function(key, val) {
						 $('tbody').append("<td>"  + val + "</td>");
					});
				}
			});
		}

		function login_access(){
			var user = $("#user").val();
			var password = $("#password").val();
//			console.log(user);
//			console.log(password);
			$.ajax({
				type : 'POST',
				url: 'login',
				data:{user:user,password:password},
				success : function(result){
					var jSon = $.parseJSON(result);
	                if (jSon == null) {
//		            	$('#loginForm').html("");
						$('#userName').append("<p style='color:yellow'>Username: "+user+"を存在しません！</p>");
	                }else{
					$('#loginForm').html("");
					$('#lignup').hide();
					$('#userName').append("<p>こにちは:  <span style='font-style: italic'>" + user + "</span></p>");
	                }
	            },
	            error: function () {
	            	$('#loginForm').html("");
	            	$('#userName').html("");
					$('#userName').append("<p style='color:yellow'>"+user+"を存在しません！</p>");
	            }
			});

		}