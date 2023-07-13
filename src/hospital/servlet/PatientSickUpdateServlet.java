package hospital.servlet;

import hospital.service.PatientService;
import hospital.user.Sick;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * 挂号数据更新--病人
 */
public class PatientSickUpdateServlet extends HttpServlet {
    PatientService patientService=new PatientService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int AppointmentID= Integer.parseInt(req.getParameter("AppointmentID"));
        int UserID=Integer.parseInt(req.getParameter("UserID"));
        String AppointmentDate=req.getParameter("AppointmentDate");
        String AppointmentTime=req.getParameter("AppointmentTime");
        boolean flag=patientService.SickUpdate(AppointmentID,AppointmentDate,AppointmentTime);
        if(flag){
            req.setAttribute("Errormessage", "挂号数据更新成功!");
            req.setAttribute("UserID", UserID);
            req.getRequestDispatcher("PatientCenter.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("Errormessage", "挂号数据更新失败!");
            req.getRequestDispatcher("PatientCenter.jsp").forward(req, resp);
        }
    }
}
