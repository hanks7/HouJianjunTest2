package com.hanks7.houjianjuntest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanks7.houjianjuntest.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondActivity extends BaseActivity {
    @Bind(R.id.button2)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=null;
                s.startsWith("s");
            }
        });

    }
}
