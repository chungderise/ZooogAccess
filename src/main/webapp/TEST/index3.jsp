<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Add icon library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>求人ウェブサイト</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
	
<!-- Custom styles for this template -->
<link href="css/fonts.css" rel="stylesheet">
<link href="css/blog.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<!-- Style追加 -->
<link href="style/style.css" rel="stylesheet">
<script type="text/javascript" src="js/access.js"></script>
<script type="text/javascript" src="js/pagination.js"></script>

<!-- ホームページにページング機能 -->
<script type="text/javascript" src="js/jquery.simplePagination.js"></script>
<link rel= "stylesheet" href="css/simplePagination.css">

</head>
<body>
	<main role="main" class="container">
	<div class="jumbotron p-3 text-white rounded bg-info">
		<div class="col-md-6 px-0">
			<h1 class="display-4 font-italic">IT求人情報検索</h1>
			<p class="lead my-3">SMHCに求人広告を 無料で掲載しましょう SMHC
				は数百万の求職者と採用企業がお互いのベストマッチを見つけるお手伝いをしています。世界
				No.1*の求人サイトに無料で求人広告を掲載できます。</p>
		</div>
	</div>
	<div class="row mb-2">
		<div class="col-md-9">

			<div class="form-group bg-info p-3">
				<form class="navbar-form navbar-left" role="search">
					<input type="text" class="form-control" placeholder="Search"
						style="width: 80%; float: left; margin-right: 20px;" id="actorID" />
					<input type="button" value="検索" class="btn btn-default"
						id="bttSearch" />
					<!-- <button type="submit" id="bttSearch">aa</button> -->
					<span id="result"></span>
				</form>
			</div>

<!-- 			<div class="card mb-4 box-shadow h-md-250" id="dataBase"> -->
<div class="card mb-4 box-shadow">
				<p class="bg-info p-3 text-white">公開中案件情報一覧</p>
				<table class="grid table table-hover tagridble-white">
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
			</div>
		</div>
		<div class="col-md-3">
			<div class="card mb-4 box-shadow h-md-250">
				<p class="bg-info p-3 text-white">大注目案件</p>
			</div>
			<div class="card mb-4 box-shadow h-md-250">
				<p class="bg-info p-3 text-white">求人情報</p>
			</div>
		</div>
	</div>

	<!-- ============== -->
	<div class="selection" id="page-1">
                <h2>事前準備</h2>
                <p>準備についての文章</p>
            </div>

            //2ページ目
            <div class="selection" id="page-2">
                <h2>追加方法1</h2>
                <p>追加方法1についての文章</p>
            </div>

            //3ページ目
            <div class="selection" id="page-3">
                <h2>追加方法2</h2>
                <p>追加方法2についての文章</p>
            </div>

            //4ページ目
            <div class="selection" id="page-4">
                <h2>追加方法3</h2>
                <p>追加方法3についての文章</p>
            </div>
           <div class="pagination-holder clearfix">
            <div id="light-pagination" class="pagination"></div>
        </div>
	<!-- /.row --> </main>
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
</html>
