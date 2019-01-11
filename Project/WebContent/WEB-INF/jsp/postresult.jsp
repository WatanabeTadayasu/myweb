<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了</title>

</head>
<body>


  <div class="form-post">
    <label for="exampleFormControlInput1">ログインID</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" name="user_id" value="${bdb.userId}" readonly>
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
				<p class="center-align">上記内容で登録しました。</p>
			</div>
		</div>
		<div class="row">
			<div class="col s12">
				<p class="center-align">
					<a href="Index" class="btn waves-effect waves-light  col s8 offset-s2">トップページへ</a>
				</p>
			</div>
		</div>



</body>
</html>