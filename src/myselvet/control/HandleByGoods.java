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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

public class HandleByGoods extends HttpServlet {
    public HandleByGoods() {
    }

    public void init(ServletConfig var1) throws ServletException {
        super.init(var1);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception var3) {
        }

    }

    public void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        var1.setCharacterEncoding("gb2312");
        String var3 = var1.getParameter("buy");
        if (var3 != null && var3.length() != 0) {
            String var4 = var1.getParameter("price");
            if (var4 != null && var4.length() != 0) {
                float var5 = Float.parseFloat(var4);
                Login var6 = null;
                HttpSession var7 = var1.getSession(true);

                try {
                    var6 = (Login)var7.getAttribute("loginBean");
                    boolean var8 = var6.getLogname() == null || var6.getLogname().length() == 0;
                    if (var8) {
                        var2.sendRedirect("login.jsp");
                    }
                } catch (Exception var14) {
                    var2.sendRedirect("login.jsp");
                }

                String var15 = "jdbc:mysql://localhost:3306/1805110209?user=root&password=ZYB1834257301&serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false";

                try {
                    Connection var9 = DriverManager.getConnection(var15);
                    String var11 = "INSERT INTO orderform VALUES (?,?,?,?)";
                    PreparedStatement var10 = var9.prepareStatement(var11);
                    var10.setInt(1, 0);
                    var10.setString(2, var6.getLogname());
                    var10.setString(3, var3);
                    var10.setFloat(4, var5);
                    var10.executeUpdate();
                    LinkedList var12 = var6.getCar();
                    var12.clear();
                    this.success(var1, var2, "生成订单成功");
                } catch (SQLException var13) {
                    this.fail(var1, var2, "生成订单失败" + var13);
                }

            } else {
                this.fail(var1, var2, "没有计算价格和，无法生成订单");
            }
        } else {
            this.fail(var1, var2, "购物车没有物品，无法生成订单");
        }
    }

    public void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        this.doPost(var1, var2);
    }

    public void success(HttpServletRequest var1, HttpServletResponse var2, String var3) {
        var2.setContentType("text/html;charset=GB2312");

        try {
            PrintWriter var4 = var2.getWriter();
            var4.println("<html><body>");
            var4.println("<h2>" + var3 + "</h2>");
            var4.println("返回主页<br>");
            var4.println("<br><a href =index.jsp>主页</a>");
            var4.println("查看订单<br>");
            var4.println("<br><a href =lookOrderForm.jsp>查看订单</a>");
            var4.println("</body></html>");
        } catch (IOException var5) {
        }

    }

    public void fail(HttpServletRequest var1, HttpServletResponse var2, String var3) {
        var2.setContentType("text/html;charset=GB2312");

        try {
            PrintWriter var4 = var2.getWriter();
            var4.println("<html><body>");
            var4.println("<h2>" + var3 + "</h2>");
            var4.println("返回主页：");
            var4.println("<a href =index.jsp>主页</a>");
            var4.println("</body></html>");
        } catch (IOException var5) {
        }

    }
}
