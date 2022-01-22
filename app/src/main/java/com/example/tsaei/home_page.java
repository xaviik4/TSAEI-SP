package com.example.tsaei;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home_page extends AppCompatActivity {

    private Button topic1;
    private Button topic2;
    private Button topic3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        topic1 = findViewById(R.id.topic1);
        topic2 = findViewById(R.id.topic2);
        topic3 = findViewById(R.id.topic3);

        topic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, Home.class);
                startActivity(intent);
            }
        });

        topic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, Home2.class);
                startActivity(intent);
            }
        });

        topic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, Home3.class);
                startActivity(intent);
            }
        });
    }
}