function DeletePatient(Id) {
    var confirmation = confirm('是否要删除该用户？');
    if (confirmation) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', './PatientRemove', true); // 根据实际情况修改Servlet路径
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    alert('删除成功！');
                    window.location.reload(); // 刷新页面
                } else {
                    alert('删除失败！');
                }
            }
        };
        xhr.send('Id=' + encodeURIComponent(Id));
    }
}
function goBack() {
    history.back();
}