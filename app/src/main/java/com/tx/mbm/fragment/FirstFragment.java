package com.tx.mbm.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tx.mbm.R;
import com.tx.mbm.base.BaseFragment;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * nathon
 * 2020/7/10
 * description:
 * version:1.0
 */

public class FirstFragment extends BaseFragment {
    private static final String TAG = "FirstFragment";
    private View view;
    private PtrClassicFrameLayout ptrClassicFrameLayout;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        Log.d(TAG, "onCreateView: ");
        initPtr();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged: ");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.d(TAG, "onAttachFragment: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    /**
     * 刷新
     */
    private void initPtr() {
        ptrClassicFrameLayout = view.findViewById(R.id.refresh);
        ptrClassicFrameLayout.setResistance(4.0f);
        ptrClassicFrameLayout.setRatioOfHeaderHeightToRefresh(0.8f);
        ptrClassicFrameLayout.setDurationToClose(200);
        ptrClassicFrameLayout.setDurationToCloseHeader(1000);
        ptrClassicFrameLayout.setPullToRefresh(false);
        ptrClassicFrameLayout.setKeepHeaderWhenRefresh(true);
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                /****上拉加载****/
//                if (canLoadMore) {
//                    page++;
//                    initData();
//                } else {
//                    ToastUtils.show(context, "没有更多数据");
//                }
//                mPtrFrame.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                /****下拉刷新****/
//                page = 1;
//                canLoadMore = true;
//                if (Utils.getInstace().isLogin(getActivity()))
//                    initData();
//                mPtrFrame.refreshComplete();
            }

        });
        ptrClassicFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrClassicFrameLayout.autoRefresh();
            }
        }, 100);
    }

}
