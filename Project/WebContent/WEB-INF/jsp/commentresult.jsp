<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>コメント完了</title>
</head>
<body>

<div align="right">
		<header class="head">
			<a href="Logout"><span style="border-bottom: solid 1px #FFFFFF;">ログアウト</span></a>
		</header>
	</div>

  <div class="form-post">
    <label>ログインID</label>
    <input type="text" class="form-control" name="user_login_id" value="${comme.userLoginId}" readonly>
  </div>

  <div class="form-post">
    <label>本文</label>
    <textarea class="form-control" name="m_comment" rows="5" readonly>${comme.comment}</textarea>
  </div>

		<div class="row">
			<div class="col s12">
				<p class="center-align">上記内容で登録しました。</p>
			</div>
		</div>
		<div class="row">
			<div class="col s12">
				<p class="center-align">
					<a href="Index" class="btn waves-effect waves-light  col s8 offset-s2">トップページへ</a>
				</p>
			</div>
		</div>

</body>
</html>