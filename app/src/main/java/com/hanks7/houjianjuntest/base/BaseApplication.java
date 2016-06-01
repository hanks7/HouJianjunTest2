package com.hanks7.houjianjuntest.base;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
//import com.umeng.socialize.PlatformConfig;

import java.io.File;


/**
 * Created by liu on 15/6/18.
 */
public class BaseApplication extends Application {
    private static BaseApplication application = null;
    public static Context context = null;
    public static RequestQueue queue = null;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        context = getApplicationContext();
        queue = Volley.newRequestQueue(this);
        initImageLoad();
//        initUM();
    }

//    private void initUM() {
//        PlatformConfig.setWeixin("wxb69878cd9241eb83", "2b2f94b8d765326aaa2f1f454db36c2e");
//        //微信 appid appsecret
//
//
//        PlatformConfig.setSinaWeibo("3463738408", "bc78526674f9117d68af948e8c312dc9");
//
//        //新浪微博 appkey appsecret
//
//        PlatformConfig.setQQZone("1105185993", "1B9OPvo62beJX14k");
//        // QQ和Qzone appid appkey
//    }

    public static RequestQueue getRequestQueueinstance() {
        if (queue == null) {
            queue = Volley.newRequestQueue(BaseApplication.getInstance());
        }
        return queue;
    }


    public static BaseApplication getInstance() {
        return application;
    }

    private void initImageLoad() {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R..mipmap.book_default_image_gried) // resource or drawable
//                .showImageForEmptyUri(R.mipmap.book_default_image_gried) // resource or drawable
//                .showImageOnFail(R.mipmap.book_default_image_gried) // resource or drawable
                .resetViewBeforeLoading(false)  // default
                .delayBeforeLoading(1000)
                .cacheInMemory(false) // default
                .cacheOnDisc(false) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .displayer(new SimpleBitmapDisplayer()) // default
                .handler(new Handler()) // default
                .build();


        File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                .discCacheExtraOptions(480, 800, null)
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .discCache(new UnlimitedDiskCache(cacheDir)) // default
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileCount(100)
                .discCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(getApplicationContext())) // default
                .defaultDisplayImageOptions(options) // defaul
                .build();

        ImageLoader.getInstance().init(config);

    }


}
