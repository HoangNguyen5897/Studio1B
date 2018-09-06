package com.example.hqng.studio1b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientLogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        getSupportActionBar().setTitle("Patient Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}