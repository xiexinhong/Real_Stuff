package org.xxh.realstuff.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.xxh.realstuff.model.BaseEntity;
import org.xxh.realstuff.model.BaseEntityDeserializer;
import org.xxh.realstuff.model.HomeEntity;
import org.xxh.realstuff.model.HomeEntityDeserializer;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class GsonProvider {

    private static Gson sDefaultIns;

    static {
        sDefaultIns = new GsonBuilder()
                .registerTypeAdapter(BaseEntity.class, new BaseEntityDeserializer())
                .registerTypeAdapter(HomeEntity.class, new HomeEntityDeserializer())
                .create();
    }

    public static Gson get() {
        return sDefaultIns;
    }
}
