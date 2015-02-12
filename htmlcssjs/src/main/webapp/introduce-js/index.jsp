<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp" %>

<h1>1. รู้จักกับ Html (Hyper Text Markup Language)</h1>
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
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-html/code.html"),
                            out
                    );
                %>
            </code>
        </pre>
        <strong>คำอธิบาย</strong>
        <p>
            ddddddd
        </p>
    </div>
</div>
<div class="page-right">
    <strong>ตัวอย่าง</strong>
    <div class="example-iframe">
        <iframe src="code.html"></iframe>
        <button class="iframe-reload-button">โหลดตัวอย่างใหม่</button>
    </div>
</div>

<%@include file="/template/footer.jsp" %>
