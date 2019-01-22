<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>投稿確認</title>

</head>
<body>

<form action="PostResult" method="POST">

  <div class="form-post">
    <label>ログインID</label>
    <input type="text" class="form-control" name="user_login_id" value="${udb.loginId}" readonly>
  </div>

  <div class="form-post">
    <label>カテゴリ</label>
    <input name="thread_category_id" type="hidden" value="${userSelectDMB.id}">
	<input type="text" class="form-control" name="thread_category_id" value="${userSelectDMB.name}" disabled>
  </div>

  <div class="form-post">
    <label>タイトル</label>
    <input type="text" class="form-control" name="thread_title" value="${bdb.threadTitle}" readonly>
  </div>

  <div class="form-post">
    <label>本文</label>
    <textarea class="form-control" name="thread_text" rows="5" readonly>${bdb.threadText}</textarea>
  </div>

		<div class="row">
			<div class="col s12">
				<p class="center-align">上記内容で投稿してよろしいでしょうか?</p>
			</div>
		</div>
		<div class="row">
			<div class="col s6 center-align">
				<button class="btn  waves-effect waves-light" type="submit" name="confirm_button" value="cancel">修正</button>
			</div>
			<div class="col s6 center-align">
				<button class="btn  waves-effect waves-light" type="submit" name="confirm_button" value="regist">登録</button>
			</div>
		</div>
</form>
</body>
</html>