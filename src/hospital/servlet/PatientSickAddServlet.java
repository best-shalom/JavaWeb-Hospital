package hospital.servlet;

import hospital.service.PatientService;
import hospital.user.Doctor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * 病人挂号
 */
public class PatientSickAddServlet extends HttpServlet {
    PatientService patientService=new PatientService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int patientId= Integer.parseInt(req.getParameter("patientId"));
//        String P_Name=req.getParameter("P_Name");
//        String D_Name=req.getParameter("D_Name");
//        String AppointmentDate=req.getParameter("AppointmentDate");
//        String AppointmentTime=req.getParameter("AppointmentTime");
//        String HospitalName=req.getParameter("HospitalName");
//        String DepartmentName=req.getParameter("DepartmentName");
//        String AppointmentStatus=req.getParameter("AppointmentStatus");
//        String PaymentStatus=req.getParameter("PaymentStatus");
//        String PaymentAmount=req.getParameter("PaymentAmount");
//
//        boolean flag=patientService.SickAdd(patientId,DoctorID,P_Name,D_Name,AppointmentDate,AppointmentTime,HospitalName,DepartmentName,AppointmentStatus,PaymentStatus,PaymentAmount);
//        if(flag){
//            resp.getWriter().write("挂号成功!");
//            resp.sendRedirect("PatientSickShow.jsp?id="+patientId);
//        }
//        else{
//            resp.getWriter().write("挂号失败!");
//            resp.sendRedirect("Error.jsp");
//        }
    }
}
