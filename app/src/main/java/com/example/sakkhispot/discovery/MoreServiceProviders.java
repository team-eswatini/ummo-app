package com.example.sakkhispot.discovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

public class MoreServiceProviders extends AppCompatActivity {

    GridView grid;
    String[] providerName= {"Home Affairs", "Mbabane Hospital", "Manzini Hospital", "Central Bank of Eswatini", "Mbabane Library"};
    String[] providerLocation= {"Mbabane", "Mbabane", "Manzini", "Mbabane", "Mbabane"};
    String[] providerContact= {"+204 5466", "+204 0092", "+204 0488", "+204 9900", "+204 9900"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Governmental");
        setContentView(R.layout.activity_more_service_providers);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        allProvidersGridView adapter = new allProvidersGridView(MoreServiceProviders.this, providerName, providerLocation, providerContact);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);


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

    public void ViewProvider(View view){
        Intent intent= new Intent(this, ScrollingActivity.class);
        this.finish();
        startActivity(intent);
    }
}
