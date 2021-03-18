<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%-- 메뉴 내용 부분 --%>
<div>
  mehtod1form.jsp
  <hr>
 <!-- 여기 action이 함수이름인지 Requestmapping주소인지 jsp주소인지 -->
  <!-- Requestmapping주소 -->
  <%-- <%=application.getContextPath()%>/exam02/method1 --%>
  <!-- method1  둘 다 가능-->
  <form method="post" action="method1">
  	<div class="form-group">
  		<label for="name">이름</label>
  		<input id="name" type="text" name="name" class="form-control"/>
  	</div>
  	<input type="submit" class="btn btn-success">
  </form>
</div>
<%-- 메뉴 내용 부분 --%>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
