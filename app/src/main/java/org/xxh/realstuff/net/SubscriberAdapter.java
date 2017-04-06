package org.xxh.realstuff.net;

import org.xxh.realstuff.model.ApiError;
import org.xxh.realstuff.model.BaseEntity;

import rx.Subscriber;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public abstract class SubscriberAdapter<T extends BaseEntity<?>> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onError(new ApiError(e));
    }

    @Override
    public void onNext(T t) {
        if(t.error || t.results == null) {
            onError(new ApiError(t.msg,t.error));
        } else {
            onSuccess(t);
        }
    }

    public abstract void onSuccess(T t);

    public abstract void onError(ApiError error);

}
