package hospital.servlet;

import hospital.service.DoctorService;
import hospital.service.PatientService;
import hospital.user.Doctor;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PatientAppointmentServlet extends HttpServlet {
    private PatientService patientService = new PatientService();
    private DoctorService doctorService = new DoctorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int UserID = Integer.parseInt(req.getParameter("UserID"));
        int HospitalID = Integer.parseInt(req.getParameter("HospitalID"));
        int DepartmentID = Integer.parseInt(req.getParameter("DepartmentID"));
        int DoctorID = Integer.parseInt(req.getParameter("DoctorID"));
        String Date = req.getParameter("Date");
        String Time = req.getParameter("Time");
        String UserName = patientService.PatientShow(UserID).getName();
        Doctor doctor = doctorService.DoctorShow(DoctorID);
        Random random = new Random();
        int PaymentAmount = random.nextInt(100) + 10;
        String Payment = Integer.toString(PaymentAmount) + "元";
        boolean flag = patientService.SickAdd(UserID,DoctorID,UserName,doctor.getName(),Date,Time,doctor.getPart(),doctor.getPart2(),"已挂号","未缴费",Payment);
        if (flag) {
            req.setAttribute("Errormessage", "挂号成功");
            req.setAttribute("UserID", UserID);
            req.getRequestDispatcher("PatientCenter.jsp").forward(req, resp);
        } else {
            req.setAttribute("Errormessage", "挂号失败");
            req.getRequestDispatcher("PatientCenter.jsp").forward(req, resp);
        }
    }
}