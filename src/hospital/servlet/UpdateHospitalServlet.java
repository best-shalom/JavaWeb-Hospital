package hospital.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dao.impl.HospitalDaoImpl;
import hospital.user.Hospital;

public class UpdateHospitalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("Id"));
        System.out.println(id);
        String name = request.getParameter("name");
        String level = request.getParameter("level");
        String address = request.getParameter("address");
        String number = request.getParameter("number");
        String presidentName = request.getParameter("presidentname");
        String time = request.getParameter("time");
        String status = request.getParameter("status");
        String introduction = request.getParameter("introduction");

        HospitalDaoImpl hospitalDaoimpl = new HospitalDaoImpl();
        Hospital hospital = hospitalDaoimpl.find(id);
        hospital.setName(name);
        hospital.setLevel(level);
        hospital.setAddress(address);
        hospital.setNumber(number);
        hospital.setPresidentname(presidentName);
        hospital.setTime(time);
        hospital.setStatus(status);
        hospital.setIntroduction(introduction);

        boolean success = hospitalDaoimpl.update(hospital); // 调用 DAO 类的更新方法
        //System.out.println(success);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (success) {
            out.println("<script>");
            out.println("alert('医院信息已成功更新！');");
            out.println("window.location.href='./AdminHospitals.jsp';"); // 更新成功后重定向到医院管理页面
            out.println("</script>");
        } else {
            out.println("<script>");
            out.println("alert('医院信息更新失败，请重试！');");
            out.println("window.location.href='./AdminHospitals.jsp';"); // 更新失败后重定向到医院管理页面
            out.println("</script>");
        }

        out.close();
    }
}