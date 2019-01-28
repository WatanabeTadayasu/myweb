<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>コメント履歴詳細</title>
</head>
<body>
	<br>
	<br>
	<div class="container">

		<div class="row center">
			<h4 class=" col s12 light">コメント一覧</h4>
		</div>

		<div class="box_0">
			<h1>題名.本文${thread.threadTitle}</h1>
			<p>ここにコメントここにコメントここにコメントここにコメントここにコメント
			${thread.threadText}${thread.createDate}</p>
		</div>

		<c:if test="${cartActionMessage != null}">
			<p class="red-text center-align">
				<span style="color: #2ca9e1;">${cartActionMessage}</span>
			</p>
		</c:if>

		<div class="box_1">
			<!--   コメント一覧   -->
			<c:forEach var="comment" items="${commentList}">
				<h6>${comment.userLoginId}<br>${comment.comment}${comment.createDate}</h6>
			</c:forEach>
		</div>

	</div>

	<a href="UserListServlet">戻る</a>
</body>
</html>