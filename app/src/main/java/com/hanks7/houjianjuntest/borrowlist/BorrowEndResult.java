package com.hanks7.houjianjuntest.borrowlist;


import com.hanks7.houjianjuntest.bean.BaseResult;

/**
 * Created by gengjiajia on 16/2/19.
 */
public class BorrowEndResult  extends BaseResult {
    private BorrowResult pageBean;

    public BorrowResult getPageBean() {
        return pageBean;
    }

    public void setPageBean(BorrowResult pageBean) {
        this.pageBean = pageBean;
    }
}
