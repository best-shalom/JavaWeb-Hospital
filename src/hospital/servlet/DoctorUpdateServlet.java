package hospital.servlet;

import hospital.service.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * 医生数据更新响应
 */
public class DoctorUpdateServlet extends HttpServlet {
    DoctorService doctorService=new DoctorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        int age= Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        String part=req.getParameter("part");
        boolean flag=doctorService.DoctorUpdate(id,name,password,age,sex,part);
        if(flag){
            resp.getWriter().write("医生数据更新成功!");
            /*使用转发,因为DoctorShow界面获参的方法为getAttribute*/
            req.setAttribute("id",id);
            req.getRequestDispatcher("DoctorShow.jsp").forward(req,resp);
        }
        else{
            resp.getWriter().write("医生数据更新失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
