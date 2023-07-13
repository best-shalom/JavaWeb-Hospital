<%--将doctor的id传给Update--%>
<%--<a href="DoctorUpdate.jsp?phone=<%=phone%>">--%>
<%--    <input type="button" value="修改个人信息">--%>
<%--</a>--%>
<%--&lt;%&ndash;将doctor所属科室传给DoctorSickShow&ndash;%&gt;--%>
<%--<a href="DoctorSickShow.jsp?part=<%=part%>">--%>
<%--    <input type="button" value="病人数据">--%>
<%--</a>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hospital.service.DoctorService" %>
<%@ page import="hospital.user.Doctor" %>

<html>
<head>
    <title>医生主页</title>

    <link rel="stylesheet" href="./css/show.css">
</head>
<body>

<div class="top-bar">
    <div class="login-page">医生首页</div>
</div>

<%
    DoctorService doctorService = new DoctorService();
    /*获取从登录页面和注册页面传入的id*/
    String phone = (String) request.getAttribute("phone");
    Doctor doctor = doctorService.DoctorShow(phone);
    String part = doctor.getPart();
    if (doctor != null) {%>

<div class="container">
    <table border="1">
        <tr>
            <th>DoctorID</th>
            <td><%=doctor.getId() %>
            </td>
        </tr>
        <tr>
            <th>DoctorName</th>
            <td><%=doctor.getName() %>
            </td>
        </tr>
        <tr>
            <th>D_Password</th>
            <td><%=doctor.getPassword() %>
            </td>
        </tr>
        <tr>
            <th>sex</th>
            <td><%=doctor.getSex() %>
            </td>
        </tr>
        <tr>
            <th>age</th>
            <td><%=doctor.getAge()%>
            </td>
        </tr>
        <tr>
            <th>phone</th>
            <td><%=doctor.getPhone()%>
            </td>
        </tr>
        <tr>
            <th>hospital</th>
            <td><%=doctor.getPart() %>
            </td>
        </tr>
        <tr>
            <th>DepartmentName</th>
            <td><%=doctor.getPart2() %>
            </td>
        </tr>
        <tr>
            <th>ProfessionalTitle</th>
            <td><%=doctor.getPart3() %>
            </td>
        </tr>
        <tr>
            <th>introduction</th>
            <td><%=doctor.getDiscript() %>
            </td>
        </tr>

    </table>
</div>

<%
    }
%>
<%--<tr style="display: flex;">--%>
<%--    &lt;%&ndash;将doctor的id传给Update&ndash;%&gt;--%>
<%--    <a href="DoctorUpdate.jsp?phone=<%=phone%>">--%>
<%--        <input type="button" value="修改个人信息">--%>
<%--    </a>--%>
<%--    &lt;%&ndash;将doctor所属科室传给DoctorSickShow&ndash;%&gt;--%>
<%--    <a href="DoctorSickShow.jsp?part=<%=part%>">--%>
<%--        <input type="button" value="病人数据">--%>
<%--    </a>--%>
<%--</tr>--%>
<div style="display: flex; justify-content: center;">
    <a href="DoctorUpdate.jsp?phone=<%=phone%>" style="margin-right: 10px; display: flex; justify-content: center; align-items: center;">
        <input type="button" class="button" value="修改个人信息">
    </a>
    <a href="DoctorSickShow.jsp?part=<%=part%>" style="display: flex; justify-content: center; align-items: center;">
        <input type="button" class="button" value="病人数据">
    </a>
</div>


<div class="bottom-bar"></div>

</body>
