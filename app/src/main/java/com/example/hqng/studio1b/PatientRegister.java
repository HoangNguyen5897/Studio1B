package com.example.hqng.studio1b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PatientRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_register);

        getSupportActionBar().setTitle("Patient Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
