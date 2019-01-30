<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>投稿</title>
</head>
<body>

<div align="right">
		<header class="head">
			<a href="Logout"><span style="border-bottom: solid 1px #FFFFFF;">ログアウト</span></a>
		</header>
	</div>

	<br>
<div class="topicpost">

	<h1>記事作成</h1>

</div>

<c:if test="${validationMessage != null}">
	    <div class="alert alert-danger" role="alert">
		  ${validationMessage}
		</div>
	</c:if>

<form action="PostConfirm" method="POST">

  <div class="form-post">
    <label>ログインID</label>
    <input type="text" class="form-control" name="user_login_id" value="${udb.loginId}" readonly>
  </div>

  <div class="form-post">
    <label>カテゴリ選択</label>
    <select name="thread_category_id">
	<c:forEach var="dmdb" items="${dmdbList}" >
		<option value="${dmdb.id}">${dmdb.name}</option>
	</c:forEach>
	</select>

    <!-- <select class="form-control" id="exampleFormControlSelect1">
      <option>旅行・日記</option>
      <option>暮らし・ライフスタイル</option>
      <option>外食</option>
      <option>スポーツ・ゲーム</option>
      <option>映画</option>
      <option>ニュース</option>
    </select> -->
  </div>

  <div class="form-post">
    <label>タイトル</label>
    <input type="text" class="form-control" name="thread_title" placeholder="タイトル">
  </div>

  <div class="form-post">
    <label>本文</label>
    <textarea class="form-control" name="thread_text" rows="5"></textarea>
  </div>

		<div class="form-post">
			<div class="col s12">
				<button class="btn  waves-effect waves-light  col s4 offset-s4"
					type="submit" name="action">投稿</button>
			</div>
		</div>

</form>

<a href="Index">戻る</a>

</body>
</html>