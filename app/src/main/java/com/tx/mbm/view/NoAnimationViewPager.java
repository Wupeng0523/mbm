package com.tx.mbm.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * nathon
 * 2020/7/10
 * description:
 * version:1.0
 */

public class NoAnimationViewPager extends ViewPager{

    public NoAnimationViewPager(@NonNull Context context) {
        super(context);
    }
    public NoAnimationViewPager(Context context, AttributeSet attrs) {

        super(context, attrs);

    }
    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }
}
