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
</head>
<body>
<form action="PatientUpdate" method="post">
    <table>
        <%--将从病人主页传来的id隐藏传入UpdateServlet--%>
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
        <%--第一行:姓名--%>
        <tr>
            <td><label for="name">姓名</label> </td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <%--第二行:密码--%>
        <tr>
            <td><label for="password">密码</label> </td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <%--第三行:年龄--%>
        <tr>
            <td><label for="age">年龄</label> </td>
            <td><input type="text" name="age" id="age"></td>
        </tr>
        <%--第四行:性别--%>
        <tr>
            <td><input type="radio" name="sex" value="男">男</td>
            <td><input type="radio" name="sex" value="女">女</td>
        </tr>
        <%--第五行:更新+重置按钮--%>
        <tr>
            <td><input type="submit" value="更新"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
