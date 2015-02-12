<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp" %>

<h1>โครงสร้าง html</h1>
<div class="prev-next-button">
    <button onclick="window.location.href = ''">< ย้อนกลับ</button>
    &nbsp;
    <button onclick="window.location.href = ''">ต่อไป > </button>
</div>

<div class="page-left">
    <div class="page-left-content">
        <pre>
            <code class="html">
                <%
                    JspUtils.fromInputStream2JspWriter(
                            request.getServletContext().getResourceAsStream("/html-structure/code.html"),
                            out
                    );
                %>
            </code>
        </pre>
        <p>
            ddddddd
        </p>
    </div>
</div>
<div class="page-right">
    <div>ตัวอย่าง</div>
    <iframe src="code.html"></iframe>
</div>

<%@include file="/template/footer.jsp" %>
