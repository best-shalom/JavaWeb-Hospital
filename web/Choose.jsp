<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        body {
            background-image: url('background.jpg');
            /* 设置背景图片的路径 */
            background-repeat: no-repeat;
            /* 控制背景图片是否重复显示 */
            background-size: cover;
            /* 控制背景图片的尺寸适应方式 */
        }
    </style>
</head>
<body>
<form action="Choose" method="post">
    <input type="radio" name="choose" value="doctor">我是医生
    <input type="radio" name="choose" value="patient">我是病人
    <input type="submit" value="提交">
</form>
</body>
</html>