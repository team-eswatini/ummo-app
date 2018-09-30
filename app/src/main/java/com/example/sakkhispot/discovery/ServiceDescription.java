package com.example.sakkhispot.discovery;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;

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

        final TextView description = findViewById(R.id.service_description);
        final TextView time = findViewById(R.id.service_time);
        final TextView cost = findViewById(R.id.service_cost);

        String id = getIntent().getStringExtra("id");

        ParseObject object = ParseObject.createWithoutData("Service", id);
        object.fetchFromLocalDatastoreInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {

                    setTitle(object.getString("name"));
                    List<String> steps = object.getList("steps");
                    description.setText(object.getString("requirements"));
                    time.setText(object.getCreatedAt().toString());
                    if(object.getString("cost")!=null){
                        cost.setText(object.getString("cost"));
                    }
                    if(steps!=null){
                        Log.e("STEPS",""+steps.size());
                        prepareListData(steps);
                        ExpandableListView expandableListView= (ExpandableListView) findViewById(R.id.provider_services_list);
                        expandableListAdapter= new ExpandableListAdapter(ServiceDescription.this, serviceList, serviceDescription);
                        expandableListView.setAdapter(expandableListAdapter);
                    }else{
                        Log.e("STEPS","No Stepa");
                    }


                    // object will be your game score
                } else {
                    Log.e("Error","Something bad happened");
                    // something went wrong
                }
            }
        });

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



    private void prepareListData(List<String> top250) {
        serviceList = new ArrayList<String>();
        serviceDescription = new HashMap<String, List<String>>();
        serviceList.add("Steps");
        serviceDescription.put(serviceList.get(0), top250);
    }


    public void ViewService(View view){
        Intent intent= new Intent(this, ServiceDescription.class);
        this.finish();
        startActivity(intent);
    }
}
