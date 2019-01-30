<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>投稿履歴詳細</title>
</head>
<body>

	<div align="right">
		<header class="head">
			<a href="Logout"><span style="border-bottom: solid 1px #FFFFFF;">ログアウト</span></a>
		</header>
	</div>

	<br>
	<br>
	<div class="container">
		<div class="row center">
			<h4 class=" col s12 light">投稿詳細</h4>
		</div>

		<!-- private int id;
		private int threadCategoryId;
		private String userId;
		private String threadTitle;
		private String threadText;
		private String createDate;
		private String threadCategoryName; -->
		<!--  購入 -->
		<div class="row">
			<div class="col s10 offset-s1">
				<div class="card grey lighten-5">
					<div class="card-content">

						<div class="form-post">
							<label for="exampleFormControlInput1">タイトル</label><br>
							${bdbbb.threadTitle}
						</div><br>

						<div class="form-post">
							<label for="exampleFormControlTextarea1">本文</label><br>
							${bdbbb.threadText}
						</div><br>

					</div>
				</div>
			</div>
		</div>
	</div>

	<a href="UserListServlet">戻る</a>

</body>
</html>