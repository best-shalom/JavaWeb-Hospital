<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医生登录</title>
</head>
<body>
<form action="DoctorLogin" method="post">
    <table>
        <%--第一行:id--%>
        <tr>
            <td><label for="name">姓名</label> </td>
            <td><input type="text" name="name" id="name"></td>

        </tr>
        <%--第二行:密码--%>
        <tr>
            <td><label for="password">密码</label> </td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <%--第三行:登录+重置按钮--%>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
<a href="DoctorRegister.jsp">
    <input type="button" value="注册">
</a>
</body>
</html>
