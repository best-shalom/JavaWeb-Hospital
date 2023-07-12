<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page import="hospital.service.DoctorService" %>--%>
<%--<%@ page import="hospital.user.Sick" %>--%>
<%--<%@ page import="java.util.List" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>预约记录</title>--%>
<%--    <meta charset="utf-8" />--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0" />--%>
<%--    <!-- 引入一个js文件 -->--%>
<%--    <style>--%>
<%--        ul.navbar {--%>
<%--            list-style-type: none;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            background-color: #f1f1f1;--%>
<%--            overflow: hidden;--%>
<%--        }--%>

<%--        ul.navbar li {--%>
<%--            float: left;--%>
<%--        }--%>

<%--        ul.navbar li a {--%>
<%--            display: block;--%>
<%--            color: black;--%>
<%--            text-align: center;--%>
<%--            padding: 14px 16px;--%>
<%--            text-decoration: none;--%>
<%--        }--%>

<%--        ul.navbar li a:hover:not(.active) {--%>
<%--            background-color: #ddd;--%>
<%--        }--%>

<%--        .active {--%>
<%--            background-color: #4CAF50;--%>
<%--        }--%>
<%--        table {--%>
<%--            width: 100%;--%>
<%--            border-collapse: collapse;--%>
<%--        }--%>

<%--        th, td {--%>
<%--            padding: 8px;--%>
<%--            text-align: left;--%>
<%--            border-bottom: 1px solid #ddd;--%>
<%--        }--%>

<%--        th {--%>
<%--            background-color: #f2f2f2;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>桂林市医院统一预约挂号服务平台</h1>--%>

<%--<div>--%>
<%--    <h1>挂号记录</h1>--%>
<%--    <div>--%>
<%--        <table>--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th>病人姓名</th>--%>
<%--                <th>主治医生</th>--%>
<%--                <th>预约日期</th>--%>
<%--                <th>预约时间段</th>--%>
<%--                <th>医院名</th>--%>
<%--                <th>科室名</th>--%>
<%--                <th>预约状态</th>--%>
<%--                <th>支付状态</th>--%>
<%--                <th>支付金额</th>--%>
<%--            </tr>--%>
<%--            <%--%>
<%--                DoctorService doctorService=new DoctorService();--%>
<%--                /*获取从医生主页传入的所属科室--%>
<%--                 * 或者从SickDelete页面传入--%>
<%--                 * 或者从SickUpdate页面传入--%>
<%--                 */--%>
<%--                String res=request.getParameter("id");--%>
<%--                int id = Integer.valueOf(res);--%>
<%--                List<Sick> sickList=doctorService.SickShow(id);--%>
<%--                for (Sick s:sickList)--%>
<%--                {%>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <td><%=s.getP_name()%></td>--%>
<%--                <td><%=s.getD_name()%></td>--%>
<%--                <td><%=s.getData() %></td>--%>
<%--                <td><%=s.getTime()%></td>--%>
<%--                <td><%=s.getHospitalname()%></td>--%>
<%--                <td><%=s.getDepartmentname()%></td>--%>
<%--                <td><%=s.getAppointmentstatus()%></td>--%>
<%--                <td><%=s.getPaymentstatus()%></td>--%>
<%--                <td><%=s.getPaymentamount()%></td>--%>
<%--                &lt;%&ndash;                <td>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    &lt;%&ndash;将此行挂号数据的id传入DoctorSickDelete响应,用于直接删除此行数据并告知这是由doctor传入的&ndash;%&gt;&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <a href="SickDelete?id=<%=s.getId()%>&choose=doctor">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                        <input type="button" value="删除">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    </a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                </td>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                <td>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    &lt;%&ndash;将此行挂号数据的id传入DoctorSickUpdate页面,用于后续更新(jsp→servlet的url传值(直接加?为get方法),在servlet的doGet调用)&ndash;%&gt;&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <a href="DoctorSickUpdate.jsp?id=<%=s.getId()%>">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                        <input type="button" value="更新">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    </a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                </td>&ndash;%&gt;--%>
<%--            </tr>--%>
<%--            <% } %>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>

<%--</div>--%>

<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hospital.service.DoctorService" %>
<%@ page import="hospital.user.Sick" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>挂号记录</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- 引入一个js文件 -->
<%--    <script src="js/Patient.js"></script>--%>
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
    <ul class="navbar">
<%--        <li><a href="./AdminCenter.jsp">首页</a></li>--%>
<%--        <li><a href="./AdminUsers.jsp">用户管理</a></li>--%>
<%--        <li><a href="./AdminHospitals.jsp">医院管理</a></li>--%>
        <!-- 添加更多功能模块链接 -->
    </ul>
</div>

<div>
    <h1>用户管理</h1>
    <div>
        <table>
            <thead>
            <tr>
                <th>病人姓名</th>
                <th>主治医生</th>
                <th>预约日期</th>
                <th>预约时间段</th>
                <th>医院名</th>
                <th>科室名</th>
                <th>预约状态</th>
                <th>支付状态</th>
                <th>支付金额</th>
            </tr>
            <%
                DoctorService doctorService=new DoctorService();
                /*获取从医生主页传入的所属科室
                 * 或者从SickDelete页面传入
                 * 或者从SickUpdate页面传入
                 */
                String res=request.getParameter("id");
                int id = Integer.valueOf(res);
                List<Sick> sickList=doctorService.SickShow(id);
                for (Sick s:sickList)
                {%>
            </thead>
            <tbody>
            <tr>
                <td><%=s.getP_name()%></td>
                <td><%=s.getD_name()%></td>
                <td><%=s.getData() %></td>
                <td><%=s.getTime()%></td>
                <td><%=s.getHospitalname()%></td>
                <td><%=s.getDepartmentname()%></td>
                <td><%=s.getAppointmentstatus()%></td>
                <td><%=s.getPaymentstatus()%></td>
                <td><%=s.getPaymentamount()%></td>
                <td>
<%--                    <label>--%>
<%--                        <input type="hidden" name="Id" value="<%=patient.getUserID()%>">--%>
<%--                    </label>--%>
<%--                    <button class="button" type="submit" onclick="DeletePatient(<%=patient.getUserID()%>); return false;">删除用户</button>--%>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>


