package com.example.commonintent.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.commonintent.R;


public class MusicOrVideoActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_or_video);

        Button btPlayMediaFile = findViewById(R.id.btPlayMediaFile);
        btPlayMediaFile.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btPlayMediaFile:
                playMedia(Uri.parse("https://www.youtube.com/watch?v=y83x7MgzWOA&list=RDy83x7MgzWOA&start_radio=1"));
                break;
            default:
                Toast.makeText(this, "This button has not been handled", Toast.LENGTH_SHORT).show();
        }
    }

    public void playMedia(Uri file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(file);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}