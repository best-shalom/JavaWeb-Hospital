package hospital.servlet;

import hospital.service.DoctorService;
import hospital.user.Doctor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * 医生注册响应
 */
public class DoctorRegisterServlet extends HttpServlet {
    DoctorService doctorService=new DoctorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String sex=req.getParameter("sex");
        int age= Integer.parseInt(req.getParameter("age"));
        String phone=req.getParameter("phone");
        String part=req.getParameter("part");
        String part2=req.getParameter("part2");
        String part3=req.getParameter("part3");
        String discript=req.getParameter("discript");

        Doctor doctor=doctorService.DoctorRegister(name,password,sex,age,phone,part,part2,part3,discript);
        int id=doctor.getId();
        if(id!=0){
            resp.getWriter().write("注册成功!");
            /*转发到医生个人主页*/
            req.setAttribute("id",id);
            req.getRequestDispatcher("DoctorShow.jsp").forward(req,resp);
        }
        else{
            resp.getWriter().write("注册失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
