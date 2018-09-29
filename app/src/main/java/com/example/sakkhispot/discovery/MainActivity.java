 package com.example.sakkhispot.discovery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

     List<String> serviceList;
     ExpandableListAdapter expandableListAdapter;
     HashMap<String, List<String>> serviceDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        ExpandableListView expandableListView= (ExpandableListView) findViewById(R.id.provider_services_list);
        expandableListAdapter= new ExpandableListAdapter(this, serviceList, serviceDescription);
        expandableListView.setAdapter(expandableListAdapter);
    }

     private void prepareListData() {
         serviceList = new ArrayList<String>();
         serviceDescription = new HashMap<String, List<String>>();

         // Adding child data
         serviceList.add("Top 250");
         serviceList.add("Now Showing");
         serviceList.add("Coming Soon..");

         // Adding child data
         List<String> top250 = new ArrayList<String>();
         top250.add("The Shawshank Redemption");
         top250.add("The Godfather");
         top250.add("The Godfather: Part II");
         top250.add("Pulp Fiction");
         top250.add("The Good, the Bad and the Ugly");
         top250.add("The Dark Knight");
         top250.add("12 Angry Men");

         List<String> nowShowing = new ArrayList<String>();
         nowShowing.add("The Conjuring");
         nowShowing.add("Despicable Me 2");
         nowShowing.add("Turbo");
         nowShowing.add("Grown Ups 2");
         nowShowing.add("Red 2");
         nowShowing.add("The Wolverine");

         List<String> comingSoon = new ArrayList<String>();
         comingSoon.add("2 Guns");
         comingSoon.add("The Smurfs 2");
         comingSoon.add("The Spectacular Now");
         comingSoon.add("The Canyons");
         comingSoon.add("Europa Report");

         serviceDescription.put(serviceList.get(0), top250);
         serviceDescription.put(serviceList.get(1), nowShowing);
         serviceDescription.put(serviceList.get(2), comingSoon);
     }
}
