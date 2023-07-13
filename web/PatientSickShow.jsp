<% int UserID = Integer.parseInt(request.getParameter("UserID")); %><%--
  Created by IntelliJ IDEA.
  User: ZhangYe
  Date: 2023/7/10
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="hospital.service.PatientService" %>
<%@ page import="hospital.user.Patient" %>
<%@ page import="java.util.List" %>
<%@ page import="hospital.dao.impl.HospitalDaoImpl" %>
<%@ page import="hospital.user.Hospital" %>
<%@ page import="hospital.user.Sick" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户首页</title>
    <style>
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
</head>
<body>
<h1>桂林市医院统一预约挂号服务平台</h1>
<div>
    <!-- 导航栏 -->
    <ul class="navbar">
        <li><a href="./PatientCenter.jsp?UserID=<%= UserID %>">首页</a></li>
        <li><a href="./PatientShow.jsp?UserID=<%= UserID %>">个人信息</a></li>
        <li><a href="./PatientSelectHospital.jsp?UserID=<%= UserID %>">预约挂号</a></li>
        <li><a href="./PatientSickShow.jsp?UserID=<%= UserID %>">查看挂号信息</a></li>
    </ul>
</div>

<div>
    <h1>挂号信息</h1>
    <%
        PatientService patientService = new PatientService();
        int patientId = Integer.parseInt(request.getParameter("UserID"));
        List<Sick> sickList = patientService.SickShow(patientId);
        assert sickList != null;
    %>
    <div>
        <table>
            <thead>
            <tr>
                <th>病人姓名</th>
                <th>主治医生</th>
                <th>预约日期</th>
                <th>预约时间段</th>
                <th>医院名</th>
                <th>科室名</th>
                <th>预约状态</th>
                <th>支付状态</th>
                <th>支付金额</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%for (Sick s : sickList) {
            %>
            <tr>
                <td><%= s.getP_name() %></td>
                <td><%= s.getD_name() %></td>
                <td><%= s.getData() %></td>
                <td><%= s.getTime() %></td>
                <td><%= s.getHospitalname() %></td>
                <td><%= s.getDepartmentname() %></td>
                <td><%= s.getAppointmentstatus() %></td>
                <td><%= s.getPaymentstatus() %></td>
                <td><%= s.getPaymentamount() %></td>
                <td>
                    <a href="SickDelete?id=<%= s.getId() %>&choose=patient">
                        <input type="button" value="取消">
                    </a>
                </td>
                <td>
                    <a href="PatientSickUpdate.jsp?UserID=<%= s.getPatientId() %>&AppointmentID=<%= s.getId() %>">
                        <input type="button" value="修改">
                    </a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>

<%--</table>--%>
<%--<a href="PatientSickAdd.jsp?patientId=<%= patientId %>">--%>
<%--    <input type="button" value="新增挂号数据">--%>
<%--</a>--%>
</body>
</html>