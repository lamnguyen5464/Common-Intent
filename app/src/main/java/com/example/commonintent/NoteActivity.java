package com.example.commonintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.actions.NoteIntents;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        handleCreateNote();
    }

    private void handleCreateNote() {
        Button b = (Button) findViewById(R.id.btnCreateNote);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText sub = findViewById(R.id.subjectText);
                EditText con = findViewById(R.id.contentText);
                createNote(sub.getText().toString(), con.getText().toString());
            }
        });
    }

    public void createNote(String subject, String text) {
        Intent intent = new Intent(NoteIntents.ACTION_CREATE_NOTE)
                .putExtra(NoteIntents.EXTRA_NAME, subject)
                .putExtra(NoteIntents.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            Log.d("Test", "123");
            startActivity(intent);
        }
    }
}