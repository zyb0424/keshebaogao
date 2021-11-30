package myselvet.control;

import mybean.date.Register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HandRegister extends HttpServlet {
    public HandRegister() {
    }

    public void init(ServletConfig var1) throws ServletException {
        super.init(var1);

        try {
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
        String var3 = "jdbc:mysql://localhost:3306/1805110209?user=root&password=ZYB1834257301&serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false";
        Register var6 = new Register();
        var1.setAttribute("userBean", var6);
        String var7 = var1.getParameter("logname").trim();
        String var8 = var1.getParameter("password").trim();
        String var9 = var1.getParameter("again_password").trim();
        String var10 = var1.getParameter("phone").trim();
        String var11 = var1.getParameter("address").trim();
        String var12 = var1.getParameter("realname").trim();
        if (var7 == null) {
            var7 = "";
        }

        if (var8 == null) {
            var8 = "";
        }

        if (!var8.equals(var9)) {
            var6.setBackNews("两次密码不同，注册失败，");
            RequestDispatcher var19 = var1.getRequestDispatcher("inputRegisterMess.jsp");
            var19.forward(var1, var2);
        } else {
            boolean var13 = true;

            for(int var14 = 0; var14 < var7.length(); ++var14) {
                char var15 = var7.charAt(var14);
                if ((var15 > 'z' || var15 < 'a') && (var15 > 'Z' || var15 < 'A') && (var15 > '9' || var15 < '0')) {
                    var13 = false;
                }
            }

            boolean var20 = var7.length() > 0 && var8.length() > 0 && var13;
            String var21 = "";

            try {
                Connection var4 = DriverManager.getConnection(var3);
                String var16 = "INSERT INTO user VALUES (?,?,?,?,?)";
                PreparedStatement var5 = var4.prepareStatement(var16);
                if (var20) {
                    var5.setString(1, this.handleString(var7));
                    var5.setString(2, this.handleString(var8));
                    var5.setString(3, this.handleString(var10));
                    var5.setString(4, this.handleString(var11));
                    var5.setString(5, this.handleString(var12));
                    int var17 = var5.executeUpdate();
                    if (var17 != 0) {
                        var21 = "注册成功";
                        var6.setBackNews(var21);
                        var6.setLogname(var7);
                        var6.setPhone(this.handleString(var10));
                        var6.setAddress(this.handleString(var11));
                        var6.setRealname(this.handleString(var12));
                    }
                } else {
                    var21 = "信息填写不完整或名字中有非法字符";
                    var6.setBackNews(var21);
                }

                var4.close();
            } catch (SQLException var18) {
                var21 = "该会员名已被使用，请您更换名字" + var18;
                var6.setBackNews(var21);
            }

            RequestDispatcher var22 = var1.getRequestDispatcher("inputRegisterMess.jsp");
            var22.forward(var1, var2);
        }
    }

    public void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        this.doPost(var1, var2);
    }
}
