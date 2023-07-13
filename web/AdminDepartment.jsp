<%--
  Created by IntelliJ IDEA.
  User: ZhangYe
  Date: 2023/7/12
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="hospital.dao.impl.DepartmentDaoimpl" %>
<%@ page import="hospital.user.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>科室管理</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- 引入一个js文件 -->
    <script src="js/Department.js"></script>
    <link rel="stylesheet" href="css/navbar.css">
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
    DepartmentDaoimpl departmentdaoimpl = new DepartmentDaoimpl();
    List<Department> departmentList = null;
    int id = -1;
    try {
        id = Integer.parseInt(request.getParameter("hospitalId"));
        departmentList = departmentdaoimpl.findAll(id); // 调用 findAll() 函数获取全部用户信息
    } catch (Exception e) {
      e.printStackTrace();
    }
    assert departmentList != null;
  %>
    <div>
        <table>
            <thead>
            <tr>
                <th>科室名称</th>
                <th>科室负责人</th>
                <th>科室简介</th>
                <th>科室服务时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%for (Department department : departmentList) { %>
            <tr>
                <td><%= department.getDepartmentname() %></td>
                <td><%= department.getDepartmenthead() %></td>
                <td><%= department.getIntroduction() %></td>
                <td><%= department.getClinichours() %></td>
                <td>
                    <label>
                        <input type="hidden" name="departmentId" value="<%=department.getId()%>">
                        <input type="hidden" name="hospitalId" value="<%=id%>">
                    </label>
                    <button class="button" type="submit" onclick="DeleteDepartment('<%=id%>','<%=department.getId()%>'); return false;">删除科室</button>
                    <button class="button" type="submit" onclick="ReviseDepartment('<%=id%>', '<%=department.getId()%>'); return false;">修改信息</button>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
