<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認</title>

</head>
<body>

<form action="PostResult" method="POST">

  <div class="form-post">
    <label for="exampleFormControlInput1">ログインID</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" name="user_id" placeholder="${userId.loginId}" value="${bdb.userId}" readonly>
  </div>

  <div class="form-post">
    <label for="exampleFormControlSelect1">カテゴリ</label>
	<input type="text" class="form-control" id="exampleFormControlInput1" name="thread_category_id" placeholder="${dmdb.name}" value="${dmdb.id}" readonly>
  </div>

  <div class="form-post">
    <label for="exampleFormControlInput1">タイトル</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" name="thread_title" value="${bdb.threadTitle}" readonly>
  </div>

  <div class="form-post">
    <label for="exampleFormControlTextarea1">本文</label>
    <textarea ${bdb.threadText} class="form-control" id="exampleFormControlTextarea1" name="thread_text" rows="5" readonly></textarea>
  </div>

		<div class="row">
			<div class="col s12">
				<p class="center-align">上記内容で投稿してよろしいでしょうか?</p>
			</div>
		</div>
		<div class="row">
			<div class="col s6 center-align">
				<button class="btn  waves-effect waves-light" type="submit" name="confirm_button" value="cancel">修正</button>
			</div>
			<div class="col s6 center-align">
				<button class="btn  waves-effect waves-light" type="submit" name="confirm_button" value="regist">登録</button>
			</div>
		</div>

</form>





	<br>
	<br>
	<div class="container">
		<div class="row center">
			<h5 class=" col s12 light">購入</h5>
		</div>
		<div class="row">
			<div class="section"></div>
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<div class="row">
							<table class="bordered">
								<thead>
									<tr>
										<th class="center">商品名</th>
										<th class="center">単価</th>
										<th class="center">小計</th>
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

										<td class="center">${userSelectDMB.name}</td>
										<td class="center"></td>
										<td class="center">${userSelectDMB.price}円</td>
									</tr>
									<tr>
										<td class="center"></td>
										<td class="center">合計</td>
										<td class="center">${bdb.totalPrice}円</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="row">
							<div class="col s12">
								<form action="BuyResult" method="post">
									<button class="btn  waves-effect waves-light  col s4 offset-s4" type="submit">購入</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>