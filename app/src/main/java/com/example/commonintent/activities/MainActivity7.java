package com.example.commonintent.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.commonintent.R;
import com.google.android.gms.actions.ReserveIntents;

public class MainActivity7 extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7_main);

        Button btCallACar = findViewById(R.id.btCallACar);
        btCallACar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btCallACar:
                callCar();
                break;
            default:
                Toast.makeText(this, "This button has not been handled", Toast.LENGTH_SHORT).show();
        }
    }

    public void callCar() {
        Intent intent = new Intent(ReserveIntents.ACTION_RESERVE_TAXI_RESERVATION);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
