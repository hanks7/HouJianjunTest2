package com.hanks7.houjianjuntest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanks7.houjianjuntest.base.BaseActivity;
import com.hanks7.houjianjuntest.util.UtilGson;
import com.hanks7.houjianjuntest.util.UtilToast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @Bind(R.id.button)
    Button button;

    private String s;
    private TestBean sd;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hide();
        ButterKnife.bind(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentLeftToRight(SecondActivity.class, bundle);
            }
        });

        parseJson();
        bundle=new Bundle();
        bundle.putParcelable("sd", sd);



    }

    private void hide() {
        s="{ \"programmers\": [\n" +
                "\n" +
                "        { \"firstName\": \"Brett\", \"lastName\":\"McLaughlin\", \"email\": \"aaaa\" },\n" +
                "\n" +
                "        { \"firstName\": \"Jason\", \"lastName\":\"Hunter\", \"email\": \"bbbb\" },\n" +
                "\n" +
                "        { \"firstName\": \"Elliotte\", \"lastName\":\"Harold\", \"email\": \"cccc\" }\n" +
                "\n" +
                "        ],\n" +
                "\n" +
                "        \"authors\": [\n" +
                "\n" +
                "        { \"firstName\": \"Isaac\", \"lastName\": \"Asimov\", \"genre\": \"science fiction\" },\n" +
                "\n" +
                "        { \"firstName\": \"Tad\", \"lastName\": \"Williams\", \"genre\": \"fantasy\" },\n" +
                "\n" +
                "        { \"firstName\": \"Frank\", \"lastName\": \"Peretti\", \"genre\": \"christian fiction\" }\n" +
                "\n" +
                "        ],\n" +
                "\n" +
                "        \"musicians\": [\n" +
                "\n" +
                "        { \"firstName\": \"Eric\", \"lastName\": \"Clapton\", \"instrument\": \"guitar\" },\n" +
                "\n" +
                "        { \"firstName\": \"Sergei\", \"lastName\": \"Rachmaninoff\", \"instrument\": \"piano\" }\n" +
                "\n" +
                "        ] }";
    }

    public void parseJson(){
        sd = (TestBean) UtilGson.fromJson(s, TestBean.class);
        UtilToast.showToast(sd.getProgrammers().get(0).getEmail());

    }
}
