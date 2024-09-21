package com.example.coiffeurr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private EditText emailField;
    private EditText passwordField;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        mAuth = FirebaseAuth.getInstance();
        emailField = findViewById(R.id.profile_email);
        passwordField = findViewById(R.id.profile_password);

        // Get email and password from intent
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");

        if (email != null) {
            emailField.setText(email);
        }
        if (password != null) {
            passwordField.setText(password);
        }

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            emailField.setText(user.getEmail());
            passwordField.setText(password);
        }
    }


    public void OpenProduct(View view) {
        Intent intent = new Intent(ProfileActivity.this, Product.class);
        startActivity(intent);
    }

    public void ApenMessage(View view) {
        Intent intent = new Intent(ProfileActivity.this, Message.class);
        startActivity(intent);
    }
    public void disconnect(View view) {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
