package hospital.servlet;

import hospital.service.PatientService;
import hospital.user.Patient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Administrator
 * 病人数据更新响应
 */
public class PatientUpdateServlet extends HttpServlet {
    PatientService patientService=new PatientService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        int age= Integer.parseInt(req.getParameter("age"));
        String sex= req.getParameter("sex");
        String email= req.getParameter("email");
        String idCard= req.getParameter("idCard");
        String DateOfBirth= req.getParameter("DateOfBirth");
        String PhoneNumber= req.getParameter("PhoneNumber");
        int UserID = Integer.parseInt(req.getParameter("UserID"));
        boolean flag =patientService.PatientUpdate(UserID,name,sex,age,email,idCard,DateOfBirth,PhoneNumber);
        if(flag){
            resp.getWriter().write("患者数据更新成功!");
            /*转发到病人个人主页*/
            req.setAttribute("UserID", UserID);
            req.getRequestDispatcher("PatientShow.jsp").forward(req,resp);
        } else{
            resp.getWriter().write("患者数据更新失败!");
            resp.sendRedirect("Error.jsp");
        }
    }

}
