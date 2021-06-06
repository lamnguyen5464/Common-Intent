package com.example.commonintent.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.commonintent.R;

public class TextMessageActivity extends AppCompatActivity implements View.OnClickListener {
    Button btMessage;
    /*TextView message;
    String sMessage;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textmessage);
        btMessage = (Button)findViewById(R.id.btMessage);
        btMessage.setOnClickListener(this);
        /*message = (TextView)findViewById(R.id.inputText);
        sMessage = message.getText().toString();*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btMessage:
                composeMmsMessage("Hello", Uri.parse("1"));
                break;
        }
    }
    public void composeMmsMessage(String message, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
