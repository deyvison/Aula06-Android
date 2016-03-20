package com.example.deyvison.aula06;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    private GridView gridView;

    private PlanetaAdapter adapter;

    private Aula06Application application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        application = (Aula06Application) getApplicationContext();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        adapter = new PlanetaAdapter(this,false);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                application.removerPlaneta(position);
                adapter.notifyDataSetChanged();
            }
        });

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                application.removerPlaneta(position);
                adapter.notifyDataSetChanged();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                application.addPlaneta();
                adapter.notifyDataSetChanged();;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_grade){
            if(!adapter.getIsGrid()){
                adapter.setIsGrid(true);
                adapter.notifyDataSetChanged();
                item.setTitle("LISTA");
            }else{
                adapter.setIsGrid(false);
                adapter.notifyDataSetChanged();
                item.setTitle("GRADE");
            }
        }
        return super.onOptionsItemSelected(item);

    }
}
