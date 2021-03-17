<%@ page contentType="text/html; charset=UTF-8"%>

<ul class="nav flex-column">
  <li class="nav-item">
    <h6 class="text-white">Controller</h6>
    <!--href안에 값들은 Controller의 RequestMapping안의 주소  -->
    <a class="nav-link text-warning" href="<%=application.getContextPath()%>">
    	홈페이지
    </a>
    <a class="nav-link text-warning" href="<%=application.getContextPath()%>/exam01/boardlist">
    	데이터를 JSP로 전달
    </a>
    <a class="nav-link text-warning" href="<%=application.getContextPath()%>/exam02/method1form">
    	한글 복원을 위한 문자 인코딩
    </a>
     <a class="nav-link text-warning" href="<%=application.getContextPath()%>/exam02/method2">
		리다이렉트(요청 재 지정)
	</a>
  </li>
</ul>