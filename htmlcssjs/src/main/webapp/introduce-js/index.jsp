<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp" %>

<h1>1. รู้จักกับ Javascript</h1>
<div class="prev-next-button">
    <button onclick="window.location.href = ''">< ย้อนกลับ</button>
    &nbsp;
    <button onclick="window.location.href = ''">ต่อไป > </button>
</div>
<p>
    Javascript เป็นภาษาที่ใช้สำหรับเพิ่มลูกเล่นให้กับ Web site
    เป็นภาษาที่เอาไว้คำนวณ  ประมวลผล  ค่าต่างๆ  ทางฝั่ง browser

    เช่น  การทำ animation
    การ  คำนวน logic ต่างๆ ที่มีความซับซ้อน  
    ซึ่ง HTML และ CSS ไม่สามารถทำได้<br/><br/>
<div class="message-block">
    HTML แค่ show<br/>
    CSS แค่ทำให้สวยงาม<br/><br/>

    แต่ถ้าต้องการให้มีลูกเล่น + ประมวลผล  ต้องใช้ Javascript<br/>
</div>
<br/>
**** Javascript ไม่มีความเกี่ยวข้องใดๆ กับภาษา Java<br/>
ไม่ใช่ภาษา Java ที่ทำงานเป็น Script
<br/>
หลายคนเข้าใจผิด
<br/>
<br/>
Javascript เป็น dynamic language
คือไม่จำเป็นต้องมีการกำหนด type ให้กับตัวแปร  ก่อนที่จะนำตัวแปรนั้นไปใช้งาน<br/>
<br/>
เราสามารถเขียน Javascript ได้ 3 แบบ  เช่นเดียวกับ CSS
คือ inline, internal และ external
</p>
<br/>
<br/>
<h3>inline</h3>
<p>
    คือเขียนไว้บน HTML element นั้นๆ เลย
</p>
<div class="content-left">
    <div class="content-left-content">
        <pre>
            <code class="html">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-js/example1.html"),
                            out
                    );
                %>
            </code>
        </pre>
    </div>
</div>
<div class="content-right">
    <strong>ตัวอย่าง</strong>
    <div class="example-iframe">
        <iframe src="example1.html" style="height: 100px;"></iframe>
        <button class="iframe-reload-button">โหลดตัวอย่างใหม่</button>
    </div>
</div>
<div class="clear"></div>
<h3>internal</h3>
<p>
    คือ  แยก javascript ออกจาก Html element<br/>
    เขียนไว้  ภายใต้ tag &lt;script&gt;
</p>
<div class="content-left">
    <div class="content-left-content">
        <pre>
            <code class="html">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-js/example2.html"),
                            out
                    );
                %>
            </code>
        </pre>
    </div>
</div>
<div class="content-right">
    <strong>ตัวอย่าง</strong>
    <div class="example-iframe">
        <iframe src="example2.html" style="height: 100px;"></iframe>
        <button class="iframe-reload-button">โหลดตัวอย่างใหม่</button>
    </div>
</div>
<div class="clear"></div>
<h3>external</h3>
<p>
    เขียนแยกเป็นไฟล์ .js ต่างห่าง<br/> 
    แล้ว import เข้าไปด้วย tag  &lt;script&gt;
</p>
<div class="content-left">
    <div class="content-left-content">
        .html
        <pre>
            <code class="html">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-js/example3.html"),
                            out
                    );
                %>
            </code>
        </pre>
        .js
        <pre>
            <code class="js">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-js/example3.js"),
                            out
                    );
                %>
            </code>
        </pre>
    </div>
</div>
<div class="content-right">
    <strong>ตัวอย่าง</strong>
    <div class="example-iframe">
        <iframe src="example3.html" style="height: 100px;"></iframe>
        <button class="iframe-reload-button">โหลดตัวอย่างใหม่</button>
    </div>
</div>
<div class="clear"></div>
<hr/>
<h1 id="sequence">ลำดับในการประมวลผล <a href="#sequence">mark</a></h1>
<p>
    ตำแหน่งในการวาง tag script จะมีลำดับในการ ประมวลผลเสมอ<br/>
    เราไม่สามารถ  ใช้ javascript query ข้อมูลของ HTML DOM ได้  ก่อนที่ browser จะประมวลผล HTML DOM นั้นเสร็จ
</p>
<div class="content-left">
    <div class="content-left-content">
        <pre>
            <code class="html">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-js/example4.html"),
                            out
                    );
                %>
            </code>
        </pre>
    </div>
</div>
<div class="content-right">
    <strong>ตัวอย่าง</strong>
    <div class="example-iframe">
        <iframe src="example4.html" style="height: 100px;"></iframe>
        <button class="iframe-reload-button">โหลดตัวอย่างใหม่</button>
    </div>
</div>
<div class="clear"></div>
<p>
    แต่ถ้าเราวาง script แบบนี้
</p>
<div class="content-left">
    <div class="content-left-content">
        <pre>
            <code class="html">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-js/example5.html"),
                            out
                    );
                %>
            </code>
        </pre>
    </div>
</div>
<div class="content-right">
    <strong>ตัวอย่าง</strong>
    <div class="example-iframe">
        <iframe src="example5.html" style="height: 100px;"></iframe>
        <button class="iframe-reload-button">โหลดตัวอย่างใหม่</button>
    </div>
</div>
<div class="clear"></div>
<p>
    แต่!!!  เราสามารถวาง script ก่อน  แล้วให้มันประมวลผลทีหลังได้
</p>
<div class="content-left">
    <div class="content-left-content">
        <pre>
            <code class="html">
                <%
                    JspUtils.readContent(
                            request.getServletContext().getResourceAsStream("/introduce-js/example6.html"),
                            out
                    );
                %>
            </code>
        </pre>
        <p>
            window.addEventListener('load', function() { ... }); <br/>
            หมายถึง  รอให้ browser ทำการ load ข้อมูลหน้าเว็บเสร็จก่อน  แล้วค่อยประมวลผลสิ่งที่อยู่ใน function (){ ... }
        </p>
    </div>
</div>
<div class="content-right">
    <strong>ตัวอย่าง</strong>
    <div class="example-iframe">
        <iframe src="example6.html" style="height: 100px;"></iframe>
        <button class="iframe-reload-button">โหลดตัวอย่างใหม่</button>
    </div>
</div>
<div class="clear"></div>
<hr/>
<h1 id="syntax">Syntax <a href="#syntax">mark</a></h1>
<p>

</p>

<%@include file="/template/footer.jsp" %>
