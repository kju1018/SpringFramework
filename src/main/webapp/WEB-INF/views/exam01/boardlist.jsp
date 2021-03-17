<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, com.mycompany.webapp.dto.*" %>

<%-- taglib 지시자 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Spring</title>
		<link rel="stylesheet" href="/webapp/resources/bootstrap-4.6.0/css/bootstrap.min.css">
		<script src="/webapp/resources/js/jquery-3.5.1.min.js"></script>
		<script src="/webapp/resources/bootstrap-4.6.0/js/bootstrap.bundle.min.js"></script>
		<script src="/webapp/resources/bootstrap-4.6.0/js/bootstrap.min.js"></script>
	</head>
  <body>
    <div class="d-flex flex-column vh-100">
     <%-- 헤더 부분 --%>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
      <div class="flex-grow-1 container-fluid">
        <div class="row h-100">
          <div class="col-md-4 p-3 bg-dark">
            <div class="h-100 d-flex flex-column">
              <div class="flex-grow-1" style="height:0px; overflow-y: auto; overflow-x: hidden;">
                <%-- 메뉴 부분 --%>
                <%@ include file="/WEB-INF/views/common/menu.jsp" %>
              </div>
            </div>
          </div>

          <div class="col-md-8 p-3">
            <div class=" h-100 d-flex flex-column">
              <div class="flex-grow-1 overflow-auto pr-3" style="height:0px">
                <%-- 메뉴 내용 부분 --%>
				<table class="table">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
						<th>글쓴이</th>
					</tr>
			
					<%-- Servlet04.java에 request.setAttribute("list", list); "list"는 <- 키 값 --%>
					<%-- board에 하나씩 꺼내서 넣어줌 $ {"키 값"}  ${} 이 형식은 EL--%>
					<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.bno}</td>
						<td>${board.btitle}</td>
						<td>${board.bcontent}</td>
						<td>${board.bwriter}</td>
					</tr>
					</c:forEach>
					
				</table>                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>

