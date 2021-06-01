package com.example.commonintent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.commonintent.R;
import com.example.commonintent.helpers.ContactHelper;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_main);

        Button btSelectContact = findViewById(R.id.btSelectConact);
        btSelectContact.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK){
            return;
        }
        switch (requestCode){
            case ContactHelper.REQUEST_SELECT_CONTACT:
                ContactHelper.handleOnReturn(this, data);
                break;
            default:
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSelectConact:
                ContactHelper.selectContact(this);
                break;
            default:
                Toast.makeText(this, "This button has not been handled", Toast.LENGTH_SHORT);
        }
    }
}