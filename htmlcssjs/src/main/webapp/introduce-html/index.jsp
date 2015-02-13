<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp" %>

<h1>รู้จักกับ HTML (Hyper Text Markup Language)</h1>
<div class="prev-next-button">
    <button onclick="window.location.href = ''">< ย้อนกลับ</button>
    &nbsp;
    <button onclick="window.location.href = ''">ต่อไป > </button>
</div>

<div class="page-left">
    <div class="page-left-content">
        <h3>ตัวอย่างที่ 1 </h3>
        example1.html
        <pre>
            <code class="html">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-html/example1.html"),
                            out
                    );
                %>
            </code>
        </pre>
        <strong>คำอธิบาย</strong>
        <p>
            Html เป็นภาษาที่ใช้สำหรับแสดงผลข้อมูลบนเว็บไซต์ (Web Site)
            <br/>
            <br/>
            โครงสร้างของภาษาจะประกอบไปด้วยแท็ก (&lt;Tag&gt;) ต่างๆ มากมาย
            เพื่อใช้สำหรับแสดงผลข้อมูลในแต่ละรูปแบบ
            <br/>
            <br/>
            การเขียน Html แท็กทั้งหมด
            จะอยู่ภายใต้แท็ก &lt;html&gt;...&lt;/html&gt;
            <br/>
            ซึ่งภายในแท็ก &lt;html&gt; ก็จะแบ่งการทำงานออกเป็น 2 ส่วนหลักๆ  ได้แก่ &lt;head&gt; กับ &lt;body&gt;
        <div class="html-description">
            &lt;html&gt;
            <div>&lt;head&gt;</div>
            <div>&lt;body&gt</div>
        </div>
        <br/>
        <br/>
        <strong>* ส่วน &lt;head&gt;</strong><br/>
        <p>
            - เป็นส่วนหัวของเว็บเพจ 
            <br/>
            - เป็นส่วนที่เอาไว้อธิบายเว็บ
            <br/>
            - เป็นส่วนที่เอาไว้เก็บ meta data ของ page นั้นๆ 
            <br/>
            <br/>
            จะถูกโหลดและ operate ก่อนเป็นส่วนแรก
            <br/>
            code อะไรก็ตามที่เราต้องการให้ทำก่อนที่ browser จะเริ่มแสดงผลเว็บไซต์
            ให้เอามาไว้ที่ส่วนนี้
        </p>
        <strong>* ส่วน &lt;body&gt;</strong><br/>
        <p>
            เป็นส่วนสำหรับแสดงผลเนื้อหาของเว็บไซต์  เนื้อหาที่เราเห็นตามเว็บต่างๆ  จะอยู่ในแท็ก &lt;body&gt;
        </p>
    </div>
</div>
<div class="page-right">
    <strong>ผลลัพธ์</strong>
    <div class="example-iframe">
        <iframe src="example1.html"></iframe>
        <button class="iframe-reload-button">โหลดผลลัพธ์ใหม่</button>
    </div>
</div>
<div class="clear"></div>
<hr/>
<div class="page-left">
    <div class="page-left-content">
        <p>
            การเขียน Html เราจะเขียนด้วย Syntax ของภาษา Html
            <br/>
            แต่จะบันทึกเป็น file นามสกุล . อะไรก็ได้  
            <br/>
            ที่รองรับ (Support) ภาษา Html
            เช่น 
            <br/>
            <br/>
            .html
            <br/>
            .jsp
            <br/>
            .php
            <br/>
            .asp
            <br/>
            ...
        </p>
    </div>
</div>
<div class="page-right">
    
</div>
<div class="clear"></div>
<hr/>
<div class="page-left">
    <div class="page-left-content">
        <h3>ตัวอย่างที่ 2 </h3>
        example2.html
        <pre>
            <code class="html">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-html/example2.html"),
                            out
                    );
                %>
            </code>
        </pre>
    </div>
</div>
<div class="page-right">
    <strong>ผลลัพธ์</strong>
    <div class="example-iframe">
        <iframe src="example2.html"></iframe>
        <button class="iframe-reload-button">โหลดผลลัพธ์ใหม่</button>
    </div>
</div>
<div class="clear"></div>
<hr/>
<div class="page-left">
    <div class="page-left-content">
        <h3>ตัวอย่างที่ 3 </h3>
        example3.html
        <pre>
            <code class="html">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-html/example3.html"),
                            out
                    );
                %>
            </code>
        </pre>
    </div>
</div>
<div class="page-right">
    <strong>ผลลัพธ์</strong>
    <div class="example-iframe">
        <iframe src="example3.html" style="height: 400px;"></iframe>
        <button class="iframe-reload-button">โหลดผลลัพธ์ใหม่</button>
    </div>
</div>
<div class="clear"></div>
<style>
    .html-description{
        background-color: #eee;
        padding: 10px;
    }

    .html-description > div{
        margin: 10px;
        padding: 10px;
    }

    .html-description > div:first-child{
        background-color: rgb(255, 194, 194);
    }

    .html-description > div:first-child + div{
        background-color: rgb(164, 255, 158);
    }
</style>

<%@include file="/template/footer.jsp" %>
