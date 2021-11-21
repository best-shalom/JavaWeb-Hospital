<%@ page import="hospital.service.PatientService" %>
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
    <title>挂号信息</title>
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
        PatientService patientService=new PatientService();
        /*获取从病人主页传入的id(对应查找patientId)
        * 或者由SickAddServlet传入
        * 或者由SickDeleteServlet传入
        * 或者由SickUpdateServlet传入
        */
        int patientId= Integer.parseInt(request.getParameter("id"));
        List<Sick> sickList=patientService.SickShow(patientId);
        for (Sick s:sickList) {%>
    <tr>
        <td><%=s.getName() %>></td>
        <td><%=s.getAge() %></td>
        <td><%=s.getSex() %></td>
        <td><%=s.getPart()%></td>
        <td><%=s.getSick()%></td>
        <td><%=s.getInform()%></td>
        <td>
            <%--将此行挂号数据的id传入SickDelete响应,用于直接删除此行数据--%>
            <a href="SickDelete?id=<%=s.getId()%>&choose=patient">
                <input type="button" value="删除">
            </a>
        </td>
        <td>
            <%--将此行挂号数据的id传入PatientSickUpdate页面,用于后续更新--%>
            <a href="PatientSickUpdate.jsp?id=<%=s.getId()%>">
                <input type="button" value="更新">
            </a>
        </td>
    </tr>
    <%}
    %>
</table>
<%--再将病人id传入SickAdd页面,便于将patientId放入新增的挂号数据中--%>
<a href="PatientSickAdd.jsp?patientId=<%=patientId%>">
    <input type="button" value="新增挂号数据">
</a>
</body>
</html>
