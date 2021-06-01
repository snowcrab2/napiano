<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/playing/list.css">
<link rel="stylesheet" href="/resources/css/includes/header.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/playing/list.js"></script>
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

		<div class="asideCategory">
			<h3>CATEGORY</h3>
			<ul>
				<li><a href="/playing/list">전체</a></li>
				<li><a href="/playing/list?category=classic" class="categoryList">클래식</a></li>
				<li><a href="/playing/list?category=newage" class="categoryList">뉴에이지</a></li>
				<li><a href="/playing/list?category=OST" class="categoryList">OST</a></li>
				<li><a href="/playing/list?category=POP" class="categoryList">가요/POP</a></li>
			</ul>
		</div>

		
		
		<div class="boardSection">
		
		
			<c:forEach items="${list}" var="pboard">
				<table class="boardList">
					<tr>
						<td colspan="2" class="firstTd">
							<span>${pboard.link }</span>
						</td>
					</tr>
					<tr>
						<td rowspan="3" class="profileImg">
							<img src="../../../resources/images/profile.png">
						</td>
						<td>
							<a class="pagingMove" href='<c:out value="${pboard.bno }"/>'>
								<c:out value="${pboard.title }"/> 
								<span class="commentView">[<c:out value="${pboard.replycnt }"/>]</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<c:out value="${pboard.writer }"/>
						</td>
					</tr>
					<tr>
						<td class="boardInfo">
							조회수 <c:out value="${pboard.hit }"/>
							<span class="divider">·</span>
							추천수 <c:out value="${pboard.recommend }"/>
						</td>
					</tr>
				</table>
			</c:forEach>
			
			<form id="searchForm" action="/playing/list" method="get">
			<table class="searchTable">
				<tr>
					<td>
						<select name="type">
							<option value=""<c:out value="${pageMaker.cri.type == null?'selected':'' }"/>>--</option>
							<option value="T"<c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>제목</option>
							<option value="C"<c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>내용</option>
							<option value="TC"<c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>제목+내용</option>
							<option value="W"<c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>작성자</option>
						</select>
						<input type="text" name="keyword" id="search" placeholder="게시글을 검색하세요">
						<img src="../../../resources/images/loupe.png" id="searchBtn">
					</td>
					<td class="regBtnTd">
						<c:if test="${loginMember.id != null}">
							<button type="button" id="regBtn">글쓰기</button>
						</c:if>
					<td>
				</tr>
			</table>

		
				

		
		
		
		
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
			
		</div>
		
		
		<!-- 페이징 번호 클릭했을때 실행되는 form -->
		<form id="actionForm" action="/playing/list" method="get">
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