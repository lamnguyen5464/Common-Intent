package com.example.commonintent.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.commonintent.R;

public class Main1Activity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_main);

        findViewById(R.id.btUseAlarm).setOnClickListener(this);
        findViewById(R.id.btUseCalendar).setOnClickListener(this);
        findViewById(R.id.btUseCamera).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btUseAlarm:
                startActivity(new Intent(this, AlarmClockActivity.class));
                break;
            case R.id.btUseCalendar:
                startActivity(new Intent(this, CalendarActivity.class));
                break;
            case R.id.btUseCamera:
                startActivity(new Intent(this, CameraActivity.class));
                break;

        }
    }
}
