package com.okhttp.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.annotations.SerializedName;
import com.okhttp.demo.response.Model;
import com.okhttp.demo.response.ResponseTest1;
import com.okhttp.demo.response.ResponseTest2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

import xiao.free.okgo.OkGo;
import xiao.free.okgo.callback.FileCallback;
import xiao.free.okgo.callback.JsonCallback;
import xiao.free.okgo.callback.StringCallback;
import xiao.free.okgo.model.Progress;
import xiao.free.okgo.model.Response;

public class MainActivity extends AppCompatActivity {
    private String TAG = "okgo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 请求返回字符串
     *
     * @param view
     */
    public void onString(View view) {
        OkGo.<String>get("http://www.wanandroid.com/tools/mockapi/2616/okgotest1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.d(TAG, response.body());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, code + "::" + msg);
                    }
                });
    }

    public void onJson1(View view) {
        OkGo.<ResponseTest1>get("http://www.wanandroid.com/tools/mockapi/2616/okgotest1")
                .execute(new JsonCallback<ResponseTest1>() {
                    @Override
                    public void onSuccess(Response<ResponseTest1> response) {
                        int aa = 1;
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, code + "::" + msg);
                    }
                });
    }

    public void onJson2(View view) {
        OkGo.<String>get("http://www.wanandroid.com/tools/mockapi/2616/okgotest2")
                .params("test", "122")
                .params("jsonTest", new ResponseTest2())
                .execute(new JsonCallback<String>() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        int aa = 1;
                        aa = 2;
                        Log.d(TAG, "test::" + response.body());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, code + "::" + msg);
                    }
                });
    }

    public void onJsonArray(View view) {
        OkGo.<List<Model>>get("http://www.wanandroid.com/tools/mockapi/2616/okgotest3")
                .execute(new JsonCallback<List<Model>>() {
                    @Override
                    public void onSuccess(Response<List<Model>> response) {
                        int aa = 1;
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, code + "::" + msg);
                    }
                });
    }


    public void onDownload(View view) {
        test();
//        OkGo.<File>get("http://mmgr.myapp.com/myapp/gjbig/dianshiguanjia/tv_video.apk")
//                .execute(new FileCallback() {
//                    @Override
//                    public void onSuccess(Response<File> response) {
//                        Log.d(TAG, response.body().getAbsolutePath());
//                    }
//
//                    @Override
//                    public void onError(int code, String msg) {
//                        Log.d(TAG, code + ":" + msg);
//                    }
//
//                    @Override
//                    public void downloadProgress(Progress progress) {
//                        Log.d(TAG, progress.fraction + " : " + progress.speed);
//                    }
//                });
    }

    private void test(){

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("accountId", "sid");
            jsonObject.put("iSystem", 1);
            jsonObject.put("version", "1.0");
            jsonObject.put("wifiId", "gj");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonObjectTarget = new JSONObject();
        try {
            jsonObjectTarget.putOpt("req", jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        OkGo.<String>post("http://t-video.ccrgt.com/jprx/1010/forward")
                .headers("JPrx-Sign", "r=test&sg=f8a0f9d09d84a421dc1129c017acd7e3")
                .upJson(new ModelData())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.d("xiao1","body:" + response.body());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d("xiao1",code + ":" + msg);
                    }
                });
    }

    class ModelData{
        @SerializedName("name")
        public String accountId = "sid";
        public String version = "1.0";
        public String wifiId = "gj";
        public int iSystem = 1;
    }
}
