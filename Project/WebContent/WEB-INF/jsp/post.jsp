<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>投稿</title>
</head>
<body>
	<br>

<div class="topicpost">

	<h1>記事作成</h1>

</div>

<form>

  <div class="form-post">
    <label for="exampleFormControlInput1">ログインID</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" value="${udb.loginId}" readonly>
  </div>

  <div class="form-post">
    <label for="exampleFormControlSelect1">カテゴリ選択</label>
    <select name="thread_category_id">
	<c:forEach var="dmdb" items="${dmdbList}" >
		<option value="${dmdb.id}">${dmdb.name}</option>
	</c:forEach>
	</select>

    <!-- <select class="form-control" id="exampleFormControlSelect1">
      <option>旅行・日記</option>
      <option>暮らし・ライフスタイル</option>
      <option>外食</option>
      <option>スポーツ・ゲーム</option>
      <option>映画</option>
      <option>ニュース</option>
    </select> -->
  </div>

  <div class="form-post">
    <label for="exampleFormControlInput1">タイトル</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="タイトル">
  </div>

  <div class="form-post">
    <label for="exampleFormControlTextarea1">本文</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="5"></textarea>
  </div>

  <a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">投稿</a>

</form>

	<br>
	<div class="container">
		<div class="row center">
			<h5 class=" col s12 light">カートアイテム</h5>
		</div>
		<div class="row">
			<div class="section"></div>
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<form action="BuyConfirm" method="POST">
							<div class="row">
								<table class="bordered">
									<thead>
										<tr>
											<th class="center" style="width: 20%">商品名</th>
											<th class="center">単価</th>
											<th class="center" style="width: 20%">小計</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cartInItem" items="${cart}" >
											<tr>
												<td class="center">${cartInItem.name}</td>
												<td class="center">${cartInItem.price}円</td>
												<td class="center">${cartInItem.price}円</td>
											</tr>
										</c:forEach>
										<tr>
											<td class="center"></td>
											<td class="center"></td>
											<td class="center">
												<div class="input-field col s8 offset-s2 ">
													<select name="thread_category_id">
														<c:forEach var="dmdb" items="${dmdbList}" >
															<option value="${dmdb.id}">${dmdb.name}</option>
														</c:forEach>
													</select> <label>投稿カテゴリ</label>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="row">
								<div class="col s12">
									<button class="btn  waves-effect waves-light  col s4 offset-s4" type="submit" name="action">投稿確認</button>
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