package com.example.hqng.studio1b;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MedicalConditionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<MedicalCondition>  list;
    private RecyclerView recyclerView;
    private ViewMedicalConditionAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private NavigationView navigationView;
    private FirebaseDatabase database;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_medical_condition);
        mToolbar = (Toolbar) findViewById(R.id.addMedicalConditionTb);
        setSupportActionBar(mToolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.conditionDl);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.conditionRv);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        readDatabase();
        adapter = new ViewMedicalConditionAdapter(this, list);
        recyclerView.setAdapter(adapter);
        navigationView = (NavigationView) findViewById(R.id.conditionNv);
        navigationView.setNavigationItemSelectedListener(this);
        setTitle("View Medical Conditions");
    }

    @Override
    protected void onStart(){
        super.onStart();
        readDatabase();
        recyclerView = (RecyclerView) findViewById(R.id.conditionRv);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ViewMedicalConditionAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    public void readDatabase(){
        DatabaseReference reference = database.getReference("MedicalConditions");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    MedicalCondition condition = snapshot.getValue(MedicalCondition.class);
                    list.add(condition);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                databaseError.toException().printStackTrace();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        if(mToggle.onOptionsItemSelected(menuItem)){
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.nav_condition: Intent intent = new Intent(this, MedicalConditionActivity.class); startActivity(intent);
            case R.id.nav_consult: Intent intent2 = new Intent(this, DoctorConsultActivity.class); startActivity(intent2);
        }
        DrawerLayout layout = (DrawerLayout) findViewById(R.id.conditionDl);
        layout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadAddConditionScreen(View view){
        Intent intent = new Intent(MedicalConditionActivity.this, AddMedicalConditionActivity.class);
        startActivity(intent);
    }
}
