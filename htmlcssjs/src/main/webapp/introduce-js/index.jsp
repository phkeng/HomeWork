<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp" %>

<h1>รู้จักกับ Javascript</h1>
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
<h1 id="variable">ตัวแปร (Variable) <a href="#variable">mark</a></h1>
<p>
    เนื่องจาก javascript เป็น dynamic type  จึงไม่มีชนิดของ ตัวแปร<br/>
    เราจะประกาศตัวแปร  ด้วย keyword เดียวกัน  คือ var<br/>
    ไม่ว่าจะเป็นตัวแปรชนิดใดก็ตาม	<br/>
</p>
<pre>
            <code class="js">
var integer = 0;

var floatingPoint = 12.05;

var string = "Hello World.";

var arr = [10, 20, 40, 80, 100, 120];

var object = {
    id : 123145,
    firstName : 'jittagorn',
    lastName : 'pitakmetagoon'
};

var page = {
    offset : 0,
    size : 50,
    contents : [
        {
            name : 'apple'
        },
        {
            name : 'orange'
        },
        ...
    ]             
};
            </code>
</pre>
<hr/>
<h1 id="function">ฟังก์ชัน (function) <a href="#function">mark</a></h1>
ประกาศแบบนี้
<pre>
            <code class="js">
function add2Numbers(numb1, numb2){
    return numb1 + numb2;
}

function log(message){
    console.log(message);
}
            </code>
</pre>
ประกาศแบบนี้ก็ได้
<pre>
            <code class="js">
var add2Numbers = function(numb1, numb2){
    return numb1 + numb2;
};

var log = function(message){
    console.log(message);
};
                
var isEventNumber = function(number){
    return (number % 2) === 0;
};
            </code>
</pre>
สังเกตว่า arguments จะไม่มีการกำหนด data type หรือ keyword var
<h3>การเรียกใช้ฟังก์ชัน</h3>
<pre>
            <code class="js">
var result = add2Numbers(2, 3); //5
log('result is ' + result); // result is 5

isEventNumber(5); // false
isEventNumber(3); // false
isEventNumber(2); // true
isEventNumber(4); // true
            </code>
</pre>
<h3>Anonymous Function</h3>
<p>
    คือ function ที่เรียกใช้ครั้งเดียว แล้วทิ้งเลย
</p>
<pre>
<code class="js">
(function(){

    //do something ...

})();

(function(message){

    console.log(message);

})('hell world.');

(function(number1, number2){

    var result = number1 + number2;
    console.log(result);

})(10, 20);
    
</code>
<p>
   จริงๆ แล้ว  มันก็คือ function ธรรมดาๆ นี่แหล่ะ  
แค่เราเขียนลัดระหว่างการประกาศ และการเรียกใช้งานในขั้นตอนเดียว
</p>
<pre>
<code class="js">
var myFunc = function(){

};

//หรือ

function myFunc(){

}

//การเรียกใช้

myFunc();

//หรือ

(myFunc)();

//เขียนสั้นๆ เป็น

(function(){

})();
    
</code>
    </pre>
    <p>
        ทำไมต้องใช้ Anonymous Function ?
        <br/> 
        เพราะบางครั้ง  เราต้องการให้มีการทำงานบางอย่างที่ทำครั้งเดียว โดยไม่ต้องเอาไปใช้ในภายหลังอีก<br/>
        ข้อดีมากๆ ข้อนึงของ anonymous function คือ มันเป็น asynchronous
        มันจะไม่ block การแสดงผลของ browser
        <br/>
        <br/>
        โดยปกติ  เวลาที่ browser ทำการ load ข้อมูลหน้าเว็บนั้นๆ
        มันจะประมวลผล (interpret) ทีละบรรทัด

        ถ้า code บรรทัดไหน  ยังประมวลผล  ไม่เสร็จ  มันจะไม่ขยับ ไปประมวลผลคำสั่ง  บรรทัดถัดไป
        ซึ่งถ้ามีรูปภาพ  อยู่ข้างล่าง code ดังกล่าว  รูปภาพนั้น ก็จะยังไม่ถูก load ขึ้นมา  เนื่องจาก
        browser ยังประมวลผล  บรรทัดข้างบนยังไม่เสร็จ

        การทำงานแบบนี้  เราเรียกว่า Synchronous หรือ Sequencial
        <br/>
        <br/>
        แต่ก็มีการทำงานบางอย่าง  ที่ทำให้ ไม่ block การแสดงผล
        ซึ่งก็คือการทำงานแบบ Asynchronous นั่นเอง

        ทำให้หน้าเว็บเราทำงานได้เร็วขึ้น
        แต่ก็มีข้อเสีย  คือ  มันจะทำงานแบบไม่สนใจลำดับ
        ถ้าเขียน code ไม่ดี  อาจทำให้การประมวลผล  ผิดพลาดได้

        code ไหนที่มีความจำเป็นต่อ code อื่นๆ 
        ก็ให้มันเป็น Synchronous ไป
        ส่วน code ไหนที่มันไม่ต้องไปยุ่งกับ code อื่นๆ
        หรือ ไม่มี code อื่นๆ มาเรียกใช้มัน  ก็แนะนำให้เป็น Asynchronous เพราะมันเร็วกว่า
    </p>
    <hr/>
    <h1 id="boolean">Boolean <a href="#boolean">mark</a></h1>
    <p>
        ภาษา Javascript เป็นภาษา ที่ไม่มี  boolean type<br/>
        ตัวแปรทุกตัวใน Javascript จะเป็นจริง (true) ทั้งหมด  ยกเว้น ค่าดังต่อไปนี้ ที่จะเป็นเท็จ (false)<br/>
        1. 0<br/>
        2. null<br/>
        3. undefined
    </p>
    <pre>
<code class="js">
    if(1) { //true
        
    }
    
    if('0') { //true
    
    }
    
    if('hello world') { //true
    
    }
    
    if(0) { //false
    
    }
    
    if(null) { // false
    
    }
    
    if(undefined) { //false
    
    }
</code>
    </pre>
    <hr/>
    <h1 id="equlas">== vs === <a href="#equals">mark</a></h1>
    <p>
        == คือเปรียบเทียบการเท่ากัน<br/>
        === คือเปรียบเทียบการเท่ากัน <br/>

        แล้วมันต่างกันยังไง?<br/>

        == เปรียบเทียบ  โดยไม่สนใจ data type<br/>
        === เปรียบเทียบ  โดยเอา data type มาคิดด้วย<br/>
    </p>
<pre>
<code class="js">
if(1 == 1){ //true

}
    
if(1 == '1'){ //true

}

if(1 === '1'){ //false

}

if('1' === '1'){ //true

}
</code>
<p>

    <%@include file="/template/footer.jsp" %>
