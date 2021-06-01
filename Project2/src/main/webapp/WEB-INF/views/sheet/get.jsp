<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/sheet/get.css">
<link rel="stylesheet" href="/resources/css/includes/header.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/sheet/reply.js"></script>
<script type="text/javascript" src="/resources/js/sheet/get.js"></script>
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
			<li><a href="/sheet/list" id="thisPage">악보</a></li>
			<li><a href="/class/list">온라인클래스</a></li>
			<li><a href="/playing/list">연주영상</a></li>
			<li><a href="/community/list">커뮤니티</a></li>
		</ul>
	
	</nav>
	
	<section>
		<div class="sectionHeder">
			<div class="profileImg">
				<img src="../../../resources/images/profile.png">
			</div>
			<div class="boardWriter">
				<strong><c:out value='${sboard.writer }'/></strong>
			</div>
			
			<!-- 작성자가 같을때(아이디) 수정,삭제 노출 -->
			<c:if test="${loginMember.id == sboard.id || loginMember.id == 'admin'}">
			<div class="boardModifyRemove">
				<button data-oper="modify">수정</button>
				<span class="divider">·</span>
				<button data-oper="remove">삭제</button>
			</div>
			</c:if>
			
			
			<div class="boardTimeHit">
				<span><fmt:formatDate pattern="MM/dd" value="${sboard.updateDate }"/></span>
				<span class="divider">·</span>
				<span>조회수 <c:out value="${sboard.hit }"/></span>
			</div>
		</div>
		<div class="boardContent">
			<h3><c:out value='${sboard.title }'/></h3>
			<c:out value="${sboard.content }"/>
			
			<table class="uploadResult">
				<tr>
					<td class="uploadTitle">첨부파일 목록</td>
				</tr>
				<tr>
					<td class="uploadTd">
						<ul>
						</ul>
					</td>
				</tr>
			</table>
			
		</div>


		
		<!-- 로그인 됐을때만 좋아요 버튼, 댓글쓰기 form 노출 -->
		<c:if test="${loginMember.nickname != null}">
			
			<!-- 댓글 작성 -->
			<div class="boardComment">
				<div class="CommentImg">
					<img src="../../../resources/images/profile.png">
				</div>
				<div class="CommentInput">
					<textarea placeholder="댓글을 작성해주세요" class="CommentText"></textarea>
					<button id="CommentBtn">작성</button>
				</div>
					
			</div>
			
			<!-- 댓글작성 버튼 눌렀을 때 가져갈 값 -->
			<input type="hidden" id="nickname" name="nickname" value="${loginMember.nickname }">
			<!-- 사용자 아이디 값 -->
			<input type="hidden" id="idValue" name="id" value="${loginMember.id }">
		</c:if>
		<!-- 댓글 목록 -->
		<div class="replyDiv">
			<ul class="replyUL">
				
			</ul>
		</div>
		<!-- 댓글 페이징 -->
		<div class="replyPageDiv">
		
		</div>
		
	</section>
	
	<div class="listBtn">
		<button data-oper="list">목록</button>
	</div>
	
	<form id="operForm" action="/community/modify" method="get">
		<!-- 글 수정 눌렀을 때 가져갈 값 -->
		<input type="hidden" id="bno" name="bno" value="<c:out value='${sboard.bno }'/>">
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