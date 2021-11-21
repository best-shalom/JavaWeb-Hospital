<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/20
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>挂号页面</title>
</head>
<body>
<form action="PatientSickAdd" method="post">
    <table>
        <%--第一行:patientId(使用hidden隐藏传递)--%>
            <input type="hidden" name="patientId" value="<%=request.getParameter("patientId")%>">
        <%--第二行:姓名--%>
        <tr>
            <td><label for="name">姓名</label> </td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <%--第三行:年龄--%>
        <tr>
            <td><label for="age">年龄</label> </td>
            <td><input type="text" name="age" id="age"></td>
        </tr>
        <%--第四行:性别--%>
        <tr>
            <td><input type="radio" name="sex" value="男">男</td>
            <td><input type="radio" name="sex" value="女">女</td>
        </tr>
        <%--第五行:科室(设置六个科室可供选择)--%>
        <tr>
            <td>所属科室</td>
            <td>
                <select name="part">
                    <option value="骨肿瘤门诊">骨肿瘤门诊</option>
                    <option value="老年科门诊">老年科门诊</option>
                    <option value="精神科门诊">精神科门诊</option>
                    <option value="普通外科门诊">普通外科门诊</option>
                    <option value="耳鼻喉科门诊">耳鼻喉科门诊</option>
                    <option value="儿科门诊">儿科门诊</option>
                </select>
            </td>
        </tr>
        <%--第六行:病名--%>
        <tr>
            <td><label for="sick">病名</label></td>
            <td><input type="text" name="sick" id="sick"></td>
        </tr>
        <%--第七行:描述--%>
        <tr>
            <td><label>病情描述</label></td>
            <td><textarea name="inform"></textarea></td>
        </tr>
        <%--第八行:提交+重置按钮--%>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
