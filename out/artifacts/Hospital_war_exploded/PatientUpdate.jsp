<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新个人信息</title>
    <link rel="stylesheet" href="./css/login.css">
    <link rel="stylesheet" href="./css/update.css">
</head>
<body>
<div class="top-bar">
    <div class="login-page">更新页面</div>
</div>
<form action="PatientUpdate" method="post">
    <table>
        <%--第一行:姓名--%>
        <tr>
            <td><label for="name">姓名</label> </td>
            <td><input type="text" name="name" id="name"></td>
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
            <td><label for="idCard" >身份证号码</label> </td>
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
        <%--第五行:更新+重置按钮--%>
        <tr>
            <td><input type="submit" value="更新"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>

<div class="bottom-bar"></div>
</body>
</html>
