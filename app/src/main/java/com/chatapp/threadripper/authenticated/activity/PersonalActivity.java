package com.chatapp.threadripper.authenticated.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chatapp.threadripper.R;
import com.chatapp.threadripper.authenticated.BaseMainActivity;
import com.chatapp.threadripper.authenticated.adapters.PersonalAdapter;
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
    FloatingActionButton btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
        setupToolbarWithBackButton(R.id.toolbar, "Trang cá nhân");

    }

    private void initView() {

        imgAvatar = (CircleImageView) findViewById(R.id.cv_avatar);
        imgCover = (ImageView) findViewById(R.id.img_cover);
        tvDisplayName = (TextView) findViewById(R.id.tv_display_name);
        btnAdd = (FloatingActionButton) findViewById(R.id.btn_create_post);

        tvDisplayName.setText(Preferences.getCurrentUser().getDisplayName());
        rcvPersonal = (RecyclerView) findViewById(R.id.rcv_personal);
        ArrayList<Diary> diaryArrayList = new ArrayList<>();
        diaryArrayList.add(new Diary("Hello", R.drawable.logohvktmm, "20 giờ trước"));
        diaryArrayList.add(new Diary("Hello", R.drawable.placeholder_group_avatar, "20 giờ trước"));
        diaryArrayList.add(new Diary("Hello", R.drawable.logohvktmm, "20 giờ trước"));
        diaryArrayList.add(new Diary("Hello", R.drawable.placeholder_user_avatar, "20 giờ trước"));

        PersonalAdapter adapter =new PersonalAdapter(this, diaryArrayList);
        rcvPersonal.setAdapter(adapter);
        rcvPersonal.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonalActivity.this, CreatePostActivity.class) );
            }
        });

    }
}
