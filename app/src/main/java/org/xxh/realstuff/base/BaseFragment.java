package org.xxh.realstuff.base;

import android.support.v4.app.Fragment;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/10/25.
 */

public class BaseFragment extends Fragment {

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        onUserVisibleHint(isVisibleToUser);
    }

    /**
     * 用于ViewPager切换Fragment的时候，提示当前可见还是隐藏
     * @param isVisibleToUser
     */
    protected void onUserVisibleHint(boolean isVisibleToUser) {
    }

}
