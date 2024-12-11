$(document).ready(function() {
    var id = localStorage.getItem("studentid");

    // Declare global variable 'values' to store subject data
    var values = [];

    // Fetch the list of subjects
    $.ajax({
        method: "GET",
        url: `http://localhost:8080/subject/getlist?id=${id}`,
    })
    .done(function(msg) {
        values = msg.data;  // Assign data to the 'values' variable

        if (msg.status === 0 && values) {
            // Create a set to store course IDs that have already been added
            let addedCourses = new Set();
        
            // Loop through each subject and add it to the dropdown
            $.each(values, function(index, value) {
                // Check if the course_id is already in the set
                if (!addedCourses.has(value.course_id)) {
                    // If not, add it to the set and append the option to the dropdown
                    addedCourses.add(value.course_id);
                    $("#subject").append(`<option value="${value.course_id}">${value.subjectName}</option>`);
                }
            });
        } else {
            alert("Không tìm thấy thông tin sinh viên.");
        }
    })
    .fail(function(xhr, status, error) {
        console.error("Lỗi khi lấy dữ liệu sinh viên:", error);
        alert("Đã xảy ra lỗi khi tải thông tin sinh viên.");
    });

    // Listen for changes when a subject is selected
    $("#subject").change(function() {
        displaySubjectInfo(values);  // Call function to display subject info when selected
    });

    // Register subject
    $("#registerButton").click(function(event) {
        event.preventDefault();
    
        var selectedCourseId = $("#subject").val();
        if (!selectedCourseId) {
            alert("Vui lòng chọn môn học để đăng ký.");
            return;
        }
    
        console.log({
            studentId: id,
            courseId: selectedCourseId
        });
    
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/subject/register",
            contentType: "application/json",  // Ensure the content type is JSON
            dataType: "json",  // Expect JSON response
            data: JSON.stringify({
                studentId: parseInt(id),  // Chuyển đổi studentId sang kiểu int
                classId: parseInt(selectedCourseId)
            })
        })
        .done(function(response) {
            console.log(response); // Log the response
            if(response.data === false){
                alert("Bạn đã đăng kí môn học này")
            }
            else{
                if (response.status === 0) {
                    alert("Đăng ký thành công!");
                    updateSubjectDropdown();
                } else {
                    alert("Đã xảy ra lỗi khi đăng ký môn học.");
                }
            }
            
        })
        .fail(function(xhr, status, error) {
            console.error("Lỗi khi đăng ký môn học:", error);
            alert("Đã xảy ra lỗi khi đăng ký môn học.");
        });
    });
    

    // Function to display subject details
    function displaySubjectInfo(values) {
        var selectedCourseId = $("#subject").val();

        // Ensure data is available and find the selected subject
        var subjectData = values.find(function(subject) {
            return subject.course_id == selectedCourseId;
        });

        if (subjectData) {
            // Display subject info
            $("#credits").text(subjectData.credits);
            $("#subjectDetails").show();

            // Display classes of the selected subject
            $("#schedule").empty();  // Clear previous class data
            $.each(subjectData.listClasses, function(index, classInfo) {
                $("#schedule").append(`<option value="${classInfo.id}">${classInfo.day_of_the_week} - ${classInfo.start_time} đến ${classInfo.end_time} (Phòng: ${classInfo.room})</option>`);
            });
        } else {
            // If subject not found
            $("#subjectDetails").hide();
            alert("Không tìm thấy môn học này.");
        }
    }
    function updateSubjectDropdown() {
        var id = localStorage.getItem("studentid");
    
        // Lấy lại danh sách môn học từ server
        $.ajax({
            method: "GET",
            url: `http://localhost:8080/subject/getlist?id=${id}`,
        })
        .done(function(msg) {
            if (msg.status === 0 && msg.data) {
                var values = msg.data;
                $("#subject").empty();  // Xóa tất cả các option trong dropdown
                $("#subject").append('<option disabled selected>- Chọn môn học -</option>');  // Thêm option mặc định
    
                // Tạo lại các option trong dropdown
                $.each(values, function(index, value) {
                    $("#subject").append(`<option value="${value.course_id}">${value.subjectName}</option>`);
                });
            } else {
                alert("Không tìm thấy thông tin sinh viên.");
            }
        })
        .fail(function(xhr, status, error) {
            console.error("Lỗi khi lấy dữ liệu sinh viên:", error);
            alert("Đã xảy ra lỗi khi tải thông tin sinh viên.");
        });
}
});
