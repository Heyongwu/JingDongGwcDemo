package mvpframework.bwie.com.jingdonggwcdemo.view;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.R;
import mvpframework.bwie.com.jingdonggwcdemo.persenter.FragmentPresenter;
import mvpframework.bwie.com.jingdonggwcdemo.view2.FourFragment;
import mvpframework.bwie.com.jingdonggwcdemo.view2.OneFragment;
import mvpframework.bwie.com.jingdonggwcdemo.view2.ThreeFragment;
import mvpframework.bwie.com.jingdonggwcdemo.view2.TwoFragment;

public class MainActivity extends FragmentActivity implements IMainActivity, View.OnClickListener {

    /**
     * 电影
     */
    private Button mBtPageOne;
    /**
     * 电视剧
     */
    private Button mBtPageTwo;
    /**
     * 动漫
     */
    private Button mBtPageThree;
    /**
     * 综艺
     */

    private Button mBtPageFour;
    private LinearLayout mBtViewInclude;
    private ViewPager viewPager;
    private RelativeLayout mActivityMain;
    private FragmentManager manager;

    private FragmentPresenter fragmentPresenter;
    private List<Fragment> list = new ArrayList<>();
    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager mFragmentContent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentPresenter  = new FragmentPresenter(this);
        initView();

    }
    private void initView() {
        mBtPageOne = (Button) findViewById(R.id.bt_pageOne);
        mBtPageTwo = (Button) findViewById(R.id.bt_pageTwo);
        mBtPageThree = (Button) findViewById(R.id.bt_pageThree);
        mBtPageFour = (Button) findViewById(R.id.bt_pageFour);
        viewPager = (ViewPager) findViewById(R.id.fragment_content);
        mBtPageOne.setOnClickListener(this);
        mBtPageTwo.setOnClickListener(this);
        mBtPageThree.setOnClickListener(this);
        mBtPageFour.setOnClickListener(this);
        fragmentPresenter.xiaocaozuo();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_pageOne:
                viewPager.setCurrentItem(0);
                break;
            case R.id.bt_pageTwo:
                viewPager.setCurrentItem(1);
                break;
            case R.id.bt_pageThree:
                viewPager.setCurrentItem(2);
                break;
            case R.id.bt_pageFour:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void show() {
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        list.add(new FourFragment());
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);

    }

    @Override
    protected void onResume() {

        int id = getIntent().getIntExtra("fragid", 0);
        if(id == 4 ){
            FourFragment fourFragment = new FourFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_content,fourFragment);
            fragmentTransaction.commit();
            viewPager.setCurrentItem(3);
            Intent intent = new Intent();
            Intent intent1 = intent.setClass(MainActivity.this, FourFragment.class);

        }
        super.onResume();
    }
}
