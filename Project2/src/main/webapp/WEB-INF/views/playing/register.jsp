<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/playing/register.css">
<link rel="stylesheet" href="/resources/css/includes/header.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
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
			<li><a href="/playing/list" id="thisPage">연주영상</a></li>
			<li><a href="/community/list">커뮤니티</a></li>
		</ul>
		
		
	</nav>
	
	<section>
		<form role="form" action="/playing/register" method="post">
			<table>
				<tr>
					<td class="h1Td">
						<h1>연주영상 업로드</h1>
					</td>
				</tr>
				<tr>
					<td class="tdlabel">
						<label>카테고리</label>
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="category" value="classic">클래식
						<input type="radio" name="category" value="newage" class="categoryMenu">뉴에이지
						<input type="radio" name="category" value="OST" class="categoryMenu">OST
						<input type="radio" name="category" value="POP" class="categoryMenu">가요/POP
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
						<label>영상 링크</label>
					</td>
				</tr>
				
				<tr>
					<td class="titleTd">
						<input type="text" name="link" placeholder="링크 주소를 작성해주세요">
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
						<button type="reset" id="resetBtn">초기화</button>
						<button type="submit" id="submitBtn">작성</button>
						
					</td>
				</tr>
			</table>
			
			<!-- 작성 시 가져가야 할 값 -->
			<input type="hidden" name="writer" value="${loginMember.nickname }">
			<input type="hidden" name="id" value="${loginMember.id }">
		</form>
	</section>
	<footer>
		<%@include file="../includes/footer.jsp" %>
	</footer>
</div>
</body>
</html>