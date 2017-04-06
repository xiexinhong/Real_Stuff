package org.xxh.realstuff.business;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import org.xxh.realstuff.R;
import org.xxh.realstuff.base.BaseActivity;

import java.util.List;


public class HomeActivity extends BaseActivity {

    private ViewPager mContentVp;
    private TabLayout mBottomTl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        mContentVp = (ViewPager) findViewById(R.id.content);
        mBottomTl = (TabLayout) findViewById(R.id.bottom_tab);
        mContentVp.setOffscreenPageLimit(2);
        List<Class<? extends Fragment>> fragmentClazzs = TabManager.getInstance()
                .getFragmentClazzs();
        List<View> tabViews = TabManager.getInstance().getTabs(this);

        mContentVp.setAdapter(new HomePagerAdapter(getSupportFragmentManager(), fragmentClazzs));
        mBottomTl.setupWithViewPager(mContentVp);
        int tabCount = mBottomTl.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tab = mBottomTl.getTabAt(i);
            tab.setCustomView(tabViews.get(i));
        }
    }
}
