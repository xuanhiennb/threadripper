package com.chatapp.threadripper.authenticated.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chatapp.threadripper.R;
import com.chatapp.threadripper.authenticated.BaseMainActivity;
import com.chatapp.threadripper.models.Diary;
import com.chatapp.threadripper.utils.Preferences;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalActivity extends BaseMainActivity {
//    ViewPager viewPager;
//    TabLayout tabLayout;
    RecyclerView rcvPersonal;
    ImageView imgCover;
    CircleImageView imgAvatar;
    TextView tvDisplayName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
        setupToolbarWithBackButton(R.id.toolbar, "Trang cá nhân");

    }

    private void initView() {
//        viewPager = (ViewPager) findViewById(R.id.vp_personal);
//        tabLayout = (TabLayout) findViewById(R.id.tabs_personal);
//        setupToolbarWithBackButton(R.id.toolbar, "Trang cá nhân");
//
//        PersonalAdapter pagerAdapter = new PersonalAdapter(getSupportFragmentManager());
//        pagerAdapter.addFragment(new DiaryFragment(), "Nhật ký");
//        pagerAdapter.addFragment(new PictureFragment(), "Hình ảnh");
//        viewPager.setAdapter(pagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);
        imgAvatar = (CircleImageView) findViewById(R.id.cv_avatar);
        imgCover = (ImageView) findViewById(R.id.img_cover);
        tvDisplayName = (TextView) findViewById(R.id.tv_display_name);

        tvDisplayName.setText(Preferences.getCurrentUser().getDisplayName());
//        imgAvatar.setImageDrawable(Preferences.getCurrentUser().getPhotoUrl());
//        ImageLoader.loadUserAvatar(imgAvatar, Preferences.getCurrentUser().getPhotoUrl());

        rcvPersonal = (RecyclerView) findViewById(R.id.rcv_personal);
        ArrayList<Diary> diaryArrayList = new ArrayList<>();
        diaryArrayList.add(new Diary("Hello", R.drawable.logohvktmm, "20 giờ trước"));
        diaryArrayList.add(new Diary("Hello", R.drawable.placeholder_group_avatar, "20 giờ trước"));
        diaryArrayList.add(new Diary("Hello", R.drawable.logohvktmm, "20 giờ trước"));
        diaryArrayList.add(new Diary("Hello", R.drawable.placeholder_user_avatar, "20 giờ trước"));

        PersonalAdapter adapter =new PersonalAdapter(this, diaryArrayList);
        rcvPersonal.setAdapter(adapter);
        rcvPersonal.setLayoutManager(new LinearLayoutManager(this));
    }
}
