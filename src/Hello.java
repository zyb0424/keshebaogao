import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hello {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String var7 ="jdbc:mysql://localhost:3306/1805110209?user=root&password=ZYB1834257301&serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false";
        Connection var3 = DriverManager.getConnection(var7);
        System.out.println("000");
    }
}
