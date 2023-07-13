function DeleteDepartment(hospitalId, departmentId) {
    var confirmation = confirm('是否要删除该科室？');
    if (confirmation) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', './DepartmentRemove', true); // 根据实际情况修改Servlet路径
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                console.log(xhr.status);
                if (xhr.status === 200) {
                    alert('删除成功！');
                    window.location.reload(); // 刷新页面
                } else {
                    console.log("NO");
                    alert('删除失败！');
                }
            }
        };
        xhr.send('hospitalId=' + encodeURIComponent(hospitalId) + '&departmentId=' + encodeURIComponent(departmentId));
    }
}
function ReviseDepartment(hospitalId, departmentId) {
    window.location.href = "DepartmentInformation.jsp?hospitalId=" + hospitalId + "&departmentId=" + departmentId;
}
function goBack() {
    history.back();
}