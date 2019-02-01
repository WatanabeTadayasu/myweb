<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>検索結果</title>
</head>
<body>

<div align="right">
		<header class="head">
			<a href="Index"><span style="border-bottom: solid 1px #FFFFFF;">トップページへ</span></a>
		</header>
	</div>

	<form class="form-inline my-2 my-lg-0" action="SearchTitleResult">
		<label for="inputState">タイトル検索</label>
			<input class="form-control mr-sm-2" type="search" width="80"
				height="40" placeholder="Search" aria-label="Search" name="search_word" value="">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>

	<div class="container">
		<div class="row center">
			<h5 class=" col s12 light">検索結果</h5>
			<p>
				検索結果${itemCount}件
			</p>
		</div>
		<div class="section">

		<!-- <div class="box_d"> -->
				<!--   おすすめ商品   -->
				<c:forEach var="thread" items="${threadList}">
						<h2>${thread.threadTitle}</h2>
						<h6>${thread.threadText}</h6>
				</c:forEach>
		<!-- </div> -->

			<div class="row">
				<c:if test="${(status.index + 1) % 4 == 0}">
				</c:if>
			</div>

			<%-- <!--   商品情報   -->
			<div class="row">
				<c:forEach var="item" items="${itemList}" varStatus="status">
				<div class="col s12 m3">
					<div class="card">
						<div class="card-image">
							<a href="Item?item_id=${item.id}&page_num=${pageNum}"><img src="img/${item.fileName}"></a>
						</div>
						<div class="card-content">
							<span class="card-title">${item.name}</span>
							<p>${item.price}円
							</p>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="row">
				<c:if test="${(status.index + 1) % 4 == 0}">
				</c:if>
			</div> --%>

		</div>

		<div class="row center">
			<ul class="pagination">
				<!-- １ページ戻るボタン  -->
				<c:choose>
					<c:when test="${pageNum == 1}">
						<li class="disabled"><a><i class="material-icons">chevron_left</i></a></li>
					</c:when>
					<c:otherwise>
						<li class="waves-effect"><a href="SearchTitleResult?search_word=${searchWord}&page_num=${pageNum - 1}"><i class="material-icons">chevron_left</i></a></li>
					</c:otherwise>
				</c:choose>

				<!-- ページインデックス -->
				<c:forEach begin="${(pageNum - 5) > 0 ? pageNum - 5 : 1}" end="${(pageNum + 5) > pageMax ? pageMax : pageNum + 5}" step="1" varStatus="status">
					<li <c:if test="${pageNum == status.index }"> class="active" </c:if>><a href="SearchTitleResult?search_word=${searchWord}&page_num=${status.index}">${status.index}</a></li>
				</c:forEach>

				<!-- 1ページ送るボタン -->
				<c:choose>
				<c:when test="${pageNum == pageMax || pageMax == 0}">
					<li class="disabled"><a><i class="material-icons">chevron_right</i></a></li>
				</c:when>
				<c:otherwise>
					<li class="waves-effect"><a href="SearchTitleResult?search_word=${searchWord}&page_num=${pageNum + 1}"><i class="material-icons">chevron_right</i></a></li>
				</c:otherwise>
				</c:choose>
			</ul>
		</div>

	</div>

</body>
</html>