package com.hanks7.houjianjuntest.borrowlist;

import java.util.List;

/**
 * Created by gengjiajia on 16/2/19.
 * 借款列表返回结果集合
 */
public class BorrowResult  {
    private List<BorrowBean> page;

    public List<BorrowBean> getPage() {
        return page;
    }

    public void setPage(List<BorrowBean> page) {
        this.page = page;
    }

    /**
     * pageNum : 1
     * pageSize : 10
     * startOfPage : 0
     * totalNum : 21
     * totalPageNum : 3
     */


    private int pageNum;
    private int pageSize;
    private int startOfPage;
    private int totalNum;
    private int totalPageNum;

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartOfPage(int startOfPage) {
        this.startOfPage = startOfPage;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStartOfPage() {
        return startOfPage;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }
}
