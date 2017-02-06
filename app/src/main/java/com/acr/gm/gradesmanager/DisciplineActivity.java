package com.acr.gm.gradesmanager;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DisciplineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discipline);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String message = intent.getStringExtra("discipline");

        Log.i("IMPORTANT", message);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.plus2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Retira o titulo por default
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // Coloca nova font no titulo
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/f&c.ttf");
        TextView tv = (TextView) findViewById(R.id.toolbar_title2);
        tv.setTypeface(tf);
    }
}
