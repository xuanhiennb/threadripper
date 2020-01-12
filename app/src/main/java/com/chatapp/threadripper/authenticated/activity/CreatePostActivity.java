package com.chatapp.threadripper.authenticated.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chatapp.threadripper.R;
import com.chatapp.threadripper.utils.Constants;
import com.chatapp.threadripper.utils.ImageLoader;
import com.chatapp.threadripper.utils.Preferences;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class CreatePostActivity extends AppCompatActivity {
    ImageView ic_back, ic_create, img_image;
    CircleImageView cv_avatar;
    TextView tv_displayName;
    EditText edt_content;
    ImageButton btn_picture, btn_capture;
    Uri uriAttachImage;
    String uriAttachImageString;
    Bitmap bitmapCaptureImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        addControls();
        addEvents();

    }

    private void addEvents() {
        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tv_displayName.setText(Preferences.getCurrentUser().getDisplayName());
        ImageLoader.loadUserAvatar(cv_avatar, Preferences.getCurrentUser().getPhotoUrl());

        btn_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePicture();
            }
        });

        btn_capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capturePicture();
            }
        });
    }

    @SuppressLint("NewApi")
    private void capturePicture() {
        btn_capture.setImageResource(R.drawable.ic_action_linked_camera_accent);

        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, Constants.REQUEST_CODE_PERMISSION_IMAGE_CAPTURE);
        } else {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, Constants.REQUEST_CODE_CAPTURE_IMAGE);
        }
    }

    private void choosePicture() {
        btn_picture.setImageResource(R.drawable.ic_action_add_photo_alternate_accent);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select picture"), Constants.REQUEST_CODE_PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE_PICK_IMAGE) {
            if (resultCode == RESULT_OK && data != null) {
                handlePickImageSuccess(data);
            }
            btn_picture.setImageResource(R.drawable.ic_action_add_photo_alternate);

        } else if (requestCode == Constants.REQUEST_CODE_CAPTURE_IMAGE) {
            if (resultCode == RESULT_OK && data != null) {
                handleCaptureImageSuccess(data);
            }
            btn_capture.setImageResource(R.drawable.ic_action_linked_camera);

        }
    }

    private void handleCaptureImageSuccess(Intent data) {

        bitmapCaptureImage = (Bitmap) Objects.requireNonNull(data.getExtras()).get("data");
        img_image.setImageBitmap(bitmapCaptureImage);
        uriAttachImageString = null; // reset method pick image, current image is captured
        uriAttachImage = null;

    }

    private void handlePickImageSuccess(Intent data) {
        Uri uri = data.getData();
        uriAttachImage = uri;
        if (uri != null) {
            uriAttachImageString = uri.toString();
        }
        ImageLoader.loadImageChatMessage(img_image, uriAttachImageString);
        bitmapCaptureImage = null; // reset method capture image, current image is picked
    }

    private void addControls() {
        ic_back = (ImageView) findViewById(R.id.ic_back);
        ic_create = (ImageView) findViewById(R.id.ivCreate);
        img_image = (ImageView) findViewById(R.id.img_image);
        cv_avatar = (CircleImageView) findViewById(R.id.cv_avatar);
        tv_displayName = (TextView) findViewById(R.id.tv_display_name);
        edt_content = (EditText) findViewById(R.id.edt_content);
        btn_capture = (ImageButton) findViewById(R.id.btn_capture);
        btn_picture = (ImageButton) findViewById(R.id.btn_picture);
    }


}
