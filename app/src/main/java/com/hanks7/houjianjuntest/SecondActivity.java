package com.hanks7.houjianjuntest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanks7.houjianjuntest.base.BaseActivity;
import com.hanks7.houjianjuntest.util.UtilToast;

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
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        UtilToast.showToast(bundle.getParcelable("sd").toString());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=null;
                s.startsWith("s");
            }
        });

    }
}
