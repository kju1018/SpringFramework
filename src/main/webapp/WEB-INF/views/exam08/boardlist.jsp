<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, com.mycompany.webapp.dto.*" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card">
	<div class="card-header">
		${role}게시물 목록
	</div>
	
	<div class="card-body">
		<%-- 메뉴 내용 부분 --%>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.bno}</td>
					<!--read?bno= {} bno는 파라미터 이름 Controller에서 바로 받음  -->
					<td><a href="read?bno=${board.bno}">${board.btitle}</a></td>
					<td>${board.bwriter}</td>				
					<td><fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/></td>
					<td>${board.bhitcount}</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="5" class="text-center">
					<div class="d-flex">
						<div class="flex-grow-1">
							<!--[처음][이전] 1 2 3 4 5 [다음][맨끝] -->
							<a class="btn btn-outline-primary btn-sm"
							href="list?pageNo=1">처음</a>
							
							<c:if test="${pager.groupNo>1}">
								<a class="btn btn-outline-info btn-sm"
									href="list?pageNo=${pager.startPageNo-1}">이전</a>
							</c:if>
							
							<c:forEach var="i" begin="${pager.startPageNo}" end="${pager.endPageNo}">
								<c:if test="${pager.pageNo!=i}">
									<a class="btn btn-outline-success btn-sm" href="list?pageNo=${i}">${i}</a>
								</c:if>
								
								<c:if test="${pager.pageNo==i}">
									<a class="btn btn-danger btn-sm" href="list?pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
							
							<c:if test="${pager.groupNo<pager.totalGroupNo}">
								<a class="btn btn-outline-info btn-sm"
									href="list?pageNo=${pager.endPageNo+1}">다음</a>
							</c:if>
							
							<a class="btn btn-outline-primary btn-sm"
							href="list?pageNo=${pager.totalPageNo}">맨끝</a>
						</div>
						<sec:authorize access="isAuthenticated()">
							<a class="btn btn-outline-success btn-sm"
								href="createForm">글쓰기</a>
						</sec:authorize>
						
					</div>
				</td>
			</tr>
			
		</table> 
	</div>
</div>
              
<%@ include file="/WEB-INF/views/common/footer.jsp" %>