package myselvet.control;

import mybean.date.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

public class HandleDelete extends HttpServlet {
    public HandleDelete() {
    }

    public void init(ServletConfig var1) throws ServletException {
        super.init(var1);
    }

    public void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        var1.setCharacterEncoding("gb2312");
        String var3 = var1.getParameter("delete");
        Login var4 = null;
        HttpSession var5 = var1.getSession(true);

        try {
            var4 = (Login)var5.getAttribute("loginBean");
            boolean var6 = var4.getLogname() == null || var4.getLogname().length() == 0;
            if (var6) {
                var2.sendRedirect("login.jsp");
            }

            LinkedList var7 = var4.getCar();
            var7.remove(var3);
        } catch (Exception var8) {
            var2.sendRedirect("login.jsp");
        }

        RequestDispatcher var9 = var1.getRequestDispatcher("lookShoppingCar.jsp");
        var9.forward(var1, var2);
    }

    public void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        this.doPost(var1, var2);
    }
}
