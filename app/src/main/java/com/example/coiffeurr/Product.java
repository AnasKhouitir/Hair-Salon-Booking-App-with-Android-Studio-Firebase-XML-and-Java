package com.example.coiffeurr;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

public class Product extends AppCompatActivity {

    private EditText searchEditText;
    private LinearLayout layoutArtisan, layoutCoupe, layoutSculpt, layoutMaestro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.products);

        searchEditText = findViewById(R.id.editTextText);

        layoutArtisan = findViewById(R.id.layoutArtisan);
        layoutCoupe = findViewById(R.id.layoutCoupe);
        layoutSculpt = findViewById(R.id.layoutSculpt);
        layoutMaestro = findViewById(R.id.layoutMaestro);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterData(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void filterData(String query) {
        String normalizedQuery = query.trim().toLowerCase();

        if (normalizedQuery.isEmpty()) {
            layoutArtisan.setVisibility(View.VISIBLE);
            layoutCoupe.setVisibility(View.VISIBLE);
            layoutSculpt.setVisibility(View.VISIBLE);
            layoutMaestro.setVisibility(View.VISIBLE);
        } else {
            layoutArtisan.setVisibility("l'artisan de la mèche".contains(normalizedQuery) ? View.VISIBLE : View.GONE);
            layoutCoupe.setVisibility("la coupe royale".contains(normalizedQuery) ? View.VISIBLE : View.GONE);
            layoutSculpt.setVisibility("le sculpt'homme".contains(normalizedQuery) ? View.VISIBLE : View.GONE);
            layoutMaestro.setVisibility("maestro des cheveux".contains(normalizedQuery) ? View.VISIBLE : View.GONE);
        }
    }

    public void openProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void openMeche(View view) {
        Intent intent = new Intent(this, Meche.class);
        startActivity(intent);
    }

    public void openSculpt(View view) {
        Intent intent = new Intent(this, Sculpt.class);
        startActivity(intent);
    }

    public void openMaestro(View view) {
        Intent intent = new Intent(this, Maestro.class);
        startActivity(intent);
    }

    public void openRoyal(View view) {
        Intent intent = new Intent(this, Royal.class);
        startActivity(intent);
    }

    public void openMessage(View view) {
        Intent intent = new Intent(this, Message.class);
        startActivity(intent);
    }
}
