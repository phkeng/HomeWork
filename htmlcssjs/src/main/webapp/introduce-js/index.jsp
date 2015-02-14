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
ไม่ใช่ภาษา Java ที่ทำงานเป็น Script (หลายคนเข้าใจผิด)
<br/>
<br/>
Javascript เป็น dynamic language
คือไม่จำเป็นต้องมีการกำหนด type ให้กับตัวแปร  ก่อนที่จะนำตัวแปรนั้นไปใช้งาน<br/>
การแปลคำสั่งของ Javascript ใช้ Interpreter คือ อ่านไปแปลไป  
ไม่ได้แปลทีเดียว เหมือน compiler
<br/>
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
//int                
var integer = 0;

//float
var floatingPoint = 12.05;

//string
var string = "Hello World.";

//array
var arr = [10, 20, 40, 80, 100, 120];

//object
var object = {
    id : 123145,
    firstName : 'jittagorn',
    lastName : 'pitakmetagoon'
};

//object
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
แล้วถ้าเราไม่ใช้ var ล่ะ
<pre>
            <code class="js">
CONTEXT_PATH = '/cpe-learning';

START = 100;
            </code>
</pre>
จริงๆ แล้ว  มันคือ
<pre>
            <code class="js">
window.CONTEXT_PATH = '/cpe-learning';

window.START = 100;
            </code>
</pre>
<p>
window เป็น global variable ของ browser<br/> 
เป็นตัวแปร  ที่เอาไว้เก็บค่า configuration ต่างๆ ของหน้าจอ browser ปัจจุบัน
</p>
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
<p>
    เราสามารถเรียกได้อีกแบบ
</p>
<pre>
            <code class="js">
var result = add2Numbers.apply([2, 3]); //5
log.call('result is ' + result); // result is 5

isEventNumber.call(5); // false
isEventNumber.call(3); // false
isEventNumber.call(2); // true
isEventNumber.call(4); // true                
                
//หรือ

var result = add2Numbers.apply(null, [2, 3]); //5
log.call(null, 'result is ' + result); // result is 5

isEventNumber.call(null, 5); // false
isEventNumber.call(null, 3); // false
isEventNumber.call(null, 2); // true
isEventNumber.call(null, 4); // true
            </code>
</pre>
<h3>call vs apply</h3>
<p>
    call เป็น function ที่ใช้สำหรับเรียกใช้  function นั้นๆ อีกที<br/>
การส่ง parameter ลงไปใน call จะต้องระบุอย่างเจาะจง<br/>
<br/>
ถ้า function นั้นมี arguments 3 ตัว  ก็จะต้องส่ง parameters ลงไปใน call 3 ตัวเช่นกัน<br/>
เช่น
 <pre>
<code class="js">
var myFunct = function(arg1, arg2, arg3){

};
    
myFunct.call(null, 1,2,3);
</code>
<pre>
apply เป็น function ที่ใช้สำหรับเรียกใช้  function นั้นๆ อีกที เหมือน call<br/>
แต่การส่ง parameter ลงไปใน apply จะระบุเป็น array<br/>
ถ้า function นั้นมี arguments 3 ตัว  เราจะส่ง parameters เป็น array ที่มีสมาชิก 3 ตัวลงไป apply <br/>
เช่น
 <pre>
<code class="js">
var myFunct = function(arg1, arg2, arg3){

};
    
myFunct.apply(null, [1,2,3]);
</code>
<pre>
<p>
จะรู้ได้ยังไง  ว่าเมื่อไหร่ ควรใช้ call หรือ apply

ถ้าเราต้องการเรียก function แบบ dynamic arguments 
เราก็จะใช้ apply  เพราะ apply สามารถกำหนด  จำนวนของ arguments ใน function 
ได้แบบ dynamic (ตามจำนวนสมาชิกใน array)


<h3>ทำไมต้องใช้ call กับ apply ?</h3>
call กับ apply  เอามาใช้สำหรับการทำ javascript reflection<br/>
เดี๋ยวจะอธิบายให้ฟัง  หลังเรื่อง Object   
</p>
<p>
ถ้าเราไม่มี arguments รองรับ ใน function 
เราจะมีวิธีการไหนมั้ย  ที่รับค่า arguments นั้นๆ ได้    
</p>
 <pre>
<code class="js">
var myFunct = function(){
    //?????
};
    
myFunct.apply(null, [1,2,3,4,5]);
</code>
<pre>
ใช้ตัวนี้ default arguments
 <pre>
<code class="js">
var myFunct = function(){
    console.log(arguments);

    console.log(arguments[0]); //1
    console.log(arguments[1]); //2
    console.log(arguments[2]); //3
    console.log(arguments[3]); //4
    console.log(arguments[4]); //5
    
    console.log(arguments[5]); //undefined
};
    
myFunct.apply(null, [1,2,3,4,5]);
</code>
<pre>
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

    console.log(message); //hell world.

})('hell world.');


(function(number1, number2){

    var result = number1 + number2;
    console.log(result); //30

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
<h1 id="boolean">ตรรกศาสตร์ (Boolean) <a href="#boolean">mark</a></h1>
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
    <h1 id="equlas">ดำเนินการเปรียบเทียบ (== vs ===) <a href="#equals">mark</a></h1>
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
</pre>
<p>
<hr/>
<h1 id="object">วัตถุ (Object) <a href="#object">mark</a></h1>
<p>
object ใน javascript จะมีลักษณะเป็นแบบนี้
<pre>
<code class="js">
var object1 = {
    
};

var object2 = {
    id : '1234567890'
    firstName : 'jittagorn',
    lastName : 'pitakmetagoon',
    nickName : 'dear'
};

var object3 = {
    id : '1234567890'
    firstName : 'jittagorn',
    lastName : 'pitakmetagoon',
    nickName : 'dear',
    occupation : {
        name : 'programmer',
        skill : ['java', 'javascript', 'html', 'css', 'sq']
    }
};
</code>
</pre>
ข้อมูล object จะถูกเก็บไว้ในปีกกา { และ }
ซึ่งข้างในจะเป็นคู่  property / value
</p>
<p>
การดึงค่า object ออกมาแสดงผล  ทำได้ดังนี้ 
</p>
<pre>
<code class="js">
var object = {
    id : '1234567890',
    firstName : 'jittagorn',
    lastName : 'pitakmetagoon',
    nickName : 'dear',
    occupation : {
        name : 'programmer',
        skill : ['java', 'javascript', 'html', 'css', 'sq']
    },
    
    getId : function(){
        return this.id;
    },
    getFirstName : function(){
        return this.firstName;
    }
};

console.log(object.id); //1234567890
console.log(object.firstName); //jittagorn
console.log(object.lastName); //pitakmetagoon
console.log(object.nickName); //dear

console.log(object.occupation.name); //programmer
console.log(object.occupation.skill[0]); //java
console.log(object.occupation.skill[1]); //javascript
console.log(object.occupation.skill[2]); //html
console.log(object.occupation.skill[3]); //css
console.log(object.occupation.skill[4]); //sql
console.log(object.occupation.skill[5]); //undefined

console.log(object.birthday); //undefined

console.log(object.getId()); //1234567890
console.log(object.getFirstName()); //jittagorn
</code>
</pre>
<p>
ส่วนการกำหนดค่าลงไปใน object ทำได้ดังนี้
</p>
<pre>
<code class="js">
var object = {
    id : '1234567890',
    firstName : 'jittagorn',
    lastName : 'pitakmetagoon',
    nickName : 'dear',
    occupation : {
        name : 'programmer',
        skill : ['java', 'javascript', 'html', 'css', 'sq']
    },
    
    addSkill : function(sk){
        this.occupation.skill.push(sk);
    }
};

object.firstName = 'pamarin';

object.website = 'http://na5cent.blogspot.com'; //new property
object.email = 'jittagornp@gmail.com'; //new property
object['phone'] = '0812345678'; //new property
object['address'] = 'muengthon thani nonthaburi thailand 11120'; //new property

object.friends = []; //defined array
object.friends.push('suppachi');
object.friends.push('theerawat');
object.friends.push('wanpawee');
object.friends.push('thitima');

object.addSkill('ubuntu server');
object.addSkill('jasper report');
</code>
</pre>
<h1 id="call_apply">call vs apply <a href="#call_apply">mark</a></h1>
<p>
ประโยชน์ข้อหนึ่งของการใช้ call และ apply คือ
การทำ javascript reflection

การทำ dynamic call function
</p>
<pre>
<code class="js">
var showMessage = function(){
    console.log(this.message);
};

showMessage();
//undefined
</code>
</pre>
<p>
เนื่องจาก  ไม่มีการประกาศ  this.message
ทำให้การแสดงผลออกทาง console เป็น undefined    
</p>
เปลี่ยนใหม่
<pre>
<code class="js">
var object = {    
    message : 'hello everybody',
    showMessage : function(){
        console.log(this.message);
    }
};

object.showMessage();
//hello everybody
</code>
</pre>
มีค่า  เพราะ this.message เป็นตัวแปร  ของ object
<p>
แต่การเขียนแบบนี้มัน fixed code
คือ this.message จะไม่สามารถเป็น อย่างอื่นไปได้เลย
นอกจากเป็น message ของ object

function showMessage ขึ้นตรงกับ object เท่านั้น
เราไม่สามารถ reuse function นี้ได้

ถ้าเราอยาก reuse function นี้  เราจะทำยังไง?
<br/>
<br/>
<h3>การ reuse function</h3>
เราสามารถ  ส่งตัวแปร this.message จากข้างนอกเข้าไปได้ ดังนี้
</p>
<pre>
<code class="js">
var showMessage = function(){
    console.log(this.message);
};

var context1 = {
    message : 'hello mr. jittagorn'
};

showMessage.call(context1); 
//hello mr. jittagorn

var context2 = {
    message : 'good job'
};

showMessage.call(context2); 
//good job
</code>
</pre>
apply
<pre>
<code class="js">
var showMessage = function(){
    console.log(this.message);
};

var context1 = {
    message : 'hello mr. jittagorn'
};

showMessage.apply(context1);
//hello mr. jittagorn

var context2 = {
    message : 'good job'
};

showMessage.apply(context2);
//good job
</code>
</pre>
<p>
call และ apply จะทำการเปลี่ยน บริบท  หรือ context  ของ function ที่ถูกเรียก
ว่าจะให้ใช้งาน function นั้นด้วย context ใด หรือ object ใด
</p>
    <%@include file="/template/footer.jsp" %>
