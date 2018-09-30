package com.example.sakkhispot.discovery;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class CatergoyAdapter extends RecyclerView.Adapter<CatergoyAdapter.MyViewHolder> {

    private List<category> categoryList;
    ProviderAdapter serviceProviderAdapter;
    ArrayList<ServiceProvider> providers= new ArrayList<>();


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView categoryTitle, moreText;
        public RelativeLayout categoryBackground;

        RecyclerView serviceProviderRecyclerView;



        public MyViewHolder(View view) {
            super(view);
            Context context = itemView.getContext();
            categoryTitle = (TextView) view.findViewById(R.id.category_title);
            moreText = (TextView) view.findViewById(R.id.more);
            categoryBackground= (RelativeLayout) view.findViewById(R.id.category_background);
            serviceProviderRecyclerView= view.findViewById(R.id.serviceproviders_rv);

            serviceProviderAdapter= new ProviderAdapter(providers);
            categoryTitle = (TextView) view.findViewById(R.id.category_title);

            //Set serviceProviderRecyclerView
            serviceProviderRecyclerView.setAdapter(serviceProviderAdapter);
            serviceProviderRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            serviceProviderRecyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }

    public CatergoyAdapter(List<category> categoryList){
        this.categoryList= categoryList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        category category= categoryList.get(position);

        holder.categoryTitle.setText(category.categoryTitle);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();

    }

    public  void addProvider(List<ServiceProvider> _providers){

        providers.clear();
        for(ServiceProvider pr:_providers){
            providers.add(pr);
        }
        serviceProviderAdapter.notifyDataSetChanged();

    }
}
