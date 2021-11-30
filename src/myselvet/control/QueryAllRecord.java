package myselvet.control;

import com.sun.rowset.CachedRowSetImpl;
import mybean.date.DateByPage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

public class QueryAllRecord extends HttpServlet {
    CachedRowSetImpl rowSet = null;

    public QueryAllRecord() {
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
        String var3 = var1.getParameter("fenleiNumber");
        if (var3 == null) {
            var3 = "0";
        }

        int var4 = Integer.parseInt(var3);
        HttpSession var5 = var1.getSession(true);
        Connection var6 = null;
        DateByPage var7 = null;

        try {
            var7 = (DateByPage)var5.getAttribute("dataBean");
            if (var7 == null) {
                var7 = new DateByPage();
                var5.setAttribute("dataBean", var7);
            }
        } catch (Exception var12) {
            var7 = new DateByPage();
            var5.setAttribute("dataBean", var7);
        }

        String var8 = "jdbc:mysql://localhost:3306/1805110209?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false";
        try {
            var6 = DriverManager.getConnection(var8, "root", "ZYB1834257301");
            Statement var9 = var6.createStatement(1005, 1007);
            ResultSet var10 = var9.executeQuery("SELECT * FROM cosmeticForm where id = " + var4);
            this.rowSet = new CachedRowSetImpl();
            this.rowSet.populate(var10);
            var7.setRowSet(this.rowSet);
            var6.close();
        } catch (SQLException var11) {
        }

        var2.sendRedirect("byPageShow.jsp");
    }

    public void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        this.doPost(var1, var2);
    }
}
