package mybean.date;

import java.util.LinkedList;

public class Login {
    String logname = "";
    String backNews = "未登录";
    LinkedList<String> car = new LinkedList();

    public Login() {
    }

    public void setLogname(String var1) {
        this.logname = var1;
    }

    public String getLogname() {
        return this.logname;
    }

    public void setBackNews(String var1) {
        this.backNews = var1;
    }

    public String getBackNews() {
        return this.backNews;
    }

    public LinkedList<String> getCar() {
        return this.car;
    }
}
