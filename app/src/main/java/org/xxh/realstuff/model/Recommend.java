package org.xxh.realstuff.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class Recommend {

    @SerializedName("")
    public String id;

    @SerializedName("createdAt")
    public String createdAt;

    @SerializedName("desc")
    public String desc;

    @SerializedName("type")
    public String type;

    @SerializedName("url")
    public String url;

    @SerializedName("used")
    public boolean used;

    @SerializedName("who")
    public String who;





}
