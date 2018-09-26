package com.example.hqng.studio1b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PatientDetails extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private Button logoutButton;
    private Button patientSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, PatientLogin.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        logoutButton = (Button) findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == logoutButton){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent( this, PatientLogin.class));
        }


    }
}
