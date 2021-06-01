<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/membership/newMember.css">
<link rel="stylesheet" href="/resources/css/includes/footer.css">

<script src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/membership/newMember.js"></script>

<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div id="headImg">
		<img src="../../../resources/images/logo1_big.png">
	</div>
	
	<section>
		<form action="/membership/register" method="post">
			<table>
				<tr>
					<td class="titleTd">
						<label>이메일</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<div class="idInput">
							<input type="text" placeholder="이메일 입력" id="id" name="id">
						</div>
					</td>
				</tr>
				<tr>
					<td class="id_fail">
					
					</td>
				</tr>
				<tr>
					<td class="titleTd">
						<label>비밀번호</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<input type="password" placeholder="비밀번호(8~32자리)" id="password" name="password">
					</td>
				</tr>
				<tr>
					<td class="pw_fail">
					
					</td>
				</tr>
				<tr>
					<td class="viewTd secondTd">
						<input type="password" placeholder="비밀번호재입력" id="passwordChk">
					</td>
				</tr>
				<tr>
					<td class="pwchk_fail">
					
					</td>
				</tr>
				<tr>
					<td class="titleTd">
						<label>닉네임</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<input type="text" placeholder="닉네임을 입력해주세요(최대 20자)" id="nickname" name="nickname">
					</td>
				</tr>
				<tr>
					<td class="namechk_fail">
					
					</td>
				</tr>
				<tr>
					<td class="titleTd">
						<label>전화번호</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<input type="text" placeholder="- 없이 번호만 입력해주세요" class="phone" name="phone">
					</td>
				</tr>
				<!-- 
				<tr>
					<td class="phoneChk">
					
					</td>
				</tr>
				<tr>
					<td id="phoneChkBtn">
						<input type="button" value="인증번호전송">
					</td>
				</tr>
				 -->
				<tr>
					<td class="titleTd">
						<label>생일/성별</label>
					</td>
				</tr>
				<tr>
					<td class="viewTd">
						<input type="text" placeholder="ex) 20210512" id="birth" name="birth">
					</td>
				</tr>
				<tr>
					<td class="birth_fail">
					
					</td>
				</tr>
				<tr>
					<td class="genderTd">
						<input type="radio" name="gender" value="선택안함" checked>선택안함
						<input type="radio" name="gender" class="genderInput" value="여성">여성
						<input type="radio" name="gender" class="genderInput" value="남성">남성
					</td>
				</tr>
				<tr>
					<td class="submitTd">
						<input type="submit" id="submit" value="가입하기">
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