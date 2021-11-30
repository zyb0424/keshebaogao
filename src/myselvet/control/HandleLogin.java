package myselvet.control;

import mybean.date.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//@WebServlet("/loginBean")
public class HandleLogin extends HttpServlet {
    public HandleLogin() {
    }

    public void init(ServletConfig var1) throws ServletException {
        super.init(var1);

        try {
            //这儿是java和mysql连接的驱动包路径
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception var3) {
        }

    }

    public String handleString(String var1) {
        try {
            byte[] var2 = var1.getBytes("iso-8859-1");
            var1 = new String(var2);
        } catch (Exception var3) {
        }

        return var1;
    }

    public void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        String var5 = var1.getParameter("logname").trim();
        String var6 = var1.getParameter("password").trim();
        var5 = this.handleString(var5);
        var6 = this.handleString(var6);
        //这儿是数据库路径的url 啊
        String var7 ="jdbc:mysql://localhost:3306/1805110209?user=root&password=ZYB1834257301&serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false";
        boolean var8 = var5.length() > 0 && var6.length() > 0;

        String var10;
        try {
            Connection var3 = DriverManager.getConnection(var7);
            String var9 = "select * from user where logname = '" + var5 + "' and password ='" + var6 + "'";
            Statement var4 = var3.createStatement();
            if (var8) {
                ResultSet var14 = var4.executeQuery(var9);
                boolean var11 = var14.next();
                if (var11) {
                    this.success(var1, var2, var5, var6);
                    RequestDispatcher var12 = var1.getRequestDispatcher("login.jsp");
                    var12.forward(var1, var2);
                } else {
                    String var15 = "您输入的用户名不存在，或密码不般配";
                    this.fail(var1, var2, var5, var15);
                }
            } else {
                var10 = "请输入用户名和密码";
                this.fail(var1, var2, var5, var10);
            }

            var3.close();
        } catch (SQLException var13) {
            var10 = "" + var13;
            this.fail(var1, var2, var5, var10);
        }

    }

    public void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        this.doPost(var1, var2);
    }

    public void success(HttpServletRequest var1, HttpServletResponse var2, String var3, String var4) {
        Login var5 = null;
        HttpSession var6 = var1.getSession(true);

        try {
            var5 = (Login)var6.getAttribute("loginBean");
            if (var5 == null) {
                var5 = new Login();
                var6.setAttribute("loginBean", var5);
                var5 = (Login)var6.getAttribute("loginBean");
            }

            String var7 = var5.getLogname();
            if (var7.equals(var3)) {
                var5.setBackNews(var3 + "已经登录了");
                var5.setLogname(var3);
            } else {
                var5.setBackNews(var3 + "登录成功");
                var5.setLogname(var3);
            }
        } catch (Exception var8) {
            var5 = new Login();
            var6.setAttribute("loginBean", var5);
            var5.setBackNews(var3 + "登录成功");
            var5.setLogname(var3);
        }

    }

    public void fail(HttpServletRequest var1, HttpServletResponse var2, String var3, String var4) {
        var2.setContentType("text/html;charset=GB2312");

        try {
            PrintWriter var5 = var2.getWriter();
            var5.println("<html><body>");
            var5.println("<h2>" + var3 + "登录反馈结果<br>" + var4 + "</h2>");
            var5.println("返回登录页面或主页<br>");
            var5.println("<a href =login.jsp>登录页面</a>");
            var5.println("<br><a href =index.jsp>主页</a>");
            var5.println("</body></html>");
        } catch (IOException var6) {
        }

    }
}
