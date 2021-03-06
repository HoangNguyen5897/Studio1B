package com.example.hqng.studio1b;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PatientRegister extends AppCompatActivity implements View.OnClickListener{

    private Button patientRegButton;
    private EditText regEmail;
    private EditText regPassword;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_register);

        firebaseAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setTitle("Patient Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressDialog = new ProgressDialog(this);

        patientRegButton = (Button) findViewById(R.id.patientRegButton);
        regEmail = (EditText) findViewById(R.id.regEmail);
        regPassword = (EditText) findViewById(R.id.regPassword);

        patientRegButton.setOnClickListener(this);

    }

    private void registerPatient(){

        String email = regEmail.getText().toString().trim();
        String password = regPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            //stopping function from executing further
            return;
        }

        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            //stopping function from executing further
            return;
        }
        //If validation is ok
        //We will first show a progress bar

        progressDialog.setMessage("Registering Patient...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                //user is successfully registered and logged in

                                Toast.makeText(PatientRegister.this, "Registered Successfully", Toast.LENGTH_SHORT). show();
                            }

                            else{
                                Toast.makeText(PatientRegister.this, "Could not register", Toast.LENGTH_SHORT). show();
                            }
                        }

                });


    }

    @Override
    public void onClick (View view){
        if(view == patientRegButton){
            registerPatient();
        }


    }
}
