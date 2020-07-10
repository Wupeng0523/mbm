package com.tx.mbm;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tx.mbm.adapter.FirstPagerFragmentAdapter;
import com.tx.mbm.base.BaseActivity;
import com.tx.mbm.fragment.FirstFragment;
import com.tx.mbm.fragment.FouthFragment;
import com.tx.mbm.fragment.SecondFragment;
import com.tx.mbm.fragment.ThirdFragment;
import com.tx.mbm.view.NoAnimationViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private TabLayout mTableLayout;
    private NoAnimationViewPager mViewPager;
    private TextView title;
    private FirstPagerFragmentAdapter pagerFragmentAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mTableLayout = findViewById(R.id.table_layout);
        mViewPager = findViewById(R.id.view_pager);
        title = findViewById(R.id.title);
        initFragment();
        initTitle();
        pagerFragmentAdapter = new FirstPagerFragmentAdapter(getSupportFragmentManager(),fragmentList,titleList);
        mViewPager.setAdapter(pagerFragmentAdapter);
        mTableLayout.setupWithViewPager(mViewPager);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        title.setText("首页");
                        break;
                    case 1:
                        title.setText("内容");
                        break;
                    case 2:
                        title.setText("分类");
                        break;
                    case 3:
                        title.setText("我的");
                        break;
                        default:
                            break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initFragment(){
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
        fragmentList.add(new ThirdFragment());
        fragmentList.add(new FouthFragment());
    }
    private void initTitle(){
        String[] TITLES = {"首页","内容","分类","我的"};
        for (int i = 0;i < TITLES.length;i++){
            titleList.add(TITLES[i]);
        }
    }
    /**
     * 连续点击两次退出键，退出应用。
     */
    private long mExitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "在按一次退出", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        // 拦截MENU按钮点击事件，让他无任何操作
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
