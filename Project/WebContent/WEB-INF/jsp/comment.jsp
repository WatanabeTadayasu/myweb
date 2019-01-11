<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href = "css/style.css">
<title>Insert title here</title>
</head>
<body>

<div class="box_0">

	<h1>題名.本文</h1>
	<p>ここにコメントここにコメントここにコメントここにコメントここにコメント</p>
	<a href="#" class="square_btn">良いでしょう</a>
</div>

<div class="box_1">

	<h2>靴</h2>
       <p>ここにコメントここにコメントここにコメントここにコメント</p>

</div>

<form>

  <div class="form-post">
    <label for="exampleFormControlInput1">名前</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="名前">
  </div>

  <div class="form-post">
    <label for="exampleFormControlTextarea1">本文</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="5"></textarea>
  </div>

  <a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">コメント</a>

</form>

</body>
</html>