package com.example.commonintent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.commonintent.R;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.btUseContact).setOnClickListener(this);
        findViewById(R.id.btUseEmail).setOnClickListener(this);
        findViewById(R.id.btUseStorage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUseContact:
                startActivity(new Intent(this, ContactActivity.class));
                break;
            case R.id.btUseEmail:
                startActivity(new Intent(this, EmailActivity.class));
                break;
            case R.id.btUseStorage:
                startActivity(new Intent(this, FileStorageActivity.class));
                break;
            case R.id.btUseLocation:
                startActivity(new Intent(this, LocalActionActivity.class));
                break;
            case R.id.btUseMap:
                startActivity(new Intent(this, MapActivity.class));
                break;
            case R.id.btUsePlayMediaFile:
                startActivity(new Intent(this, MusicOrVideoActivity.class));
                break;
        }
    }
}