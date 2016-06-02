package com.hanks7.houjianjuntest.borrowlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanks7.houjianjuntest.MainActivity;
import com.hanks7.houjianjuntest.R;
import com.hanks7.houjianjuntest.base.BaseActivity;

import java.util.List;

/**
 * Created by gengjiajia on 16/1/15.
 * 最新借款列表适配器
 */
public class NewBorrowViewAdapter extends BaseAdapter {
    private BaseActivity context;
    private LayoutInflater inflater;
    private List<BorrowBean> result;

    public NewBorrowViewAdapter(BaseActivity context, List<BorrowBean> date) {
        this.context = context;
        inflater = inflater.from(context);
        this.result = date;

    }

    @Override
    public int getCount() {
        return result==null?0:result.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.borrow_list_item, null);
            viewHolder.pb_progressbar = (ProgressBar) convertView.findViewById(R.id.pb_progressbar);
            viewHolder.progress_text = (TextView) convertView.findViewById(R.id.progress_text);
            viewHolder.project_item_layout = (RelativeLayout) convertView.findViewById(R.id.project_item_layout);


            viewHolder.one_text = (TextView) convertView.findViewById(R.id.one_text);
            viewHolder.jiekuan_typy = (TextView) convertView.findViewById(R.id.jiekuan_typy);
            viewHolder.borrow_lilv = (TextView) convertView.findViewById(R.id.borrow_lilv);
            viewHolder.tv_cycle_time = (TextView) convertView.findViewById(R.id.tv_cycle_time);
            viewHolder.tv_cycle_money = (TextView) convertView.findViewById(R.id.tv_cycle_money);
            viewHolder.tv_pay_way = (TextView) convertView.findViewById(R.id.tv_pay_way);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.one_text.setText(result.get(position).getBorrowTitle());
        if (result.get(position).getBorrowWay() == 6) {
            viewHolder.jiekuan_typy.setText("流转标");
            viewHolder.jiekuan_typy.setBackgroundResource(R.mipmap.green_biao);
        } else if (result.get(position).getBorrowWay() == 3) {
            viewHolder.jiekuan_typy.setText("信用标");
            viewHolder.jiekuan_typy.setBackgroundResource(R.mipmap.green_biao);
        }


        viewHolder.borrow_lilv.setText(result.get(position).getAnnualRate() + "%");

        viewHolder.pb_progressbar.setProgress((int) Double.parseDouble(result.get(position).getSchedules()));
        viewHolder.progress_text.setText(result.get(position).getSchedules() + "%");


        viewHolder.tv_cycle_time.setText(result.get(position).getDeadline() + "个月");
        viewHolder.tv_cycle_money.setText("融资金额:" + result.get(position).getBorrowAmount());


        if (result.get(position).getPaymentMode() == 1) {
            viewHolder.tv_pay_way.setText("等额本息");
        } else if (result.get(position).getPaymentMode() == 2) {
            viewHolder.tv_pay_way.setText("按月付息,到期还本");
        } else if (result.get(position).getPaymentMode() == 4) {
            viewHolder.tv_pay_way.setText("一次性还款");
        }


        viewHolder.project_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt("borrowId", result.get(position).getId());
                bundle.putInt("borrowshow", result.get(position).getBorrowWay());
                context.intentLeftToRight(MainActivity.class);
            }
        });

        return convertView;
    }

    public void setResult(List<BorrowBean> result) {
        this.result = result;
    }

    public void addData(List<BorrowBean> data) {
        if (data != null) {
            this.result.addAll(data);
        }
    }

    private class ViewHolder {
        private RelativeLayout project_item_layout;
        private TextView one_text;//标名
        private TextView jiekuan_typy;
        private TextView borrow_lilv;
        private ProgressBar pb_progressbar;
        private TextView progress_text;
        private TextView tv_cycle_time;
        private TextView tv_cycle_money;
        private TextView tv_pay_way;


    }
}
