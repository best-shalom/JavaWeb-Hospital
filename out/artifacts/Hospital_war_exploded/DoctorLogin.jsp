<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医生登录</title>
    <style>
        .form-row {
            display: flex;
            align-items: center;
        }

        .form-row label {
            margin-right: 8px;
        }

        .captcha-container {
            display: flex;
            align-items: center;
            margin-bottom: 16px;
        }

        .captcha-container input {
            margin-left: 8px;
        }
    </style>
    <script>
        // Define a function to show password error alert
        function showMessage(message) {
            alert(message);
        }
        // Function to reload captcha image
        function loadimage() {
            document.getElementById("validationCode_img").src = "generateCaptcha.jsp?time=" + new Date().getTime();
        }
    </script>
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
<div class="top-bar">
    <div class="login-page">登录页面</div>
</div>
<!-- 创建居中的容器 -->
<form action="DoctorLogin" method="post">
    <table>
        <tr>
            <td><label for="phone">手机号</label></td>
            <td><input type="text" name="phone" id="phone"></td>
        </tr>
        <tr>
            <td><label for="password">密码:</label></td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td><label for="validationCode">验证码</label></td>
            <td class="captcha-container">
                <input type="text" name="validationCode" id="validationCode" placeholder="请输入验证码" lay-verify="required">
                <img src="generateCaptcha.jsp" id="validationCode_img" title="看不清?换一个"
                     onclick="loadimage();return false;" name="validationCode_img" align="middle">
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="重置"></td>

        </tr>
        <tr>
            <td>
                <a href="DoctorRegister.jsp">
                    注册
                </a>
            </td>
        </tr>
    </table>
</form>

</table>
<!-- Check if there is a login error message from the backend and show password error alert -->
<% if (request.getAttribute("Errormessage") != null) { %>
<script>
    showMessage("<%= request.getAttribute("Errormessage") %>");
</script>
<% } %>

<div class="bottom-bar"></div>
</body>
</html>
