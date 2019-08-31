$(document).ready(function(){
	var userID = $("#username").val();
	$.ajax({
		type: 'POST',
		url: 'createAccountController',
		data:{userID:userID},
		success : function(result){

		}
	});

	// Get the modal
	var modal1 = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal1) {
	        modal.style.display = "none";
	    }
	}

	// Get the modal
	var modal2 = document.getElementById('id02');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal2) {
	        modal.style.display = "none";
	    }
	}


	$('#loginAccess').click(function() {
		login_access();

	});

	// ユーザ登録ボタン
	$('#createuser').click(function() {
		createAccount();
	});
});



//ログインのボタンをチェックする
function login_access() {
	var user = $("#user").val();
	var password = $("#password").val();
	$.ajax({
		type : 'POST',
		url : 'login',
		data : {
			user : user,
			password : password
		},
		success : function(result) {
			var jSon = $.parseJSON(result);
			if (jSon == null) {
				$('#userName').html("");
				$('#userName').append(
						"<p style='color:yellow'>Username: " + user
								+ "を存在しません！</p>");
			} else {
				$('#loginForm').html("");
				$('#lignup').hide();
				$('#userName').append(
						"<p>こにちは:  <span style='font-style: italic'>" + user
								+ "</span></p>");
			}
		},
		error : function() {
			$('#loginForm').html("");
			$('#userName').html("");
			$('#userName').append(
					"<p style='color:yellow'>" + user + "を存在しません！</p>");
		}
	});

}

// ログアウトのボタンをチェック
function createAccount() {
	var userAccount = $("#userAccount").val();
	var passAccount = $("#passwordAccount").val();
	$.ajax({
		type : 'POST',
		url : 'createAccountController',
		data : {
			userAccount : userAccount,
			passAccount : passAccount
		},
		success : function(result) {
			var jSon = $.parseJSON(result);
			if (jSon == null) {
				// $('#createAccount').html("");
				$('#userName').append("ユーザを存在しています。他のユーザを作成してください。");
			} else {
				$('#createAccount').html("");
				$('#userName').append(userAccount + "を登録しました");
				$('#login').show();
			}

		},
		error : function() {
			$('#createAccount').html("");
			$('#userName').html("");
			$('#userName').append(
					"<p style='color:yellow'>" + user + "を存在しません！</p>");
		}
	});

}
