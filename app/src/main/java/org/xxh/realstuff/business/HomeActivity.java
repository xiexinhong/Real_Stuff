package org.xxh.realstuff.business;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import org.xxh.realstuff.R;
import org.xxh.realstuff.base.BaseActivity;

import java.util.ArrayList;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new OtherFragment());
        mContentVp.setAdapter(new HomePagerAdapter(getSupportFragmentManager(), fragments));
        mBottomTl.setupWithViewPager(mContentVp);
        int tabCount = mBottomTl.getTabCount();
        String[] tabs = new String[]{"最新", "分类", "其它"};

        List<View> tabViews = TabManager.getInstance().getTabs(this);
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tab = mBottomTl.getTabAt(i);
            tab.setCustomView(tabViews.get(i));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
