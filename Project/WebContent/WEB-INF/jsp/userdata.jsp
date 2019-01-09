<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>ユーザー情報</title>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<div class="row center">
			<h5 class=" col s12 light">ユーザー情報</h5>
		</div>
		<div class="row">
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<form action="UserDataUpdateConfirm" method="POST">
							<c:if test="${validationMessage != null}">
								<p class="red-text center-align">${validationMessage}</p>
							</c:if>
							<br> <br>

							<!-- public UserDataBeans(int id, String loginId, String name, String password, String birthdate) { -->

							<div class="row">
								<div class="input-field col s6">
									<input type="text" name="login_id" value="${udb.loginId}" readonly> <label>ログインID</label>
								</div>
								<div class="input-field col s6">
									<input type="text" name="user_name" value="${udb.name}"> <label>名前</label>
								</div>
								<div class="input-field col s6">
									<input type="text" name="password" value="${udb.password}"> <label>パスワード</label>
								</div>
								<div class="input-field col s6">
									<input type="text" name="birthdate" value="${udb.birthdate}"> <label>生年月日</label>
								</div>
							</div>
							<%-- <div class="row">
								<div class="input-field col s12">
									<input type="text" name="user_address" value="${udb.address}"> <label>住所</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<input type="text" name="user_address" value="${udb.address}"> <label>住所</label>
								</div>
							</div> --%>
							<div class="row">
								<div class="col s12">
									<button class="btn  waves-effect waves-light  col s4 offset-s4" type="submit" name="action">更新</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--  購入履歴 -->
		<div class="row">
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<table class="bordered">
							<thead>
								<tr>
									<th style="width: 10%"></th>
									<th class="center">購入日時</th>
									<th class="center">配送方法</th>
									<th class="center">購入金額</th>
								</tr>
							</thead>
							<tbody>

			<!-- private int id;
			private int userId;
			private int totalPrice;
			private int delivertMethodId;
			private Date buyDate;
			private String deliveryMethodName;
			private int deliveryMethodPrice; -->

					<c:forEach var="bdbhList" items="${bdbhList}">
								<tr>
									<td class="center"><a href="UserBuyHistoryDetail?buy_id=${bdbhList.id}" class="btn-floating btn waves-effect waves-light "> <i class="material-icons">details</i></a></td>
									<td class="center">${bdbhList.buyDate}</td>
									<td class="center">${bdbhList.deliveryMethodName}</td>
									<td class="center">${bdbhList.totalPrice}円</td>
								</tr>
								<%-- <tr>
								・スレッドtitle
								・投稿時間
								・カテゴリ内容
									<td class="center"><a href="UserBuyHistoryDetail?buy_id=2" class="btn-floating btn waves-effect waves-light "> <i class="material-icons">details</i></a></td>
									<td class="center">${bdbhList.buyDate}</td>
									<td class="center">${bdbhList.deliveryMethodName}</td>
									<td class="center">${bdbhList.totalPrice}円</td>
								</tr> --%>
					</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

<a href="UserListServlet">戻る</a>

</body>
</html>