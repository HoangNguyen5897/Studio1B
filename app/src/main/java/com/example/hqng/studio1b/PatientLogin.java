package com.example.hqng.studio1b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PatientLogin extends AppCompatActivity {

    private Button patientLoginButton;
    private EditText patientLoginEmail;
    private EditText patientLoginPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        patientLoginEmail = (EditText) findViewById(R.id.patientLoginEmail);
        patientLoginPassword = (EditText) findViewById(R.id.patientLoginPassword);
        patientLoginButton = (Button) findViewById(R.id.patientLoginButton);

        getSupportActionBar().setTitle("Patient Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}