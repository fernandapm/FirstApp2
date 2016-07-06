package com.example.fernanda.firstapp;

import android.content.Intent;
import android.R.layout;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayMessageActivity extends AppCompatActivity {

    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }
}
