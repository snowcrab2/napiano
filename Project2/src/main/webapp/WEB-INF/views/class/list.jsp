<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/class/list.css">
<link rel="stylesheet" href="/resources/css/includes/header.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/class/list.js"></script>
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
		
		
			<c:forEach items="${list}" var="oboard">
				<table class="boardList">
					<tr>
						<td class="firstTd">
							<a class="pagingMove" href='<c:out value="${oboard.bno }"/>'>
								<img src="../../../resources/images/<c:out value='${oboard.imglink }'/>">
							</a>
						</td>
					</tr>
					<tr>
						<td class="classWriter">
							<c:out value="${oboard.writer }"/>
						</td>
					</tr>
					<tr>
						<td  class="classTitle">
							<a class="pagingMove" href='<c:out value="${oboard.bno }"/>'>
								<c:out value="${oboard.title }"/>
							</a>
						</td>
					</tr>
					<tr>
						<td class="classRec">
							<img src="../../../resources/images/like.png">
							<c:out value="${oboard.recommend }"/>
						</td>
					</tr>
					<tr>
						<td class="priceTd">
							<c:out value="${oboard.price }"/>원
						</td>
					</tr>

				</table>
			</c:forEach>
			
		<!-- 검색 -->
		<form id="searchForm" action="/class/list" method="get">
			<div class="searchTable">
				
						<select name="type">
							<option value=""<c:out value="${pageMaker.cri.type == null?'selected':'' }"/>>--</option>
							<option value="T"<c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>제목</option>
							<option value="C"<c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>내용</option>
							<option value="TC"<c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>제목+내용</option>
							<option value="W"<c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>작성자</option>
						</select>
						<input type="text" name="keyword" id="search" placeholder="클래스를 검색하세요">
						<img src="../../../resources/images/loupe.png" id="searchBtn">
				
						
	
			</div>

	
		
		
			<!-- 페이징 값을 같이 넘겨야함 -->
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
			
		</form>
			
			
			<!-- 페이징 -->
			<div id="boardPage">
				<ul>
					<c:if test="${pageMaker.prev }">
						<li class="paginateBtn">
							<a href="${pageMaker.startPage -1 }">
								<img src="../../../resources/images/left-arrow.png">
							</a>
						</li>
					</c:if>
					<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
						<li class="paginateBtn">
							<a href="${num }">${num }</a>
						</li>
					</c:forEach>
					<c:if test="${pageMaker.next }">
						<li class="paginateBtn">
							<a href="${pageMaker.endPage +1 }">
								<img src="../../../resources/images/next.png">
							</a>
						</li>
					</c:if>
				</ul>
				
			</div>
			

		
		
		<!-- 페이징 번호 클릭했을때 실행되는 form -->
		<form id="actionForm" action="/community/list" method="get">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
			<input type="hidden" name="type" value="${pageMaker.cri.type }">
			<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
		</form>
	</section>
	
	<footer>
		<%@include file="../includes/footer.jsp" %>
	</footer>
</div>
</body>
</html>