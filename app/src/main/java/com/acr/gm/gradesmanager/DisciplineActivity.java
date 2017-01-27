package com.acr.gm.gradesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DisciplineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discipline);

       Intent intent = getIntent();
        String message = intent.getStringExtra("discipline");

        Log.i("IMPORTANT", message);
    }
}
