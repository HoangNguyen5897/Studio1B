package com.example.hqng.studio1b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceRegister extends AppCompatActivity {
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_register);

        getSupportActionBar().setTitle("Studio 1B");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button4= (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPatientRegister();
            }
        });

    }

    public void openPatientRegister(){

        Intent intent = new Intent(this, PatientRegister.class);
        startActivity(intent);
    }

}
