package com.hanks7.houjianjuntest.borrowlist;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanks7.houjianjuntest.R;
import com.hanks7.houjianjuntest.base.BaseActivity;
import com.hanks7.houjianjuntest.base.BaseViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanks7 on 2016/6/2.
 */
public class BorrowMoneyFragment extends Fragment implements View.OnClickListener{
    private View view;
    private BaseActivity activity;
    private TextView title_text;
    private ViewPager my_collection_viewpager;
    private List<LinearLayout> views = new ArrayList<>();
//    private NewBorrowView newBorrowView;
//    private TransferView transferView;
    private BaseViewPageAdapter adapter;
    private View new_borrow_tex_view;
    private View zai_zhuanrang_view;
    private TextView new_borrow_tex;
    private TextView zai_zhuanrang_tex;


    public BorrowMoneyFragment() {
        super();
    }

    private void initView() {
        title_text = (TextView) view.findViewById(R.id.title_text);

        title_text.setText("借款列表");



        my_collection_viewpager = (ViewPager) view.findViewById(R.id.my_collection_viewpager);

        new_borrow_tex = (TextView) view.findViewById(R.id.new_borrow_tex);
        zai_zhuanrang_tex = (TextView) view.findViewById(R.id.zai_zhuanrang_tex);


        new_borrow_tex_view = (View) view.findViewById(R.id.new_borrow_tex_view);
        zai_zhuanrang_view = (View) view.findViewById(R.id.zai_zhuanrang_view);


//        newBorrowView = new NewBorrowView(activity);
//        transferView = new TransferView(activity);
//
//        views.add(newBorrowView);
//        views.add(transferView);

        adapter = new BaseViewPageAdapter(views);
        my_collection_viewpager.setAdapter(adapter);
        my_collection_viewpager.setOnPageChangeListener(new ViewPageListner());
        new_borrow_tex.setOnClickListener(this);
        zai_zhuanrang_tex.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return view.inflate(getActivity(), R.layout.fragment_type,container);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_borrow_tex:
                toborrow();
                my_collection_viewpager.setCurrentItem(0);
                break;
            case R.id.zai_zhuanrang_tex:
                tozhaiquan();
                my_collection_viewpager.setCurrentItem(1);
                break;

        }
    }

    private void toborrow() {
        new_borrow_tex.setTextColor(activity.getResources().getColor(R.color.c0781e6));
        zai_zhuanrang_tex.setTextColor(activity.getResources().getColor(R.color.c727272));
        new_borrow_tex_view.setVisibility(View.VISIBLE);
        zai_zhuanrang_view.setVisibility(View.INVISIBLE);
    }

    private void tozhaiquan() {
        new_borrow_tex.setTextColor(activity.getResources().getColor(R.color.c727272));
        zai_zhuanrang_tex.setTextColor(activity.getResources().getColor(R.color.c0781e6));
        new_borrow_tex_view.setVisibility(View.INVISIBLE);
        zai_zhuanrang_view.setVisibility(View.VISIBLE);
    }

    private class ViewPageListner implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            switch (position) {
                case 0:
                    toborrow();
                    break;
                case 1:
                    tozhaiquan();
                    break;
            }
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }


}
