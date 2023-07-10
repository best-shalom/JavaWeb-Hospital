package hospital.servlet;

import hospital.service.PatientService;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PatientLoginServlet extends HttpServlet {
    private PatientService patientService = new PatientService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Captcha = req.getParameter("validationCode");
        String SureCaptcha = (String)req.getSession().getAttribute("randomCode");
        System.out.println(Captcha);
        if (!Objects.equals(Captcha, SureCaptcha)){
            req.setAttribute("Errormessage", "登录失败！验证码错误，请重新输入。");
            req.getRequestDispatcher("PatientLogin.jsp").forward(req, resp);
        }
        String phoneNumber = req.getParameter("PhoneNumber");
        String password = req.getParameter("Password");
        boolean flag = patientService.PatientLogin(phoneNumber, password);
        if (flag) {
            resp.getWriter().write("登录成功!");
            req.setAttribute("PhoneNumber", phoneNumber);
            req.getRequestDispatcher("PatientShow.jsp").forward(req, resp);
        } else {
            req.setAttribute("Errormessage", "登录失败！手机号或密码错误，请重新输入。");
            req.getRequestDispatcher("PatientLogin.jsp").forward(req, resp);
        }
    }
}