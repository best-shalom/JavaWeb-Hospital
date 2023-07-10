<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>病人登录</title>
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
</head>
<body>
<form action="PatientLogin" method="post">
    <table>
        <!-- First row: Phone number -->
        <tr>
            <td><label for="PhoneNumber">手机号</label></td>
            <td><input type="text" name="PhoneNumber" id="PhoneNumber"></td>
        </tr>
        <!-- Second row: Password -->
        <tr>
            <td><label for="Password">密码</label></td>
            <td><input type="password" name="Password" id="Password"></td>
        </tr>

        <!-- Third row: Captcha -->
        <tr>
            <td><label for="validationCode">验证码</label></td>
            <td class="captcha-container">
                <input type="text" name="validationCode" id="validationCode" placeholder="请输入验证码" lay-verify="required">
                <img src="generateCaptcha.jsp" id="validationCode_img" title="看不清?换一个" onclick="loadimage();return false;" name="validationCode_img" align="middle">
            </td>
        </tr>

        <!-- Fourth row: Login and reset buttons -->
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
<a href="PatientRegister.jsp">
    <input type="button" value="注册">
</a>

<!-- Check if there is a login error message from the backend and show password error alert -->
<% if (request.getAttribute("Errormessage") != null) { %>
<script>
    showMessage("<%= request.getAttribute("Errormessage") %>");
</script>
<% } %>

</body>
</html>
