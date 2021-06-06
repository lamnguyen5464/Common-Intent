package com.example.commonintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnNote).setOnClickListener(this);
        findViewById(R.id.btnPhone).setOnClickListener(this);
        findViewById(R.id.btnSearch).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNote:
                startActivity(new Intent(this, NoteActivity.class));
                break;
            case R.id.btnPhone:
                startActivity(new Intent(this, PhoneActivity.class));
                break;
            case R.id.btnSearch:
                startActivity(new Intent(this, SearchActivity.class));
                break;
        }
    }
}