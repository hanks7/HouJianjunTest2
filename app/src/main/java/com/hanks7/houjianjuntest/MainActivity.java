package com.hanks7.houjianjuntest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanks7.houjianjuntest.base.BaseActivity;
import com.hanks7.houjianjuntest.util.UtilToast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.button)
    Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isHome = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UtilToast.showToast("fasdfasdf");
        ButterKnife.bind(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentLeftToRight(SecondActivity.class);
            }
        });
        Button button2=new Button(this);


    }
}
