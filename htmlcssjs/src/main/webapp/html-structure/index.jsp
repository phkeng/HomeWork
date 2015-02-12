<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp" %>

        <h1>โครงสร้าง html</h1>
        <div class="page-left">
            <div class="page-left-content">
                <p>
                    ddddddd
                </p>
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
            </div>
        </div>
        <div class="page-right">
            <div>ตัวอย่าง</div>
            <iframe src="code.html"></iframe>
        </div>
                        
<%@include file="/template/footer.jsp" %>
