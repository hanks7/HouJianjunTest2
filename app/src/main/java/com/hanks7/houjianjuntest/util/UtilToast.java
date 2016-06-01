package com.hanks7.houjianjuntest.util;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hanks7.houjianjuntest.R;
import com.hanks7.houjianjuntest.base.BaseApplication;

/**
 * Created by liu on 15/11/5.
 */
public class UtilToast {

    public static void showToast(String text)
    {
        Toast toast = new Toast(BaseApplication.context);
        View view = LayoutInflater.from(BaseApplication.context).inflate(R.layout.toast_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.msg_tv);
        textView.setText(text);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();
    }
}
