package hospital.servlet;

import hospital.service.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * 医生登录响应
 */
public class DoctorLoginServlet extends HttpServlet {
    DoctorService doctorService=new DoctorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String password=req.getParameter("password");
        boolean flag=doctorService.DoctorLogin(id,password);
        if(flag){
            resp.getWriter().write("登录成功!");
            /*转发到医生个人主页*/
            req.setAttribute("id",id);
            req.getRequestDispatcher("DoctorShow.jsp").forward(req,resp);
        }
        else{
            resp.getWriter().write("登录失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
