package hospital.servlet;

import hospital.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * 病人登录响应
 */
public class PatientLoginServlet extends HttpServlet {
    PatientService patientService=new PatientService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String password=req.getParameter("password");
        boolean flag=patientService.PatientLogin(id,password);
        if(flag){
            resp.getWriter().write("登录成功!");
            req.setAttribute("id",id);
            req.getRequestDispatcher("PatientShow.jsp").forward(req,resp);
        }
        else{
            resp.getWriter().write("登录失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
