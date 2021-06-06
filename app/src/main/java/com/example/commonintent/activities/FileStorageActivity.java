package com.example.commonintent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.commonintent.R;
import com.example.commonintent.helpers.FileStorageHelper;

import static com.example.commonintent.constant.IntentTypes.REQUEST_IMAGE_OPEN;

public class FileStorageActivity extends AppCompatActivity {
    Button btSelectImage;
    ImageView selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);
        btSelectImage = findViewById(R.id.btSelectImage);
        selectedImage = findViewById(R.id.selectedImage);

        btSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileStorageHelper.selectImage(FileStorageActivity.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_OPEN && resultCode == RESULT_OK) {
            Uri fullPhotoUri = data.getData();
            // Do work with full size photo saved at fullPhotoUri
            selectedImage.setImageURI(fullPhotoUri);
        }else{
            Log.d("@@", "fail to intent image");
        }
    }
}