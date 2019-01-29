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
								<p class="red-text center-align"><span style="color:#ff0000;">${validationMessage}</span></p>
							</c:if>
							<br> <br>

							<!-- public UserDataBeans(int id, String loginId, String name, String password, String birthdate) { -->

							<div class="row">
								<div class="form-group col-md-6">
									<label>ログインID</label><input type="text" name="login_id" value="${udb.loginId}" readonly>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-6">
									<label>名前</label><input type="text" name="user_name" value="${udb.name}">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-6">
									<label>パスワード</label><input type="password" name="password" value="">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-6">
									<label>パスワード(確認)</label><input type="password" name="password1" value="">
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<label>生年月日</label><input type="text" name="birthdate" value="${udb.birthdate}">
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
	</div>

	<!--  投稿履歴 -->
	<div class="row center">
		<h5 class=" col s12 light">投稿履歴</h5>
	</div>

	<c:if test="${cartActionMessage != null}">
		<p class="red-text center-align">
			<span style="color: #2ca9e1;">${cartActionMessage}</span>
		</p>
	</c:if>

	<form action="PostDelete" method="POST">
				<div class="row">
					<div class="col s12">
						<div class="card grey lighten-5">
							<div class="card-content">
								<table class="bordered">
									<thead>
										<tr>
											<th style="width: 5%"></th>
											<th class="center">投稿時間</th>
											<th class="center">タイトル</th>
											<th class="center">カテゴリ</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="bdbhList" items="${bdbhList}"
											varStatus="status">

											<tr>
												<td class="center">
												<p>
												<input type="checkbox" id="${status.index}"
													name="delete_item_id_list" value="${bdbhList.id}" /> <label
													for="${status.index}">削除</label>
												</p>
												<a href="UserBuyHistoryDetail?thread_id=${bdbhList.id}"
													class="btn-floating btn waves-effect waves-light "> <i
														class="material-icons">details</i></a>
												</td>
												<td class="center">${bdbhList.createDate}</td>
												<td class="center">${bdbhList.threadTitle}</td>
												<td class="center">${bdbhList.threadCategoryName}</td>
											</tr>

										</c:forEach>
									</tbody>
								</table>
								<div class="row">
									<c:if test="${(status.index+1) % 4 == 0 }">
									</c:if>
								</div>
								<div class="row">
									<div class="col s12">
										<div class="col s6 center-align">
											<button
												class="btn waves-effect waves-light col s6 offset-s3 "
												type="submit" name="action">
												削除<i class="material-icons right">delete</i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>

	<%-- <div class="row">
		<div class="col s12">
			<div class="card grey lighten-5">
				<div class="card-content">
					<table class="bordered">
						<thead>
							<tr>
								<th style="width: 5%"></th>
								<th class="center">投稿時間</th>
								<th class="center">タイトル</th>
								<th class="center">カテゴリ</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bdbhList" items="${bdbhList}">
								<tr>
								<td class="center"><a href="UserBuyHistoryDetail?thread_id=${bdbhList.id}"
									class="btn-floating btn waves-effect waves-light"><i
									class="material-icons">details</i></a></td>
								<td class="center">${bdbhList.createDate}</td>
								<td class="center">${bdbhList.threadTitle}</td>
								<td class="center">${bdbhList.threadCategoryName}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div> --%>

	<a href="UserListServlet">戻る</a>

</body>
</html>