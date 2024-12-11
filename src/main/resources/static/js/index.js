$(document).ready(function() {
    var linkStudent = "http://localhost:8080/student/detail";
    const studentid = localStorage.getItem("studentid");


    // Khởi tạo DataTable nếu `studentid` hợp lệ
    $.ajax({
        url: `http://localhost:8080/student/detail?id=${studentid}`, // Sử dụng `studentid` trong URL
        type: "GET",
        dataType: "json" // sửa từ `datatype` thành `dataType`
    })
    .done(function(msg) {
        if (msg.status === 0 && msg.data) {
            // Dữ liệu sinh viên
            var student = msg.data;

            // Cập nhật các thông tin vào bảng
            $("#fullName").text(student.fullname); // Thay đổi nội dung tên sinh viên
            $("#dateOfBirth").text(student.dob); // Cập nhật ngày sinh
            $("#gender").text(student.gender === "men" ? "Nam" : "Nữ"); // Cập nhật giới tính
        }
    })
});