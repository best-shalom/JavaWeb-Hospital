<%@ page import="javax.print.Doc" %>
<%@ page import="hospital.service.DoctorService" %>
<%@ page import="hospital.user.Doctor" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医生主页</title>
</head>
<body>
<table border="1">
    <tr>
        <th>DoctorID</th>
        <th>DoctorName</th>
        <th>D_Password</th>
        <th>sex</th>
        <th>age</th>
        <th>phone</th>
        <th>hospital</th>
        <th>DepartmentName</th>
        <th>ProfessionalTitle</th>
        <th>introduction</th>
    </tr>
    <%
        DoctorService doctorService=new DoctorService();
        /*获取从登录页面和注册页面传入的id*/
        String phone = (String) request.getAttribute("phone");
        Doctor doctor=doctorService.DoctorShow(phone);
        String part=doctor.getPart();
        if(doctor!=null)
        {%>
    <tr>
        <td><%=doctor.getId() %></td>
        <td><%=doctor.getName() %>></td>
        <td><%=doctor.getPassword() %></td>
        <td><%=doctor.getSex() %></td>
        <td><%=doctor.getAge()%></td>
        <td><%=doctor.getPhone()%></td>
        <td><%=doctor.getPart() %></td>
        <td><%=doctor.getPart2() %></td>
        <td><%=doctor.getPart3()%></td>
        <td><%=doctor.getDiscript()%></td>
    </tr>
    <%}
    %>
</table>
<%--将doctor的id传给Update--%>
<a href="DoctorUpdate.jsp?phone=<%=phone%>">
    <input type="button" value="修改个人信息">
</a>
<%--将doctor所属科室传给DoctorSickShow--%>
<a href="DoctorSickShow.jsp?part=<%=part%>">
    <input type="button" value="病人数据">
</a>
</body>
</html>
