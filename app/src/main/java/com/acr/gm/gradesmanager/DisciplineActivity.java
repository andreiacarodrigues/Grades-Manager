package com.acr.gm.gradesmanager;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DisciplineActivity extends AppCompatActivity {

    // Lista de Disciplinas & Notas
    private ArrayList<String> test = new ArrayList<String>(Arrays.asList("Mini-teste", "Exame"));
    private ArrayList<String> percentage = new ArrayList<String>(Arrays.asList("60%", "40%"));
    private ArrayList<String> grade = new ArrayList<String>(Arrays.asList("16.52", "13.65"));

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


        // Guarda elementos topo da pagina
        EditText disciplineTitle = (EditText) findViewById(R.id.editDisciplineName);
        TextView gradeTitle = (TextView) findViewById(R.id.grade_title);
        TextView gradeTotal = (TextView) findViewById(R.id.grade_total);

        // Poe tipo de letra
        disciplineTitle.setTypeface(tf);
        gradeTitle.setTypeface(tf);
        gradeTotal.setTypeface(tf);


        disciplineTitle.setText(message);
        disciplineTitle.clearFocus();
        disciplineTitle.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Toast.makeText(getApplicationContext(), "got the focus", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "lost the focus", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

/*

    // Mini classe que vai tomar conta da atribuição dos elementos das strings classes & grades aos elementos corretos e coloca-os na lista
    private class MyTestAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            if(test != null && test.size() != 0){
                return test.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return test.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //ViewHolder holder = null;
            final DisciplineActivity.MyTestAdapter.ViewHolder holder;
            if (convertView == null) {

                holder = new DisciplineActivity.MyTestAdapter.ViewHolder();
                LayoutInflater inflater = DisciplineActivity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.list_items, null);
                holder.Item_grade = (EditText) convertView.findViewById(R.id.Item_grade);
                holder.Item_name = (EditText) convertView.findViewById(R.id.Item_name);

                convertView.setTag(holder);

            } else {

                holder = (MainActivity.MyListAdapter.ViewHolder) convertView.getTag();
            }

            // New Font
            Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/f&c.ttf");

            holder.ref = position;

            holder.Item_grade.setText(grades.get(position));
            holder.Item_grade.setTypeface(tf);

            holder.Item_name.setText(classes.get(position));
            holder.Item_name.setTypeface(tf);
            holder.Item_name.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub
                    classes.set(holder.ref,arg0.toString());
                }
            });
            holder.Item_grade.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub
                    classes.set(holder.ref,arg0.toString());
                }
            });

            return convertView;
        }

        private class ViewHolder {
            EditText Item_grade;
            EditText Item_name;
            EditText Item_percentage;
            int ref;
        }
    }*/
}
