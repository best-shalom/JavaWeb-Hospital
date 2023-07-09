<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="Choose" method="post">
    <input type="radio" name="choose" value="doctor" class="doctor-option">我是医生
    <input type="radio" name="choose" value="patient">我是病人
    <input type="radio" name="choose" value="root">我是管理员
    <br><br>
    <input type="submit" value="提交" class="submit-button">
</form>
</body>
</html>