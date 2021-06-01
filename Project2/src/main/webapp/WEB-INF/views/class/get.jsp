<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/class/get.css">
<link rel="stylesheet" href="/resources/css/includes/header.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/class/get.js"></script>
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
			<li><a href="/class/list" id="thisPage">온라인클래스</a></li>
			<li><a href="/playing/list">연주영상</a></li>
			<li><a href="/community/list">커뮤니티</a></li>
		</ul>
	
	</nav>
	
	<section>
		
		<div class="classImg">
			<img src="../../../resources/images/<c:out value='${oboard.imglink }'/>">
		</div>
		
		<div class="classInfo">
			<table>
				<tr>
					<td class="classWriter">
						<c:out value="${oboard.writer }"/>
					</td>
				</tr>
				<tr>
					<td class="classTitle">
						<c:out value="${oboard.title }"/>
					</td>
				</tr>
			
				<tr>
					<td class="priceTd">
						<c:out value="${oboard.price }"/>원
					</td>
				</tr>
				
				<tr>
					<td class="classRec">
						강의 만족도 <img src="../../../resources/images/like.png">
						<c:out value="${oboard.recommend }"/>
					</td>
				</tr>
				
				<tr>
					<td class="orderTd optionTd">
						<input type="button" value="강의추천" class="optionBtn recBtn">
						<input type="button" value="선물하기" class="optionBtn">
					</td>
				</tr>
				
				<tr>
					<td class="orderTd">
						<input type="button" value="수강신청하기" class="order">
					</td>
				</tr>
				
			</table>
		</div>
		
		<form id="operForm" action="/community/modify" method="get">
			<input type="hidden" id="bno" name="bno" value="<c:out value='${oboard.bno }'/>">
			
			<!-- 검색조건과 키워드 유지하기 위해 -->
			<input type="hidden" name="type" value="${pageMaker.cri.type }">
			<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
		</form>
		
	</section>
	
	<div class="listBtn">
		<button data-oper="list">목록</button>
	</div>
	
	<form id="operForm" action="/community/modify" method="get">
		<!-- 글 수정 눌렀을 때 가져갈 값 -->
		<input type="hidden" id="bno" name="bno" value="<c:out value='${cboard.bno }'/>">
		<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum }'/>">
		<input type="hidden" name="amount" value="<c:out value='${cri.amount }'/>">
		
			
		<!-- 검색조건과 키워드 유지하기 위해 -->
		<input type="hidden" name="type" value="${pageMaker.cri.type }">
		<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
	</form>
	
	<footer>
		<%@include file="../includes/footer.jsp" %>
	</footer>
</div>
</body>
</html>