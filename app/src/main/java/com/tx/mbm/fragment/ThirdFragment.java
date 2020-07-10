package com.tx.mbm.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tx.mbm.R;
import com.tx.mbm.base.BaseFragment;

/**
 * nathon
 * 2020/7/10
 * description:
 * version:1.0
 */

public class ThirdFragment extends BaseFragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_third,container,false);
        return view;
    }
}
