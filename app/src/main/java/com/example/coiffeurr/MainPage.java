package com.example.coiffeurr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainPage extends AppCompatActivity {
    private static final String TAG = "MainPage";
    private FirebaseAuth mAuth;
    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);
        Log.d(TAG, "onCreate: MainPage started");

        mAuth = FirebaseAuth.getInstance();
        emailField = findViewById(R.id.email_input);
        passwordField = findViewById(R.id.password_input);
    }

    public void loginUser(View view) {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        Log.d(TAG, "loginUser: Authentication successful");
                        updateUI(user, email, password);
                    } else {
                        Log.d(TAG, "loginUser: Authentication failed", task.getException());
                        Toast.makeText(MainPage.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        updateUI(null, null, null);
                    }
                });
    }

    private void updateUI(FirebaseUser user, String email, String password) {
        if (user != null) {
            Log.d(TAG, "updateUI: Navigating to ProfileActivity");
            Intent intent = new Intent(MainPage.this, ProfileActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("password", password);
            startActivity(intent);
            finish();
        }
    }

    public void register(View view) {
        Log.d(TAG, "register: Navigating to RegisterActivity");
        startActivity(new Intent(MainPage.this, RegisterActivity.class));
    }

    public void aceuil(View view) {
        Log.d(TAG, "aceuil: Navigating to MainActivity");
        startActivity(new Intent(MainPage.this, MainActivity.class));
    }
}
