<%
    int UserID = Integer.parseInt(request.getParameter("UserID"));
%><%--
  Created by IntelliJ IDEA.
  User: ZhangYe
  Date: 2023/7/10
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="hospital.service.PatientService" %>
<%@ page import="hospital.user.Patient" %>
<%@ page import="java.util.List" %>
<%@ page import="hospital.dao.impl.PatientDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>患者首页</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- 引入一个js文件 -->
    <script src="js/Patient.js"></script>

    <link rel="stylesheet" href="./css/patientshow.css">
</head>
<body>
<h1>桂林市医院统一预约挂号服务平台</h1>
<div>
    <!-- 导航栏 -->
    <ul class="navbar">
        <li><a href="./PatientCenter.jsp?UserID=<%= UserID %>">首页</a></li>
        <li><a href="./PatientShow.jsp?UserID=<%= UserID %>">个人信息</a></li>
        <li><a href="./PatientSelectHospital.jsp?UserID=<%= UserID %>">挂号</a></li>
    </ul>
</div>

<div>
    <h1>个人信息</h1>
    <div>
        <table>
            <thead>
            <tr>
                <th>用户名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>电话号码</th>
                <th>邮箱地址</th>
                <th>出生日期</th>
            </tr>
            </thead>
            <tbody>
            <%
                PatientDaoImpl patientdaoimpl = new PatientDaoImpl();
                Patient patient = patientdaoimpl.find(UserID);
            %>
            <tr>
                <td><%= patient.getName() %></td>
                <td><%= patient.getSex() %></td>
                <td><%= patient.getAge() %></td>
                <td><%= patient.getPhoneNumber() %></td>
                <td><%= patient.getEmail() %></td>
                <td><%= patient.getDateOfBirth() %></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
<a href="PatientUpdate.jsp?UserID=<%= UserID %>">
    <input type="button" value="修改个人信息">
</a>
<a href="PatientSickShow.jsp?UserID=<%= UserID %>">
    <input type="button" value="挂号信息">
</a>

<% if (request.getAttribute("Errormessage") != null) { %>
<script>
    showMessage("<%= request.getAttribute("Errormessage") %>");
</script>
<% } %>
</body>
</html>
