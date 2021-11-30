package mybean.date;

import javax.servlet.annotation.WebServlet;


public class Register {
    String logname = "";
    String phone = "";
    String address = "";
    String realname = "";
    String backNews = "请输入信息";

    public Register() {
    }

    public void setLogname(String var1) {
        this.logname = var1;
    }

    public String getLogname() {
        return this.logname;
    }

    public void setPhone(String var1) {
        this.phone = var1;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAddress(String var1) {
        this.address = var1;
    }

    public String getAddress() {
        return this.address;
    }

    public void setRealname(String var1) {
        this.realname = var1;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setBackNews(String var1) {
        this.backNews = var1;
    }

    public String getBackNews() {
        return this.backNews;
    }
}
