<%--
  Created by IntelliJ IDEA.
  User: ZhangYe
  Date: 2023/7/10
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="hospital.dao.impl.HospitalDaoImpl" %>
<%@ page import="hospital.user.Hospital" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>管理员首页</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!-- 引入一个js文件 -->
  <script src="js/Hospital.js"></script>
  <link rel="stylesheet" href="css/navbar.css">
  <link rel="stylesheet" href="css/adminform.css">
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
    HospitalDaoImpl hospitaldaoimpl = new HospitalDaoImpl();
    List<Hospital> hospitalList = null;
    try {
      hospitalList = hospitaldaoimpl.findAll(); // 调用 findAll() 函数获取全部用户信息
    } catch (Exception e) {
      e.printStackTrace();
    }
    assert hospitalList != null;
  %>
<%--  <div>--%>
<%--    <table>--%>
<%--      <thead>--%>
<%--      <tr>--%>
<%--        <th>医院名称</th>--%>
<%--        <th>级别</th>--%>
<%--        <th>详细地址</th>--%>
<%--        <th>联系电话</th>--%>
<%--        <th>院长姓名</th>--%>
<%--        <th>成立日期</th>--%>
<%--        <th>运营状态</th>--%>
<%--        <th>简介</th>--%>
<%--        <th>操作</th>--%>
<%--      </tr>--%>
<%--      </thead>--%>
<%--      <tbody>--%>
<%--      <%for (Hospital hospital : hospitalList) { %>--%>
<%--      <tr>--%>
<%--        <td><%= hospital.getName() %></td>--%>
<%--        <td><%= hospital.getLevel() %></td>--%>
<%--        <td><%= hospital.getAddress() %></td>--%>
<%--        <td><%= hospital.getNumber() %></td>--%>
<%--        <td><%= hospital.getPresidentname() %></td>--%>
<%--        <td><%= hospital.getTime() %></td>--%>
<%--        <td><%= hospital.getStatus() %></td>--%>
<%--        <td><%= hospital.getIntroduction() %></td>--%>
<%--        <td>--%>
<%--          <label>--%>
<%--            <input type="hidden" name="Id" value="<%=hospital.getId()%>">--%>
<%--          </label>--%>
<%--          <button class="button" type="submit" onclick="DeleteHospital(<%=hospital.getId()%>); return false;">删除医院</button>--%>
<%--          <button class="button" type="submit" onclick="ReviseHospital(<%=hospital.getId()%>); return false;">修改信息</button>--%>
<%--        </td>--%>
<%--      </tr>--%>
<%--      <% } %>--%>
<%--      </tbody>--%>
<%--    </table>--%>
<%--  </div>--%>

<%--  <div class="card-container">--%>
<%--    <% for (Hospital hospital : hospitalList) { %>--%>
<%--    <div class="card">--%>
<%--      <div class="card-header">--%>
<%--        <h2 class="card-title"><%= hospital.getName() %></h2>--%>
<%--      </div>--%>
<%--      <div class="card-info">--%>
<%--        <p><span class="info-label">级别:</span> <%= hospital.getLevel() %></p>--%>
<%--        <p><span class="info-label">详细地址:</span> <%= hospital.getAddress() %></p>--%>
<%--        <p><span class="info-label">联系电话:</span> <%= hospital.getNumber() %></p>--%>
<%--        <p><span class="info-label">院长姓名:</span> <%= hospital.getPresidentname() %></p>--%>
<%--        <p><span class="info-label">成立日期:</span> <%= hospital.getTime() %></p>--%>
<%--        <p><span class="info-label">运营状态:</span> <%= hospital.getStatus() %></p>--%>
<%--        <p><span class="info-label">简介:</span> <%= hospital.getIntroduction() %></p>--%>
<%--      </div>--%>
<%--      <div class="card-footer">--%>
<%--        <input type="hidden" name="Id" value="<%=hospital.getId()%>">--%>
<%--        <button class="button" type="submit" onclick="DeleteHospital(<%=hospital.getId()%>); return false;">删除医院</button>--%>
<%--        <button class="button" type="submit" onclick="ReviseHospital(<%=hospital.getId()%>); return false;">修改信息</button>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--    <% } %>--%>
<%--  </div>--%>
  <div class="card-container">
    <% for (Hospital hospital : hospitalList) { %>
    <div class="card">
      <table>
        <tr>
          <th>医院名称:</th>
          <td><%= hospital.getName() %></td>
        </tr>
        <tr>
          <th>级别:</th>
          <td><%= hospital.getLevel() %></td>
        </tr>
        <tr>
          <th>详细地址:</th>
          <td><%= hospital.getAddress() %></td>
        </tr>
        <tr>
          <th>联系电话:</th>
          <td><%= hospital.getNumber() %></td>
        </tr>
        <tr>
          <th>院长姓名:</th>
          <td><%= hospital.getPresidentname() %></td>
        </tr>
        <tr>
          <th>成立日期:</th>
          <td><%= hospital.getTime() %></td>
        </tr>
        <tr>
          <th>运营状态:</th>
          <td><%= hospital.getStatus() %></td>
        </tr>
<%--        <tr>--%>
<%--          <th>简介:</th>--%>
<%--          <td><%= hospital.getIntroduction() %></td>--%>
<%--        </tr>--%>
      </table>
      <div class="card-footer">
        <input type="hidden" name="Id" value="<%=hospital.getId()%>">
        <button class="button" type="submit" onclick="DeleteHospital(<%=hospital.getId()%>); return false;">删除医院</button>
        <button class="button" type="submit" onclick="ReviseHospital(<%=hospital.getId()%>); return false;">修改信息</button>
      </div>
    </div>
    <% } %>
  </div>




</body>
</html>