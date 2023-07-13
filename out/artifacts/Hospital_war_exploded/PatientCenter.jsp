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
    <style>
        .welcome-message {
            font-size: 18px;
            margin-left: 1300px;
        }
        ul.navbar {
            list-style-type: none;
            margin: 0;
            padding: 0;
            background-color: #f1f1f1;
            overflow: hidden;
        }

        ul.navbar li {
            float: left;
        }

        ul.navbar li a {
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        ul.navbar li a:hover:not(.active) {
            background-color: #ddd;
        }

        .active {
            background-color: #4CAF50;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
    <script>
        function showMessage(message) {
            alert(message);
        }
    </script>
</head>
<body>
    <h1>
        桂林市医院统一预约挂号服务平台
    </h1>
<%--    <span class="welcome-message">--%>
<%--        欢迎<%= Name %>使用桂林市医院统一预约挂号服务平台--%>
<%--    </span>--%>
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