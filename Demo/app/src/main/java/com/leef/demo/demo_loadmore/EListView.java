package com.leef.demo.demo_loadmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;

import com.leef.demo.R;

/**
 * 支持上拉加载更多的 ExpandableListView
 */
public class EListView extends ExpandableListView implements AbsListView.OnScrollListener {

    View footer;    //  底部布局
    int totalItemCount; //总数量
    int lastVisibleItem;//最后一个可见的 Item
    boolean isLoading;

    ILoadListener iLoadListener;

    public void setInterface(ILoadListener iLoadListener) {
        this.iLoadListener = iLoadListener;
    }

    public interface ILoadListener {
        void onLoad();
    }

    public EListView(Context context) {
        super(context);
        initView(context);
    }

    public EListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    public EListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.footer_view, null);
        footer.findViewById(R.id.loading).setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (totalItemCount == lastVisibleItem
                && scrollState == SCROLL_STATE_IDLE) {
            if (!isLoading) {
                isLoading = true;
                footer.findViewById(R.id.loading).setVisibility(View.VISIBLE);
                iLoadListener.onLoad();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.lastVisibleItem = firstVisibleItem + visibleItemCount;
        this.totalItemCount = totalItemCount;
    }

    public void loadComplete() {
        isLoading = false;
        footer.findViewById(R.id.loading).setVisibility(View.GONE);
    }
}
