<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML><HEAD><%@ include file="head.txt" %></HEAD>
<BODY background=image/back2.jpg><font size=2>
<div align="center">
<%   try {  Class.forName("com.mysql.cj.jdbc.Driver");
      }
      catch(Exception e){} 
      String uri="jdbc:mysql://localhost:3306/1805110209?user=root&password=ZYB1834257301&serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false";
      Connection con;
      Statement sql;
      ResultSet rs;
      try {
        con=DriverManager.getConnection(uri);
        sql=con.createStatement();
        //读取classify表，获得分类：  
        rs=sql.executeQuery("SELECT * FROM classify  ");
        out.print("<form action='queryServlet' method ='post'>") ;
        out.print("<select name='fenleiNumber'>") ;
        while(rs.next()){
           int id = rs.getInt(1);
           String name = rs.getString(2);
           out.print("<option value ="+id+">"+name+"</option>");
        }  
        out.print("</select>");
        out.print("<input type ='submit' value ='提交'>");  
        out.print("</form>");
        con.close();
     }
     catch(SQLException e){ 
        out.print(e);
     }
%>
</div></font>
</BODY></HTML>
