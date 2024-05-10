package com.example.activitylifecycle;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "APP Started", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart: App is started successfully ");
        System.out.println("App is started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity Paused", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause: App is Paused");
        System.out.println("App is Paused");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity Resumed", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume: App is Resumed");
        System.out.println("App is Resumed");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "App is Restarted", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart: App is Restarted");
        System.out.println("App is Restarted");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "App is Destroyed", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy: App is Destroyed");
        System.out.println("App is Destroyed");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "App is Stoped", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop: App is Stopped");
        System.out.println("App is stopped");

    }
}