package com.hanks7.houjianjuntest.borrowlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.hanks7.houjianjuntest.R;
import com.hanks7.houjianjuntest.base.BaseActivity;
import com.hanks7.houjianjuntest.common.AppData;

import java.util.HashMap;
import java.util.Map;

import in.srain.cube.views.loadmore.LoadMoreContainer;
import in.srain.cube.views.loadmore.LoadMoreHandler;
import in.srain.cube.views.loadmore.LoadMoreListViewContainer;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by hanks7 on 2016/6/2.
 */
public class BorrowMoneyFragment extends Fragment implements View.OnClickListener{
    private View view;
    private BaseActivity activity;
    private TextView title_text;
//    private List<LinearLayout> views = new ArrayList<>();
//    private NewBorrowView newBorrowView;
//    private TransferView transferView;
//    private BaseViewPageAdapter adapter;
    private View new_borrow_tex_view;
    private View zai_zhuanrang_view;
    private TextView new_borrow_tex;
    private TextView zai_zhuanrang_tex;


    private ListView borrow_commen_list;
    private NewBorrowViewAdapter adapter;
    private int curPage = 1;//页码 1
    private int pageSize;//每页数量
    private Map<String, String> map = new HashMap<>();
    private BorrowController controller;
    private PtrClassicFrameLayout ptrFragment;
    private PtrClassicFrameLayout ptrLayout;
    private LoadMoreListViewContainer loadListLayout;
    private int type;//1是刷新 2是加载


    public BorrowMoneyFragment() {
        super();
    }

    private void initView() {
        title_text = (TextView) view.findViewById(R.id.title_text);

        title_text.setText("借款列表");




        new_borrow_tex = (TextView) view.findViewById(R.id.new_borrow_tex);
        zai_zhuanrang_tex = (TextView) view.findViewById(R.id.zai_zhuanrang_tex);


        new_borrow_tex_view = (View) view.findViewById(R.id.new_borrow_tex_view);
        zai_zhuanrang_view = (View) view.findViewById(R.id.zai_zhuanrang_view);



        new_borrow_tex.setOnClickListener(this);
        zai_zhuanrang_tex.setOnClickListener(this);

        borrow_commen_list = (ListView) view.findViewById(R.id.borrow_commen_list);


        ptrLayout = (PtrClassicFrameLayout)view.findViewById(R.id.ptr_layout);
        loadListLayout = (LoadMoreListViewContainer) view.findViewById(R.id.load_list_layout);

        ptrLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, borrow_commen_list, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                curPage = 1;
                type = 1;
                getDate(type);
            }
        });
        loadListLayout.useDefaultHeader();
        loadListLayout.setLoadMoreHandler(new LoadMoreHandler() {
            @Override
            public void onLoadMore(LoadMoreContainer loadMoreContainer) {
                curPage++;
                type = 2;
                getDate(type);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_type,container,false);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (BaseActivity) this.getActivity();
        initView();

        controller = new BorrowController(this, activity);
        type = 0;
        getDate(type);
    }


    public void getDate(int type) {

        map.put("type", String.valueOf(1));
        map.put("curPage", String.valueOf(curPage));
        map.put("pageSize", AppData.pageSize);
        controller.getDate(map, type);

    }







    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_borrow_tex:
                toborrow();
                break;
            case R.id.zai_zhuanrang_tex:
                tozhaiquan();
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



    public void refreshDate(BorrowResult result) {
        ptrLayout.refreshComplete();
        if (adapter == null) {
            adapter = new NewBorrowViewAdapter(activity, result.getPage());
            borrow_commen_list.setAdapter(adapter);
        } else {
            adapter.setResult(result.getPage());
            adapter.notifyDataSetChanged();
        }


        isPaging(result.getTotalNum(), adapter.getCount());
    }

    public void loadDate(BorrowResult result) {
        if(adapter == null)
        {
            adapter = new NewBorrowViewAdapter(activity, result.getPage());
            borrow_commen_list.setAdapter(adapter);
        }else{
            adapter.addData(result.getPage());
            adapter.notifyDataSetChanged();
        }

        isPaging(result.getTotalNum(), adapter.getCount());
    }


    private void isPaging(int total, int currTotal) {
        if (currTotal < total) {
            loadListLayout.loadMoreFinish(false, true);
        } else {
            loadListLayout.loadMoreFinish(false, false);
        }
    }

    public void erro() {
        ptrLayout.refreshComplete();
        loadListLayout.loadMoreFinish(false, true);
    }


    public void initDate(BorrowResult result) {


        adapter = new NewBorrowViewAdapter(activity, result.getPage());

        adapter.setResult(result.getPage());
        borrow_commen_list.setAdapter(adapter);
        isPaging(result.getTotalNum(), adapter.getCount());

    }


}
