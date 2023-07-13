<%
    int UserID = Integer.parseInt(request.getParameter("UserID"));
    int HospitalID = Integer.parseInt(request.getParameter("HospitalID"));
    int DepartmentID = Integer.parseInt(request.getParameter("DepartmentID"));
    int DoctorID = Integer.parseInt(request.getParameter("DoctorID"));
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
<%@ page import="hospital.dao.impl.HospitalDaoImpl" %>
<%@ page import="hospital.user.Hospital" %>
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
    <h1>选时间</h1>
    <div>
        <label for="date">选择日期:</label>
        <input type="date" id="date" name="Date">
        <br><br>
    </div>
    <div>
        <table>
            <thead>
            <tr>
                <th>时间段</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>8:00~9:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'8:00~9:00'); return false;">预约</button>
                </td>
            </tr>
            <tr>
                <td>9:00~10:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'9:00~10:00'); return false;">预约</button>
                </td>
            </tr>
            <tr>
                <td>10:00~11:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'10:00~11:00'); return false;">预约</button>
                </td>
            </tr>
            <tr>
                <td>11:00~12:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'11:00~12:00'); return false;">预约</button>
                </td>
            </tr>
            <tr>
                <td>12:00~13:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'12:00~13:00'); return false;">预约</button>
                </td>
            </tr>
            <tr>
                <td>13:00~14:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'13:00~14:00'); return false;">预约</button>
                </td>
            </tr>
            <tr>
                <td>14:00~15:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'14:00~15:00'); return false;">预约</button>
                </td>
            </tr>
            <tr>
                <td>15:00~16:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'15:00~16:00'); return false;">预约</button>
                </td>
            </tr>
            <tr>
                <td>16:00~17:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'16:00~17:00'); return false;">预约</button>
                </td>
            </tr>
            <tr>
                <td>17:00~18:00</td>
                <td>
                    <button class="button" type="submit" onclick="Appointment(<%=UserID%>,<%=HospitalID%>,<%=DepartmentID%>,<%=DoctorID%>,'17:00~18:00'); return false;">预约</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script>
    function Appointment(UserID, HospitalID, DepartmentID, DoctorID, Time) {
        var selectedDate = document.getElementById("date").value;
        if (selectedDate === "") {
            alert("请选择一个日期");
            return;
        }

        var url = "./PatientAppointment";
        url += "?UserID=" + UserID;
        url += "&HospitalID=" + HospitalID;
        url += "&DepartmentID=" + DepartmentID;
        url += "&DoctorID=" + DoctorID;
        url += "&Date=" + selectedDate;
        url += "&Time=" + Time;
        // 创建一个隐藏的表单
        var form = document.createElement("form");
        form.setAttribute("method", "POST");
        form.setAttribute("action", url);

        // 将表单添加到页面中
        document.body.appendChild(form);

        // 提交表单
        form.submit();
        // Rest of the code remains the same
    }
</script>

</body>
</html>