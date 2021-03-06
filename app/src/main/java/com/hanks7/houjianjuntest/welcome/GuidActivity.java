package com.hanks7.houjianjuntest.welcome;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hanks7.houjianjuntest.R;
import com.hanks7.houjianjuntest.base.BaseActivity;
import com.hanks7.houjianjuntest.home.HomeActivity;
import com.hanks7.houjianjuntest.util.UtilSPutil;
import com.hanks7.houjianjuntest.util.UtilSystem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class GuidActivity extends BaseActivity {
    @Bind(R.id.gui_circle_indicator)
    CircleIndicator circleIndicator;
    @Bind(R.id.gui_viewpager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isWelcome=true;
        isHome=true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guid);
        ButterKnife.bind(this);
        GuiPagerAdapter adapter=new GuiPagerAdapter();
        viewPager.setAdapter(adapter);
        circleIndicator.setVisibility(View.INVISIBLE);
        circleIndicator.setViewPager(viewPager);
        UtilSPutil.getInstance().setInt("code", UtilSystem.getVersionCode());


    }

    public class GuiPagerAdapter extends PagerAdapter{
        int[] images =new int[]{R.mipmap.guide_one,R.mipmap.guide_two,R.mipmap.guide_three};


        List<ImageView> imageViews=new ArrayList<ImageView>();


        public GuiPagerAdapter() {
            for (int i = 0; i < images.length ; i++) {
                ImageView imageview=new ImageView(GuidActivity.this);
                imageview.setImageResource(images[i]);
                imageview.setScaleType(ImageView.ScaleType.FIT_XY);
                if(images.length==i+1){
                    imageview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            intentLeftToRight(HomeActivity.class);
                            finish();
                        }
                    });
                }
                imageViews.add(imageview);
            }

        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }
    }

}
