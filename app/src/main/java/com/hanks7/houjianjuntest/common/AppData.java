package com.hanks7.houjianjuntest.common;

import android.os.Environment;


/**
 * Created by liu on 15/6/1.
 */
public class AppData {

    //    public static String BASE_URL = "http://192.168.1.30/app/";
    //    public static String URL_IMAGE = "http://192.168.1.30/";



    public static String BASE_URL = "http://app.chinatou.com/app/";
    public static String URL_IMAGE = "http://app.chinatou.com/";
    public static String uid = null;
    public static String PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/cool/";
    public static String FILE_PATH = PATH + "lession/";
    public static String pageSize = "10";
//    public static LoginMesResult personMesResult;
    public static Boolean exit = false;//是否退出登录账号
    public static Boolean refushMineMess = false;//是否刷新个人数据

    public static String CACHE = Environment.getExternalStorageDirectory().getAbsolutePath() + "/chintou/";
    public static String PATH_CHINATOU_CACHE = CACHE + "chintou/";
    /**
     * 用户信息保存文件
     * *
     */
    public static String touxiang = "touxiang.dat";

    public static String usagbemoney;
}
