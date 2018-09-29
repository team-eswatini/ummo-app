package com.example.sakkhispot.discovery;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceDescription extends AppCompatActivity {

    List<String> serviceList;
    ExpandableListAdapter expandableListAdapter;
    HashMap<String, List<String>> serviceDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        prepareListData();

        ExpandableListView expandableListView= (ExpandableListView) findViewById(R.id.provider_services_list);
        expandableListAdapter= new ExpandableListAdapter(this, serviceList, serviceDescription);
        expandableListView.setAdapter(expandableListAdapter);



    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent= new Intent(this, Discovery.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent i= new Intent(this, Discovery.class);
                finish();
                startActivity(i);
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void prepareListData() {
        serviceList = new ArrayList<String>();
        serviceDescription = new HashMap<String, List<String>>();

        // Adding child data
        serviceList.add("Steps");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");



        serviceDescription.put(serviceList.get(0), top250);
    }


    public void ViewService(View view){
        Intent intent= new Intent(this, ServiceDescription.class);
        this.finish();
        startActivity(intent);
    }
}
