package hospital.servlet;

import hospital.service.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Administrator
 * 医生登录响应
 */
public class DoctorLoginServlet extends HttpServlet {
    DoctorService doctorService=new DoctorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Captcha = req.getParameter("validationCode");
        String SureCaptcha = (String)req.getSession().getAttribute("randomCode");
        System.out.println(Captcha);
        if (!Objects.equals(Captcha, SureCaptcha)){
            req.setAttribute("Errormessage", "登录失败！验证码错误，请重新输入。");
            req.getRequestDispatcher("DoctorLogin.jsp").forward(req, resp);
        }
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        boolean flag=doctorService.DoctorLogin(phone,password);
        if(flag){
            resp.getWriter().write("登录成功!");

            /*转发到医生个人主页*/
            req.setAttribute("phone",phone);
            req.getRequestDispatcher("DoctorShow.jsp").forward(req,resp);
        }
        else{
            resp.getWriter().write("登录失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
