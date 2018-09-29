package com.example.sakkhispot.discovery;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class CatergoyAdapter extends RecyclerView.Adapter<CatergoyAdapter.MyViewHolder> {

    private List<category> categoryList;
    ArrayList<ServiceProvider> providers= new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView categoryTitle, moreText;
        public RelativeLayout categoryBackground;
        ProviderAdapter serviceProviderAdapter;
        RecyclerView serviceProviderRecyclerView;

        public MyViewHolder(View view) {
            super(view);
            Context context = itemView.getContext();
            categoryTitle = (TextView) view.findViewById(R.id.category_title);
            moreText = (TextView) view.findViewById(R.id.more);
            categoryBackground= (RelativeLayout) view.findViewById(R.id.category_background);
            serviceProviderRecyclerView= view.findViewById(R.id.serviceproviders_rv);

            serviceProviderAdapter= new ProviderAdapter(providers);

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

    public  void addProvider(){
        ServiceProvider serviceProvider= new ServiceProvider("Home Affairs", "Mbabane",
                "+204 5466", "www.homeaffairs.org.sz");
        providers.add(serviceProvider);

        serviceProvider= new ServiceProvider("Mbabane Hospital", "Mbabane",
                "+204 0092", "www.mbabanehospital.org.sz");
        providers.add(serviceProvider);

        serviceProvider= new ServiceProvider("Manzini Hospital", "Manzini",
                "+204 0488", "www.manzinihospital.org.sz");
        providers.add(serviceProvider);

        serviceProvider= new ServiceProvider("Central Bank of Eswatini", "Mbabane",
                "+204 9900", "www.centralbankeswatini.org.sz");
        providers.add(serviceProvider);

        serviceProvider= new ServiceProvider("Mbabane Library", "Mbabane",
                "+204 9900", "www.mbabanenationallibrary.org.sz");
        providers.add(serviceProvider);

    }
}
