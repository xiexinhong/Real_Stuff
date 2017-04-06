package org.xxh.realstuff.business.others;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xxh.realstuff.R;
import org.xxh.realstuff.base.BaseFragment;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/10/25.
 */

public class OtherFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_other,container,false);
        return contentView;
    }
}
