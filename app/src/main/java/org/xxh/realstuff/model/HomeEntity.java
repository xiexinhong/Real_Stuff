package org.xxh.realstuff.model;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class HomeEntity {

    @SerializedName("msg")
    public String msg;

    @SerializedName("error")
    public boolean error;

    @SerializedName("results")
    public LinkedHashMap<String,List<Recommend>> results;

    @SerializedName("category")
    public List<String> category;

}
