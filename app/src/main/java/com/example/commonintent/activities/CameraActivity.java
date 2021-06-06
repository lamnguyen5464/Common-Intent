package com.example.commonintent.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.commonintent.R;

import java.util.concurrent.TimeUnit;

import static com.example.commonintent.constant.IntentTypes.REQUEST_IMAGE_CAPTURE;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    Button btOpenCamera;

    void mapping(){
        btOpenCamera = findViewById(R.id.btOpenCamera);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mapping();

        btOpenCamera.setOnClickListener(this);
    }

    public void capturePhoto() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btOpenCamera){
                capturePhoto();
            }
        }
    }


