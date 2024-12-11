$(document).ready(function(){
    $("#btn-signin").click(function() {
        var email = $("#email").val()
        var passwords = $("#password").val()
        
        
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/login/signin",
            data: { 
                username: email, 
                passwords: passwords }
          })
          .done(function(msg) {
            console.log(msg); // Kiểm tra cấu trúc của phản hồi
            if (msg.data && msg.data.studentid) {
                localStorage.setItem("studentid", msg.data.studentid);
                window.location.href = "index.html";
            } else {
                alert("Đăng nhập thất bại, vui lòng kiểm tra lại.");
            }
        })
    });
})