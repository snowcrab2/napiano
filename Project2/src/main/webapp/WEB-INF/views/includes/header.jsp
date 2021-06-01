<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<div id="headerTop">
			<div id="memberInfo">
				<!-- 로그아웃 상태일때만 노출 -->
				<c:if test="${loginMember.nickname == null}">
					<table>
						<tr>
							<td>
								<a href="/membership/loginForm">
									로그인
								</a>
							</td>
							<td>
								<span class="verticalBar">
									ㅣ
								</span>
							</td>
							<td>
								<a href="/membership/newMember">
									회원가입
								</a>
							</td>
						</tr>
					</table>
				</c:if>
				
				<!-- 로그인 상태일때 -->
				<c:if test="${loginMember.nickname != null}">
				<form action="/membership/logout" method="post" class="membershipForm">
					<table>
						<tr>
							<td>
								<a href="${loginMember.id }" class="memberModify">${loginMember.nickname }님 반갑습니다</a>
							</td>
							<td>
								<span class="verticalBar">
									ㅣ
								</span>
							</td>
							<td>
								<input type="submit" id="logoutBtn" value="로그아웃">
							</td>
						</tr>
					</table>
				</form>
				</c:if>
			</div>
		</div>
		<div id="headerLogo">
			<a href="/">
			<img src="../../../resources/images/logo1_big.png">
			</a>
		</div>