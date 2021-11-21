package hospital.servlet;

import hospital.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * 病人数据更新响应
 */
public class PatientUpdateServlet extends HttpServlet {
    PatientService patientService=new PatientService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        int age= Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        boolean flag=patientService.PatientUpdate(id,name,password,age,sex);
        if(flag){
            resp.getWriter().write("病人数据更新成功!");
            /*使用转发,因为PatientShow界面获参的方法为getAttribute*/
            req.setAttribute("id",id);
            req.getRequestDispatcher("PatientShow.jsp").forward(req,resp);
        }
        else{
            resp.getWriter().write("病人数据更新失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
