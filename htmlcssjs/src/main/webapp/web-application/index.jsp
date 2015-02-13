<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp" %>

<h1>การทำงานของ Web Application</h1>
<div class="prev-next-button">
    <button onclick="window.location.href = ''">< ย้อนกลับ</button>
    &nbsp;
    <button onclick="window.location.href = ''">ต่อไป > </button>
</div>

<img src="<%= request.getServletContext().getContextPath()%>/static/image/web-application.JPG"/>

<%@include file="/template/footer.jsp" %>
