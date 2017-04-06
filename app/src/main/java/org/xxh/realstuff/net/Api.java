package org.xxh.realstuff.net;

import org.xxh.realstuff.net.api.RealStuffService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class Api {

    private static final String TAG = Api.class.getSimpleName();

    private static Map<Class, Class<? extends BaseRetrofitFactory>> mFactoryClassHolder = new
            HashMap<>();

    private static Map<Class<? extends BaseRetrofitFactory>, Retrofit> mRetrofitHolder = new
            HashMap<>();

    static {
        mFactoryClassHolder.put(RealStuffService.class, RealStuffRetrofitFactory.class);
    }

    public synchronized static <T> T get(Class<T> clazz) {
        Class<? extends BaseRetrofitFactory> factoryClass = mFactoryClassHolder.get(clazz);
        if (factoryClass == null) {
            return null;
        }
        try {
            if (!mRetrofitHolder.containsKey(factoryClass)) {
                mRetrofitHolder.put(factoryClass, factoryClass.newInstance().create());
            }
            return mRetrofitHolder.get(factoryClass).create(clazz);
        } catch (Exception e) {
            return null;
        }
    }

}
