<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>ユーザ一覧画面</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href = "css/style.css">
  </head>

<body>

<div align="right">
<header class="head">



<a href="Logout">ログアウト</a>
</header>
</div>

<div align="center">
<h1>ユーザー一覧</h1>
</div>
<!-- <div align="right">
<a href="Regist">新規登録</a>
</div> -->

<form method="post" action="UserListServlet" class="form-horizontal">

    <div class="form-group col-md-6">
      <label for="inputCity">ログインID</label>
      <input type="text" name="loginId" class="form-control" id="inputCity">
    </div>


    <div class="form-group col-md-6">
      <label for="inputCity">ユーザー名</label>
      <input type="text" name="name" class="form-control" id="inputCity">
    </div>

<div class="boxContainer">
<div class="box">

      <label for="inputCity">生年月日</label>
      <input type="Date" name="birthdate" value="1990-09-09" class="form-control" id="inputCity">

</div>
    ～
<div class="box">

      <input type="Date" name="birthdate1" value="2018-09-09" class="form-control" id="inputCity">

</div>
</div>

<div class="sub">
    <button type="submit" class="btn btn-primary">検索</button>
</div>

</form>

	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ログインID</th>
					<th>ユーザ名</th>
					<th>生年月日</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="UserDataBeans" items="${userList}">
					<tr>
						<td>${UserDataBeans.loginId}</td>
						<td>${UserDataBeans.name}</td>
						<td>${UserDataBeans.birthdate}</td>
						<!-- TODO 未実装；ログインボタンの表示制御を行う -->

						<c:if test="${userId == 1}">
							<td><a class="btn btn-primary"
								href="UserDetailServlet?userId=${UserDataBeans.id}">詳細</a> <a
								class="btn btn-success"
								href="UserData?userId=${UserDataBeans.id}">更新</a> <a
								class="btn btn-danger"
								href="UserDeleteServlet?userId=${UserDataBeans.id}">削除</a></td>
						</c:if>
						<c:if test="${userId != 1}">
							<td><a class="btn btn-primary"
								href="UserDetailServlet?userId=${UserDataBeans.id}">詳細</a>
								<c:if test="${userId == UserDataBeans.id}">
									<a class="btn btn-success"
										href="UserData?userId=${UserDataBeans.id}">更新</a>
								</c:if></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<a href="Index">戻る</a>

</body>
</html>
