<%@ page import="hospital.service.DoctorService" %>
<%@ page import="hospital.user.Sick" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>病人数据</title>
    <%--在医生的科室病人显示页面中,包含对病人数据的删除和更新操作--%>
</head>
<body>
<table border="1">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>科室</th>
        <th>病名</th>
        <th>描述</th>
        <th>删除</th>
        <th>更新</th>
    </tr>
    <%
        DoctorService doctorService=new DoctorService();
        /*获取从医生主页传入的所属科室
        * 或者从SickDelete页面传入
        * 或者从SickUpdate页面传入
        */
        String part=request.getParameter("part");
        List<Sick> sickList=doctorService.SickShow(part);
        for (Sick s:sickList)
        {%>
    <tr>
        <td><%=s.getName() %>></td>
        <td><%=s.getAge() %></td>
        <td><%=s.getSex() %></td>
        <td><%=s.getPart()%></td>
        <td><%=s.getSick()%></td>
        <td><%=s.getInform()%></td>
        <td>
            <%--将此行挂号数据的id传入DoctorSickDelete响应,用于直接删除此行数据并告知这是由doctor传入的--%>
            <a href="SickDelete?id=<%=s.getId()%>&choose=doctor">
                <input type="button" value="删除">
            </a>
        </td>
        <td>
            <%--将此行挂号数据的id传入DoctorSickUpdate页面,用于后续更新(jsp→servlet的url传值(直接加?为get方法),在servlet的doGet调用)--%>
            <a href="DoctorSickUpdate.jsp?id=<%=s.getId()%>">
                <input type="button" value="更新">
            </a>
        </td>
    </tr>
    <%}
    %>
</table>
</body>
</html>
