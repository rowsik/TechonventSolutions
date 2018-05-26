package com.example.android.happymeals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String name = getIntent().getStringExtra("name");
        Toast.makeText(DetailActivity.this, name, Toast.LENGTH_SHORT).show();


    }
}
