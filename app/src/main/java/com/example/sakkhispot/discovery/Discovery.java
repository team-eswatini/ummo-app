package com.example.sakkhispot.discovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Discovery extends AppCompatActivity {

    //Derclaration of variables
    ArrayList<category> categoryList= new ArrayList<>();

    RecyclerView categoryRecyclerView;
    CatergoyAdapter catergoyAdapter;
    private List<ServiceProvider> myData = new ArrayList<ServiceProvider>();
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Service");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);
        catergoyAdapter= new CatergoyAdapter(categoryList);

        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> serviceList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + serviceList.size() + "services");
                    for(ParseObject service:serviceList){
                        service.pinInBackground();
                        myData.add(new ServiceProvider(service.getString("name"),service.getString("province"),service.getObjectId(),service.getString("logo_url")));
                    }
                    catergoyAdapter.addProvider(myData);
                    //catergoyAdapter.notifyDataSetChanged();

                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });


        //Fill categoryList and providersList
        addCategories();

        //Initialise adapters



        //Initialise RecyclerViews
        categoryRecyclerView=(RecyclerView) findViewById(R.id.category_rv);


        //Instantiate LinearLayoutManager
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);

        //Set catergoryRecyclerView
        categoryRecyclerView.setAdapter(catergoyAdapter);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);
        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    public void addCategories(){
        category category= new category("Governmental");
        categoryList.add(category);

        category= new category("Entertainment");
        categoryList.add(category);

        category= new category("Financial");
        categoryList.add(category);

        category= new category("Medical");
        categoryList.add(category);

    }

    public void ViewProvider(View view){
       // Intent intent= new Intent(this, ServiceDescription.class);
        //this.finish();
        //startActivity(intent);
    }

    public void ViewMoreProviders(View view){
        Intent intent= new Intent(this, MoreServiceProviders.class);
        this.finish();
        startActivity(intent);
    }




}
