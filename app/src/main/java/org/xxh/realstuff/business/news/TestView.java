package org.xxh.realstuff.business.news;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import org.xxh.realstuff.R;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/12/16.
 */

public class TestView extends FrameLayout {

    public TestView(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_other,this,false);
        this.addView(view);
        this.addView(LayoutInflater.from(context).inflate(R.layout.fragment_other,this,false));
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e("xxh","onFinishInflate");
    }
}
