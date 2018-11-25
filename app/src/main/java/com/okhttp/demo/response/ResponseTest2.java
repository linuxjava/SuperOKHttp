package com.okhttp.demo.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTest2 {
    @SerializedName("code")
    public int code;
    @SerializedName("msg")
    public String msg;
    @SerializedName("data")
    public List<Data> dataList;

    public class Data{
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
        @SerializedName("age")
        public int age;
    }
}
