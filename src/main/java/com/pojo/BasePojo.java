package com.pojo;

public class BasePojo {
    int entry;
    int page;
    int pageStart;
    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public int getPage() {
        return page;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
