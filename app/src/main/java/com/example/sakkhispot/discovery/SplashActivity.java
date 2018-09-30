package com.example.sakkhispot.discovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.parse.ParseUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(ParseUser.getCurrentUser()==null){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return ;
        }
        Intent intent = new Intent(this, Discovery.class);
        startActivity(intent);
        finish();
    }
}
