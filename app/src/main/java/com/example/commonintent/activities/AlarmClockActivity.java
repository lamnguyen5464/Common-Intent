package com.example.commonintent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.AlarmClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commonintent.R;

import java.util.concurrent.TimeUnit;

public class AlarmClockActivity extends AppCompatActivity implements View.OnClickListener {
    Button btSetTimer;
    EditText timerSecond, timerMsg;
    TextView timeView;

    private static final String FORMAT = "%02d:%02d:%02d";


    void mapping(){
        timerSecond = findViewById(R.id.inputTimerSecond);
        timerMsg = findViewById(R.id.inputTimerMsg);
        btSetTimer = findViewById(R.id.btSetTimer);
        timeView=(TextView)findViewById(R.id.timeView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        mapping();

        btSetTimer.setOnClickListener(this);
    }

    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btSetTimer){
            if(!TextUtils.isEmpty(timerSecond.getText().toString())){
                int sec = Integer.parseInt(timerSecond.getText().toString());
                String msg = timerMsg.getText().toString();
                startTimer(msg, sec);

                new CountDownTimer(sec*1000, 1000) {

                    public void onTick(long millisUntilFinished) {

                        timeView.setText(""+String.format(FORMAT,
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                    }

                    public void onFinish() {
                        timeView.setText(msg);
                    }
                }.start();
            }
            else{
                timeView.setText("Please input the amount of time");
            }
        }
    }
}


