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
        String PhoneNumber = req.getParameter("PhoneNumber");
        String name=req.getParameter("Name");
        String password=req.getParameter("Password");
        int age= Integer.parseInt(req.getParameter("Age"));
        String sex=req.getParameter("Sex");
        boolean flag=patientService.PatientUpdate(PhoneNumber,name,password,age,sex);
        if(flag){
            resp.getWriter().write("病人数据更新成功!");
            /*使用转发,因为PatientShow界面获参的方法为getAttribute*/
            req.setAttribute("PhoneNumber",PhoneNumber);
            req.getRequestDispatcher("PatientShow.jsp").forward(req,resp);
        }
        else{
            resp.getWriter().write("病人数据更新失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
