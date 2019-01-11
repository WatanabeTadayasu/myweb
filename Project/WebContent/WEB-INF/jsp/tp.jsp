<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>トップページ</title>
</head>
<body>

<div class="wrapper">

<div class = "header">

<h1>掲示板</h1>
<ul class="nav">
  <li class="nav-item">
    <a class="nav-link" href="#">
    <span style="border-bottom: solid 5px blue;">ランキング</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">
    <span style="border-bottom: solid 5px blue;">速報</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">
    <span style="border-bottom: solid 5px blue;">おすすめ</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Regist">
    <span style="border-bottom: solid 5px blue;">新規登録</span></a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="UserListServlet">
    <span style="border-bottom: solid 5px blue;">ユーザー一覧</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Login">
    <span style="border-bottom: solid 5px blue;">ログイン</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Logout">
    <span style="border-bottom: solid 5px blue;">ログアウト</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Post">
    <span style="border-bottom: solid 5px blue;">投稿</span></a>
  </li>
</ul>

</div>

<div class="box_d">

		<!-- <c:if test="${userInfo.loginId == 'admin'}"> -->
			<div class="delete">
             <a class="btn btn-danger" href ="UserDeleteServlet?id=${user.id}">削除</a>
			</div>
		<!-- </c:if> -->

			<div class="box_1">
				<h2>
					<a href="https://saruwakakun.com/">うどん
						${resultBDB.threadTitle}</a>
				</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント
				${resultBDB.threadText}</p>
			</div>

			<!-- <c:if test="${userInfo.loginId == 'admin'}"> -->
			<div class="delete">
             <a class="btn btn-danger" href ="UserDeleteServlet?id=${user.id}">削除</a>
			</div>
		<!-- </c:if> -->

<div class="box_2">
      <h2>パスタ</h2>
      <p>ここにコメントここにコメントここにコメントここにコメント</p>
  </div>


<div class="box_3">
      <h2>ラーメン</h2>
      <p>ここにコメントここにコメントここにコメントここにコメント</p>
  </div>


<div class="box_4">
      <h2>寿司</h2>
      <p>ここにコメントここにコメントここにコメントここにコメント</p>
  </div>


<div class="box_5">
      <h2>スイーツ</h2>
      <p>ここにコメントここにコメントここにコメントここにコメント</p>
  </div>


<div class="box_6">
      <h2>イタリアン</h2>
      <p>ここにコメントここにコメントここにコメントここにコメント</p>
  </div>


<div class="box_7">
      <h2>ワイン</h2>
      <p>ここにコメントここにコメントここにコメントここにコメント</p>
  </div>

</div>

<div class= "footer">
      <p>keiziban</p>
</div>

</div>

</body>
</html>