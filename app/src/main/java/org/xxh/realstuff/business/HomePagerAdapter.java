package org.xxh.realstuff.business;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/10/25.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    List<Class<? extends Fragment>> mFragmentClazzs;

    public HomePagerAdapter(FragmentManager fm, List<Class<? extends Fragment>> fragmentClazzs) {
        super(fm);
        mFragmentClazzs = fragmentClazzs;
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("xxh","position");
        Fragment fragment = null;
        Class<? extends Fragment> clazz = mFragmentClazzs.get(position);
        try {
            fragment = clazz.newInstance();
        } catch (Exception e) {
            return null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mFragmentClazzs != null ? mFragmentClazzs.size() : 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

}
