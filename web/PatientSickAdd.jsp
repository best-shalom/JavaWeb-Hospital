<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>挂号页面</title>
</head>
<body>
<form action="PatientSickAdd" method="post">
    <table>
        <%--第一行:patientId(使用hidden隐藏传递)--%>
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
            <td><label for="AppointmentStatus">预约状态</label> </td>
            <td><input type="text" name="AppointmentStatus" id="AppointmentStatus"></td>
        </tr>

        <tr>
            <td><label for="PaymentStatus">支付状态</label> </td>
            <td><input type="text" name="PaymentStatus" id="PaymentStatus"></td>
        </tr>

        <tr>
            <td><label for="PaymentAmount">支付金额</label> </td>
            <td><input type="text" name="PaymentAmount" id="PaymentAmount">元</td>
        </tr>

        <%--第八行:提交+重置按钮--%>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
