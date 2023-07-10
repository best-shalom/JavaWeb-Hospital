<%@ page import="hospital.user.Patient" %>
<%@ page import="hospital.service.PatientService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>病人主页</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>身份证</th>
        <th>电话号码</th>
        <th>邮箱</th>
        <th>生日</th>
    </tr>
    <%
        PatientService patientService=new PatientService();
        /*获取从登录页面和注册页面传入的id
        * 或者从UpdateServlet传入的id
        */
         String PhoneNumber= (String)request.getAttribute("PhoneNumber");
        Patient patient=patientService.PatientShow(PhoneNumber);
        if(patient!=null)
        {%>
    <tr>
        <td><%=patient.getUserID() %></td>
        <td><%=patient.getName() %></td>
        <td><%=patient.getPassword() %></td>
        <td><%=patient.getSex() %></td>
        <td><%=patient.getAge()%></td>
        <td><%=patient.getIdCard() %></td>
        <td><%=patient.getPhoneNumber() %></td>
        <td><%=patient.getEmail() %></td>
        <td><%=patient.getDateOfBirth() %></td>
    </tr>
    <%}
    %>
</table>
<a href="PatientUpdate.jsp?PhoneNumber=<%=PhoneNumber%>">
    <input type="button" value="修改个人信息">
</a>
<a href="PatientSickShow.jsp?PhoneNumber=<%=PhoneNumber%>">
    <input type="button" value="挂号信息">
</a>
</body>
</html>
