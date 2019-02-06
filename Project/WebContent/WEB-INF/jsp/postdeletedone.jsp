<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>削除完了</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
</head>
<body>

<div align="right">
		<header class="head">
			<a href="Logout"><span style="border-bottom: solid 1px #FFFFFF;">ログアウト</span></a>
		</header>
	</div>

	<div class="row">
		<div class="section"></div>
		<div class="col s6 offset-s3">
			<div class="card grey lighten-5">
				<div class="card-content">
					<div class="row">
						<div class="col s12">
							<br> <br>
							<c:if test="${cartActionMessage != null}">
								<p class="red-text center-align">
									<span>${cartActionMessage}</span>
								</p>
							</c:if>
							<br> <br> <br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- <div class="row">
		<div class="section"></div>
		<div class="col s6 offset-s3">
			<div class="card grey lighten-5">
				<div class="card-content">
					<div class="row">
						<div class="col s12">
							<br> <br> <br>
							<p class="center-align">削除完了しました。</p>
							<br> <br> <br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->

<a href="UserListServlet">戻る</a>

	<!-- <p>削除完了しました</p>

    <a href="UserListServlet">戻る</a> -->

</body>
</html>