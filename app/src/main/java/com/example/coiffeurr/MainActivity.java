package com.example.coiffeurr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: MainActivity started");
    }

    public void connecte(View view) {
        Log.d(TAG, "connecte: Navigating to MainPage");
        startActivity(new Intent(MainActivity.this, MainPage.class));
    }

    public void register(View view) {
        Log.d(TAG, "register: Navigating to RegisterActivity");
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }
}
