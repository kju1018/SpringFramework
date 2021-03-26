<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div>
	<div class="alert alert-primary">
		로그인
	</div>

	<!-- http://localhost:8080까지만 생략 -->
	<form method="post" action="<%=application.getContextPath()%>/login">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<div class="form-group">
			<label for="uid">아이디</label>
			<input type="text" class="form-control" id="uid" name="uid">
		</div>

		<div class="form-group">
			<label for="upassword">비밀번호</label>
			<input type="password" class="form-control" id="upassword" name="upassword">
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>
 <%@ include file="/WEB-INF/views/common/footer.jsp" %>           	
             