<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK REL="SHORTCUT ICON" HREF="images/img/img/logo.icon">
<title>求人ウェブサイト</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<!-- Add icon library -->
<link rel="stylesheet" href="css/bootstrap/font-awesome.min.css">
<!-- Custom styles for this template -->
<link href="css/bootstrap/fonts.css" rel="stylesheet">
<link href="css/bootstrap/blog.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap/jquery-3.3.1.min.js"></script>

<!-- Style追加 -->
<link rel="stylesheet" type="text/css" href="css/css_style/style.css">
<link rel="stylesheet" type="text/css"
	href="css/css_style/loginStyle.css">

</head>
<body>
	<!--ログインフォーム -->
	<div id="loginform">
		<div id="id01" class="modal">

			<form class="modal-content animate">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('id01').style.display='none'"
						class="close" title="Close Modal">&times;</span> <img
						src="images/logo/img_avatar2.png" alt="Avatar" class="avatar">
				</div>

				<div class="container">
					<label for="uname"><b>Username</b></label> <input type="email"
						placeholder="username@mail.com" name="emailaddress" required
						id="email"> <label for="psw"><b>Password</b></label> <input
						type="password" placeholder="Enter Password" name="psw" required
						id="password"> <input type="button" value="Login"
						id="loginAccess" /> <label> <input type="checkbox"
						checked="checked" name="remember"> Remember me
					</label>
				</div>

				<div class="container" style="background-color: #f1f1f1">
					<input type="button"
						onclick="document.getElementById('id01').style.display='none'"
						class="cancelbtn" value="Cancel" /> <span class="psw">Forgot
						<a href="#">password?</a>
					</span>
				</div>
			</form>
		</div>
	</div>


	<!-- 新規登録フォーム -->
	<div id="createAccount">
		<div id="id02" class="modal">
			<form class="modal-content animate">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('id02').style.display='none'"
						class="close" title="Close Modal">&times;</span> <img
						src="images/logo/1-36-512.png" alt="Create Account" class="avatar">
				</div>

				<div class="container">
					<label for="uname"><b>Username</b></label> <input type="email"
						placeholder="username@mail.com" name="emailaddress" required
						id="userAccount"> <label for="psw"><b>Password</b></label>
					<input type="password" placeholder="Enter Password" name="psw"
						required id="passwordAccount"> <input type="button"
						value="Create Account" id="loginAccess" />
				</div>

				<div class="container" style="background-color: #f1f1f1">
					<input type="button"
						onclick="document.getElementById('id02').style.display='none'"
						class="cancelbtn" value="Cancel" />
				</div>
			</form>
		</div>
	</div>
	<!-- メニューバー -->
	<div class="bg-dark text-white p-1 mb-1">
		<div class="col-11 d-flex justify-content-end align-items-center"
			id="loginfrom">
			<input type="button" value="ログイン"
				class="btn btn-sm btn-outline-secondary" id="login"
				onclick="document.getElementById('id01').style.display='block'"
				style="width: auto;" /> <input type="button" value="新規登録"
				class="btn btn-sm btn-outline-secondary" id="lignup"
				onclick="document.getElementById('id02').style.display='block'"
				style="width: auto;" />
		</div>
		<div id="userName"></div>
	</div>

	<div role="main" class="container">
		<div class="jumbotron p-3 text-white rounded bg-info row" id="slogan">
			<div class="col-md-6 px-0">
				<h1 class="display-4 font-italic">IT求人情報検索</h1>
				<p class="lead my-3">ZOOOGに求人広告を 無料で掲載しましょう ZOOOG
					は数百万の求職者と採用企業がお互いのベストマッチを見つけるお手伝いをしています。世界
					No.1*の求人サイトに無料で求人広告を掲載できます。</p>
			</div>
			<div class="col-md-6">
				<img src="images/img/ShowImage.jpg"
					style="width: 100%; height: 100%;">
			</div>
		</div>
		<div class="row mb-2">
			<div class="col-md-9">
				<!-- 検索タブ -->
				<div class="form-group bg-info p-3">
					<form class="navbar-form navbar-left" role="search">
						<input type="text" class="form-control" placeholder="Search"
							id="actorID" /> <input type="button" value="検索"
							class="btn btn-default" id="bttSearch" /> <span id="result"></span>
					</form>
				</div>

				<div class="card mb-4 box-shadow">
					<div class="container" style="margin: 5px;">
						<h6>Select Number of Rows</h6>
						<div class="form-group">
							<select class="form-control" name="state" id="maxRows" style="width: 150px;">
								<option value="5000">Show All</option>
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="15">15</option>
								<option value="20">20</option>
								<option value="50">50</option>
								<option value="75">75</option>
								<option value="100">100</option>
								<option value="5000">Show ALL Rows</option>
							</select>
						</div>
					</div>
					<p class="bg-info p-3 text-white">公開中案件情報一覧</p>
					<table class="grid table table-hover tagridble-white" id="Tabla">
						<thead>
							<tr>
								<th scope="col">案件名</th>
								<th scope="col">最寄駅</th>
								<th scope="col">開始</th>
								<th scope="col">期間</th>
								<!-- <th scope="col">人数</th> -->
								<!-- <th scope="col">Max月額</th> -->
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<div>
						<nav>
							<ul class="pagination" style="cursor: pointer"></ul>
						</nav>
					</div>
				</div>
			</div>
			<div class="details"></div>
			<div class="col-md-3">
				<div class="card mb-4 box-shadow h-md-250">
					<p class="bg-info p-3 text-white">大注目案件</p>
				</div>
				<div class="card mb-4 box-shadow h-md-250">
					<p class="bg-info p-3 text-white">求人情報</p>
				</div>
			</div>
		</div>
	</div>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/holder.min.js"></script>
	<script>
		Holder.addTheme('thumb', {
			bg : '#55595c',
			fg : '#eceeef',
			text : 'Thumbnail'
		});
	</script>
	<!-- js Style 追加 -->
	<script type="text/javascript" src="js/js_style/paginationRecord.js"></script>
	<script type="text/javascript" src="js/js_style/access.js"></script>
	<script type="text/javascript" src="js/js_style/loginaccess.js"></script>
</html>
