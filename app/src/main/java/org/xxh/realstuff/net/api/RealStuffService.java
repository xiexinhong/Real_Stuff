package org.xxh.realstuff.net.api;

import org.xxh.realstuff.model.BaseEntity;
import org.xxh.realstuff.model.HomeEntity;
import org.xxh.realstuff.model.Recommend;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public interface RealStuffService {

    @GET("/api/day/{year}/{month}/{day}")
    Observable<HomeEntity> getHomePageData(@Path("year") int year,
                                           @Path("month") int month,
                                           @Path("day") int day);

    @GET("/api/data/Android/{month}/{day}")
    Observable<BaseEntity<Recommend>> getAndroidData(@Path("month") String month,
                                                     @Path("day") String day);

}
