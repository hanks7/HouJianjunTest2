package com.hanks7.houjianjuntest.borrowlist;


import com.hanks7.houjianjuntest.base.ActionController;
import com.hanks7.houjianjuntest.base.BaseActivity;
import com.hanks7.houjianjuntest.base.BaseResultListener;

import java.util.Map;


/**
 * Created by gengjiajia on 15/9/17.
 * 借款列表controller
 */
public class BorrowController {
    private BaseActivity activity;
    private BorrowMoneyFragment borrowView;
    private int type;

    public BorrowController(BorrowMoneyFragment newBorrowView, BaseActivity baseActivity) {
        this.borrowView = newBorrowView;
        this.activity = baseActivity;
    }

    public void getDate(Map<String, String> map, int type) {
        this.type = type;
        if (type == 0) {
            ActionController.postDate(activity, BorrowManager.class, map, new BorrowListener(activity));
        } else {
            ActionController.postDate(activity, BorrowManager_NET.class, map, new BorrowListener(activity));
        }

    }


    private class BorrowListener extends BaseResultListener {

        public BorrowListener(BaseActivity act) {
            super(act);
        }

        @Override
        public void onStart() {
            super.onStart();

            switch (type) {
                case 0:
                    activity.showLoadDialog();
                    break;
            }


        }

        @Override
        public void onSuccess(Object result1) {

            super.onSuccess(result1);
            activity.removeLoadDialog();
            BorrowEndResult result = (BorrowEndResult) result1;


            switch (type) {
                case 0://初始化
                    borrowView.initDate(result.getPageBean());
                    break;
                case 1://刷新
                    borrowView.refreshDate(result.getPageBean());
                    break;
                case 2://加载更多
                    borrowView.loadDate(result.getPageBean());
                    break;
            }


        }

        @Override
        public void onFailure(Object result) {
            super.onFailure(result);
            borrowView.erro();
        }
    }

}
