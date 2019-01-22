<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>ユーザー情報/更新確認</title>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<div class="row center">
			<h5 class=" col s12 light">入力内容確認</h5>
		</div>
		<div class="row">
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<form action="UserDataUpdateResult" method="POST">
							<div class="row">
								<div class="form-group col-md-6">
									 <label>ログインID</label><input type="text" name="login_id_update"
										value="${udb.loginId}" readonly>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-6">
									 <label>名前</label><input type="text" name="user_name_update" value="${udb.name}" readonly>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-6">
									<label>パスワード</label><input type="text" name="password_update"
										value="${udb.password}" readonly>
								</div>
							</div>
							<div class="row">
								 <label>生年月日</label><div class="form-group col-md-6">
									<input type="text" name="birthdate_update"
										value="${udb.birthdate}" readonly>
								</div>
							</div>
							<%-- <div class="row">
								<div class="input-field col s12">
									<input type="text" name="user_address_update" value="${udb.address}" readonly> <label>住所</label>
								</div>
							</div> --%>
							<div class="row">
								<div class="col s12">
									<p class="center-align">上記内容で更新してよろしいでしょうか?</p>
								</div>
							</div>
							<div class="row">
								<div class="col s12">
									<div class="col s6 center-align">
										<button class="btn  waves-effect waves-light  col s6 offset-s3" type="submit" name="confirmButton" value="cancel">戻る</button>
									</div>

									<div class="col s6 center-align">
										<button class="btn  waves-effect waves-light  col s6 offset-s3" type="submit" name="confirmButton" value="update">更新</button>
									</div>
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