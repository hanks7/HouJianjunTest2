package com.hanks7.houjianjuntest.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanks7.houjianjuntest.R;
import com.hanks7.houjianjuntest.base.BaseActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        init();
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
                break;
            case R.id.rl_borrow:
                break;
            case R.id.rl_platform:
                break;
            case R.id.rl_mine:
                break;
        }

    }
}
