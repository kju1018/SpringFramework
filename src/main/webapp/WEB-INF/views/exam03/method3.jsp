<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div>
	<!-- user는 클래스명 -->
  	uid: ${user.uid} <br/>
  	uname: ${user.uname} <br/>
  	upassword: ${user.upassword}<br/>
  	uhobby: 
	<c:forEach var="hobby" items="${user.uhobby}">
		${hobby},
	</c:forEach><br/>
  	ujob: ${user.ujob}<br/>
  
</div>
 <%@ include file="/WEB-INF/views/common/footer.jsp" %>           	
             