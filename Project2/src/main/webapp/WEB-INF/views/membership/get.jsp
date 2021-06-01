<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/membership/get.css">
<link rel="stylesheet" href="/resources/css/includes/header.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/header.js"></script>
<script type="text/javascript" src="/resources/js/membership/get.js"></script>

<title>Insert title here</title>
</head>
<body>
	
<div class="container">
	<header>
		<%@include file="../includes/header.jsp" %>
	</header>
	
	<nav>
		
		<ul>
			<li><a href="/sheet/list">악보</a></li>
			<li><a href="/class/list">온라인클래스</a></li>
			<li><a href="/playing/list">연주영상</a></li>
			<li><a href="/community/list">커뮤니티</a></li>
		</ul>
		
		
	</nav>
	
	<section>
		<form action="/membership/modify" method="post" class="memberForm">
			<table>
				<tr>
					<td class="titleTd">
						<label>이메일</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<div class="idInput">
							<input type="text" id="id" name="id" value="<c:out value='${mboard.id }'/>" readonly>
						</div>
					</td>
				</tr>

				<tr>
					<td class="titleTd">
						<label>비밀번호</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<input type="password" id="password" name="password" value="<c:out value='${mboard.password }'/>">
					</td>
				</tr>

				<tr>
					<td class="titleTd">
						<label>닉네임</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<input type="text" id="nickname" name="nickname" value="<c:out value='${mboard.nickname }'/>">
					</td>
				</tr>

				<tr>
					<td class="titleTd">
						<label>전화번호</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<input type="text" class="phone" name="phone" value="<c:out value='${mboard.phone }'/>">
					</td>
				</tr>

				
				<tr>
					<td class="titleTd">
						<label>생일</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<input type="text" id="birth" name="birth" value="<c:out value='${mboard.birth }'/>" readonly>
					</td>
				</tr>
				<tr>
					<td class="birth_fail">
					
					</td>
				</tr>

				<tr>
					<td class="submitTd">
						<input type="submit" id="submit" value="수정">
						<input type="submit" id="removeBtn" value="탈퇴">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<footer>
		<%@include file="../includes/footer.jsp" %>
	</footer>
</div>
</body>
</html>