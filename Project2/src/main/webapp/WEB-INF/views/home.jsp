<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/home.css">
<link rel="stylesheet" href="/resources/css/includes/header.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/home.js"></script>
<script type="text/javascript" src="/resources/js/header.js"></script>

<title>나 혼자 피아노 친다</title>
</head>
<body>
<div class="container">
	<header>
		<%@include file="includes/header.jsp" %>
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
		<div class="banner">
			<img src="../../../resources/images/banner.png">
		</div>
		
		<div class="bestPlaying">
			<h3>인기연주영상</h3>
			<table class="firstTable">
			<c:forEach items="${list}" var="pboard">
				
				<tr>

					<td rowspan="2" class="profileImg">
						<img src="../../../resources/images/profile.png">
					</td>
					<td>
						<a class="pagingMove" href='<c:out value="${pboard.bno }"/>'>
							<c:out value="${pboard.title }"/> 
						</a>
					</td>
				</tr>
				<tr>
					<td class="boardWriter">
						<c:out value="${pboard.writer }"/>
					</td>
				</tr>
				
			</c:forEach>
			</table>
			
			<table>
			<c:forEach items="${list2}" var="pboard2">
				
				<tr>

					<td rowspan="2" class="profileImg">
						<img src="../../../resources/images/profile.png">
					</td>
					<td>
						<a class="pagingMove" href='<c:out value="${pboard2.bno }"/>'>
							<c:out value="${pboard2.title }"/> 
						</a>
					</td>
				</tr>
				<tr>
					<td class="boardWriter">
						<c:out value="${pboard2.writer }"/>
					</td>
				</tr>
				
			</c:forEach>
			</table>
		</div>
		
		<form id="actionForm" action="/playing/list" method="get">
		</form>
		
		<div class="newClass">
			<h2>실시간 TOP 클래스</h2>

			<c:forEach items="${list3}" var="oboard">
			
				<table>
					<tr>
						<td class="classFirstTd">
							<a class="pagingMove2" href='<c:out value="${oboard.bno }"/>'>
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
						<td class="classTitle">
							<a class="pagingMove2" href='<c:out value="${oboard.bno }"/>'>
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

		</div>
	</section>
	
	
	
	<footer>
		<%@include file="includes/footer.jsp" %>
	</footer>
	<!-- 
	<div class="fixed">
		<div class="fixedTitle">
		<span>인터스텔라 Interstellar OST - First Step</span>
		</div>
		<div class="fixedPlaying">
			<iframe src="https://www.youtube.com/embed/Acv8deK5Rok?rel=0&amp;autoplay=1&mute=1&amp;loop=1;" title="YouTube video player" frameborder="0" allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</div>
	</div>
	 -->
</div>
</body>
</html>
