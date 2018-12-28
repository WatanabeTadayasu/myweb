<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>ログイン</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="section"></div>
			<div class="col s6 offset-s3">
				<div class="card grey lighten-5">
					<div class="card-content">
						<form action="LoginResult" method="POST">
							<div class="row">
								<c:if test="${loginErrorMessage != null}">
									<p class="red-text center-align">${loginErrorMessage}</p>
									<br>
								</c:if>
								<div class="input-field col s8 offset-s2">
									<input type="text" name="login_id" value="${inputLoginId}" required> <label>ログインID</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s8 offset-s2">
									<input type="password" name="password" required> <label>パスワード</label>
								</div>
							</div>
							<div class="row">
								<div class="col s12">
									<p class="center-align">
										<button class="btn btn-large waves-effect waves-light  col s8 offset-s2" type="submit" name="action">ログイン</button>
									</p>
								</div>
							</div>
							<div class="row">
								<div class="col s8 offset-s2">
									<p class="right-align">
										<a href="Regist">新規登録</a>
									</p>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>