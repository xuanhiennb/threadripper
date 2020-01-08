package com.chatapp.threadripper.authenticated.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.chatapp.threadripper.R;
import com.chatapp.threadripper.authenticated.BaseMainActivity;

public class PersonalActivity extends BaseMainActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
//        initView();
        setupToolbarWithBackButton(R.id.toolbar, "Trang cá nhân");

    }

//    private void initView() {
//        viewPager = (ViewPager) findViewById(R.id.vp_personal);
//        tabLayout = (TabLayout) findViewById(R.id.tabs_personal);
//        setupToolbarWithBackButton(R.id.toolbar, "Trang cá nhân");
//
//        PersonalAdapter pagerAdapter = new PersonalAdapter(getSupportFragmentManager());
//        pagerAdapter.addFragment(new DiaryFragment(), "Nhật ký");
//        pagerAdapter.addFragment(new PictureFragment(), "Hình ảnh");
//        viewPager.setAdapter(pagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);
//    }
}
