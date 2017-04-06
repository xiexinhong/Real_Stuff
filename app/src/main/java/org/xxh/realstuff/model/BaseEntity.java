package org.xxh.realstuff.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class BaseEntity<T> {

    @SerializedName("msg")
    public String msg;

    @SerializedName("error")
    public boolean error;

    @SerializedName("results")
    public List<T> results;
}
