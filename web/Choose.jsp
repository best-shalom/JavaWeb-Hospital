<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>首页</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 83vh;
        }

        form {
            width: 400px;
            height: 100px;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 4px;
            text-align: center;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        h3 {
            font-size: 36px;
            /* 增加字体大小 */
            font-weight: bold;
            /* 设置为粗体 */
            color: #333;
            /* 修改为更适合页面的颜色 */
        }

        .radio-container {
            display: flex;
            /* 修改为flex布局 */
            align-items: center;
            margin-bottom: 20px;
        }

        input[type="button"] {
            padding: 12px 15px;
            width: 293px;
            height: 73px;
            font-size: 31px;
            border-radius: 4px;
            border: none;
            background-color: #00CC99;
            color: #fff;
            transition: background-color 0.3s;
            cursor: pointer;
            flex: 1;
        }

        input[type="button"]:hover {
            background-color: #00B38F;
        }
    </style>
    <script>
        function submitForm(role) {
            document.getElementById("choose").value = role;
            document.getElementById("chooseForm").submit();
        }
    </script>
</head>

<body>
<form id="chooseForm" action="Choose" method="post">
    <h3>请选择您的角色</h3>
    <div class="radio-container">
        <input type="button" onclick="submitForm('doctor')" value="医生" id="doctor">
    </div>
    <div class="radio-container">
        <input type="button" onclick="submitForm('patient')" value="病人" id="patient">
    </div>
    <div class="radio-container">
        <input type="button" onclick="submitForm('root')" value="管理员" id="root">
    </div>
    <input type="hidden" id="choose" name="choose">
</form>
</body>

</html>