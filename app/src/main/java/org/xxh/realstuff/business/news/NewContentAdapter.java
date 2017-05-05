package org.xxh.realstuff.business.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.xxh.realstuff.R;
import org.xxh.realstuff.model.Recommend;
import org.xxh.realstuff.widgets.PullZoomRecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/21.
 */

public class NewContentAdapter extends RecyclerView.Adapter {

    private static final float ASPECT_RATIO = 10.0f / 13.0f;

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_CATEGORY = 1;
    private static final int TYPE_ITEM = 2;
    private String mHeadUrl;
    private LinkedHashMap<String, List<Recommend>> mRecommendMaps;
    private List<ItemInfo> mItemInfos = new ArrayList<>();
    private PullZoomRecyclerView mRecyclerView;
    private LayoutInflater mInflater;


    public NewContentAdapter(PullZoomRecyclerView pullZoomRecyclerView, Context context) {
        mInflater = LayoutInflater.from(context);
        mRecyclerView = pullZoomRecyclerView;
    }

    public void setDataAndNotify(String headImgUrl, LinkedHashMap<String, List<Recommend>> maps) {
        mHeadUrl = headImgUrl;
        mItemInfos.clear();
        ItemInfo info = new ItemInfo();
        info.mType = TYPE_HEAD;
        info.mCategoryName = headImgUrl;
        mItemInfos.add(info);

        mRecommendMaps = maps;
        ItemInfo itemInfo;
        List<Recommend> recommends;
        for (Map.Entry<String, List<Recommend>> entry : maps.entrySet()) {
            itemInfo = new ItemInfo();
            itemInfo.mType = TYPE_CATEGORY;
            itemInfo.mCategoryName = entry.getKey();
            mItemInfos.add(itemInfo);
            recommends = entry.getValue();
            if (recommends != null) {
                for (int i = 0; i < recommends.size(); i++) {
                    itemInfo = new ItemInfo();
                    itemInfo.mType = TYPE_ITEM;
                    itemInfo.mCategoryName = entry.getKey();
                    itemInfo.mItemIndex = i;
                    mItemInfos.add(itemInfo);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mItemInfos.get(position).mType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View itemView;
        switch (viewType) {
            case TYPE_HEAD:
                itemView = mInflater.inflate(R.layout.layout_new_head_img, parent, false);
                holder = new HeadViewHolder(itemView);
                break;
            case TYPE_CATEGORY:
                itemView = mInflater.inflate(R.layout.layout_listitem_new_category, parent, false);
                holder = new CategoryViewHolder(itemView);
                break;
            case TYPE_ITEM:
                itemView = mInflater.inflate(R.layout.layout_listitem_new_item, parent, false);
                holder = new ItemViewHolder(itemView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeadViewHolder) {
            ((HeadViewHolder) holder).refreshItemUI();
        }

        if (holder instanceof CategoryViewHolder) {
            ((CategoryViewHolder) holder).refreshItemUI(position);
            return;
        }

        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).refreshItemUI(position);
            return;
        }
    }


    @Override
    public int getItemCount() {
        return mItemInfos == null ? 0 : mItemInfos.size();
    }

    private class HeadViewHolder extends RecyclerView.ViewHolder {
        private ViewGroup mHeadContainerVg;
        private ImageView mHeadDv;

        public HeadViewHolder(View itemView) {
            super(itemView);
            mHeadContainerVg = (ViewGroup) itemView;
            mHeadDv = (ImageView) itemView.findViewById(R.id.sdv_top_beauty_girl);
//            mHeadDv.setAspectRatio(ASPECT_RATIO);
        }


        public void refreshItemUI() {
            mRecyclerView.setZoomView(mHeadDv);
            mRecyclerView.setHeaderContainer(mHeadContainerVg);
//            if (!TextUtils.isEmpty(mHeadUrl)) {
//                mHeadDv.setImageURI(mHeadUrl);
//            }
        }
    }

    private class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView mCategoryTv;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            mCategoryTv = (TextView) itemView.findViewById(R.id.category_name_tv);
        }

        public void refreshItemUI(int position) {
            ItemInfo itemInfo = mItemInfos.get(position);
            mCategoryTv.setText(itemInfo.mCategoryName);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTv;
        private TextView mTimeTv;
        private TextView mRecommendPeopleTv;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTitleTv = (TextView) itemView.findViewById(R.id.tv_title);
            mTimeTv = (TextView) itemView.findViewById(R.id.tv_time);
            mRecommendPeopleTv = (TextView) itemView.findViewById(R.id.tv_recommend_people);
        }

        public void refreshItemUI(int position) {
            ItemInfo itemInfo = mItemInfos.get(position);
            List<Recommend> recommends = mRecommendMaps.get(itemInfo.mCategoryName);
            if (recommends != null) {
                Recommend recommend = recommends.get(itemInfo.mItemIndex);
                if (recommend != null) {
                    mTitleTv.setText(recommend.desc);
                    mTimeTv.setText(recommend.createdAt);
                    mRecommendPeopleTv.setText(recommend.who);
                }
            }
        }
    }

    private class ItemInfo {
        public int mType;
        public String mCategoryName;
        public int mItemIndex;
    }
}
