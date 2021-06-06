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
        findViewById(R.id.btUseAlarm).setOnClickListener(this);
        findViewById(R.id.btUseCalendar).setOnClickListener(this);
        findViewById(R.id.btUseCamera).setOnClickListener(this);

        findViewById(R.id.btnNote).setOnClickListener(this);
        findViewById(R.id.btnSearch).setOnClickListener(this);
        findViewById(R.id.btnPhone).setOnClickListener(this);
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
<<<<<<< HEAD
            case R.id.btUseLocation:
                startActivity(new Intent(this, LocalActionActivity.class));
                break;
            case R.id.btUseMap:
                startActivity(new Intent(this, MapActivity.class));
                break;
            case R.id.btUsePlayMediaFile:
                startActivity(new Intent(this, MusicOrVideoActivity.class));
=======
            case R.id.btUseAlarm:
                startActivity(new Intent(this, AlarmClockActivity.class));
                break;
            case R.id.btUseCalendar:
                startActivity(new Intent(this, CalendarActivity.class));
                break;
            case R.id.btUseCamera:
                startActivity(new Intent(this, CameraActivity.class));
                break;
            case R.id.btnNote:
                startActivity(new Intent(this, NoteActivity.class));
                break;
            case R.id.btnSearch:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.btnPhone:
                startActivity(new Intent(this, PhoneActivity.class));
>>>>>>> intent/dev_main
                break;
        }
    }
}