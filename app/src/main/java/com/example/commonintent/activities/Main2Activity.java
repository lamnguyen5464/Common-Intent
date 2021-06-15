package com.example.commonintent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.commonintent.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_main);

        findViewById(R.id.btUseContact).setOnClickListener(this);
        findViewById(R.id.btUseEmail).setOnClickListener(this);
        findViewById(R.id.btUseStorage).setOnClickListener(this);
        findViewById(R.id.btUseSettings).setOnClickListener(this);
        findViewById(R.id.btUseTextMassage).setOnClickListener(this);
        findViewById(R.id.btUseWebBrowser).setOnClickListener(this);
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
            case R.id.btUseSettings:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.btUseTextMassage:
                startActivity(new Intent(this, TextMessageActivity.class));
                break;
            case R.id.btUseWebBrowser:
                startActivity(new Intent(this, WebBrowserActivity.class));
                break;
        }
    }
}