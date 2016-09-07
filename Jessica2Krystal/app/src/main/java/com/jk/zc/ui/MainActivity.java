package com.jk.zc.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jk.zc.R;
import com.jk.zc.ui.fragment.FragmentOne;
import com.jk.zc.ui.fragment.FragmentThree;
import com.jk.zc.ui.fragment.FragmentTwo;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_viewpage)
    ViewPager mViewPage;

    List<Fragment> mFragments;

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setViewPager();
        setBottomBar(savedInstanceState);
    }

    private void setViewPager() {
        mFragments = new ArrayList<>();
        mFragments.add(FragmentOne.newInstance());
        mFragments.add(FragmentTwo.newInstance());
        mFragments.add(FragmentThree.newInstance());
        mViewPage.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
        mViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomBar.selectTabAtPosition(position, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setBottomBar(Bundle savedInstanceState) {
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.bottombar_menu_three_items);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.bb_menu_favorites:
                        mViewPage.setCurrentItem(0);
                        break;
                    case R.id.bb_menu_nearby:
                        mViewPage.setCurrentItem(1);
                        break;
                    case R.id.bb_menu_friends:
                        mViewPage.setCurrentItem(2);
                        break;
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mBottomBar.onSaveInstanceState(outState);
    }
}

