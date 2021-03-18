<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%-- 메뉴 내용 부분 --%>
<div>
  mehtod1form.jsp
  <hr>
  <div class="alert alert-primary">
  	현재 요청 방식: <span id="method">${method}</span>
  </div>
	<!-- 여기 action이 함수이름인지 Requestmapping주소인지 jsp주소인지 -->
	<!-- Requestmapping주소 -->
	<%--(1) <%=application.getContextPath()%>/exam02/method1--%>
	<!-- (2) method1  (1) (2) 둘 다 가능-->
	<h6>&lt;form&gt; 이용</h6>
	<form method="get" action="method3" class="mb-2 d-inline-block">
  		<input type="submit" class="btn btn-success mb-2" value="GET 전송">
  	</form>
  
	<form method="post" action="method3" class="mb-2 d-inline-block">
	  	<input type="submit" class="btn btn-success mb-2" value="POST 전송">
	</form>
	  
	<form method="put" action="method3" class="mb-2 d-inline-block">
		<input type="submit" class="btn btn-success mb-2" value="PUT 전송">
	</form>
	  
	<form method="delete" action="method3" class="mb-2 d-inline-block">
		<input type="submit" class="btn btn-success mb-2" value="DETE 전송">
	</form> 
  
  <hr/>
	<h6>AJAX 이용</h6>
	<button class="btn btn-info btn-sm" onclick="sendGet()">AJAX GET 방식 요청</button>
	<script>
		const sendGet = () => {
			$.ajax({url:"ajaxmethod3", method:"get"})
			.then(data => {/*1. 여기 data가*/
				$("#method").html(data.method);/*2. 여기 data*/
				/* data여기까지가 json객체  */
				
			});
		};
		
	</script>
	
	<button class="btn btn-info btn-sm" onclick="sendPost()">AJAX POST 방식 요청</button>
		<script>
		const sendPost = () => {
			$.ajax({url:"ajaxmethod3", method:"POST"})
			.then(data => { 
				$("#method").html(data.method);
			
			});
		};
		
		</script>
	
	<button class="btn btn-info btn-sm" onclick="sendPut()">AJAX PUT 방식 요청</button>
	<script>
		const sendPut = () => {
			$.ajax({url:"ajaxmethod3", method:"put"})
			.then(data => {
				$("#method").html(data.method);
			});
		};
		
	</script>
	<button class="btn btn-info btn-sm" onclick="sendDelete()">AJAX DELETE 방식 요청</button>
	<script>
		const sendDelete = () => {
			$.ajax({url:"ajaxmethod3", method:"delete"})
			.then(data => {
				$("#method").html(data.method);
			});
		};
		
	</script>
</div>
<%-- 메뉴 내용 부분 --%>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
