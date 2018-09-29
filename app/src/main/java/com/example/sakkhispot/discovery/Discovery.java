package com.example.sakkhispot.discovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class Discovery extends AppCompatActivity {

    //Derclaration of variables
    ArrayList<category> categoryList= new ArrayList<>();

    RecyclerView categoryRecyclerView;
    CatergoyAdapter catergoyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);

        //Fill categoryList and providersList
        addCategories();

        //Initialise adapters
        catergoyAdapter= new CatergoyAdapter(categoryList);

        catergoyAdapter.addProvider();

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
        Intent intent= new Intent(this, ScrollingActivity.class);
        this.finish();
        startActivity(intent);
    }

    public void ViewMoreProviders(View view){
        Intent intent= new Intent(this, MoreServiceProviders.class);
        this.finish();
        startActivity(intent);
    }




}
