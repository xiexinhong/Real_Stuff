package org.xxh.realstuff.business;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.xxh.realstuff.R;
import org.xxh.realstuff.business.categories.CategoryFragment;
import org.xxh.realstuff.business.news.NewFragment;
import org.xxh.realstuff.business.others.OtherFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/10/26.
 */

public class TabManager {

    private List<View> mTabs;
    private int[] mTxtIds;
    private int[] mIconIds;
    private List<Class<? extends Fragment>> mFragmentClzzs;
    private static final int TAB_SIZE = 3;

    private TabManager() {
        mTxtIds = new int[]{R.string.tab_new, R.string.tab_category, R.string.tab_other};
        mIconIds = new int[]{R.drawable.ic_tab_new, R.drawable.ic_tab_category, R.drawable
                .ic_tab_other};
        mFragmentClzzs = new ArrayList<>();
        mFragmentClzzs.add(NewFragment.class);
        mFragmentClzzs.add(CategoryFragment.class);
        mFragmentClzzs.add(OtherFragment.class);
    }

    private static class TabManagerHolder {
        private static TabManager mTabManager = new TabManager();
    }

    public static TabManager getInstance() {
        return TabManagerHolder.mTabManager;
    }

    public List<View> getTabs(Context context) {
        if (mTabs == null || TAB_SIZE > mTabs.size()) {
            initTabs(context);
        }
        return mTabs;
    }

    public List<Class<? extends Fragment>> getFragmentClazzs() {
        return mFragmentClzzs;
    }

    private void initTabs(Context context) {
        mTabs = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(context);
        for (int i = 0; i < TAB_SIZE; i++) {
            View tabView = inflater.inflate(R.layout.layout_tab_item, null);
            ImageView tabIcon = (ImageView) tabView.findViewById(R.id.tab_icon);
            tabIcon.setImageResource(mIconIds[i]);
            TextView tabTxt = (TextView) tabView.findViewById(R.id.tab_txt);
            tabTxt.setText(mTxtIds[i]);
            mTabs.add(tabView);
        }
    }

}
