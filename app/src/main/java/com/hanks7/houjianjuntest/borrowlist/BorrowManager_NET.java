package com.hanks7.houjianjuntest.borrowlist;

import com.android.volley.Request;
import com.hanks7.houjianjuntest.base.BaseManager;
import com.hanks7.houjianjuntest.common.AppData;

/**
 * Created by gengjiajia on 16/2/16.http://127.0.0.1/app/index.do
 * 借款列表manager
 */
public class BorrowManager_NET extends BaseManager {
    @Override
    public void onExecute() {
        String url = AppData.BASE_URL + "financeList.do?auth=f7ef28202ea5d47f20191a2a2d507b16";
        getWebData(url, BorrowEndResult.class, Request.Method.POST);
    }
}
