package hospital.servlet;

import hospital.service.PatientService;

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
        int patientId= Integer.parseInt(req.getParameter("patientId"));
        String name=req.getParameter("name");
        int age=Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        String part=req.getParameter("part");
        String sick=req.getParameter("sick");
        String inform=req.getParameter("inform");
        boolean flag=patientService.SickAdd(patientId,name,age,sex,part,sick,inform);
        if(flag){
            resp.getWriter().write("挂号成功!");
            resp.sendRedirect("PatientSickShow.jsp?id="+patientId);
        }
        else{
            resp.getWriter().write("挂号失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
