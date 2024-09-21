package com.example.coiffeurr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Meche extends AppCompatActivity {

    private LinearLayout messageContainer;
    private EditText messageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meche);

        messageContainer = findViewById(R.id.message_container);
        messageInput = findViewById(R.id.message_input);
        Button sendButton = findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageInput.getText().toString().trim();
                if (!message.isEmpty()) {
                    addMessageToContainer(message);
                    messageInput.setText("");
                }
            }
        });
    }

    private void addMessageToContainer(String message) {
        TextView messageView = new TextView(this);
        messageView.setText(message);
        messageView.setPadding(8, 8, 8, 8);
        messageView.setTextSize(16);
        messageContainer.addView(messageView);

        // Scroll to the bottom when a new message is added
        final ScrollView scrollView = (ScrollView) messageContainer.getParent();
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
    public void openProfile(View view) {
        Intent intent = new Intent(Meche.this, ProfileActivity.class);
        startActivity(intent);
    }
    public void openProduct(View view) {
        Intent intent = new Intent(Meche.this, Product.class);
        startActivity(intent);
    }
    public void IpenMessage(View view) {
        Intent intent = new Intent(Meche.this, Message.class);
        startActivity(intent);
    }
}
