package com.example.sakkhispot.discovery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.MyViewHolder>{

    private List<ServiceProvider> providerList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView providerName, providerLocation, providerContact;
        public LinearLayout providerBackground;

        public MyViewHolder(View view) {
            super(view);
            providerName= (TextView) view.findViewById(R.id.provider_name);
            providerLocation = (TextView) view.findViewById(R.id.provider_location);
            providerContact = (TextView) view.findViewById(R.id.provider_contact);
        }
    }

    public ProviderAdapter(List<ServiceProvider> providerList){
        this.providerList= providerList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.serviceprovider_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ServiceProvider serviceProvider= providerList.get(position);

        holder.providerName.setText(serviceProvider.providerName);
        holder.providerLocation.setText(serviceProvider.location);
        holder.providerContact.setText(serviceProvider.contact);
    }

    @Override
    public int getItemCount() {
        return providerList.size();

    }
}
