package com.example.coiffeurr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Message extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
    }
    public void OpenProduct(View view) {
        Intent intent = new Intent(Message.this, Product.class);
        startActivity(intent);
    }
    public void openProfile(View view) {
        Intent intent = new Intent(Message.this, ProfileActivity.class);
        startActivity(intent);
    }
    public void ApenMeche(View view) {
        Intent intent = new Intent(Message.this, Meche.class);
        startActivity(intent);
    }
    public void ApenRoyal(View view) {
        Intent intent = new Intent(Message.this, Royal.class);
        startActivity(intent);
    }
    public void ApenSculpt(View view) {
        Intent intent = new Intent(Message.this, Sculpt.class);
        startActivity(intent);
    }
    public void ApenMaestro(View view) {
        Intent intent = new Intent(Message.this, Maestro.class);
        startActivity(intent);
    }
}