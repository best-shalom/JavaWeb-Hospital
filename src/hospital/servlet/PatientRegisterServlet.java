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
 * 病人注册响应
 */
public class PatientRegisterServlet extends HttpServlet {
    PatientService patientService=new PatientService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String SurePassword=req.getParameter("SurePassword");
        int age= Integer.parseInt(req.getParameter("age"));
        String sex= req.getParameter("sex");
        String email= req.getParameter("email");
        String idCard= req.getParameter("idCard");
        String DateOfBirth= req.getParameter("DateOfBirth");
        String PhoneNumber= req.getParameter("PhoneNumber");

        Patient patient=patientService.PatientRegister(name,password,age,sex,email,idCard,DateOfBirth,PhoneNumber);
        int id=patient.getId();

        if(!Objects.equals(password, SurePassword)){

        } else if(id!=0 ){
            resp.getWriter().write("注册成功!");
            /*转发到病人个人主页*/
            req.setAttribute("id",id);
            req.getRequestDispatcher("PatientShow.jsp").forward(req,resp);
        } else{
            resp.getWriter().write("注册失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
