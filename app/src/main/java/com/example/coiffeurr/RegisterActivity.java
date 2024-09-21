package com.example.coiffeurr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private FirebaseAuth mAuth;
    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        Log.d(TAG, "onCreate: RegisterActivity started");

        mAuth = FirebaseAuth.getInstance();
        emailField = findViewById(R.id.email_input);
        passwordField = findViewById(R.id.password_input);
    }

    public void registerUser(View view) {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        Log.d(TAG, "registerUser: Registration successful");
                        updateUI(user, email, password);
                    } else {
                        Log.d(TAG, "registerUser: Authentication failed", task.getException());
                        Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        updateUI(null, null, null);
                    }
                });
    }

    private void updateUI(FirebaseUser user, String email, String password) {
        if (user != null) {
            Log.d(TAG, "updateUI: Navigating to ProfileActivity");
            Intent intent = new Intent(RegisterActivity.this, Product.class);
            intent.putExtra("email", email);
            intent.putExtra("password", password);
            startActivity(intent);
            finish();
        }
    }

    public void connect(View view) {
        Log.d(TAG, "connect: Navigating to MainPage");
        startActivity(new Intent(RegisterActivity.this, MainPage.class));
    }

    public void aceuil(View view) {
        Log.d(TAG, "aceuil: Navigating to MainActivity");
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }
}
