<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/sheet/register.css">
<link rel="stylesheet" href="/resources/css/includes/header.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/header.js"></script>
<!-- 
<script type="text/javascript" src="/resources/js/sheet/modify.js"></script>
 -->
 
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
		<form role="form" action="/sheet/modify" method="post">
		
		<!-- 수정 완료된 후 보고있던 페이지로 돌아가기 위해 -->
		<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum }'/>">
		<input type="hidden" name="amount" value="<c:out value='${cri.amount }'/>">
		<!-- 검색조건과 키워드 유지하기 위해 -->
		<input type="hidden" name="type" value="${pageMaker.cri.type }">
		<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
		
			<table>
				<tr>
					<td class="h1Td">
						<h1>글 수정</h1>
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
						<label>난이도</label>
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="difficulty" value="veryeasy">매우쉬움
						<input type="radio" name="difficulty" value="easy" class="categoryMenu">쉬움
						<input type="radio" name="difficulty" value="normal" class="categoryMenu">보통
						<input type="radio" name="difficulty" value="difficulty" class="categoryMenu">어려움
						<input type="radio" name="difficulty" value="verydifficulty" class="categoryMenu">매우어려움
					</td>
				</tr>
				
				<tr>
					<td class="tdlabel">
						<label>제목</label>
					</td>
				</tr>
				<tr>
					<td class="titleTd">
						<input type="text" name="title" value="<c:out value='${sboard.title }'/>">
					</td>
				</tr>
				
				<tr>
					<td class="tdlabel">
						<label>가격</label>
					</td>
				</tr>
				
				<tr>
					<td class="titleTd">
						<input type="text" name="price" value="<c:out value='${sboard.price }'/>">
					</td>
				</tr>
				
				<tr>
					<td class="tdlabel">
						<label>내용</label>
					</td>
				</tr>
				<tr>
					<td>
						<textarea rows="31" name="content"><c:out value='${sboard.content }'/></textarea>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="file" name="uploadFile" multiple>
					</td>
				</tr>
				<tr>
					<td class="uploadResult">
						<ul>
						
						</ul>
					</td>
				</tr>
				
				<tr>
					<td class="tdlabel" id="regBtnTd">
						<input type="hidden" id="bno" name="bno" value="<c:out value='${sboard.bno }'/>">
						
						<button type="reset" id="resetBtn">초기화</button>
						<button type="submit" id="submitBtn">수정</button>
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