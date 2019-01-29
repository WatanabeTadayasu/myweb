<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>コメントする</title>
</head>
<body>

	<div class="box_0">
		<h6>${thread.createDate}</h6>
		<h1>${thread.threadTitle}</h1>
		<p>ここにコメントここにコメントここにコメントここにコメントここにコメント${thread.threadText}
		</p>
	</div>

	<%-- <div class="yoibottun">
	<a href="#"class="square_btn">良いでしょう</a>
	</div>

	<div class="yoibottun">
		<!--   コメント一覧ボタン  -->
		<a href="CommentHistoryDetail?thread_id=${thread.id}">
			<button type="submit" class="btn btn-primary">コメント一覧</button>
		</a>
	</div> --%>

	<div class="box_2">
		<!--   コメント一覧   -->
		<c:forEach var="comment" items="${commentList}">
			<h6>${comment.userLoginId}<br>${comment.comment}${comment.createDate}</h6>
		</c:forEach>
	</div>

	<form action="CommentConfirm" method="POST">

		<div class="form-post">
			<!--  <label>スレッドID送信用</label> -->
			<input name="thread_id" type="hidden" value="${thread.id}">
			<%-- <input type="text" class="form-control" name="thread_category_id" value="${userSelectDMB.name}" disabled> --%>
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

	</form>

</body>
</html>