package org.xxh.realstuff;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/21.
 */

public class RsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }

}
