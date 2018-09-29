package com.example.sakkhispot.discovery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class allProvidersGridView extends BaseAdapter {
    private Context mContext;
    private final String[] providerName;
    private final String[] providerLocation;
    private final String[] providerContact;

    public allProvidersGridView(Context c,String[] providerName,String[] providerLocation, String[] providerContact) {
        mContext = c;
        this.providerName = providerName;
        this.providerLocation= providerLocation;
        this.providerContact= providerContact;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return providerName.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.all_service_providers, null);
            TextView name = (TextView) grid.findViewById(R.id.provider_name);
            TextView location = (TextView) grid.findViewById(R.id.provider_location);
            TextView contact = (TextView) grid.findViewById(R.id.provider_contact);
            name.setText(providerName[position]);
            location.setText(providerLocation[position]);
            contact.setText(providerContact[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
