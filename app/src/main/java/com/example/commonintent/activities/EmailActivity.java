package com.example.commonintent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commonintent.R;
import com.example.commonintent.helpers.EmailHelper;

import java.util.ArrayList;
import java.util.List;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {
    Button btAdd, btClear, btSend;
    EditText inputEmail, inputSubject, inputContent;
    List<String> listEmails =new ArrayList<>();
    LinearLayout listEmailLayout;
    int idTextView  = 0;

    void mapping(){
        btAdd = findViewById(R.id.btAdd);
        btClear = findViewById(R.id.btClear);
        btSend = findViewById(R.id.btSend);

        inputEmail = findViewById(R.id.inputEmail);
        inputSubject = findViewById(R.id.inputSubject);
        inputContent = findViewById(R.id.inputContent);
        listEmailLayout = findViewById(R.id.listEmails);
    }

    void removeListEmail(){
        idTextView = 0;
        listEmailLayout.removeAllViews();
    }

    void addEmailToView(String txtEmail){
        TextView textEmail = new TextView(this);
        textEmail.setText(txtEmail);
        textEmail.setId(idTextView++);
        listEmailLayout.addView(textEmail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        mapping();

        btAdd.setOnClickListener(this);
        btClear.setOnClickListener(this);
        btSend.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAdd:
                String email = inputEmail.getText().toString();
                if (email.equals("")){
                    Toast.makeText(this, "Please input email", Toast.LENGTH_SHORT);
                }else{
                    listEmails.add(email);
                    addEmailToView(email);
                }
                break;
            case R.id.btClear:
                listEmails.clear();
                removeListEmail();
                break;
            case R.id.btSend:
                String[] addresses = new String[listEmails.size()];
                for(int i = 0; i < listEmails.size(); i++){
                    addresses[i] = listEmails.get(i);
                }
                EmailHelper.composeEmail(this, addresses, inputSubject.getText().toString(), inputContent.getText().toString());
                break;

        }
    }
}