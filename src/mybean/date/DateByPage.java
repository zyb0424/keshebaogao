package mybean.date;

import com.sun.rowset.CachedRowSetImpl;

import javax.servlet.annotation.WebServlet;


public class DateByPage {
    CachedRowSetImpl rowSet = null;
    int pageSize = 1;
    int totalPages = 1;
    int currentPage = 1;

    public void DataByPage() {
    }

    public void setRowSet(CachedRowSetImpl var1) {
        this.rowSet = var1;
    }

    public CachedRowSetImpl getRowSet() {
        return this.rowSet;
    }

    public void setPageSize(int var1) {
        this.pageSize = var1;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int var1) {
        this.totalPages = var1;
    }

    public void setCurrentPage(int var1) {
        this.currentPage = var1;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }
}
