package org.xxh.realstuff.net;

import com.google.gson.Gson;

import org.xxh.realstuff.commons.Constants;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class RealStuffRetrofitFactory extends BaseRetrofitFactory {


    @Override
    protected String getBaseUrl() {
        return Constants.Host.RELEASE_HOST;
    }

    @Override
    protected OkHttpClient getClient() {
        return CallFactoryProvider.get();
    }


    @Override
    protected CallAdapter.Factory getCallAdapterFactory() {
        return RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    @Override
    protected Converter.Factory getConverterFactory() {
        return GsonConverterFactory.create(new Gson());
    }
}
