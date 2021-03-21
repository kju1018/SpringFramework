<%-- page 지시자 --%>
<!-- page 지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>

<%-- taglib 지시자 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>Spring</title>
	<!--application: ServletContext 객체(웹 애플리케이션 실행 정보를 가지고 있는 객체) 참조  -->
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/bootstrap-4.6.0/css/bootstrap.min.css">
	<script src="<%=application.getContextPath()%>/resources/js/jquery-3.5.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap-4.6.0/js/bootstrap.bundle.min.js"></script>
	<script src="<%=pageContext.getRequest().getServletContext().getContextPath()%>/resources/bootstrap-4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
  	uid: ${userTemp.uid} <br/>
  	upassword: ${userTemp.upassword}<br/>
  	urepassword: ${userTemp.urepassword}<br/>
  	uname: ${userTemp.uname} <br/>
  	uaddress1: ${userTemp.uaddress1} <br/>
  	unumber1: ${userTemp.unumber1} <br/>
  	unumber2: ${userTemp.unumber2} <br/>
  	unumber3: ${userTemp.unumber3} <br/>
  	uemail: ${userTemp.uemail} <br/>
  	uyear: ${userTemp.uyear} <br/>
  	umonth: ${userTemp.umonth} <br/>
  	uday: ${userTemp.uday} <br/>
  
</div>
</body>
</html>