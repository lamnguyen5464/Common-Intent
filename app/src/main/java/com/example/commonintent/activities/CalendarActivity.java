package com.example.commonintent.activities;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.commonintent.R;

import java.util.Calendar;


public class CalendarActivity extends AppCompatActivity implements View.OnClickListener{
    EditText inputTitle, inputLocation, inputDuration;
    Button btSetCalendar;
    TextView resultMsg;


    void mapping() {
        inputTitle = findViewById(R.id.inputTitle);
        inputLocation = findViewById(R.id.inputLocation);
        inputDuration = findViewById(R.id.inputDuration);
        btSetCalendar = findViewById(R.id.btSetCalendar);
        resultMsg = findViewById(R.id.resultMsg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mapping();

        btSetCalendar.setOnClickListener(this);

    }

    public void addEvent(String title, String location, int duration) {
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis()+duration*60*60*1000);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btSetCalendar){
            if(!TextUtils.isEmpty(inputDuration.getText().toString()) && !TextUtils.isEmpty(inputTitle.getText()) && !TextUtils.isEmpty(inputLocation.getText())){
                int duration = Integer.parseInt(inputDuration.getText().toString());
                String title = inputTitle.getText().toString();
                String location = inputLocation.getText().toString();
                resultMsg.setText("Create successfully!");
            addEvent(title, location, duration);
            }
            else {
                resultMsg.setText("Please fill all inputs!");
            }

        }
    }

    }


