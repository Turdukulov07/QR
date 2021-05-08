package com.example.andr3lesson8.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.andr3lesson8.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.andr3lesson8.databinding.ActivityMainBinding ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
    }
}


