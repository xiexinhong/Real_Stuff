package org.xxh.realstuff.business.news;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xxh.realstuff.R;
import org.xxh.realstuff.base.BaseFragment;
import org.xxh.realstuff.model.HomeEntity;
import org.xxh.realstuff.model.Recommend;
import org.xxh.realstuff.net.Api;
import org.xxh.realstuff.net.api.RealStuffService;
import org.xxh.realstuff.widgets.PullZoomRecyclerView;

import java.util.LinkedHashMap;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

import static org.xxh.realstuff.widgets.PullZoomBaseView.ZOOM_HEADER;


/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/10/25.
 */

public class NewFragment extends BaseFragment implements View.OnClickListener {

    private PullZoomRecyclerView mToadyContentPzrv;
    private RecyclerView mTodayContentRv;
    private LinkedHashMap<String, List<Recommend>> mTodayData = new LinkedHashMap<>();
    private List<Recommend> mWelfares;
    private NewContentAdapter mAdapter;
    private String[] mCategory = {"福利", "休息视频", "iOS", "Android", "瞎推荐", "拓展资源"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_new, container, false);

        mToadyContentPzrv = (PullZoomRecyclerView) contentView;
        mToadyContentPzrv.setModel(ZOOM_HEADER);
        mTodayContentRv = mToadyContentPzrv.getRecyclerView();

        mTodayContentRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new NewContentAdapter(mToadyContentPzrv,getActivity());
        mTodayContentRv.setAdapter(mAdapter);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getTodayContent();
    }

    @Override
    public void onClick(View view) {
        getTodayContent();
    }

    private void getTodayContent() {
        Api.get(RealStuffService.class)
                .getHomePageData(2015, 8, 7)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("xxh", "" + e.getMessage());
                    }

                    @Override
                    public void onNext(HomeEntity homeEntity) {
                        Log.e("xxh", "Looper.myLooper() == Looper.getMainLooper()" + (Looper
                                .myLooper() == Looper.getMainLooper()));
                        if (homeEntity.results != null) {
                            adjustData(homeEntity.results);
                        }
                    }
                });
    }

    private void adjustData(LinkedHashMap<String, List<Recommend>> results) {
        mTodayData.clear();
        for (int i = 0; i < mCategory.length; i++) {
            if (i == 0) {
                mWelfares = results.get(mCategory[i]);
            } else {
                mTodayData.put(mCategory[i], results.get(mCategory[i]));
            }
        }
        refreshUI();
    }

    private void refreshUI() {
        String url = null;
        if (mWelfares != null && mWelfares.get(0) != null) {
            url = mWelfares.get(0).url;
        }
        mAdapter.setDataAndNotify(url,mTodayData);
    }
}
