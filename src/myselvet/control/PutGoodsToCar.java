package myselvet.control;

import mybean.date.Login;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class PutGoodsToCar extends HttpServlet {
    public PutGoodsToCar() {
    }

    public void init(ServletConfig var1) throws ServletException {
        super.init(var1);
    }

    public void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        var1.setCharacterEncoding("gb2312");
        String var3 = var1.getParameter("java");
        System.out.println(var3);
        Login var4 = null;
        HttpSession var5 = var1.getSession(true);

        try {
            var4 = (Login)var5.getAttribute("loginBean");
            boolean var6 = var4.getLogname() == null || var4.getLogname().length() == 0;
            if (var6) {
                var2.sendRedirect("login.jsp");
            }

            LinkedList var7 = var4.getCar();
            var7.add(var3);
            this.speakSomeMess(var1, var2, var3);
        } catch (Exception var8) {
            var2.sendRedirect("login.jsp");
        }

    }

    public void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        this.doPost(var1, var2);
    }

    public void speakSomeMess(HttpServletRequest var1, HttpServletResponse var2, String var3) {
        var2.setContentType("text/html;charset=GB2312");

        try {
            PrintWriter var4 = var2.getWriter();
            var4.print("<%@ include file='head.txt' %></HEAD>");
            var4.println("<html><body>");
            var4.println("<h2>" + var3 + "放入购物车</h2>");
            var4.println("查看购物车或返回浏览化妆品<br>");
            var4.println("<a href =lookShoppingCar.jsp>查看购物车</a>");
            var4.println("<br><a href =byPageShow.jsp>浏览化妆品</a>");
            var4.println("</body></html>");
        } catch (IOException var5) {
        }

    }
}
