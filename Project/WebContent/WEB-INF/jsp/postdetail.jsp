<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>投稿詳細</title>
</head>
<body>

	<c:if test="${userId != null}">
		<div align="right">
			<header class="head">
				<a href="Logout"><span style="border-bottom: solid 1px #FFFFFF;">ログアウト</span></a>
			</header>
		</div>
	</c:if>

	<div class="box_0">
	<!--   投稿タイトル  -->
		<h6>${thread.createDate}${thread.userLoginId}</h6>
		<h1>${thread.threadTitle}</h1>
		<p>ここにコメントここにコメントここにコメントここにコメントここにコメント${thread.threadText}
		</p>
	</div>

	<c:if test="${cartActionMessage != null}">
		<p class="red-text center-align">
			<span style="color: #2ca9e1;">${cartActionMessage}</span>
		</p>
	</c:if>

	<c:if test="${validationMessage != null}">
		<p class="red-text center-align">
			<span style="color: #2ca9e1;">${validationMessage}</span>
		</p>
	</c:if>

	<c:if test="${userId != null}">
		<div class="box_1">

			<div class="yoibottun">
				<a href="ThreadRecord?thread_id=${thread.id}" class="square_btn">良いでしょう(${itemCount})</a>
			</div>

			<div class="yoibottun">
				<!--   コメント一覧ボタン  -->
				<a href="Comment?thread_id=${thread.id}">
					<button type="submit" class="btn btn-primary">コメントする</button>
				</a>
			</div>

		</div>
	</c:if>

	<div class="box_d">

		<!--   コメント一覧   -->
		<c:forEach var="comment" items="${commentList}">
			<h6>${comment.createDate}${comment.userLoginId}<br>${comment.comment}</h6>
		</c:forEach>

	</div>

	<%-- <form action="CommentConfirm" method="POST">

		<div class="form-post">
			<!--  <label>スレッドID送信用</label> -->
			<input name="thread_id" type="hidden" value="${thread.id}">
			<input type="text" class="form-control" name="thread_category_id" value="${userSelectDMB.name}" disabled>
		</div>

		<div class="form-post">
			<label>名前</label> <input type="text" class="form-control"
				name="user_login_id" value="${udb.loginId}" readonly>
		</div>

		<div class="form-post">
			<label>コメント欄</label>
			<textarea class="form-control" name="m_comment" rows="5"></textarea>
		</div>

		<div class="form-post">
			<!-- <div class="col s12"> -->
				<button class="btn  waves-effect waves-light  col s4 offset-s4"
					type="submit" name="action">コメント</button>
			<!-- </div> -->
		</div>

		<!-- <div class="form-post">
			<button class="btn btn-primary" type="submit" name="action">コメント</button>
		</div> -->

	</form> --%>

	<a href="Index">戻る</a>

</body>
</html>