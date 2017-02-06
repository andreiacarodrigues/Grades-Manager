package com.acr.gm.gradesmanager;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Lista de Disciplinas & Notas
    private ArrayList<String> classes = new ArrayList<String>(Arrays.asList("LAIG", "RCOM", "ESOF", "PLOG", "LTW"));
    private ArrayList<String> grades = new ArrayList<String>(Arrays.asList("0.0", "1.0", "2.0", "3,0", "4.0"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Coloca elementos do ListAdapter (que coloca ambos os ArrayLists classes e grades em elementos distintos) no ListView
        ListView lv = (ListView)findViewById(R.id.listView);
        final MyListAdapter myListAdapter = new MyListAdapter();
        lv.setAdapter(myListAdapter);

        // Trata do botão plus
        FloatingActionButton plus = (FloatingActionButton) findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewElement(myListAdapter);
                Log.i("IMPORTANT", "Added new discipline. Nº of disciplines: " + classes.size());
            }
        });

        // Retira o titulo por default
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // Coloca nova font no titulo
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/f&c.ttf");
        TextView tv = (TextView) findViewById(R.id.toolbar_title);
        tv.setTypeface(tf);
    }

    // Adiciona novo elemento á listView
    private void addNewElement(MyListAdapter ml){
        classes.add("Discipline");
        grades.add("0.0");

        ml.notifyDataSetChanged();
    }

    // Muda para a activity de display das notas, enviando o nome da disciplina que quero
    public void DisciplineOnClick(View v)
    {
        Log.i("IMPORTANT", "New Activity incoming: " + ((TextView)v).getText().toString());
        Intent intent = new Intent(MainActivity.this, DisciplineActivity.class);
        String text = ((TextView)v).getText().toString();
        intent.putExtra("discipline", text);
        startActivity(intent);
    }

    // Mini classe que vai tomar conta da atribuição dos elementos das strings classes & grades aos elementos corretos e coloca-os na lista
    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            if(classes != null && classes.size() != 0){
                return classes.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return classes.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //ViewHolder holder = null;
            final ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.list_items, null);
                holder.Item_grade = (TextView) convertView.findViewById(R.id.Item_grade);
                holder.Item_name = (TextView) convertView.findViewById(R.id.Item_name);

                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            // New Font
            Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/f&c.ttf");

            holder.ref = position;

            holder.Item_grade.setText(grades.get(position));
            holder.Item_grade.setTypeface(tf);

            holder.Item_name.setText(classes.get(position));
            holder.Item_name.setTypeface(tf);
           /* holder.Item_name.addTextChangedListener(new TextWatcher() {

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
*/
            return convertView;
        }

        private class ViewHolder {
            TextView Item_grade;
            TextView Item_name;
            int ref;
        }
    }

    // Estas funções são para a options bar no canto superior direito da app bar
   /* @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

}
