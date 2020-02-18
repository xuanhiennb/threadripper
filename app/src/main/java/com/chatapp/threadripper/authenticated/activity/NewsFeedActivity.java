package com.chatapp.threadripper.authenticated.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.chatapp.threadripper.R;
import com.chatapp.threadripper.authenticated.BaseMainActivity;

public class NewsFeedActivity extends BaseMainActivity {
    FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
        setupToolbarWithBackButton(R.id.toolbar, "Bảng tin");
    }

    private void initView() {
        btnAdd = (FloatingActionButton) findViewById(R.id.btn_create_post);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewsFeedActivity.this, CreatePostActivity.class) );
            }
        });
    }

}
