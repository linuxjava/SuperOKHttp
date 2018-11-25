package com.okhttp.demo.response;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("age")
    public int age;
}
