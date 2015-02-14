
var button = document.getElementById("my_button");
button.addEventListener('click', function() {
    alert('คลิกแล้วขึ้นข้อความ : ' + this.id + ' นี้อีกแล้ว');
});