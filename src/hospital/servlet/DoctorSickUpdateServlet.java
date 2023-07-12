package hospital.servlet;

import hospital.service.DoctorService;
import hospital.user.Sick;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * 挂号数据更新--医生
 */
public class DoctorSickUpdateServlet extends HttpServlet {
    DoctorService doctorService=new DoctorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        /*patientId保持不变*/
        Sick s=doctorService.SickFindById(id);
        /*获取原科室以传给SickShow页面,便于显示医生科室下的病人*/
        String p=s.getDepartmentname();
        String P_Name=req.getParameter("P_Name");
        String D_Name=req.getParameter("D_Name");
        String AppointmentDate=req.getParameter("AppointmentDate");
        String AppointmentTime=req.getParameter("AppointmentTime");
        String HospitalName=req.getParameter("HospitalName");
        String DepartmentName=req.getParameter("DepartmentName");
        boolean flag=doctorService.SickUpdate(id,P_Name,D_Name,AppointmentDate,AppointmentTime,HospitalName,DepartmentName);
        if(flag){
            resp.getWriter().write("挂号数据更新成功!");
            resp.sendRedirect("DoctorSickShow.jsp?part="+p);
        }
        else {
            resp.getWriter().write("挂号数据更新失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
