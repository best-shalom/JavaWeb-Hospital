<%--
  Created by IntelliJ IDEA.
  User: ZhangYe
  Date: 2023/7/12
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="hospital.dao.impl.DepartmentDaoimpl" %>
<%@ page import="hospital.user.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改科室信息</title>
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
  </style>
</head>
<body>
<h1>桂林市医院统一预约挂号服务平台</h1>
<div>
  <!-- 导航栏 -->
  <ul class="navbar">
    <li><a href="./AdminCenter.jsp">首页</a></li>
    <li><a href="./AdminUsers.jsp">用户管理</a></li>
    <li><a href="./AdminHospitals.jsp">医院管理</a></li>
    <!-- 添加更多功能模块链接 -->
  </ul>
</div>
<div>
  <h1>科室管理</h1>
  <%
    int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
    int departmentId = Integer.parseInt(request.getParameter("departmentId"));
    DepartmentDaoimpl departmentdaoimpl = new DepartmentDaoimpl();
    Department department;
    department = departmentdaoimpl.find(departmentId);
  %>
  <div>
    <form action="UpdateDepartment" method="POST"> <!-- 替换 /updateHospital 为你想要处理更新请求的 URL -->
      <input type="hidden" name="hospitalId" value="<%= hospitalId %>">
      <input type="hidden" name="D_Id" value="<%= department.getId()%>">
      <label>科室名称:</label>
      <input type="text" name="name" value="<%= department.getDepartmentname() %>"><br><br>

      <label>科室负责人:</label>
      <input type="text" name="head" value="<%= department.getDepartmenthead() %>"><br><br>

      <label>简介:</label>
      <textarea name="introduction"><%= department.getIntroduction() %></textarea><br><br>

      <label>服务时间:</label>
      <input type="text" name="time" value="<%= department.getClinichours() %>"><br><br>

      <input type="submit" value="保存修改">
    </form>
  </div>
</div>
</body>
</html>