<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, com.mycompany.webapp.dto.*" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card">
	<div class="card-header">
		게시물 목록
	</div>
	
	<div class="card-body">
		<%-- 메뉴 내용 부분 --%>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.bno}</td>
					<td>${board.btitle}</td>
					<td>${board.bcontent}</td>
					<td>${board.bwriter}</td>
					<td><fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/></td>
					<td>${board.bhitcount}</td>
				</tr>
			</c:forEach>
			
		</table> 
	</div>
</div>
              
<%@ include file="/WEB-INF/views/common/footer.jsp" %>