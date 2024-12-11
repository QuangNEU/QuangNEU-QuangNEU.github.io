$(document).ready(function () {
    const studentid = localStorage.getItem("studentid");

    if (!studentid) {
        alert("Không tìm thấy thông tin sinh viên.");
        return;
    }

    // Khởi tạo DataTable nếu `studentid` hợp lệ
    $.ajax({
        url: `http://localhost:8080/schedule/detail?id=${studentid}`, // Sử dụng `studentid` trong URL
        type: "GET",
        dataType: "json" // sửa từ `datatype` thành `dataType`
    })
        .done(function (msg) {
            if (msg.status === 0 && msg.data) {
                var values = msg.data;
                const dayOrder = {
                    "Thu 2": 1,
                    "Thu 3": 2,
                    "Thu 4": 3,
                    "Thu 5": 4,
                    "Thu 6": 5,
                    "Thu 7": 6,
                };

                // Sắp xếp dữ liệu theo thứ và giờ bắt đầu
                values.sort(function (a, b) {
                    let dayA = dayOrder[a.thu];
                    let dayB = dayOrder[b.thu];
                    if (dayA !== dayB) return dayA - dayB;

                    let timeA = a.s_time;
                    let timeB = b.s_time;
                    return timeA.localeCompare(timeB);
                });

                // Hiển thị các lớp học trong bảng
                $.each(values, function (index, value) {
                    $("#schedule").append(`
                    <tr data-course-id="${value.classId}" data-student-id="${studentid}">
                        <td>${value.thu}</td>
                        <td>${value.subj_name}</td>
                        <td>${value.s_time} - ${value.e_time}</td>
                        <td>${value.room}</td>
                        <td><button class="cancel-btn" data-class-id="${value.classId}" data-student-id="${studentid}" type="submit">Hủy Tín</button></td>
                    </tr>
                `);
                });

                // Xử lý sự kiện click cho nút "Hủy Tín"
                $(document).on('click', '.cancel-btn', function () {
                    const courseId = $(this).data("class-id"); // Lấy course_id từ data-attribute
                    const studentId = $(this).data("student-id"); // Lấy student_id từ data-attribute
                    const row = $(this).closest('tr'); // Lấy dòng chứa nút hủy

                    if (!courseId) {
                        alert("Không tìm thấy ID môn học.");
                        return;
                    }

                    if (confirm("Bạn chắc chắn muốn hủy môn học này?")) {
                        // Gửi yêu cầu hủy tín (hủy đăng ký môn học)
                        $.ajax({
                            method: "POST",
                            url: "http://localhost:8080/schedule/cancel",
                            contentType: "application/json",  // Đảm bảo gửi dữ liệu dưới dạng JSON
                            dataType: "json",
                            data: JSON.stringify({
                                studentId: studentId,
                                courseId: courseId     // Gửi tham số courseId
                            }),
                            success: function (response) {
                                if (response.data === "Hủy tín thành công.") {
                                    alert("Hủy đăng ký môn học thành công.");
                                    row.remove();  // Xóa dòng đã hủy
                                } else {
                                    alert("Không thể hủy môn học này.");
                                }
                            },
                            error: function (xhr, status, error) {
                                console.error("Lỗi khi hủy môn học:", error);
                                alert("Đã xảy ra lỗi khi hủy môn học.");
                            }
                        });
                    }
                });
            } else {
                alert("Không tìm thấy thông tin sinh viên.");
            }
        })
        .fail(function (xhr, status, error) {
            console.error("Lỗi khi lấy dữ liệu sinh viên:", error);
            alert("Đã xảy ra lỗi khi tải thông tin sinh viên.");
        });
});
