<%--
  Created by IntelliJ IDEA.
  User: ZhangYe
  Date: 2023/7/12
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="hospital.user.Hospital" %>
<%@ page import="hospital.dao.impl.HospitalDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改医院信息</title>
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
  <h1>医院管理</h1>
  <%
    int id = Integer.parseInt(request.getParameter("Id"));
    HospitalDaoImpl hospitaldaoimpl = new HospitalDaoImpl();
    Hospital hospital;
    hospital = hospitaldaoimpl.find(id);
  %>
  <div>
    <form action="UpdateHospital" method="POST"> <!-- 替换 /updateHospital 为你想要处理更新请求的 URL -->
      <input type="hidden" name="Id" value="<%= hospital.getId()%>">
      <label>医院名称:</label>
      <input type="text" name="name" value="<%= hospital.getName() %>"><br><br>

      <label>级别:</label>
      <input type="text" name="level" value="<%= hospital.getLevel() %>"><br><br>

      <label>详细地址:</label>
      <input type="text" name="address" value="<%= hospital.getAddress() %>"><br><br>

      <label>联系电话:</label>
      <input type="text" name="number" value="<%= hospital.getNumber() %>"><br><br>

      <label>院长姓名:</label>
      <input type="text" name="presidentname" value="<%= hospital.getPresidentname() %>"><br><br>

      <label>成立日期:</label>
      <input type="date" name="time" value="<%= hospital.getTime() %>"><br><br>

      <label>运营状态:</label>
      <input type="text" name="status" value="<%= hospital.getStatus() %>"><br><br>

      <label>简介:</label>
      <textarea name="introduction"><%= hospital.getIntroduction() %></textarea><br><br>

      <input type="submit" value="保存修改">
    </form>
  </div>
</div>
</body>
</html>