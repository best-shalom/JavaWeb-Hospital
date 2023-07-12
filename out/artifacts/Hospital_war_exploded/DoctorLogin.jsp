<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医生登录</title>
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


<div class="bottom-bar"></div>
</body>
</html>
