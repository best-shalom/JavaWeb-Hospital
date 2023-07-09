package hospital.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Administrator
 * 选择界面响应
 * --choose==医生,resp.send...(DoctorLogin.jsp)
 * --choose==病人,resp.send...(PatientLogin.jsp)
 */
public class ChooseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choose=req.getParameter("choose");
        if(Objects.equals(choose, "doctor")){
            resp.getWriter().write("重定向到医生登录");
            resp.sendRedirect("DoctorLogin.jsp");
        }
        else if(Objects.equals(choose, "patient")){
            resp.getWriter().write("转向病人登录");
            resp.sendRedirect("PatientLogin.jsp");
        }
        else if(Objects.equals(choose, "root")){
            resp.getWriter().write("转向管理员登陆");
            resp.sendRedirect("RootLogin.jsp");
        } else{
            resp.getWriter().write("未知错误");
            resp.sendRedirect("Error.jsp");
        }
    }
}
