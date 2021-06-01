<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/membership/loginForm.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/membership/loginForm.js"></script>

<title>Insert title here</title>
</head>
<body>

<div class="container">
	
	<form action="/membership/login" method="post">
		<table>
			<tr>
				<td>
					<a href="/">
					<img src="../../../resources/images/logo1_big.png">
					</a>
				</td>
			</tr>
			<tr>
				<td class="loginTd">로그인</td>
			</tr>
			
			<!-- 
			<c:if test="${errorMessage == fail } ">
			</c:if>
			 -->
				<tr>
					<td class="loginfail">
						
					</td>
				</tr>

			
			<tr>
				<td class="titleTd">이메일</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="id" name="id" placeholder="example@naver.com">
				</td>
			</tr>
			<tr>
				<td class="titleTd">비밀번호</td>
			</tr>
			<tr>
				<td>
					<input type="password" id="pw" name="password" placeholder="********">
				</td>
			</tr>
			<tr>
				<td class="membershipTd">
					<a href="/membership/newMember">회원가입하기</a>
				</td>
			</tr>
			<tr>
				<td class="submitTd">
					<input type="submit" id="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
</div>

<div class="backgrourndAside">
	<!-- 
	<img src="../../../resources/images/photo6.jpg">
	 -->
</div>

</body>
</html>