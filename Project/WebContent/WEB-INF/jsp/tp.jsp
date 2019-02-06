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

<div align="left">

<header class="head">

<ul class="nav">
	<li class="nav-item">
     <h1><a class="nav-link" href="Index">
   	<span style="border-bottom: solid 1px #FFFFFF;">掲示板</span></a></h1>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#rank">
    <span style="border-bottom: solid 1px #FFFFFF;">ランキング</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#quick">
    <span style="border-bottom: solid 1px #FFFFFF;">速報</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#recommen">
    <span style="border-bottom: solid 1px #FFFFFF;">おすすめ</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Post">
    <span style="border-bottom: solid 1px #FFFFFF;">投稿</span></a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="Login">
    <span style="border-bottom: solid 1px #FFFFFF;">ログイン</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Regist">
    <span style="border-bottom: solid 1px #FFFFFF;">新規登録</span></a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="UserListServlet">
    <span style="border-bottom: solid 1px #FFFFFF;">ユーザー一覧</span></a>
  </li>
 <!--  <li class="nav-item">
    <a class="nav-link" href="Logout">
    <span style="border-bottom: solid 1px #0088e7;">ログアウト</span></a>
  </li> -->
</ul>

	</header>

</div>

<!-- <div class="container"> -->

<!-- <div class="searchbbutton"> -->

<!-- <div class="form-row"> -->

	<c:if test="${searchEerrorMessage != null}">
		<p class="red-text center-align">
			<span style="color: #ff0000;">${searchEerrorMessage}</span>
		</p>
	</c:if>

	<form class="form-inline my-2 my-lg-0" action="SearchTitleResult">
		<label for="inputState">タイトル検索</label>
			<input class="form-control mr-sm-2" type="search" width="80"
				height="40" placeholder="Search" aria-label="Search" name="search_word" value="">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>

<c:if test="${userId != null}">

		<form class="form-inline my-2 my-lg-0" action="SearchCategoryResult">

				<!-- <div class="form-group col-md-4"> -->
				<label for="inputState">カテゴリ検索</label>
				<select id="inputState" class="form-control" name="thread_category_id">
					<option value="1">旅行日記</option>
					<option value="2">暮らしライフスタイル</option>
					<option value="3">外食</option>
					<option value="4">スポーツゲーム</option>
					<option value="5">映画</option>
					<option value="6">ニュース</option>
				</select>

				<!-- </div> -->
				<button type="submit" class="btn btn-outline-success my-2 my-sm-0">Search</button>
		</form>

</c:if>

<!-- </div> -->

<!-- </div> -->

<!-- </div> -->

<div class="wrapper">

		<div class="container">
			<div class="row center">
				<h5 class=" col s12 light" id="recommen">おすすめ記事</h5>
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
				<h2>タイトル</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

			<div class="box_5">
				<h2>タイトル</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

		</div>

		<div class="container">
			<div class="row center">
				<h5 class=" col s12 light" id="rank">ランキング</h5>
			</div>
		</div>

		<div class="box_d">

				<!--   ランキング商品   -->
				<c:forEach var="thread" items="${rankingThreadList}">
						<h2><a href="PostDetail?thread_id=${thread.id}">${thread.threadTitle}</a></h2>
						<h6>${thread.threadText}</h6>
				</c:forEach>

			<div class="box_4">
				<h2>タイトル</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

			<div class="box_5">
				<h2>タイトル</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

		</div>

	<div class="container">
			<div class="row center">
				<h5 class=" col s12 light" id="quick">速報</h5>
			</div>
		</div>

		<div class="box_d">

				<!--   速報商品   -->
				<c:forEach var="thread" items="${quickThreadList}">
						<h2><a href="PostDetail?thread_id=${thread.id}">${thread.threadTitle}</a></h2>
						<h6>${thread.threadText}</h6>
				</c:forEach>

			<div class="box_4">
				<h2>タイトル</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

			<div class="box_5">
				<h2>タイトル</h2>
				<p>ここにコメントここにコメントここにコメントここにコメント</p>
			</div>

		</div>

		<div class="footer">
			<div class="container">
				<div class="row center">
					<p>keiziban</p>
				</div>
			</div>
		</div>

	</div>

</body>
</html>