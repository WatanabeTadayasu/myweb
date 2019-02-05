<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>ユーザー情報更新完了</title>
</head>
<body>

	<div align="right">
		<header class="head">
			<a href="Logout"><span style="border-bottom: solid 1px #FFFFFF;">ログアウト</span></a>
		</header>
	</div>

	<br>
	<br>
	<div class="container">
		<div class="row center">
			<h5 class=" col s12 light">更新完了</h5>
		</div>
		<div class="row">
			<div class="section"></div>
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<div class="row">
							<div class="input-field col s6">
								<label>名前</label><input type="text" value="${udb.name}" readonly>
							</div>
						</div>

						<c:if test="${udb.password != \"\"}">
						<div class="row">
							<div class="input-field col s6">
								<label>パスワード</label><input type="text" value="${udb.password}"
									readonly>
							</div>
						</div>
						</c:if>

						<div class="row">
							<div class="input-field col s6">
								<label>生年月日</label><input type="text" value="${udb.birthdate}"
									readonly>
							</div>
						</div>
						<div class="row">
							<div class="col s12">
								<p class="center-align">上記内容で更新しました</p>
							</div>
						</div>
						<div class="row">
							<div class="col s12">
								<p class="center-align">
									<a href="UserListServlet" class="btn waves-effect waves-light  col s4 offset-s4">ユーザー一覧へ</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>