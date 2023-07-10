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
    <title>病人注册</title>
    <style>
        .password-message {
            position: absolute;
            top: 65px;
            left: 280px; /* 调整 left 值来控制提示信息的水平位置 */
            margin-top: 5px;
            font-size: 14px;
            color: red;
        }
    </style>
    <script>
        function showMessage(message) {
            alert(message);
        }
        function validatePassword() {
            var password = document.getElementById("password").value;
            var SurePassword = document.getElementById("SurePassword").value;
            var message = document.getElementById("passwordMessage");

            if (password === SurePassword) {
                message.innerHTML = "密码匹配";
                message.style.color = "green";
            } else {
                message.innerHTML = "密码不匹配";
                message.style.color = "red";
            }
        }
        function updateAgeValue(value) {
            document.getElementById("ageValue").textContent = value;
        }
    </script>
</head>
<body>
<form action="PatientRegister" method="post">
    <table>
        <%--第一行:姓名--%>
        <tr>
            <td><label for="name">姓名</label> </td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <%-- 第二行:密码 --%>
        <tr>
            <td><label for="password">密码</label></td>
            <td><input type="password" name="password" id="password" oninput="validatePassword()"></td>
        </tr>
        <%-- 第三行:确认密码 --%>
        <tr>
            <td><label for="SurePassword">确认密码</label></td>
            <td><input type="password" name="SurePassword" id="SurePassword" oninput="validatePassword()"></td>
        </tr>
        <tr>
            <td colspan="2"><span class="password-message" id="passwordMessage"></span></td>
        </tr>
        <!-- 第四行:年龄 -->
        <tr>
            <td><label for="age">年龄</label></td>
            <td>
                <input type="range" name="age" id="age" min="0" max="100" oninput="updateAgeValue(this.value)">
            </td>
            <td><span id="ageValue"></span></td>
        <%--第五行:性别--%>
        <tr>
            <td><input type="radio" name="sex" value="男">男</td>
            <td><input type="radio" name="sex" value="女">女</td>
        </tr>
        <%--第六行:邮箱--%>
        <tr>
            <td><label for="email">邮箱</label> </td>
            <td><input type="text" name="email" id="email"></td>
        </tr>
        <%--第七行:身份证号码--%>
        <tr>
            <td><label for="idCard">身份证号码</label> </td>
            <td><input type="text" name="idCard" id="idCard"></td>
        </tr>
        <%--第八行:出生年月--%>
        <tr>
            <td><label for="DateOfBirth">出生年月</label> </td>
            <td><input type="date" name="DateOfBirth" id="DateOfBirth" pattern="\d{4}-\d{2}-\d{2}"><td>
        </tr>
        <%--第九行:手机号码--%>
        <tr>
            <td><label for="PhoneNumber">手机号码</label> </td>
            <td><input type="text" name="PhoneNumber" id="PhoneNumber"></td>
        </tr>
        <%--第十行:注册+重置按钮--%>
        <tr>
            <td><input type="submit" value="注册"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
<a href="PatientLogin.jsp">
    <input type="button" value="登录">
</a>
<% if (request.getAttribute("Errormessage") != null) { %>
<script>
    showMessage("<%= request.getAttribute("Errormessage") %>");
</script>
<% } %>

</body>
</html>
