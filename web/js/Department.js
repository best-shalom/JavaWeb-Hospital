function DeleteDepartment(D_Id) {
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
        xhr.send('D_Id=' + encodeURIComponent(D_Id));
    }
}
function ReviseDepartment(D_Id) {
    window.location.href = './DepartmentInformation.jsp?D_Id=' + D_Id;
}
function goBack() {
    history.back();
}