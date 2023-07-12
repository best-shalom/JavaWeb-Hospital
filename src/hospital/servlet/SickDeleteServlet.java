package hospital.servlet;

import hospital.service.DoctorService;
import hospital.service.PatientService;
import hospital.user.Sick;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Administrator
 * 挂号数据删除
 * --医生删除--删除后转到DoctorSickShow
 * --病人删除--删除后转到PatientSickShow
 */
public class SickDeleteServlet extends HttpServlet {
    DoctorService doctorService=new DoctorService();
    PatientService patientService=new PatientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        /*按sick的id查找sick,便于取出patientId(PatientSickShow)和part(DoctorSickShow)传给SickShow页面*/
        Sick sick=doctorService.SickFindById(id);
        int patientId=sick.getPatientId();
        String DepartmentName=sick.getDepartmentname();
        String choose=req.getParameter("choose");
        if(Objects.equals(choose, "doctor")){
            boolean flag=doctorService.SickDelete(id);
            if(flag){
                resp.getWriter().write("删除成功!");
                /*用url传参的方式(因为SickShow中获取参数的方式是getParameter)*/
                resp.sendRedirect("DoctorSickShow.jsp?part="+DepartmentName);
            }
            else{
                resp.getWriter().write("删除失败!");
                resp.sendRedirect("Error.jsp");
            }
        }
        else if(Objects.equals(choose,"patient")){
            boolean flag=patientService.SickDelete(id);
            if(flag){
                resp.getWriter().write("删除成功!");
                resp.sendRedirect("PatientSickShow.jsp?id="+patientId);
            }
            else{
                resp.getWriter().write("删除失败!");
                resp.sendRedirect("Error.jsp");
            }
        }
        else{
            resp.getWriter().write("删除失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
