package com.hanks7.houjianjuntest.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanks7.houjianjuntest.R;
import com.hanks7.houjianjuntest.base.BaseActivity;
import com.hanks7.houjianjuntest.borrowlist.BorrowMoneyFragment;
import com.hanks7.houjianjuntest.util.UtilAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.rl_home)
    RelativeLayout rl_home;
    @Bind(R.id.rl_borrow)
    RelativeLayout rl_borrow;
    @Bind(R.id.rl_platform)
    RelativeLayout rl_platform;
    @Bind(R.id.rl_mine)
    RelativeLayout rl_mine;

    @Bind(R.id.iv_icon_home)
    ImageView iv_icon_home;
    @Bind(R.id.iv_icon_borrow)
    ImageView iv_icon_borrow;
    @Bind(R.id.iv_icon_platform)
    ImageView iv_icon_platform;
    @Bind(R.id.iv_icon_mine)
    ImageView iv_icon_mine;

    @Bind(R.id.tv_icon_home)
    TextView tv_icon_home;
    @Bind(R.id.tv_icon_borrow)
    TextView tv_icon_borrow;
    @Bind(R.id.tv_icon_platform)
    TextView tv_icon_platform;
    @Bind(R.id.tv_icon_mine)
    TextView tv_icon_mine;

    private FragmentManager manager;

    private BorrowMoneyFragment borrowMoneyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isHome=true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        init();
        setTabSelection(0);
        clickfailure(0);
    }

    private void init() {
        manager = getSupportFragmentManager();
        rl_home.setOnClickListener(this);
        rl_borrow.setOnClickListener(this);
        rl_platform.setOnClickListener(this);
        rl_mine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_home:
                setTabSelection(0);
                clickfailure(0);
                break;
            case R.id.rl_borrow:
                setTabSelection(1);
                clickfailure(1);
                break;
            case R.id.rl_platform:
                setTabSelection(2);
                clickfailure(2);
                break;
            case R.id.rl_mine:
                setTabSelection(3);
                clickfailure(3);
                break;
        }

    }

    /**
     * 点击失效
     *
     * @param index
     */
    private void clickfailure(int index) {
        switch (index) {
            case 0:
                rl_home.setEnabled(false);
                rl_borrow.setEnabled(true);
                rl_platform.setEnabled(true);
                rl_mine.setEnabled(true);
                break;
            case 1:
                rl_home.setEnabled(true);
                rl_borrow.setEnabled(false);
                rl_platform.setEnabled(true);
                rl_mine.setEnabled(true);
                break;
            case 2:
                rl_home.setEnabled(true);
                rl_borrow.setEnabled(true);
                rl_platform.setEnabled(false);
                rl_mine.setEnabled(true);
                break;
            case 3:
                rl_home.setEnabled(true);
                rl_borrow.setEnabled(true);
                rl_platform.setEnabled(true);
                rl_mine.setEnabled(false);
                break;
            default:
                break;
        }
    }

    /**
     * 清楚所有状态
     */
    private void clearState() {
        tv_icon_home.setTextColor(0xff727272);
        iv_icon_home.setImageResource(R.mipmap.home_image_grey);
        tv_icon_borrow.setTextColor(0xff727272);
        iv_icon_borrow.setImageResource(R.mipmap.borrow_money_grey);
        tv_icon_platform.setTextColor(0xff727272);
        iv_icon_platform.setImageResource(R.mipmap.platform_date_grey);
        tv_icon_mine.setTextColor(0xff727272);
        iv_icon_mine.setImageResource(R.mipmap.me_image_grey);
    }

    private void setTabSelection(int index) {
        //开启一个Fragment事务
        FragmentTransaction transaction = manager.beginTransaction();
        clearState();
        hideFragments(transaction);
        switchS(index, transaction);
    }

    private void switchS(int index, FragmentTransaction transaction) {
        switch (index) {
            case 0:

//                ivHome.setImageResource(R.mipmap.home_select);
                UtilAnimation.scaleView(iv_icon_home, R.mipmap.home_image_blue);
                tv_icon_home.setTextColor(0xff3696d3);
                if (borrowMoneyFragment == null) {
                    borrowMoneyFragment = new BorrowMoneyFragment();
                    transaction.add(R.id.activity_layout, borrowMoneyFragment);
                } else {
                    transaction.show(borrowMoneyFragment);
                }
                break;

            case 1:
//                ivHome.setImageResource(R.mipmap.home_select);
                UtilAnimation.scaleView(iv_icon_borrow, R.mipmap.home_image_blue);
                tv_icon_borrow.setTextColor(0xff3696d3);
                if (borrowMoneyFragment == null) {
                    borrowMoneyFragment = new BorrowMoneyFragment();
                    transaction.add(R.id.activity_layout, borrowMoneyFragment);
                } else {
                    transaction.show(borrowMoneyFragment);
                }
                break;

            case 2:
//                 ivHome.setImageResource(R.mipmap.home_select);
                UtilAnimation.scaleView(iv_icon_platform, R.mipmap.home_image_blue);
                tv_icon_platform.setTextColor(0xff3696d3);
                if (borrowMoneyFragment == null) {
                    borrowMoneyFragment = new BorrowMoneyFragment();
                    transaction.add(R.id.activity_layout, borrowMoneyFragment);
                } else {
                    transaction.show(borrowMoneyFragment);
                }
                break;
            case 3:
//                ivMine.setImageResource(R.mipmap.mine_select);
                UtilAnimation.scaleView(iv_icon_mine, R.mipmap.home_image_blue);
                tv_icon_mine.setTextColor(0xff3696d3);
                if (borrowMoneyFragment == null) {
                    borrowMoneyFragment = new BorrowMoneyFragment();
                    transaction.add(R.id.activity_layout, borrowMoneyFragment);
                } else {
                    transaction.show(borrowMoneyFragment);
                }
                break;


            default:
                break;
        }
        transaction.commit();

    }

    /**
     * 将所有的Fragment设置为隐藏状态
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (borrowMoneyFragment != null) {
            transaction.hide(borrowMoneyFragment);
        }

    }
}
