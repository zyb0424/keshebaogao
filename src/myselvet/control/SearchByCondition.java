package myselvet.control;

import com.sun.rowset.CachedRowSetImpl;
import mybean.date.DateByPage;

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


public class SearchByCondition extends HttpServlet {
    CachedRowSetImpl rowSet = null;

    public SearchByCondition() {
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
        String var3 = var1.getParameter("searchMess");
        String var4 = var1.getParameter("radio");
        if (var3 != null && var3.length() != 0) {
            String var5 = "";
            if (var4.equals("cosmetic_number")) {
                var5 = "SELECT * FROM cosmeticForm where cosmetic_number ='" + var3 + "'";
            } else if (var4.equals("cosmetic_name")) {
                var5 = "SELECT * FROM cosmeticForm where cosmetic_name LIKE '%" + var3 + "%'";
            } else if (var4.equals("cosmetic_price")) {
                double var6 = 0.0D;
                double var8 = 0.0D;
                String var10 = "[^0123456789.]";
                String[] var11 = var3.split(var10);
                if (var11.length == 1) {
                    var6 = var8 = Double.parseDouble(var11[0]);
                } else {
                    if (var11.length != 2) {
                        this.fail(var1, var2, "输入的价格格式有错误");
                        return;
                    }

                    var8 = Double.parseDouble(var11[0]);
                    var6 = Double.parseDouble(var11[1]);
                    if (var6 < var8) {
                        double var12 = var6;
                        var6 = var8;
                        var8 = var12;
                    }
                }

                var5 = "SELECT * FROM cosmeticForm where cosmetic_price <= " + var6 + " AND cosmetic_price>=" + var8;
            }

            HttpSession var16 = var1.getSession(true);
            Connection var7 = null;
            DateByPage var17 = null;

            try {
                var17 = (DateByPage)var16.getAttribute("dataBean");
                if (var17 == null) {
                    var17 = new DateByPage();
                    var16.setAttribute("dataBean", var17);
                }
            } catch (Exception var15) {
                var17 = new DateByPage();
                var16.setAttribute("dataBean", var17);
            }

            String var9 = "jdbc:mysql://localhost:3306/1805110209?user=root&password=ZYB1834257301&serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false";

            try {
                var7 = DriverManager.getConnection(var9);
                Statement var18 = var7.createStatement(1005, 1007);
                ResultSet var19 = var18.executeQuery(var5);
                this.rowSet = new CachedRowSetImpl();
                this.rowSet.populate(var19);
                var17.setRowSet(this.rowSet);
                var7.close();
            } catch (SQLException var14) {
            }

            var2.sendRedirect("byPageShow.jsp");
        } else {
            this.fail(var1, var2, "没有查询信息，无法查询");
        }
    }

    public void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        this.doPost(var1, var2);
    }

    public void fail(HttpServletRequest var1, HttpServletResponse var2, String var3) {
        var2.setContentType("text/html;charset=GB2312");

        try {
            PrintWriter var4 = var2.getWriter();
            var4.println("<html><body>");
            var4.println("<h2>" + var3 + "</h2>");
            var4.println("返回：");
            var4.println("<a href =searchCosmetic.jsp>查询化妆品</a>");
            var4.println("</body></html>");
        } catch (IOException var5) {
        }

    }
}
