package com.example.commonintent.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.commonintent.R;

import org.w3c.dom.Text;

public class WebBrowserActivity extends AppCompatActivity implements View.OnClickListener{
    Button btWebBrowser;
    /*Text inputURL;
    String URL;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webbrowser);
        btWebBrowser = (Button)findViewById(R.id.btWebBrowser);
        btWebBrowser.setOnClickListener(this);
        /*inputURL = (Text)findViewById(R.id.inputURL);*/
        /*URL = inputURL.toString();*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btWebBrowser:
                openWebPage("https://www.facebook.com/");
                break;
        }
    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
