<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<form action="Choose" method="post">
    <input type="radio" name="choose" value="doctor">我是医生
    <input type="radio" name="choose" value="patient">我是病人
    <input type="submit" value="提交">
</form>
</body>
</html>
