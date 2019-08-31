$(document).ready(function(){

	// Get the modal
	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}

	$('#loginAccess').click(function() {
		login_access();
	    modal.style.display = "none";
	});

	$("#id01").on("keypress", function(event) {
		if (event.keyCode == 13) {
			event.preventDefault();
			login_access();
	        modal.style.display = "none";
		}
	});

	// ユーザ登録ボタン
	$('#createuser').click(function() {
		createAccount();
	});
});



//ログインのボタンをチェックする
function login_access() {
	var user = $("#username").val();
	var password = $("#password").val();
	$.ajax({
		type : 'POST',
		url : 'login',
		data : {
			"username" : user,
			"password" : password
		},
		success : function(data) {
			var jSon = $.parseJSON(data);
			if (data == null) {
				$('#loginForm').html("");
				// $('#lignup').hide();
				$('#loginUserNames').append(
						"<p>こにちは:  <span style='font-style: italic'>" + user
								+ "</span>Error</p>");
			} else {
				$('#userName').html("");
//				$(location).attr('href','index.html');
				$('#lignup').hide();
				$('#login').hide();
				$('#loginfrom').append("<span><p style='color:yellow'>Email " + user + "</p></span>");
			}
		},
		error : function() {
			$(location).attr('href','error404.html');
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
};
