package org.xxh.realstuff.net;


import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public abstract class BaseRetrofitFactory {

    public Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(getClient())
                .addCallAdapterFactory(getCallAdapterFactory())
                .addConverterFactory(getConverterFactory())
                .build();
    }

    protected abstract String getBaseUrl();

    protected abstract OkHttpClient getClient();

    protected abstract CallAdapter.Factory getCallAdapterFactory();

    protected abstract Converter.Factory getConverterFactory();

}
