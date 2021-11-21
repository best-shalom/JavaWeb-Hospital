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
        int id= Integer.parseInt(req.getParameter("id"));
        /*patientId保持不变*/
        Sick s=patientService.SickFindById(id);
        /*获取patientId以传给SickShow页面*/
        int patientId=s.getPatientId();
        String name=req.getParameter("name");
        int age= Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        String part=req.getParameter("part");
        String sick=req.getParameter("sick");
        String inform=req.getParameter("inform");
        boolean flag=patientService.SickUpdate(id,name,age,sex,part,sick,inform);
        if(flag){
            resp.getWriter().write("挂号数据更新成功!");
            resp.sendRedirect("PatientSickShow.jsp?id="+patientId);
        }
        else {
            resp.getWriter().write("挂号数据更新失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
