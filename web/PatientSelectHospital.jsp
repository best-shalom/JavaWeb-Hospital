<% int UserID = Integer.parseInt(request.getParameter("UserID")); %><%--
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
  <link rel="stylesheet" href="css/navbar.css">
  <link rel="stylesheet" href="css/patientform.css">
</head>
<body>
<h1>桂林市医院统一预约挂号服务平台</h1>
<div>
  <!-- 导航栏 -->
  <ul class="navbar">
    <li><a href="./PatientCenter.jsp?UserID=<%=UserID%>">首页</a></li>
    <li><a href="./PatientShow.jsp?UserID=<%=UserID%>">个人信息</a></li>
    <li><a href="./PatientSelectHospital.jsp?UserID=<%=UserID%>">挂号</a></li>
  </ul>
</div>

<div >
  <h1>找医院</h1>
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
<%--  <div class="card-container">--%>
<%--    <table>--%>
<%--      <thead>--%>
<%--      <tr>--%>
<%--        <th>医院名</th>--%>
<%--        <th>医院类型</th>--%>
<%--        <th>地址</th>--%>
<%--        <th>电话号码</th>--%>
<%--        <th>医院院长</th>--%>
<%--        <th>医院创立</th>--%>
<%--        <th>运营状态</th>--%>
<%--        <th></th>--%>
<%--      </tr>--%>
<%--      </thead>--%>
<%--      <tbody>--%>
<%--      <%for (Hospital hospital : hospitalList) {--%>
<%--      %>--%>
<%--      <tr>--%>
<%--        <td><%= hospital.getName() %></td>--%>
<%--        <td><%= hospital.getLevel() %></td>--%>
<%--        <td><%= hospital.getAddress() %></td>--%>
<%--        <td><%= hospital.getNumber() %></td>--%>
<%--        <td><%= hospital.getPresidentname() %></td>--%>
<%--        <td><%= hospital.getTime() %></td>--%>
<%--        <td><%= hospital.getStatus() %></td>--%>
<%--&lt;%&ndash;        <td class="introduction"><%=hospital.getIntroduction()%></td>&ndash;%&gt;--%>
<%--        <td>--%>
<%--          <label>--%>
<%--            <input type="hidden" name="Id" value="<%=hospital.getId()%>">--%>
<%--          </label>--%>
<%--          <button class="button" type="submit" onclick="SelectDepartment(<%=UserID%>,<%=hospital.getId()%>); return false;">选择该医院</button>--%>
<%--        </td>--%>
<%--      </tr>--%>
<%--      <% } %>--%>
<%--      </tbody>--%>
<%--    </table>--%>
<%--  </div>--%>


  <div class="card-container">
    <% for (Hospital hospital : hospitalList) { %>
    <div class="card">
      <div class="card-header">
        <h2 class="card-title"><%= hospital.getName() %></h2>
      </div>
      <div class="card-info">
        <p><span class="info-label">医院类型:</span> <%= hospital.getLevel() %></p>
        <p><span class="info-label">地址:</span> <%= hospital.getAddress() %></p>
        <p><span class="info-label">电话号码:</span> <%= hospital.getNumber() %></p>
        <p><span class="info-label">医院院长:</span> <%= hospital.getPresidentname() %></p>
        <p><span class="info-label">医院创立:</span> <%= hospital.getTime() %></p>
        <p><span class="info-label">运营状态:</span> <%= hospital.getStatus() %></p>
        <p class="info-label">简介:</p>
        <p class="description"><%= hospital.getIntroduction() %></p>
      </div>
      <div class="card-footer">
        <button class="button" type="submit" onclick="SelectDepartment(<%= UserID %>, <%= hospital.getId() %>); return false;">选择该医院</button>
      </div>
    </div>
    <% } %>
  </div>

</div>

<script>
  function SelectDepartment(UserID,HospitalID) {
    // 在这里进行页面跳转
    window.location.href = "./PatientSelectDepartment.jsp?UserID=" + UserID + "&HospitalID=" + HospitalID;
  }
</script>

</body>
</html>