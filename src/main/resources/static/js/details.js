$(document).ready(function() {
    var linkStudent = "http://localhost:8080/student/detail";
    const studentid = localStorage.getItem("studentid");
    
    if (!studentid) {
        alert("Không tìm thấy thông tin sinh viên.");
        return;
    }

    // Khởi tạo DataTable nếu `studentid` hợp lệ
    $.ajax({
        url: `http://localhost:8080/student/detail?id=${studentid}`, // Sử dụng `studentid` trong URL
        type: "GET",
        dataType: "json" // sửa từ `datatype` thành `dataType`
    })
    .done(function(msg) {
        if (msg.status === 0 && msg.data) {
            var student = msg.data;
            $("#mssv").text(student.msv); 
            $("#name").text(student.fullname); 
            $("#gender").text(student.gender === "men" ? "Nam" : "Nữ");
            $("#dateOfBirth").text(student.dob); 
            $("#cccd").text(student.cccd); 
            $("#email").text(student.student_email); 
            $("#address").text(student.district); 
            $("#class").text(student.specialized_class)
        }
        else {
            alert("Không tìm thấy thông tin sinh viên.");
        }
    })
    .fail(function(xhr, status, error) {
        console.error("Lỗi khi lấy dữ liệu sinh viên:", error);
        alert("Đã xảy ra lỗi khi tải thông tin sinh viên.");
    });
});
