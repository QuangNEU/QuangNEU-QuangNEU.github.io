$(document).ready(function() {
    const studentid = localStorage.getItem("studentid");

    if (!studentid) {
        alert("Không tìm thấy thông tin sinh viên.");
        return;
    }

    $.ajax({
        url: `http://localhost:8080/subject/grade?id=${studentid}`,
        type: "GET",
        dataType: "json"
    })
    .done(function(msg) {
        if (msg.status === 0 && msg.data) {
            var values = msg.data;
            var totalCredits = 0;
            var totalGrade =0;
            // Lặp qua từng môn học và thêm hàng vào bảng
            $.each(values, function(index, value) {
                const result = value.getDTB4 >= 1.0 ? "Đạt" : "Không đạt";
                
                totalCredits += value.credits;
                totalGrade += value.getDTB4 * value.credits;
                $("#table-body").append(`
                    <tr>
                        <td>${value.subject_name}</td>
                        <td>${value.credits}</td>
                        <td>${value.attendance_grade}</td>
                        <td>${value.midterm_grade}</td>
                        <td>${value.final_exam_grade}</td>
                        <td>${value.getDTB4.toFixed(1)}</td>
                        <td>${result}</td>
                    </tr>
                `);
            });
            const gpa = (totalCredits > 0) ? (totalGrade / totalCredits).toFixed(2) :"0.00";
            $("#totalcredits").html(`<b>Tổng số tín:</b> ${totalCredits}`);
            $("#GPA").html(`<b>GPA:</b>    ${gpa}`);
        } else {
            alert("Không tìm thấy thông tin sinh viên.");
        }
    })
    .fail(function(xhr, status, error) {
        console.error("Lỗi khi lấy dữ liệu sinh viên:", error);
        alert("Đã xảy ra lỗi khi tải thông tin sinh viên.");
    });
});
