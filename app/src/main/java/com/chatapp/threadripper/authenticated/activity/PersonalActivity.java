package com.chatapp.threadripper.authenticated.activity;

import android.os.Bundle;

import com.chatapp.threadripper.R;
import com.chatapp.threadripper.authenticated.BaseMainActivity;

public class PersonalActivity extends BaseMainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        inietView();

    }

    private void inietView() {
    setupToolbarWithBackButton(R.id.toolbar, "Trang cá nhân");
    }
}
