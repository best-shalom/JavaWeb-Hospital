package hospital.servlet;

import hospital.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminLoginServlet extends HttpServlet {
    AdminService adminService=new AdminService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String A_Name = req.getParameter("A_Name");
        String A_password = req.getParameter("A_password");
        boolean flag = adminService.AdminLogin(A_Name, A_password);

        if (flag) {
            resp.getWriter().write("登录成功!");
            req.setAttribute("A_Name", A_Name);
            req.getRequestDispatcher("Choose.jsp").forward(req, resp);
        } else {
            resp.getWriter().write("登录失败!");
            resp.sendRedirect("Error.jsp");
        }
    }
}
