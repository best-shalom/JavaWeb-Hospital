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
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- 引入一个js文件 -->
    <script src="js/Patient.js"></script>
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
    <%
        String phone = (String) request.getAttribute("phone");
        DoctorService doctorService=new DoctorService();
        /*获取从登录页面和注册页面传入的id*/
        Doctor doctor=doctorService.DoctorShow(phone);
        int id = doctor.getId();
    %>
    <ul class="navbar">
        <li><a href="DoctorUpdate.jsp?phone=<%=phone%>">更新用户信息</a></li>
        <li><a href="DoctorSickShow.jsp?id=<%=id%>">查看预约</a></li>
        <%--        <li><a href="./AdminHospitals.jsp">医院管理</a></li>--%>
        <!-- 添加更多功能模块链接 -->
    </ul>
</div>

<div>
    <h1>医生主页</h1>
    <%
        if(doctor!=null)
        {%>
    <div>
        <table>
            <thead>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>联系方式</th>
                <th>所属医院</th>
                <th>所属科室</th>
                <th>职称</th>
                <th>个人简介</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <%--                <td><%=doctor.getId() %></td>--%>
                <td><%=doctor.getName() %></td>
                <%--                <td><%=doctor.getPassword() %></td>--%>
                <td><%=doctor.getSex() %></td>
                <td><%=doctor.getAge()%></td>
                <td><%=doctor.getPhone()%></td>
                <td><%=doctor.getPart() %></td>
                <td><%=doctor.getPart2() %></td>
                <td><%=doctor.getPart3()%></td>
                <td><%=doctor.getDiscript()%></td>
                <td>
                    <label>
                        <input type="hidden" name="Id" value="<%=doctor.getId()%>">
                    </label>
                    <%--                    <button class="button" type="submit" onclick="DeletePatient(<%=doctor.getId()%>); return false;">删除用户</button>--%>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>

</div>

</body>
