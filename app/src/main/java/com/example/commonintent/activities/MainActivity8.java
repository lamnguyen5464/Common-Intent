package com.example.commonintent.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.commonintent.R;


public class MainActivity8 extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8_main);

        Button btMapLocation = findViewById(R.id.btMapLocation);
        btMapLocation.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btMapLocation:
                mapLocation(Uri.parse("geo:47.6,-122.3"));
                break;
            default:
                Toast.makeText(this, "This button has not been handled", Toast.LENGTH_SHORT).show();
        }
    }

    public void mapLocation(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}