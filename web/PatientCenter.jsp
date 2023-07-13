<%@ page import="hospital.user.Patient" %>
<%@ page import="hospital.dao.impl.PatientDaoImpl" %>
<%
    int UserID;
    if (request.getAttribute("UserID")!= null) {
        UserID = (int) (request.getAttribute("UserID"));
    } else {
        UserID = Integer.parseInt(request.getParameter("UserID"));
    }
//    PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
//    String Name = patientDaoImpl.find(UserID).getName();
%><%--
  Created by IntelliJ IDEA.
  User: ZhangYe
  Date: 2023/7/10
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户首页</title>
    <link rel="stylesheet" href="css/navbar.css">

</head>
<body>
    <h1>
        桂林市医院统一预约挂号服务平台
    </h1>
    <span class="welcome">
        欢迎<%= Name %>使用桂林市医院统一预约挂号服务平台
    </span>
</div>

<div>
    <!-- 导航栏 -->
    <ul class="navbar">
        <li><a href="./PatientCenter.jsp?UserID=<%= UserID %>">首页</a></li>
        <li><a href="./PatientShow.jsp?UserID=<%= UserID %>">个人信息</a></li>
        <li><a href="./PatientSelectHospital.jsp?UserID=<%= UserID %>">预约挂号</a></li>
        <li><a href="./PatientSickShow.jsp?UserID=<%= UserID %>">查看挂号信息</a></li>
    </ul>
</div>

<% if (request.getAttribute("Errormessage") != null) { %>
<script>
    showMessage("<%= request.getAttribute("Errormessage") %>");
</script>
<% } %>
</body>
</html>