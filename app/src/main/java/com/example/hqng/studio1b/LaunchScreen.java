package com.example.hqng.studio1b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LaunchScreen extends AppCompatActivity {

    private Button button3;
    private Button choicePatientButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);

        getSupportActionBar().setTitle("Studio1B");



        button3= (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChoiceRegister();
            }
        });

        choicePatientButton= (Button) findViewById(R.id.choicePatientButton);
        choicePatientButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openPatientLogin();
            }

        });
    }

    public void openChoiceRegister(){

        Intent intent = new Intent(this, ChoiceRegister.class);
        startActivity(intent);
    }

    public void openPatientLogin(){

        Intent intent = new Intent(this, PatientLogin.class);
        startActivity(intent);
    }
}
