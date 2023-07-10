
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>管理员登录</title>
</head>
<body>
<form action="AdminLogin" method="post">
  <table>
    <%--第一行:id--%>
    <tr>
      <td><label for="A_Name">用户名</label> </td>
      <td><input type="text" name="A_Name" id="A_Name"></td>
    </tr>
    <%--第二行:密码--%>
    <tr>
      <td><label for="A_password">密码</label> </td>
      <td><input type="password" name="A_password" id="A_password"></td>
    </tr>
    <%--第三行:登录+重置按钮--%>
    <tr>
      <td><input type="submit" value="登录"></td>
      <td><input type="reset" value="重置"></td>
    </tr>
  </table>
</form>
</body>
</html>
