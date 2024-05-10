package com.example.registrationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void replacetopfrag(Fragment frg) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmenttop, frg)
                .commit();

    }

    public void replacebottomfrag(Fragment frg) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentbottom, frg)
                .commit();


    }
}