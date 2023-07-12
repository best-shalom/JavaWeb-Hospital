<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新挂号数据</title>
</head>
<body>
<form action="PatientSickUpdate" method="post">
    <table>
        <input type="hidden" name="patientId" value="<%=request.getParameter("patientId")%>">

        <tr>
            <td><label for="P_Name">病人姓名</label> </td>
            <td><input type="text" name="P_Name" id="P_Name"></td>
        </tr>

        <tr>
            <td><label for="D_Name">医生姓名</label> </td>
            <td><input type="text" name="D_Name" id="D_Name"></td>
        </tr>

        <tr>
            <td><label for="AppointmentDate">预约日期</label> </td>
            <td><input type="text" name="AppointmentDate" id="AppointmentDate"></td>
        </tr>

        <tr>
            <td><label for="AppointmentTime">预约时间段</label> </td>
            <td><input type="text" name="AppointmentTime" id="AppointmentTime"></td>
        </tr>

        <tr>
            <td><label for="HospitalName">医院名</label> </td>
            <td><input type="text" name="HospitalName" id="HospitalName"></td>
        </tr>

        <tr>
            <td><label for="DepartmentName">科室名</label> </td>
            <td><input type="text" name="DepartmentName" id="DepartmentName"></td>
        </tr>

        <tr>
            <td><input type="submit" value="更新"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
