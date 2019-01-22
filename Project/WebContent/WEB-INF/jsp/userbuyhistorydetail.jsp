<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>投稿履歴詳細</title>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<div class="row center">
			<h4 class=" col s12 light">投稿詳細</h4>
		</div>
		<!--  購入 -->
		<div class="row">
			<div class="col s10 offset-s1">
				<div class="card grey lighten-5">
					<div class="card-content">
						<table>
							<thead>
								<tr>
									<th class="center" style="width: 20%;">タイトル</th>
									<th class="center">本文</th>
								</tr>
							</thead>

							<!-- private int id;
	private int threadCategoryId;
	private String userId;
	private String threadTitle;
	private String threadText;
	private String createDate;
	private String threadCategoryName; -->

							<tbody>
								<tr>
									<td class="center">${bdbbb.threadTitle}</td>
									<td class="center">${bdbbb.threadText}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- 詳細 -->
		<div class="row">
			<div class="col s10 offset-s1">
				<div class="card grey lighten-5">
					<div class="card-content">
						<table class="bordered">
							<thead>
								<tr>
									<th class="center" style="width: 20%">商品名</th>
									<th class="center">単価</th>
								</tr>
							</thead>

							<!-- idb.setId(rs.getInt("id"));
							idb.setName(rs.getString("name"));
							idb.setPrice(rs.getInt("price")); -->

							<tbody>
						<c:forEach var="buyIDB" items="${buyIDBList}" >
									<tr>
										<td class="center">${buyIDB.name}</td>
										<td class="center">${buyIDB.price}円</td>
									</tr>
								</c:forEach>
								<tr>
									<td class="center">${bdbbb.threadTitle}</td>
									<td class="center">${bdbbb.threadText}円</td>
								</tr>
								<!-- <tr>
									<td class="center">サンプル商品名2</td>
									<td class="center">222222222円</td>
								</tr>
								<tr>
									<td class="center">サンプル商品名3</td>
									<td class="center">333333333円</td>
								</tr>
								<tr>
									<td class="center">サンプル</td>
									<td class="center">123456789円</td>
								</tr> -->
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