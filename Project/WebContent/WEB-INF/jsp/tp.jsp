<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>トップページ</title>
</head>
<body>

<div class = "header">

<ul class="nav">
	<li class="nav-item">
     <h1><a class="nav-link" href="#">
   	<span style="border-bottom: solid 1px #fff;">掲示板</span></a></h1>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">
    <span style="border-bottom: solid 1px #fff;">ランキング</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">
    <span style="border-bottom: solid 1px #fff;">速報</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">
    <span style="border-bottom: solid 1px #fff;">おすすめ</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Regist">
    <span style="border-bottom: solid 1px #fff;">新規登録</span></a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="UserListServlet">
    <span style="border-bottom: solid 1px #fff;">ユーザー一覧</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Login">
    <span style="border-bottom: solid 1px #fff;">ログイン</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Logout">
    <span style="border-bottom: solid 1px #fff;">ログアウト</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Post">
    <span style="border-bottom: solid 1px #fff;">投稿</span></a>
  </li>
</ul>

</div>

<div class="wrapper">

		<div class="container">
			<div class="row center">
				<h5 class=" col s12 light">おすすめ記事</h5>
			</div>
		</div>

		<div class="box_d">

				<!--   おすすめ商品   -->
				<c:forEach var="thread" items="${threadList}">
						<h2><a href="PostDetail?thread_id=${thread.id}">${thread.threadTitle}</a></h2>
						<h6>${thread.threadText}</h6>
				</c:forEach>

			<%-- <div class="box_2">
				<!--   おすすめ商品   -->
				<c:forEach var="item" items="${itemList}">
						<h2>
							<a href="Item?item_id=${item.id}">${item.threadTtitle}</a>
						</h2>
						<h6>${item.threadText}${item.createDate}</h6>
				</c:forEach>
			</div>

			<div class="box_3">
				<!--   おすすめ商品   -->
				<c:forEach var="item" items="${itemList}">
						<h2>
							<a href="Item?item_id=${item.id}">${item.threadTtitle}</a>
						</h2>
						<h6>${item.threadText}${item.createDate}</h6>
				</c:forEach>
			</div> --%>

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

		<div class="container">
			<div class="row center">
				<h5 class=" col s12 light">ランキング</h5>
			</div>
		</div>

		<div class="box_d">

				<!--   ランキング商品   -->
				<c:forEach var="item" items="${itemList}">
						<h2>
							<a href="Item?item_id=${item.id}">${item.threadTtitle}</a>
						</h2>
						<h6>${item.threadText}${item.createDate}</h6>
				</c:forEach>

			<div class="box_4">
				<h2>寿司</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

			<div class="box_5">
				<h2>スイーツ</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

	</div>

	<div class="container">
			<div class="row center">
				<h5 class=" col s12 light">速報</h5>
			</div>
		</div>

		<div class="box_d">

				<!--   速報商品   -->
				<c:forEach var="item" items="${itemList}">
						<h2>
							<a href="Item?item_id=${item.id}">${item.threadTtitle}</a>
						</h2>
						<h6>${item.threadText}${item.createDate}</h6>
				</c:forEach>

			<div class="box_4">
				<h2>寿司</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

			<div class="box_5">
				<h2>スイーツ</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

	</div>

		<div class="footer">
			<p>keiziban</p>
		</div>

	</div>

</body>
</html>