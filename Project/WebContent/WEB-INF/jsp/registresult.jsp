<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>ユーザ-登録完了</title>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<div class="row center">
			<h5 class=" col s12 light">登録完了</h5>
		</div>
		<div class="row">
			<div class="section"></div>
			<div class="col s6 offset-s3">
				<div class="card grey lighten-5">
					<div class="card-content">
						<div class="row">
							<div class="input-field col s10 offset-s1">
								<input type="text" value="${udb.name}" readonly> <label>名前</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s10 offset-s1">
								<input type="text" value="${udb.loginId}" readonly> <label>ログインID</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s10 offset-s1">
								<input type="text" value="${udb.birthdate}" readonly> <label>生年月日</label>
							</div>
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
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>