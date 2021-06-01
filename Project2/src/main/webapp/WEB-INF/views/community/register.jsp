<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/community/register.css">
<link rel="stylesheet" href="/resources/css/includes/header.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/header.js"></script>

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
			<li><a href="/community/list" id="thisPage">커뮤니티</a></li>
		</ul>
		
		
	</nav>
	
	<section>
		<form role="form" action="/community/register" method="post">
			<table>
				<tr>
					<td class="h1Td">
						<h1>커뮤니티 글쓰기</h1>
					</td>
				</tr>
				<tr>
					<td class="tdlabel">
						<label>카테고리</label>
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="category" value="piano">피아노토크
						<input type="radio" name="category" value="qna" class="categoryMenu">질문
						<input type="radio" name="category" value="talk" class="categoryMenu">잡담
					</td>
				</tr>
				
				<tr>
					<td class="tdlabel">
						<label>제목</label>
					</td>
				</tr>
				<tr>
					<td class="titleTd">
						<input type="text" name="title" placeholder="제목">
					</td>
				</tr>
				
				<tr>
					<td class="tdlabel">
						<label>내용</label>
					</td>
				</tr>
				<tr>
					<td>
						<textarea rows="31" name="content" placeholder="내용을 입력하세요"></textarea>
					</td>
				</tr>
				
				<tr>
					<td class="tdlabel" id="regBtnTd">
						<input type="hidden" name="writer" value="${loginMember.nickname }">
						<input type="hidden" name="id" value="${loginMember.id }">
						
						<button type="reset" id="resetBtn">초기화</button>
						<button type="submit" id="submitBtn">작성</button>
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